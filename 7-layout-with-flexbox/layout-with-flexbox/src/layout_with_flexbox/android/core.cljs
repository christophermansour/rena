(ns layout-with-flexbox.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def view (r/adapt-react-class (.-View ReactNative)))

(def app-registry (.-AppRegistry ReactNative))

(defn layout-with-flexbox []
  ;; [view {:style {:flex 1
  ;;                :flex-direction "row"}}
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "powderblue"}}]
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "skyblue"}}]
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "steelblue"}}]])
  ;; [view {:style {:flex 1
  ;;                :flex-direction "column"
  ;;                :justify-content "space-between"}}
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "powderblue"}}]
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "skyblue"}}]
  ;;  [view {:style {:width 50
  ;;                 :height 50
  ;;                 :background-color "steelblue"}}]])
  [view {:style {:flex 1
                 :flex-direction "column"
                 :justify-content "center"
                 :align-items "center"}}
   [view {:style {:width 50
                  :height 50
                  :background-color "powderblue"}}]
   [view {:style {:width 50
                  :height 50
                  :background-color "skyblue"}}]
   [view {:style {:width 50
                  :height 50
                  :background-color "steelblue"}}]])

(defn app-root []
  [layout-with-flexbox])

(defn init []
  (.registerComponent app-registry "LayoutWithFlexbox" #(r/reactify-component app-root)))
