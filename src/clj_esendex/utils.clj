(ns clj-esendex.utils (:require [clojure.data.codec.base64 :as b64]))

(defn base64-encode [string-to-encode]
  (String. (b64/encode (.getBytes string-to-encode)) "UTF-8"))
