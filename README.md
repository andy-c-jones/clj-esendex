# clj-esendex
[![Build Status](https://snap-ci.com/andy-c-jones/clj-esendex/branch/master/build_image)](https://snap-ci.com/andy-c-jones/clj-esendex/branch/master)[![Clojars Project](https://img.shields.io/clojars/v/clj-esendex.svg)](https://clojars.org/clj-esendex)

Esendex Clojure SDK (Work In Progess)

run "lein midje" to run all tests

#Example Usage
Add dependency to lein project file
```
[clj-esendex "0.1.1-SNAPSHOT"]
```

run lein repl
```
(require '[clj-esendex.core :as client])

(let [dispatch (client/sms-dispatcher "USERNAME" "PASSWORD")]
  (-> (client/sms-xml "EX0000000" 447987654321 "Every message matters!")
       dispatch))
```

#Working
* Sending a single message (fire and forget)

#Next Steps
* Read the response of a sent message
