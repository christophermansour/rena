(ns using-navigators.android.my-scene
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def navigator (r/adapt-react-class (.-Navigator ReactNative)))

(defn my-scene [title]
  [view
   [text "Hi! My name is " title]])
