(ns hello.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn -main
  "I don't do a whole lot."
  []
  (def aString "Gustavo") ;Declarando uma string
  (def aLong 15)
  (def aDouble 1.123456)
  (format "Meu nome é %s" aString)
  (format "5 spaces and %5d" aLong)
  (format "Leading zeros %04d" aLong)
  (format "%-8d left justified" aLong)
  (format "3 decimals %.3f" aDouble)
  (def str1 "Segunda string")
  (str/blank? str1)
  (str/includes? str1 "a")
  
  )

; (println "What is this:" (+ 1 2))
; (println "What is this:" (+ 1 3))

; (defn -fizzbuzz
;   ([i]
;     (cond
;       (= 0 (mod i (* 3 5))) "FizzBuzz"
;       (= 0 (mod i 5)) "Buzz"
;       (= 0 (mod i 3)) "Fizz"
;       :else (str i)))
;   ([start end]
;a       (map fizbuzz (range start end))))
