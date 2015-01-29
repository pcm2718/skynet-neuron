(defproject skynet-neuron "0.1.0-SNAPSHOT"
  :description "BYU CS 478 . An implementation and discussion of the Perceptron learning algorithm. Written in Clojure."
  :url "http://github.com/pcm2718/minority-mirror"
;  :license {:name "Eclipse Public License"
;            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot skynet-neuron.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
