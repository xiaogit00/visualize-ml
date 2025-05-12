(ns visualize-ml.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub ::x (fn [db] (:x db)))
(re-frame/reg-sub ::y (fn [db] (:y db)))
(re-frame/reg-sub ::w (fn [db] (:w db)))
(re-frame/reg-sub ::b (fn [db] (:b db)))