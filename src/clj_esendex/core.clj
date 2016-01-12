(ns clj-esendex.core (:require [clojure.data.xml :as xml]))

(defn create-sms-xml [to body]
  (-> (xml/element :message)
      (xml/emit-str)))
