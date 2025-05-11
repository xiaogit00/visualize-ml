(ns visualize-ml.events
  (:require
   [re-frame.core :as re-frame]
   [visualize-ml.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

;; (re-frame/reg-event-db
;;  ::update-form
;;  (fn [db [_ id val]]
;;    (assoc-in db [:form id] val)))