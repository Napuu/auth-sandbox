(ns auth-sandbox.core
  (:require 
    [environ.core :refer [env]] 
    [clojure.string :as str]
    [ring.adapter.jetty :refer [run-jetty]]
    [ring.util.response :refer [status]])
  (:gen-class))

(def whitelisted-ips
  (let [t  (or (env :whitelisted-ips) "")]
    (set (str/split (or t "")  #","))))

(def app
  (fn [request]
    (let [{headers :headers} request
          {real-ip "cf-connecting-ip"} headers]
      (status (if (contains? whitelisted-ips real-ip) 200 401)))))

(defn -main [& _]
  (run-jetty app {:port 3000}))
