(ns clj-esendex.utils-test
  (:require [clojure.test :refer :all]
            [clj-esendex.utils :refer :all]))

(deftest base64-encode-test
 (testing "base64-encode should encode the string passed in as UTF-8 base64"
 (is (= (base64-encode "test@example.com:letmein") "dGVzdEBleGFtcGxlLmNvbTpsZXRtZWlu"))))
