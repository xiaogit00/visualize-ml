(ns visualize-ml.events
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   [clojure.string :as str]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(defn str->vec [s]
  (mapv #(js/parseFloat (str/trim %)) (str/split s #",")))


(re-frame/reg-event-db
 ::update-x
 (fn [db [_ val]]
   (if (= val "") (assoc db :x []) (assoc db :x (str->vec val)))))
  
(re-frame/reg-event-db
 ::update-y
 (fn [db [_ val]]
   (if (= val "") (assoc db :y []) (assoc db :y (str->vec val)))))