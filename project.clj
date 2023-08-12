(defproject sub-rip-analyser "0.0.1"
  :description "A Clojure command line tool designed to analyse Sub Rip Subtitle files."
  :url "https://github.com/Timo-Linde/sub-rip-analyser"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [cli-matic "0.5.4"]
                 [org.clojure/data.priority-map "1.1.0"]]
  :repl-options {:init-ns sub-rip-analyser.core}
  :main sub-rip-analyser.core
  :aot [sub-rip-analyser.core])

