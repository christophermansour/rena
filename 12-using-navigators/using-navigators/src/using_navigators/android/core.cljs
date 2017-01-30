(ns using-navigators.android.core
  (:require [reagent.core :as r]
            [using-navigators.android.my-scene :as ms]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(defn app-root []
  [ms/my-scene])

(defn init []
  (.registerComponent app-registry "UsingNavigators" #(r/reactify-component app-root)))
