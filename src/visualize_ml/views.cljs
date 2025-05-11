(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.events :as events]
   [visualize-ml.subs :as subs]))
   
(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div 
     [:h1 "Hello from " @name]
     [:button.button {:on-click #(re-frame/dispatch [::events/update-name "Sarah"])} "Update Name 2"]]
    ))