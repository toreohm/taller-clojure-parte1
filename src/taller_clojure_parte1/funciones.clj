(ns taller-clojure-parte1.funciones)

;Ejecutando una función: Ya se ha visto muchos ejemplos de esto.

(+ 1 2 3)
(str "concatenar " "una cadena")
(first [1 2 3 4])

;Todas las operaciones de CLojure cuentan con la misma sintaxis:
; 1) Se abre parentésis
; 2) Operator
; 3) Operands
; 4) se cierra paréntesis

; El ejecutar una función es solo otro término para una operación donde el operador es
; la función en sí o una function expression (una expresión que devuelve una función).

(if true
  (fn [a] (+ a 2))
  100)

;Esto (function expression) que regresa la función + (addition)
(or + -)

;En el siguiente ejemplo, como ya vimos regresa la función +, entonces para ejecutarla:
;Envolvemos la expresión (or + - ) en otros parentesis externos para ejecutar lo que devuelve.
;Y a la derecha ponemos sus argumentos (operands).
((or + -) 1 2 3) ;6

;Un ejemplo más complejo, perovlo dividimos en dos partes.
(and (= 1 1) +) ;Devuelve el primer valor falso que encuentre o el ultimo valor verdadero, en este caso +

;En el siguiente ejemplo primero se ejecuta la operación más interna y devuelve su resultado: +
;El cuál implicitamente sería (+ 1 2 3). Y después se ejecuta la operación externa a ésta y así sucesivamente
;hasta llegar a la más externa.
((and (= 1 1) +) 1 2 3) ;6

;Sin embargo no todo son function calls validas, lo siguiente es un error
(1 2 3 4)  "java.lang.Long cannot be cast to clojure.lang.IFn"
("test" 1 2 3) "java.lang.String cannot be cast to clojure.lang.IFn"

;Mas llamadas válidas a funciones
(inc 1.1) ;2.1

;En el caso de llamadas anidadas se ejecuta primero la operación más interna
;La siguiente operación se ejecuta de la siguiente manera
(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2)))
(+ 200 (/ 100 5))
(+ 200 20)

220

;Estructura de una función en clojure (definición de funciones).

;Podemos "dividir" la definición de una función en 5 partes.
(comment
  "1) defn
   2) Nombre de la función
   3) Un string describiendo la función (opcional)
   4) Parametros de la función en corchetes []
   5) Function body")
;Ejemplo

(defn mi-suma-personalizada
  "Recibe una colleción de parametros y todo se suma más 5 al final"
  [& numeros]
  (println numeros)
  "100"
  (:a {:a 1})
  (apply + (conj numeros 5)))
(mi-suma-personalizada 1 2 3 4)
;=> 15

;En clojure no usa "return" como en otros lenguajes.
;En clojure toda operación devuele el último valor o expresión a evaluar.
;En el caso de una función en clojure aplica lo mismo; ;Se devuelve lo último que se evalua en el cuerpo de la función

(defn funcion-patito
  "Devuelve 100"
  [param1 param2]
  param1
  param2
  (println param1)
  (str "Mario" "Maria" "Franco")
  [:name :age :location :sex :occupation]
  100)

;Funciones multi-arity
;En clojure se puede definir una función que ejecute diferentes bodies dependiendo del número de
;argumentos a pasar.
;Esta es la forma general de una definición de función de multiple-arity.

;Probar en REPL la siguiente función
(defn multi-arity
  "Cadena opcional para describir la función"
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
   (str first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (+ first-arg second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
   (vector first-arg))
  ([]
   "Sin argumentos"
   (let [numero 100
         numero2 200]
     (+ numero  numero2))
   ))


