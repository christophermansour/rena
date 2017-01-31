(ns using-navigators.android.core
  (:require [reagent.core :as r]
            [using-navigators.android.my-scene :as ms]))

(def ReactNative (js/require "react-native"))

(def navigator (r/adapt-react-class (.-Navigator ReactNative)))

(def app-registry (.-AppRegistry ReactNative))

(defn app-root []
  ;; [ms/my-scene]
  [navigator {:initial-route {:title "My Initial Scene"
                              :index 0}
              :render-scene (fn [route, nav]
                              (r/as-element [ms/my-scene {:title (.-title route)
                                                          :on-forward (fn []
                                                                        (.push nav #js {:title (str "Scene " (.-index route))
                                                                                        :index (inc (.-index route))}))
                                                          :on-back (fn []
                                                                     (.pop nav))}]))}])

(defn init []
  (.registerComponent app-registry "UsingNavigators" #(r/reactify-component app-root)))
