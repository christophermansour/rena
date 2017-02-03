(ns using-alist-view.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def view (r/adapt-react-class (.-View ReactNative)))
(def list-view (r/adapt-react-class (.-ListView ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def list-view-ds (.-DataSource (.-ListView ReactNative)))
(def app-registry (.-AppRegistry ReactNative))

(def ds (list-view-ds. (clj->js {:rowHasChanged (fn [r1 r2]
                                                  (not= r1 r2))})))
(def data-source (.cloneWithRows ds (clj->js ["John", "Joel", "James", "Jimmy", "Jackson", "Jillian", "Julie", "Devin"])))

(defn list-view-basics []
  [view {:style {:flex 1 :padding-top 22}}
   [list-view {:dataSource data-source
               :render-row (fn [row-data]
                             (r/as-element [text row-data]))}]])

(defn app-root []
  [list-view-basics])

(defn init []
  (.registerComponent app-registry "UsingAListView" #(r/reactify-component app-root)))
