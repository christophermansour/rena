(ns handling-text-input.android.core
  (:require [reagent.core :as r]
            [clojure.string :as s]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))
(def text (r/adapt-react-class (.-Text ReactNative)))
(def text-input (r/adapt-react-class (.-TextInput ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))

(defn pizza-translator []
  (let [char (r/atom nil)]
    (fn []
      [view {:style {:padding 10}}
       [text-input
        {:style {:height 40}
         :placeholder "Type here to translate!"
         :on-change-text #(reset! char %)}]
       [text {:style {:padding 10
                      :font-size 42}}
        (s/join " " (map #(if-not (s/blank? %) "🍕" nil) (s/split @char #" ")))]])))

(defn app-root []
  [pizza-translator])

(defn init []
  (.registerComponent app-registry "HandlingInputText" #(r/reactify-component app-root)))
