(ns style.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn lots-of-styles []
  [view
   [text {:style (get styles :red)} "just red"]
   [text {:style (get styles :big-blue)} "just bigblue"]
   [text {:style (merge
                  (get styles :big-blue)
                  (get styles :red))} "bigblue, then red"]
   [text {:style (merge
                  (get styles :red)
                  (get styles :big-blue))} "red, then bigblue"]])

(def styles
  {:big-blue
   {:color "blue"
    :font-weight "bold"
    :font-size 30}
   :red
   {:color "red"}})

(defn app-root []
  [lots-of-styles])

(defn init []
  (.registerComponent app-registry "Style" #(r/reactify-component app-root)))
