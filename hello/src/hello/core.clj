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

( defn funNada
  [ x ]
  ( first x ))

; This os not working well
( defn exemple [ aList ]
  ( if ( not ( nil? aList ) )
    ( do
      ( println ( first aList ) ) 
      ( println ( rest aList ) ) ) ) )

; (nil? '())

(loop [x 10]
  ( type x )
  (when (> x 1)
    (println x)
    (recur (- x 2))))

;;=> 10 8 6 4 2

( defn is1 [ x ]
  ( cond
    (= x \1) true
    (= x \0) true
    :else false ) )

( defn mulx2 [ aList ]
  ( apply str ( filter is1 aList ) ) )


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
