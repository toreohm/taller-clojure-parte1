(defproject taller-clojure-parte1 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [org.clojure/data.json "2.4.0"]]
  :main ^:skip-aot taller-clojure-parte1.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
