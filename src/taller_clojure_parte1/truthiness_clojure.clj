(ns taller-clojure-parte1.truthiness-clojure)

; Clojure tiene valores true y false. nil se usa para indicar que no hay valor en Clojure.
; Se puede verificar si un valor es nulo con la función nil? :
(nil? 1)  ;false
(nil? nil) ;true

(nil? (first [])) ;true
(nil? (last [1 2 3]))  ;false

;Tanto nil como false se utilizan para representar logicamente falso, mientras que todos los demás valores son
; lógicamente verdaderos. Verdadero y falso se refieren a cómo se trata un valor en una expresión booleana,
; como la primera expresión pasada a if:
(if (= 10 (+ 5 5))
  "yes of course"
  "no")

(if nil
  "Esto no se muestra"
  "Esto sí se muestra porque nil is falsey")

(if (first '())
  "Esto no se muestra"
  "Esto sí se muestra porque nil is falsey")

;En clojure no hay operador de asignación, por lo que el operador = vendría siendo el operador de igualdad

(= 1 1)
; => true

(= nil nil)
; => true

(= 1 2)
; => false

;Clojure uses the Boolean operators "or" and "and". "or" returns either the first truthy value or the last value.
; "and" returns the first falsey value or, if no values are falsey, the last truthy value.

(or false nil :ciudad) ; :ciudad
(or (= 0 1) (= "yes" "no") (first [])) ;nil
(or (= 0 1) (> 5 1) (= "yes" "no") (first [])) ;true

(and :free_wifi :hot_coffee) ; :hot_coffee
(and :hot_coff|ee nil false) ; nil

