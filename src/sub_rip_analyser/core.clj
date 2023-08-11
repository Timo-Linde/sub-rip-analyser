(ns sub-rip-analyser.core
  (:require
    [cli-matic.core :as cm-core]
    [sub-rip-analyser.sum-words :refer [sum-words]])
  (:gen-class))

(def cli-matic-config
  {:app         {:command     "sub-rip-analyser"
                 :description "A command-line tool to analyse .srt files."
                 :version     "0.0.1"}
   :global-opts [{:option  "input-files"
                  :as      ".srt files to analyse"
                  :type    :slurp
                  :multiple :true
                  :default :present}
                 {:option "output-file"
                  :as "analytic output"
                  :type :string
                  :default :present}]
   :commands    [{:command     "sum-words"
                  :short "s"
                  #_:spec        #_::analyse-validation
                  :description ["Analyses .srt files and outputs all spoken words to a given file"]
                  :opts        [{:option "exclude-soundeffects"
                                 :short "se"
                                 :type :flag
                                 :default :true
                                 #_:spec #_::spec
                                 }]
                  :runs        sum-words}
                 ]})

(defn -main
  "This is our entry point.
  Just pass parameters and configuration.
  Commands (functions) will be invoked as appropriate."
  [& args]
  (cm-core/run-cmd args cli-matic-config))
