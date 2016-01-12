(ns clj-esendex.core (:require [clojure.data.xml :as xml]))

(defn create-sms-xml [to body]
  (-> (xml/element :message {} (xml/element :to {} to) (xml/element :body {} body))
      (xml/emit-str)))
