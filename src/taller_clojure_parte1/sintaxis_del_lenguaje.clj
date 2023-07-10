(ns taller-clojure-parte1.sintaxis-del-lenguaje)

;REPL -> Read Evaluate Print Loop
;El REPL te permite ejecutar codigo clojure. También cargar otros archivos (require) en el namespace actual
; sobre el cual se trabaja en el REPL.

;El REPL, será lo que usaremos en el resto del curso y será una herramienta indispensable al momento de que
;empiecen a desarrollar cualquier proyecto. El REPL será el pan de cada día como programador clojure.

;SINTAXIS

; El código de Clojure está escrito de manera uniforme. Es decir, siempre se usa el mismo patrón de
; sintaxis. Clojure reconoce dos tipos de estructuras:
; 1) Estructuras de datos literales (números, strings, mapas, vectores)
; 2) Operaciones.
;

 1  "a string"  ["a" "vector" "of" "strings"] {:name "Un mapa"}

;Todas las operaciones usan la manera uniforme de representarse de la siguiente manera:
; 1) Se abre paréntesis
; 2) Operador
; 3) operandos (Lo podemos entender como argumentos)
; 4) Se cierra parentésis
; (operator operand1 operand2 ... operandn)

(+ 1 2 3)  ;En otros lenguajes: 1 + 2 + 3
(concat [1 2 3] [4 5 6])  ;En js [].concat([1,2,3],4,5)
(str "Cadena " "concatenada")  ;En js "hola " + "mundo" <------> "hola ".concat("mundo")

(str "Cadena " (+ 1 2 3) " concatenada")
;"Hola ".concat(1 + 2 + 3, " mundo")        ;"Hola ".concat(sumar(1, 2), " mundo")

;CONTROL FLOW

; Empezaremos con tres operadores básicos de flujo de control: if, do, when.

(comment (if boolean-form ;Expresión que se evalua a verdadero o falso
           then-form
           optional-else-form))

(if true
  "Pase gratis del cine"
  "A lavar las vasijas")

(if false
  "Si es true se ejecuta el then, o sea éste string"
  "De lo contrario se ejecuta el else (opcional)")

;Podemos omitir el "optional-else-form", y en caso de que la expresión booleana se evalue
;como false, clojure retorna nil, o sea nulo en otros lenguajes.
(if false
  "Se muestra mensaje de error al cliente.")

;El operador "do" permite encerrar varias formas entre paréntesis y ejecutar
; cada uno de ellos.
(do 100
    "100"
    [1,2,3,4])

(if true
  (do (insertar-registro-db {:name "Maria" :age 56 :location "Peru"})
      (println "Registro insertado en la base de datos"))
  (do (mostrar-mensaje-error :db-failure)
      (println "Error en la base de datos")))
(if (> 5 2)
  (do (println "Sí lo es")
      true)
  (do (println "No lo es")
      false))
;IF-ELSE EN CLOJURE
(if "proceso" (if (< 5 3) "Aprobado" (if false "true" "Esto se va a ver")) :db-error)

;El operador "when" es como una combinación de if y do, pero sin el else.
;En caso de que la expresión booleana se evalue a false, "when" devuelve nil

(when true
  (println "Success!")
  "abra cadabra!!!")

;Supongamos que recorremos un vector de mapas y necesitamos evaluar un determinado valor de
;cada mapa comparandolo con 100
[{:a 100 :b true} {:a 99 :b true} {:a 10 :b true} {:a 500 :b false}]
(when (> 101 100)
  "Ah ok, entonces ejecuta esta función y haz esto y aquello")

