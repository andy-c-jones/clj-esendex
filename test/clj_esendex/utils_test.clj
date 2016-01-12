(ns clj-esendex.utils-test
  (:use midje.sweet)
  (:require [clj-esendex.utils :refer :all]))

(fact "base64-encode encodes a string as UTF-8 base64"
 (base64-encode "test@example.com:letmein") => "dGVzdEBleGFtcGxlLmNvbTpsZXRtZWlu")
