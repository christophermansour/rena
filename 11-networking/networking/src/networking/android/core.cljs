(ns networking.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defn networking []
  ;; (js/fetch "https://jsonplaceholder.typicode.com/posts/1")

  ;; (->
  ;;  (js/fetch "https://jsonplaceholder.typicode.com/posts/1"
  ;;            {:method "POST"
  ;;             :headers {:accept "application/json"
  ;;                       :content-type "application/json"}
  ;;             :body (.stringify js/JSON {:userId 1
  ;;                                        :title "yourValue"
  ;;                                        :body "yourOtherValue"})}))

  (->
   (js/fetch "https://facebook.github.io/react-native/movies.json")
   (.then (fn [response]
            (.json response)))
   (.then (fn [response-json]
            (.-movies response-json)))
   (.catch (fn [error]
             (prn error)))))

(defn app-root []
  [networking]
  [text]) ;; app-root needs to return a component

(defn init []
  (.registerComponent app-registry "Networking" #(r/reactify-component app-root)))
