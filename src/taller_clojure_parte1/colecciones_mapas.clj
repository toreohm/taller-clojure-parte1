(ns taller-clojure-parte1.colecciones_mapas)

; Las colecciones, también conocidas cómo estructuras de datos, son inmutables.

;Mapas: Los mapas en clojure se asemejan a los objetos en JavaScript. Un array de objetos vendría siendo
;Un vector de mapas o una coll (colección) de mapas.

; Aquí está un mapa vacío
{}

{:nombre "Juan" :apellido "Perez"}
{:a 1 :b 2 :c {:d {:e 1000}}}

;Intentar esto en el REPL

(def mapa {:a 1 :b 2 :c {:d {:e 1000}}})
(get-in {:a 1 :b 2 :c {:d {:e 1000}}} [:c :d :e])
(get-in {:a 1 :b 2 :c {:d {:e 1000}}} [:c :d])
(get-in {:a 1 :b 2 :c {:d {:e 1000}}} [:c :h])
(get-in {:a 1 :b 2 :c {:d {:e 1000}}} [:c :h :e] "valor default")

;Aunque tambien se puede usar un string como una key, es muy raro hacer esto.
;Casi siempre se usa keywords en los mapas, más adelante se verá las ventajas.
;Notese que en clojure no se usa comas para separar los valores, parametros en funciones
;este patrón de sintaxis es uniforme.
(get {"a" 1000} "a")                                        ;1000

;Besides using map literals, you can use the hash-map function to create a map:

(hash-map :a 1 :b 2)                                        ;{:b 2 :a 1}

(get {:a 0 :b 1} :b)                                        ;Si no hay mapas anidados, se puede usar get de esta manera.
(get {:a 0 :b {:c "ho hum"}} :b)                            ;{:c "ho hum"} Hay un mapa anidado, obtenemos su valor pero no el valor del keyword :c
;Para eso se requiere get-in
(get-in {:a 0 :b 1} [:b])                                   ;Aun así podemos usar get-in

;Otra forma de buscar un valor en un mapa es tratar el mapa como una función con el key como argumento:
({:name "The Human Coffeepot"} :name)                       ;"The Human Coffeepot"
;Sin embargo esta forma casi no se usa.
; Mas adelante veremos formas muy común de uso dando a conocer el poder de las keywords.

;Las keywords son muy usadas en clojure como llaves en los mapas (llave-valor).

:a
:34

;En algunas ocaciones podremos tener una coll de keywords para llevar a cabo cierta logica en la resolución de problemas.
[:age :sex :location :occupation]

;La forma más comun de obtener un valor de un mapa es la siguiente:
(:a {:a 1 :b 2 :c 3})                                       ;1

;En varios casos (y esto es comun) se usa las keywords como funciones, en el ejemplo previo
; usamos una keywords como el operador de una operación.

;Mapas anidados
(:c (:b (:a {:a {:b {:c 1000}}})))                          ;1000
; es equivalente a
(get-in {:a {:b {:c 1000}}} [:a :b :c] :valor-default)      ;1000

(:d {:a 1 :b 2 :c 3} "Valor default")                       ;"Valor default"

;Usar una keyword como una función es muy común en clojure.

(first [{:a 1} {:a 2} {:a 3}]) "Resultado es: " {:a 1}
(:a (first [{:a 1} {:a 2} {:a 3}])) "Resultado es: " 1

{:a 1 :b2 2 :c 3 :d 4}                                      ;Comentario

