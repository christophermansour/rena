(ns using-ascroll-view.android.core
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def scroll-view (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def text (r/adapt-react-class (.-Text ReactNative)))

(def app-registry (.-AppRegistry ReactNative))

(defn using-a-scrollview []
  [scroll-view
   [text {:style {:fontSize 96}} "Scroll me plz"]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [text {:style {:fontSize 96}} "If you like"]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [text {:style {:fontSize 96}} "Scrolling down"]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [text {:style {:fontSize 96}} "What's the best"]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [text {:style {:fontSize 96}} "Framework around"]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [image {:source (js/require "./images/favicon.png")}]
   [text {:style {:fontSize 96}} "React Native"]])

(defn app-root []
  [using-a-scrollview])

(defn init []
  (.registerComponent app-registry "UsingAScrollView" #(r/reactify-component app-root)))
