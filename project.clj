(defproject clj-esendex "0.1.0-SNAPSHOT"
  :description "Esendex Clojure SDK"
  :url "https://github.com/andy-c-jones/clj-esendex"
  :license {:name "MIT Licence"
            :url "https://github.com/andy-c-jones/clj-esendex/blob/master/LICENSE"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/data.xml "0.0.8"]
                 [clj-http "2.0.0"]]
  :profiles {:dev {:dependencies [[midje "1.8.3"]]
                   :plugins [[lein-midje "3.1.4-SNAPSHOT"]]}})
