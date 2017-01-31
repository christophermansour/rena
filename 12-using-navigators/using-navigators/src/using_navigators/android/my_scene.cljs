(ns using-navigators.android.my-scene
  (:require [reagent.core :as r]))

(def ReactNative (js/require "react-native"))

(def app-registry (.-AppRegistry ReactNative))

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))

(defn my-scene [props]
  [view
   [text "Current Scene: " (:title props)]
   [touchable-highlight {:on-press (:on-forward props)}
    [text "Tap me to load the next scene"]]
   [touchable-highlight {:on-press (:on-back props)}
    [text "Tap me to go back"]]])
