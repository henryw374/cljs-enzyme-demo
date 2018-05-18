(ns projectx.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [projectx.events :as events]
            [projectx.routes :as routes]
            [projectx.views :as views]
            [projectx.config :as config]
            [cljsjs.enzyme]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
