(defproject auth-sandbox "0.1.0"
  :description "My auth sandbox"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [environ "1.2.0"]
                 [ring "1.9.5"]]
  :plugins [[lein-ring "0.12.5"]]

  ; for dev, run 'lein ring server'
  :ring {:handler auth-sandbox.core/app}

  :main ^:skip-aot auth-sandbox.core
  :profiles {:uberjar {:aot :all}})
