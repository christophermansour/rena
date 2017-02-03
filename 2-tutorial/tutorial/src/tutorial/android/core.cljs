(ns tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def app-registry (.-AppRegistry ReactNative))

(defn hello-world-app []
  [text "Hello world!"])

(defn app-root []
  [hello-world-app])

(defn init []
  (.registerComponent app-registry "Tutorial" #(r/reactify-component app-root)))
