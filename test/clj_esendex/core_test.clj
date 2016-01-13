(ns clj-esendex.core-test
  (:require [clj-esendex.core :refer :all]
            [midje.sweet :refer :all]
            [ring.adapter.jetty-async :refer [run-jetty-async]]
            [clojure.data.xml :as xml]
            [ring.util.request :as request-util]))

(fact "sms-xml creates the correct xml for a single message"
  (sms-xml "EX0000000" 447987654321 "Every message matters!") => "<?xml version=\"1.0\" encoding=\"UTF-8\"?><messages><accountreference>EX0000000</accountreference><message><to>447987654321</to><body>Every message matters!</body></message></messages>")

(def ok {:status 200 :headers {"Content-Type" "application/xml"}})
(def not-authorised {:status 200 :headers {"Content-Type" "application/xml"}})

(defn ok-with-request-for-test-assertions [request]
  (->> request
       request-util/body-string
       (assoc ok :body)))

(defn app-handler [request]
  (let [response {:status 200 :headers {"Content-Type" "application/xml"}}])
  (cond
    (not= (get (:headers request) "authorization")"Basic dXNlcjpwYXNz") not-authorised
    :else (ok-with-request-for-test-assertions request)))

(facts "The post response function sends an sms and basic auth to the service"
  (let [fake (run-jetty-async app-handler {:join? false :port 3210})]
  (Thread/sleep 2000)

(let [response (->> (sms-xml "EX123456" 447987654321 "Integration tests matter!")
                    (post-reponse "http://localhost:3210" "user" "pass"))]
    (fact "A post is made to the service with basic auth"
      response => (contains {:status 200}))
    (fact "The sms xml was correctly passed in the body of the request to the service"
      (-> response :body) => "<?xml version=\"1.0\" encoding=\"UTF-8\"?><messages><accountreference>EX123456</accountreference><message><to>447987654321</to><body>Integration tests matter!</body></message></messages>")
  (.stop fake))))
