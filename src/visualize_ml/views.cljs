(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.subs :as subs]))

(defn chart [] 
  [:div.column.is-two-fifths
       [:h2 "charts"]])

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
(defn x-input [] 
  [:div.column.is-two-thirds.is-flex.is-align-items-center
   [:p.pr-2 "x:"]
   [:input.input {:on-change ()
                  :type "text" :placeholder "1, 2, 3, 4..."}]])

(defn bottom-control-panel [] 
  [:div.is-fixed-bottom.columns
   [:div.is-flex.is-flex-direction-column.column.is-two-fifths.is-justify-content-space-around.pt-0
    [:div "Input Data"]
    [:div.columns.mb-0
     [x-input]
     [:div.column.is-one-third 
      [:button.button "Initialize Params"]]]
    
    
    [:div.is-flex.columns
     [:div.column.is-two-thirds.is-flex.is-align-items-center
      [:p.pr-2 "y:"]
      [:input.input {:type "text" :placeholder "1, 2, 3, 4..."}]]]]]
  )

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div.is-family-monospace 
     [:div.container
      [:h1.has-text-centered "Logistic Regression"]
      ]
     [:div.container.columns
      [chart]
      [x-matrix]
      [y-matrix]
      [params]
      [z-matrix]
      ]
    [bottom-control-panel]
     ]
    ))
