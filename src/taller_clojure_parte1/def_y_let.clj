(ns taller-clojure-parte1.def-y-let)

; def se usa para vincular un nombre a un valor en Clojure:
; En la prácitca podemos usar a def para definir constantes en un scope global.

(def nombres ["Juan" "Maria" "Mario" "Enrique" "Juanita"])
(def numeros '(1 2 3 4 5 6 7 8 9))

; Se está usando el término "vincular un nombre", mientras que en otros lenguajes de programación
; diría que estoy asignando un valor a una variable.
; En clojure no se acostumbra a usar el término variable.
; Tomemos en cuenta que no hay operador de asignación en clojure y las estructuras de datos son inmutables.
; Esto es parte del paradigma funcional.

;A pesar de que no hay operador de asignación, se puede hacer "asignación de variables"
; en clojure gracias a let.
;En otros términos, estamos asignando valores a nombres y éstos tendran un scope local a let.
; Es decir, una vez fuera de let, ya están fuera de scope.

(let [a 100
      b "cadena de texto"
      a true   ;Se puede reasignar el valor, pero una vez fuera de los corchetes, dicho valor es inmutable
      c false
      concatenacion (str b " " (+ 1000 0))]
  (println concatenacion)
  a)
(let [a (first nombres)
      b (second numeros)
      c (first numeros)]
  (println (str a b c))
  (+ b c))

