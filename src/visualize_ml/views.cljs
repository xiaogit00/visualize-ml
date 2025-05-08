(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1
      "Logistic Regression"]
     [:button {:on-click #(println "Hello")} "Click here"]
     ]))
