(ns clj-esendex.core (:require [clojure.data.xml :as xml]
                               [clj-http.lite.client :as client]))

(defn sms-xml [account-ref to body]
  (-> (xml/element :messages {} [(xml/element :accountreference {} account-ref) (xml/element :message {} (xml/element :to {} to) (xml/element :body {} body))])
      (xml/emit-str)))

(defn post-reponse [url user pass body]
  (client/post url
    {:basic-auth [user pass]
     :body body}))

(defn dispatched-sms [user pass body]
  (partial post-reponse "https://api.esendex.com/v1.0/messagedispatcher" user pass body))

(defn sms-dispatcher [user pass]
  (partial dispatched-sms user pass))
