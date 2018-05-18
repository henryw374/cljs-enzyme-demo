(defproject projectx "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]
                 [com.cemerick/url "0.1.1"]
                 [secretary "1.2.3"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev

   {   :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
    :dependencies [[binaryage/devtools "0.9.10"]
                   [cljsjs/enzyme "3.0.0"]
                   [com.cemerick/piggieback "0.2.1"]
                   [figwheel-sidecar "0.5.16"]]

    :plugins      [[lein-figwheel "0.5.16"]]}
   :prod { }}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "projectx.core/mount-root"}
     :compiler     {:main                 projectx.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            projectx.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}


    ]}

  )
