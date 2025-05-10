(ns visualize-ml.form
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.subs :as subs]))

(defn text-input []
  [:div.field
   [:label.label "Name"]
   [:div.control
    [:input.input {:type "text" :placeholder "Text input"}]]])

(defn select-input []
  [:div.field
   [:label.label "Subject"]
   [:div.control
    [:div.select
     [:select
      [:option "Select Dropdown"]
      [:option "With options"]]]]])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [text-input]
     [select-input]
     [:button.button.is-primary "Save"]]))
