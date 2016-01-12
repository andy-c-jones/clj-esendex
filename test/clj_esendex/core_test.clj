(ns clj-esendex.core-test
  (:require [clj-esendex.core :refer :all]
            [midje.sweet :refer :all]
            [ring.adapter.jetty-async :refer [run-jetty-async]]
            [clojure.data.xml :as xml]))

(fact "sms-xml creates the correct xml for a single message"
  (sms-xml "EX0000000" 447987654321 "Every message matters!") => "<?xml version=\"1.0\" encoding=\"UTF-8\"?><messages><accountreference>EX0000000</accountreference><message><to>447987654321</to><body>Every message matters!</body></message></messages>")

(defn app-handler [request]
  {:status 200
   :headers {"Content-Type" "application/xml"}
   :body ""})

(fact "you can send an sms"
  (let [fake (run-jetty-async app-handler {:join? false :port 3210})]
  (Thread/sleep 1000)
  (post-reponse "http://localhost:3210" "user" "pass" "body") => (contains {:status 200})
  (.stop fake)))
