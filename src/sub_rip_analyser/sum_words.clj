(ns sub-rip-analyser.sum-words
  (:require
    [clojure.data.priority-map :refer [priority-map]]
    [clojure.string :as str]
    [sub-rip-analyser.srt :as srt]))

;; TODO: Fill list
(def ^:private punctuation
  #{\.
    \-
    \?
    \!
    \,})

(defn- punctuation?
  [c]
  (contains? punctuation c))

(defn- remove-punctuation
  [s]
  (->> s
       (remove punctuation?)
       (apply str)))


(defn- remove-soundeffect
  [s]
  (str/replace s #"\(.*\)" ""))

(defn- count-word
  [m word]
  (let [word-count
        (->> m
             (filter #(= word %))
             (count))]
    (hash-map word word-count)))

(defn- count-words
  [m]
  (let [all-existing-words (set m)]
    (->> all-existing-words
         (map (partial count-word m))
         (apply merge)
         (into (priority-map))
         (reverse))))

(defn- generate-output
  [m]
  (->> m
    (map (fn [[word count]]
           (str "Wort: '" word "', Anzahl: " count \newline)))
    (apply str)))

(defn sum-words
  "This function counts the words used in a .srt file."
  [{:keys [input-files output-file exclude-soundeffects]}]
  ;; Step 1: Parse .srt Files
  ;; Step 2: Look at all files together
  ;; Step 3: We only need the Text
  ;; Step 4: Remove soundeffects if needed
  ;; Step 5: Remove punctuations
  ;; Step 6: Split the Text into words
  ;; Step 7: Remove empty words
  ;; Step 8: Remove empty sequences
  ;; Step 9: Look at all words together
  ;; Step 10: Count all Words
  ;; Step 11: Generate Output
  ;; Step 12: Write Output to File
  (->> input-files
    (map srt/parse-srt)
    (apply concat)
    (map :text)
    (map (if exclude-soundeffects remove-soundeffect identity))
    (map remove-punctuation)
    (map (fn [text]
           (str/split text #" ")))
    (map (partial remove empty?))
    (remove empty?)
    (apply concat)
    (count-words)
    (generate-output)
    (spit output-file)))


(comment
  (def terminator-1
    (slurp "./data/Der Terminator 1984.srt"))
  (def terminator-2
    (slurp "./data/Terminator 2 1991.srt"))
  (sum-words {:file [terminator-1 terminator-2]
              :only-nouns true}))