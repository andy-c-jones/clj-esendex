(ns clj-esendex.core-test
  (:use midje.sweet)
  (:require [clj-esendex.core :refer :all]
            [clojure.data.xml :as xml]))

(fact "message coverts to the correct xml"
  (create-sms-xml 447987654321 "Every message matters!") => "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message><to>447987654321</to><body>Every message matters!</body></message>")
