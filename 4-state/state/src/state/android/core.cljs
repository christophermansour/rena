(ns state.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(def app-registry (.-AppRegistry ReactNative))

(defn blink [title]
  (let [show-text (r/atom true)]
    (fn []
      (js/setTimeout (fn []
                       (swap! show-text not)) 1000)
      [text (if @show-text title "")])))

(defn state []
  [view
   [blink "I love blinking"]
   [blink "Yes blinking is so great"]
   [blink "Why did they ever take this out of HTML"]
   [blink "Look at me look at me look at me"]])

(defn app-root []
  [state])

(defn init []
  (.registerComponent app-registry "State" #(r/reactify-component app-root)))
