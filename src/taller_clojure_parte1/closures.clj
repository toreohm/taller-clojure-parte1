(ns taller-clojure-parte1.closures)

;FUNCIONES ANONIMAS

(def concatenar-banana #(str % " banana"))
(concatenar-banana "Una fruta es") "Una fruta es banana"

(def concatenar-banana2 (fn [cadena] (str cadena " banana")))
(concatenar-banana2 "Una fruta es") "Una fruta es banana"

;Un atomo te permite MUTAR un valor en clojure
;De la forma convencional no funcionaría, porque los valores en clojure son inmutables
(let [a "cadena"]
  (do (str a " cadena2 cadena3")
      100
      {:a 1 :b 2}
      a))

;Pero con un atomo, el valor sí se puede mutar en clojure
(let [a (atom "cadena")]
  (do (swap! a str " cadena2 cadena3")
      100
      {:a 1 :b 2}
      @a))

;ejemplo con reset!
(let [x (atom 5)]
  (reset! x "Suiza"))

(comment "By now you’ve seen that functions can return other functions.
The returned functions are closures, which means that they can access all the variables
that were in scope when the function was created.")

(comment "Here, inc-by is in scope, so the returned function has access to it even when the returned function
is used outside inc-maker.")

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))
(def inc3 (inc-maker 3))
(inc3 15) ;18

;OTRO EJEMPLO DE CLOSURE

(defn save-coins []
  (let [coins (atom 5)]
    (fn [num]
      (swap! coins + num))))

(def save-5-coins (save-coins))
(save-5-coins 5) 10
(save-5-coins 5) 15
(save-5-coins 5) 20

