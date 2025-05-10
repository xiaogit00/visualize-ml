(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.subs :as subs]))


(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:<>
     [:div.container
      [:h2.has-text-centered "Logistic Regression"]
      ]
     [:div.container.debug.columns
      [:div.column.is-two-fifths
       [:h2.debug "charts"]]
      [:div.column.is-one-fifths
       [:h2 "x"]]
      [:div.column.is-one-fifths
       [:h2 "y"]]
      [:div.column.is-one-fifths
       [:h2 "params"]]
      [:div.column.is-one-fifths
       [:h2 "z"]]]
     ]
    
    ))
