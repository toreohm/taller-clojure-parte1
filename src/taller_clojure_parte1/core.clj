(ns taller-clojure-parte1.core
  (:require [clojure.string :as s]
            [clojure.data.json :as json])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [mapa coll & args]
  (let [mapa (if (string? mapa) (json/read-str mapa :key-fn keyword) mapa)
        {port :port info :info} mapa
        coll (if (string? coll) (read-string coll) coll)]
    (println mapa)
    (println (type coll) coll)
    (println (str "Hello, World!  " port " || " info " " (s/join " " args)))
    mapa))

;lein run "{\"port\":8080,\"info\":\"banana\"}" "{:a 1}" 500 100
;lein run "{\"port\":8080,\"info\":\"banana\"}" "#{1 2 3}" 500 100
;(+ 33 (parse-long "1"))