(ns height-and-width.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def app-registry (.-AppRegistry ReactNative))

(defn height-and-width []
  ;; [view
  ;;  [view {:style {:width 50 :height 50 :background-color "powderblue"}}]
  ;;  [view {:style {:width 100 :height 100 :background-color "skyblue"}}]
  ;;  [view {:style {:width 150 :height 150 :background-color "steelblue"}}]]
  [view {:style {:flex 1}}
   [view {:style {:flex 1 :background-color "powderblue"}}]
   [view {:style {:flex 2 :background-color "skyblue"}}]
   [view {:style {:flex 3 :background-color "steelblue"}}]])

(defn app-root []
  [height-and-width])

(defn init []
  (.registerComponent app-registry "HeightAndWidth" #(r/reactify-component app-root)))
