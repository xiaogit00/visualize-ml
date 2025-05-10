(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.subs :as subs]))

(defn chart [] 
  [:div.column.is-two-fifths
       [:h2.debug "charts"]])
(defn x-matrix []
  [:div.column.is-one-fifths
   [:h2 "x"]])
(defn y-matrix [] 
  [:div.column.is-one-fifths
   [:h2 "y"]])
(defn params [] 
  [:div.column.is-one-fifths
   [:h2 "params"]])
(defn z-matrix [] 
  [:div.column.is-one-fifths
   [:h2 "z"]])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:<>
     [:div.container
      [:h2.has-text-centered "Logistic Regression"]
      ]
     [:div.container.debug.columns
      [chart]
      [x-matrix]
      [y-matrix]
      [params]
      [z-matrix]
      
      ]
     ]
    
    ))
