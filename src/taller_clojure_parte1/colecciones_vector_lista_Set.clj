(ns taller-clojure-parte1.colecciones-vector-lista-Set)

;Vectors: Un vector es similar a un array, ya que es una 0-indexed collection. Por ejemplo, aquí hay un vector literal:
[1 2 3]
(get [3 2 1] 0) "resultado es:" 3

(get ["a" {:name "John Wick"} "c"] 1) "resultado es:" {:name "John Wick"}

(get [1 2 3 4 5 6] 7) ;nil
(get [1 2 3 4 5 6] 5)  ;6

(get [1 2 3] 7 "banana")
;=> "banana"
;Probar en REPL
(vector {:a 1} {:a 100} "string" true 1000 [1 2 3])
(vec '(1 2 3 4))
(count (vector {:a 1} {:a 100} "string" true 1000 [1 2 3]))

(conj [1 2 3] 4) ;[1 2 3 4]

;LISTAS: Son similares a los vectores en el sentido de que son collecciones lineal de valores (tienen principio y fin)
;Pero hay diferencia, esto NO funciona con listas
(get '(1 2 3) 0)  ;Te da nil

'(1 2 3 4) ;Es equivalente a
(quote (1 2 3 4))
;Quote: Te devuelve la forma sin evaluar.

(nth '(:a :b :c) 0) ;a
(nth '(:a :b :c) 2) ; => :c
(nth '(1 2 3) 8 "banana")
;=> "banana"
(conj '(1 2 3) 4) ; => (4 1 2 3)

(comment "Obtener el segundo elemento de la lista anidada: " '(1 2 3 4 '(1 2 3)))
;-------------------------------------------------------------------------
(nth (nth (get-in (vec '(1 2 3 4 '(1 2 3))) [4]) 1) 1)
(second (nth (get (vec '(1 2 3 4 '(1 2 3))) 4) 1))
;--------------------------------------------------------------------------
;Checar en REPL
(list 1 "two" {3 4})
(count (list 1 "two" {3 4}))
;Transformar un vector a una lista
(reverse (into (list) [1 2 3 4 5]))
(reverse (into (list) (vector 1 2 3 4 5)))

;When should you use a list and when should you use a vector?
; A good rule of thumb is that if you need to easily add items to the beginning of a sequence or
; if you’re writing a macro, you should use a list.
;Otherwise, you should use a vector.
; it’s good to know that using "nth" to retrieve an element from a list is slower than using "get"
; to retrieve an element from a vector.

;SETS: Son collecciones de valores únicos

#{1 2 3}
;Ver en REPL
(hash-set 1 1 2 2)
(conj #{:a :b} :b)
(conj #{:a :b} :c)
(set [3 3 3 4 4])

;Puedes checar si tiene un valor el set con la función contains?, el cual es una función booleana
(contains? #{:a :b} :a) ; => true
(contains? #{:a :b} 3) ; => false

(:a #{:a :b}) ; => :a
(:c #{:a :b}) ; => nil

(get #{1 2 3} 3) ;3
(get #{"a" "b" "c"} "d")  ;nil

;Valores default
(:c #{:a :b} "valor default")
;=> "valor default"
(get #{"a" "b" "c"} "d" 1000)
;=> 1000

(count #{"a" 2 3 4})
