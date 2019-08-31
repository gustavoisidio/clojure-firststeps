(ns helloworld.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;(ns hello
;  (:require [clj-time.core :as t]
;            [clj-time.format :as f]))

;(defn time-str
;  "Returns a string representation of a datetime in the local time zone."
;  [dt]
;  (f/unparse
;    (f/with-zone (f/formatter "hh:mm aa") (t/default-time-zone))
;    dt))

(defn -main
  "I can say 'Hello World'."
  []  
  (println "Hello, World!"))

;(defn -main []
;  (println "Hello world, the time is" (time-str (t/now))))
