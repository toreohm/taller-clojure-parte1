(ns taller-clojure-parte1.resumen-practico)

(def mapa {:a 1 :b 2 :c 3 :d {:e 100 :f {:g [10 20 30]}}})
(def my-coll [{:a 1 :b 2 :c 3}
              {:a 100 :b 200 :c 300}
              {:a "uno" :b "dos" :c "tres"}
              {:a "banana" :b "apple" :c "orange"}
              {:a "Morelia" :b "Toluca" :c "Monterrey"}
              {:a 1000 :b 2000 :c 3000}
              {:a -1 :b -2 :c -3}])

;Obtener el valor 30 de mapa. Hay tres maneras de resolverlo.
(get-in mapa [:d :f :g 2])                                  ;30
(get (:g (:f (:d mapa))) 2)                                 ;30
((comp #(get % 2) :g :f :d) mapa)                           ;30

;-----------------------------------------
(get-in [1 2 3 4 [11 12]] [4 0])                            ;11

;comp: Toma un conjunto de funciones y retorna una fn que es la composición de esas fns.
;Dichas funciones se ejecutan de derecha a izquierda.
;La fn retornada (composición de funciones) acepta un numero variable de args, el cual es pasado
;a la primera función (derecha a izquierda), el resultado de ésta pasa como argumento de la segunda función
;y así sucecivamente.

;Viendolo por pasos
((comp apply) + [1 2 3 4])                                  ;10
((comp dec apply) + [1 2 3 4])                              ;9
((comp str dec apply) + [1 2 3 4])                          ;"9"

;Usando comp sería más legible en algunas ocasiones que hacerlo de la siguiente forma.
;En todo caso vealo como una alternativa
(str (dec (apply + [1 2 3 4])))                             ;"9"

;RECURSIVIDAD - Una función que se llama así misma hasta que cumple con cierta condición.

(defn obtener-valor
  "Obtener el valor de una coll de mapas a través de la recursividad."
  [coll valor llave]
  (let [mapa (first coll)
        coll-restante (rest coll)]
    (if (nil? mapa)
      (str "No se encontró el valor buscado: [" valor "] con la llave: [" llave "]")
      (if (= (llave mapa) valor)
        [mapa valor]
        (recur coll-restante valor llave)))))

(loop [coll my-coll
       valor 3000
       llave :c]
  (let [head (first coll)
        tail (rest coll)]
    (if (nil? head)
      (str "No se encontró el valor buscado: [" valor "] con la llave: [" llave "]")
      (if (= (llave head) valor)
        [head valor]
        (recur tail valor llave)))))

;JUEGO DE PIEDRA PAPEL O TIJERA - Interactivo con recursividad
(def valores ["piedra" "papel" "tijera"])

(defn evaluar-jugada [valor-jugador valor-maquina]
  (if (= valor-jugador "piedra")
    (cond
      (= valor-maquina "piedra") {:jugador "piedra" :maquina "piedra" :resultado "Empate"}
      (= valor-maquina "papel") {:jugador "piedra" :maquina "papel" :resultado "Maquina gana"}
      (= valor-maquina "tijera") {:jugador "piedra" :maquina "tijera" :resultado "Jugador gana"})
    (if (= valor-jugador "papel")
      (cond
        (= valor-maquina "piedra") {:jugador "papel" :maquina "piedra" :resultado "Jugador gana"}
        (= valor-maquina "papel") {:jugador "papel" :maquina "papel" :resultado "Empate"}
        (= valor-maquina "tijera") {:jugador "papel" :maquina "tijera" :resultado "Maquina gana"})
      (if (= valor-jugador "tijera")
        (cond
          (= valor-maquina "piedra") {:jugador "tijera" :maquina "piedra" :resultado "Maquina gana"}
          (= valor-maquina "papel") {:jugador "tijera" :maquina "papel" :resultado "Jugador gana"}
          (= valor-maquina "tijera") {:jugador "tijera" :maquina "tijera" :resultado "Empate"})))))
(defn jugar []
  (println "Escribe tu jugada [piedra, papel, tijera]:")
  (let [valor-jugador (clojure.string/lower-case (read-line))
        valor-maquina (get valores (rand-int 3))
        salir? (not (some #(when (= % valor-jugador) %) ["piedra" "papel" "tijera"]))]
    (if salir?
      "Fin del juego"
      (do (println (pr-str (evaluar-jugada valor-jugador valor-maquina)))
          (recur)))))
