(ns state.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn blink [title]
  (let [show-text (r/atom true)]
    (fn []
      (js/setTimeout #(swap! show-text not) 1000)
      [text (if @show-text title "")])))

(defn app-root []
  [view
   [blink "I love blinking"]
   [blink "Yes blinking is so great"]
   [blink "Why did they ever take this out of HTML"]
   [blink "Look at me look at me look at me"]])

(defn init []
  (.registerComponent app-registry "State" #(r/reactify-component app-root)))
