;;; Reimplement this with function return via closure later.
;;; The weird immutable stuff could make this slow, find a workaround if possible.

(defn perceptron-rule [weight lr result target inval]
  (+ weight (* lr (- target result) inval)))

;(defn delta-rule)

;(defn perceptron-build [weights])

(defn perceptron-recall [perceptron invec]
  (if (> (apply + (map * perceptron invec)) 0) 1 0))

(defn perceptron-train-datum [perceptron invec target]
  ; Should I use identical? here?
  (let [result (perceptron-recall perceptron invec)]
    (if (= result target)
      ; If the recall and the target are equal, then return
      ; perceptron unmodified.
      perceptron
      ; Otherwise, return a new perceptron created by modifying
      ; perceptron according to the given rule.
      (map (fn [weight inval] (perceptron-rule weight 0.1 result target inval))
           perceptron invec))))

(defn perceptron-train-datum-test [initialperceptron invec target]
  (loop [perceptron initialperceptron]
    (let [next-perceptron (perceptron-train-datum perceptron invec target)]
      ; This line of code is kind of sketchy.
      (if (every? identity (map < (map (fn [b a] (Math/abs (- b a))) next-perceptron perceptron) [0.001 0.001]))
        perceptron
        (recur next-perceptron)))))

;; Maybe for my lab I could examine the difference between stopping
;; inside or inbetween epochs.
(defn perceptron-train-data [ip data]
  (loop [p ip
         data data]
    (let [datum (first data)]
      (if (nil? datum)
        p
        (recur (perceptron-train-datum p (first datum) (second datum)) (rest data))))))

;; Fix the biasing dealie.
