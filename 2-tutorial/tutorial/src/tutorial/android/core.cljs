(ns tutorial.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))
(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defn app-root []
  [text "Hello world!"])

(defn init []
  (.registerComponent app-registry "Tutorial" #(r/reactify-component app-root)))
