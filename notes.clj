;
; - COLLECTIONS --
; Are immutable, persistent data structures and you can not update them
; A function that change a collection actually gives back a new version of that collection 
;
;
; USO BÁSICO DE LISTAS
; Lists are for collections of data that you want to access from the top of the list
;
user=> (last [:rabbit :pocket-watch :marmalade])
:marmalade
user=> (first [:rabbit :pocket-watch :marmalade])
:rabbit
user=> (rest [:rabbit :pocket-watch :marmalade])
(:pocket-watch :marmalade)
user=> (nth [:rabbit :pocket-watch :marmalade] 2)
:marmalade
user=> (def usu '(1 2 3 4 5))
#'user/usu
user=> usu
(1 2 3 4 5)
user=> (first usu)
1
user=> (last usu)
5
user=> (nth usu 2)
3
user=> (cons 3 usu)
(3 1 2 3 4 5)
user=> (cons 5 usu)
(5 1 2 3 4 5)
user=> (cons 6 nil)
(6)
user=> (cons 7'())
(7)
user=> (first usu)
1
user=> (rest usu)
(2 3 4 5)
user=> (cons (first usu) (rest usu))
(1 2 3 4 5)
user=> (count usu)
5
;
; TENTANDO COISAS DIFERENTES COM LISTAS, CONCATENAÇÕES E MERGES
;
user=> (cons (rest usu) (first usu)) ; Não funciona pois (cons element list) e não (cons list element)
user=> (cons (cons (rest usu) (first usu)) ; (cons element list) -> (cons list1 list2) => list2(list1(),... )
user=> (cons (rest usu) (cons (first usu) '())) ; Funciona pois (rest usu) é uma lista assim como (cons (first usu) '())
((2 3 4 5) 1) ; Porém a primeira lista passa a ser um elemento da segunda (cons list1 list2) => list2 (list1 (),...)
;
; FUNÇÕES BASICAS EM VECTORS
; Vectors are for collections of data that you want to access anywhere by position
;                 
user=> (def eli [:jar1 1 2 3 :jar2])
#'user/eli
user=> eli
[:jar1 1 2 3 :jar2]
user=> (count eli)
5
;
; CONJ FUNCTION
;
user=> (conj eli 55) ; Add in the back of vector
[:jar1 1 2 3 :jar2 55]
user=> (conj eli 55 33 12)
[:jar1 1 2 3 :jar2 55 33 12]
user=> (conj usu 84) ; Add in front of the list
(84 1 2 3 4 5)
user=> (conj usu 51 64 26)
(26 64 51 1 2 3 4 5)
; conj do this way because is more natural add in the end of the vector and in front of the list
;
; MAPS
; Maps are for key-value pairs, which is great for organizing data and having easy access
;
user=> (def poui {:jam1 "str" :k2 "black"})
#'user/poui
user=> poui
{:jam1 "str", :k2 "black"}
user=> (get poui :k2)
"black"
user=> (def asu '(:jam1 :k2)) ; A list of keys for poui 
#'user/asu
user=> (get poui (first asu))
"str"
; but what if does'nt found the value with some key?
user=> (get poui :r) ; poui has'nt any key called :r
nil ; so than it returns nil
user=> (get poui :r "Nao achou") ; here we have a default menssage who will print if poui has'nt any key called :r
"Nao achou"
; Using the key as a function works too and is more idiomatic however get is more clearer to read 
user=> (:k2 poui)
"black"
user=> (keys poui) ; Print all keys
(:jam1 :k2)
user=> (vals poui) ; Print all values
("str" "black")
user=> (assoc poui :jam1 "another value") ; Assoc "change" the value of that key
{:jam1 "another value", :k2 "black"}
user=> (dissoc poui :k2) ; Dissoc removes the value and that associated key
{:jam1 "str"}
user=> (def ous {:jam1 "uss"})
#'user/ous
user=> (def uer {:jam2 "eita" :k1 "bora"})
(def usu '(1 2 3 4 5))#'user/uer
user=> (merge ous uer poui)
{:jam1 "str", :jam2 "eita", :k1 "bora", :k2 "black"}
user=> (merge ous poui uer)
{:jam1 "str", :k2 "black", :jam2 "eita", :k1 "bora"}
user=> (merge uer poui ous)
{:jam2 "eita", :k1 "bora", :jam1 "uss", :k2 "black"}
user=> (merge uer ous poui)
{:jam2 "eita", :k1 "bora", :jam1 "str", :k2 "black"}
;
; SETS
; Collection of elements who do not allow duplicates
; Sets are for collections of unique elements; by grouping elements together in a set, you can perform set operations on them
;
user=> #{:c :b :d :a}
#{:c :b :d :a}
user=> (clojure.set/union #{:r :b :w} #{:w :p :y})
#{:y :r :w :b :p}
user=> (clojure.set/difference #{:r :b :w} #{:w :p :y})
#{:r :b}
user=> (clojure.set/intersection #{:r :b :w} #{:w :p :y})
#{:w}
user=> (set [:rabbit :rabbit :watch :door]) ; We can convert another data structures in to sets
#{:door :watch :rabbit}
user=> (set {:a 1 :b 2 :c 3}) ; Theses convertions facilitates when we need to use a set function with a vector, list or maps
#{[:c 3] [:b 2] [:a 1]}
user=> (get #{:rabbit :door :watch} :rabbit)
:rabbit
user=> (contains? #{:rabbit :door :watch} :rabbit) ; Quering the set asking if :rabbit is there
true
user=> (contains? #{:rabbit :door :watch} :riru) 
false
user=> (conj #{:rabbit :door :mau} :jam) ; As we already seen conj add a element. In case of sets it add in the back 
#{:mau :door :rabbit :jam}
user=> (disj #{:rabbit :door :mau} :door) ; disj removes that element from the set
#{:mau :rabbit}
;
; LET
; Use let to create something temporary
; Use def to create global variables
;
user=> (def developer "Alice")
#'user/developer
user=> user/developer
"Alice"
user=> (let [developer "Alice in Wonderland"] developer)
"Alice in Wonderland"
user=> developer
"Alice"
user=> (let [developer "macumba" rabbit "mumia"] developer)
"macumba"
user=> (let [developer "macumba" rabbit "mumia"] rabbit)
"mumia"

;
; FUNCTIONS
;

user=> (defn shop-f [x y] {:name "joao" :jam1 x :jam2 y}) ; Definindo funcao com 2 parametros que entram em um maps
#'user/shop-f
user=> (shop-f "Maria" "jose") ; Chamando a função e passando os 2 parametros como duas strings
{:name "joao", :jam1 "Maria", :jam2 "jose"}

; Defining a function to add key-val in to a map
user=> (def kiu {:k1 "A" :k2 "B"})
#'user/kiu
user=> (defn addMap [x y] (merge kiu {x y}))
#'user/addMap
user=> (addMap :k3 "C")
{:k1 "A", :k2 "B", :k3 "C"}

; A special function called "Anonnymous Function"
user=> (fn [] (str "Off we go" "!"))
#function[user/eval7323/fn--7324]
user=> ((fn [] (str "Off we go" "!"))) ; Calling this function
"Off we go!"
user=> (def flowme (fn [] (str "Off we go" "!"))) ; Defining a symbol for this Annonymous Function 
#'user/flowme
user=> (flowme)
"Off we go!"
; Other ways to define and manipulate those Annonymous FUNCTIONS
user=> (#(str "Off we go" "!")) ; Here we are using # in front of to specify a Annonymous Function
"Off we go!"
user=> (#(str "Off we go" "!" " - " %) "again") ; With % we can use arguments
"Off we go! - again"
user=> (#(str "Off we go" "!" " - " %1 %2) "again" "?") ; For more than 1 argument we can use %2, %3, %4...
"Off we go! - again?"





              
                     
                            
                                   
                                          
                                                 
                                                        
                                                               
                                                                      
                                                                             
                                                                                    
                                                                                           
                                                                                                  
                                                                                                         
