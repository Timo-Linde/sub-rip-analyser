(ns sub-rip-analyser.srt
  (:require
    [clojure.string :as str]))

(defn- ->map
  [m]
  (let [time (second m)
        time-splitted (str/split time #" --> ")]
  {:numeric-counter (first m)
   :time-start (first time-splitted)
   :time-end (last time-splitted)
   :text (nth m 2)}))

(defn parse-srt
  "Parses a SubRip .srt file to a clojure data structure"
  [s]
  ;; A .srt file is just a text file with a defined format:
  ;; Source: https://en.wikipedia.org/wiki/SubRip
  ;; One entry is always 4 lines long.
  ;; Line 1: A numeric counter identifying each sequential subtitle
  ;; Line 2: The time that the subtitle should appear on the screen, followed by --> and the time it should disappear
  ;; Line 3: Subtitle text itself on one or more lines
  ;; Line 4: A blank line containing no text, indicating the end of this subtitle

  ;; Step 1 Split whole string into a sequence of lines.
  ;; Step 2 Separate Entries (4 lines long)
  ;; Step 3 (optional) Convert to Map
  (->> s
       (str/split-lines)
       (partition 4)
       (map ->map)))

(comment
  (def raw-file
    (slurp "C:/git/sub-rip-analyser/data/Der Terminator 1984.srt"))
  (parse-srt raw-file)
  )