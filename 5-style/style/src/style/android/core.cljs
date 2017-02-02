(ns style.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def view (r/adapt-react-class (.-View ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(def app-registry (.-AppRegistry ReactNative))

(def styles
  {:big-blue {:color "blue"
              :font-weight "bold"
              :font-size 30}
   :red {:color "red"}})

(defn lots-of-styles []
  [view
   [text {:style (:red styles)} "just red"]
   [text {:style (:big-blue styles)} "just bigblue"]
   [text {:style (merge
                  (:big-blue styles)
                  (:red styles))} "bigblue, then red"]
   [text {:style (merge
                  (:red styles)
                  (:big-blue styles))} "red, then bigblue"]])

(defn app-root []
  [lots-of-styles])

(defn init []
  (.registerComponent app-registry "Style" #(r/reactify-component app-root)))
