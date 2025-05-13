(ns visualize-ml.views
  (:require
   [re-frame.core :as re-frame]
   [reagent.core :as r]
   [visualize-ml.subs :as subs]
   [visualize-ml.events :as events]
   ["chart.js/auto" :as Chart]))

(defonce chart-instance (atom nil))

(defn line-chart []
  (let [chart-ref (r/atom nil)]
    (r/create-class
     {:display-name "line-chart"

      :component-did-mount
      (fn [this]
        (let [ctx (.getContext @chart-ref "2d")
              data {:labels ["Jan" "Feb" "Mar" "Apr"]
                    :datasets [{:label "My Dataset"
                                :data [10 20 15 30]
                                :borderColor "rgba(75, 192, 192, 1)"
                                :tension 0.4
                                :fill false}]}
              config {:type "line"
                      :data data}]
          (reset! chart-instance (Chart. ctx (clj->js config)))))

      :reagent-render
      (fn []
        [:canvas {:ref #(reset! chart-ref %)
                  :width 400
                  :height 200}])})))

(defn chart [] 
  [:div.column.is-two-fifths
       [:h2 "charts"]
   [line-chart]])

(defn x-matrix []
  (let [x (re-frame/subscribe [::subs/x])]
    [:div.column.is-one-fifths
     [:h2 "x"]
     [:p (pr-str @x)]]))

(defn y-matrix [] 
  (let [y (re-frame/subscribe [::subs/y])]
  [:div.column.is-one-fifths
   [:h2 "y"]
   [:p (pr-str @y)]]))

(defn params []
  (let [w (re-frame/subscribe [::subs/w])
        b (re-frame/subscribe [::subs/b])]
    [:div.column.is-one-fifths
     [:div "params"]
     [:div "w: " @w]
     [:div "b: " @b]]))

(defn Z [w X b] (mapv #(+ (* % w) b) X))

(defn z-matrix []
  (let [w (re-frame/subscribe [::subs/w])
        b (re-frame/subscribe [::subs/b])
        X (re-frame/subscribe [::subs/x])]
   [:div.column.is-one-fifths
    [:h2 "z: "]
    [:div (pr-str (Z @w @X @b))]]))

(defn x-input [] 
  [:div.column.is-two-thirds.is-flex.is-align-items-center
   [:p.pr-2 "x:"]
   [:input.input {:on-change #(re-frame/dispatch [::events/update-x (-> % .-target .-value)] )
                  :type "text" :placeholder "1, 2, 3, 4..."}]])

(defn y-input []
  [:input.input {:on-change #(re-frame/dispatch [::events/update-y (-> % .-target .-value)])
                 :type "text" :placeholder "1, 2, 3, 4..."}])

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
      [y-input]]]]]
  )

(defn main-panel [] 
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
  )
