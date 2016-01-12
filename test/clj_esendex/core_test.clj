(ns clj-esendex.core-test
  (:use midje.sweet)
  (:require [clj-esendex.core :refer :all]
            [clojure.data.xml :as xml]))

(fact "message coverts to the correct xml"
  (create-sms-xml 447987654321 "Hello World") => "<?xml version=\"1.0\" encoding=\"UTF-8\"?><message></message>")
