(ns props.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
;; (def image (r/adapt-react-class (.-Image ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn greeting [name]
  [text "Hello " name "!"])

(defn lots-of-greetings []
  [view {:style {:align-items "center"}}
   [greeting "Rexxar"]
   [greeting "Jaina"]
   [greeting "Valeera"]])

(defn app-root []
  ;; (let [pic {:uri "https://upload.wikimedia.org/wikipedia/commons/d/de/Bananavarieties.jpg"}]
  ;;   [image {:source pic
  ;;           :style {:width 193 :height 110}}])
  [lots-of-greetings])

(defn init []
  (.registerComponent app-registry "Props" #(r/reactify-component app-root)))
