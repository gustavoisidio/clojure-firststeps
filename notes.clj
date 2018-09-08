;
; USO BÁSICO DE LISTAS
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
; FUNÇÕES BASICAS EM ARRAYS
;                 
user=> (def eli [:jar1 1 2 3 :jar2])
#'user/eli
user=> eli
[:jar1 1 2 3 :jar2]
user=> (count eli)
5