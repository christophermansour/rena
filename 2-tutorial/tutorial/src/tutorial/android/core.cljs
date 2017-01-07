(ns tutorial.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [tutorial.events]
            [tutorial.subs]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))

(defn alert [title]
  (.alert (.-Alert ReactNative) title))

(defn app-root []
  (let [greeting (subscribe [:get-greeting])]
    (fn []
      [text @greeting])))

(defn init []
  (dispatch-sync [:initialize-db])
  (.registerComponent app-registry "Tutorial" #(r/reactify-component app-root)))
