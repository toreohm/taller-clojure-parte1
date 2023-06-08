(ns taller-clojure-parte1.destructuracion)

(comment
  "La idea básica detrás de la desestructuración es que le permite vincular de manera concisa
  (breve, claro y preciso) nombres a valores dentro de una colección.")
(comment "Supongamos que tenemos un vector, y queremos vincular los tres primeros elementos
con un nombre cada quien.")

(let [[uno dos tres & los-demas] [1 2 3 4 5 6]]
  (println uno)
  (println dos)
  (println tres)
  (println los-demas)
  true)

; En una función

(defn sumar-elementos
  "La primera coll solo me interesa sus primeros dos elementos a sumar, los demas no se tomaran en cuenta.
  A la segunda coll, le agrego los dos elementos de la primera coll y posteriormente sumo cada elemento de la
  nueva coll."
  [[elem1 elem2] coll]
  (apply + (conj coll elem1 elem2)))

(comment "También podemos destructurar los mapas de dos maneras.")

(let [{uno :a dos :b} {:a 1 :b 2}]
  (str uno " " dos))

(let [{:keys [a b]} {:a 100 :b 200}]
  (hash-map :a (inc a) :b (dec b)))

;Destructuración como parametros en una función

(defn sumita [{:keys [a b]}]
  (if (and (number? a) (number? b))
    (+ 100 a b)
    "Parametros incorrectos"))

(sumita {:a 5 :b 10})