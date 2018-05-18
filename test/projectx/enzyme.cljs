(ns projectx.enzyme
  (:require [reagent.core :as r]
            [cljsjs.enzyme]
            [projectx.views :as views]
            [cemerick.url :as c.url]
            [secretary.core :as secretary]))


(comment ; load this ns and switch into it. eval these at repl
  
  (def p
    (->> (r/as-element
           [:div
            {:on-click #(do
                          (when-let [target-url (.. % -target -href)]
                            (let [path (:anchor (cemerick.url/url target-url))]
                              (println path)
                              (secretary/dispatch! path)))
                          )}
            [views/main-panel]])
        (.mount js/enzyme)
         ;.debug
         )
    )

  (.debug p)

  ;simulate a click
  (->
    (.find p "a[href=\"#/about\"]")
    (.simulate "click")
    ;.debug
    )
  
  ; eval p again. now main panel is on about

  
  

  )


