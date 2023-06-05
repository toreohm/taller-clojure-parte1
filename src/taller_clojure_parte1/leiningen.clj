(ns taller-clojure-parte1.leiningen)
;¿Qué es Leiningen?
; Leiningen es una herramienta de gestión de dependencias y automatización de compilación para
; una configuración simple de proyectos de software escritos en el lenguaje de programación Clojure.
;(Wikipedia)

; Leiningen es una aplicación, programa, que te permite:
; 1) Gestionar las dependencias en tu proyecto de una maner simple y eficiente
; 2) Correr tu aplicación en consola para ver los resultados
; 3) Construir (build) de tu aplicación creando un archivo jar que podrá ser ejecutado con java
; 4) Te permite usar el REPL.

;https://www.braveclojure.com/getting-started/#Leiningen

;Creemos un proyecto de la nada con Leiningen:

;lein new app prueba-pretmex

(defn -main
  "I don't do a whole lot...yet."
  [& args]
  (println "Hello, World!"))

;Se le puede cambiar en el project.clj para que se ejecute otro archivo en lugar del archivo default: core.clj
; :main ^:skip-aot taller-clojure-parte1.leiningen

;Para correr el proyecto: lein run
;Para construir el proyecto: lein uberjar
;Para usar el repl en la consola: lein repl

