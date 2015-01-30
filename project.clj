(defproject skynet-neuron "0.1.0-SNAPSHOT"
  :description "BYU CS 478 . An implementation and discussion of the Perceptron learning algorithm. Written in Clojure."
  :url "http://github.com/pcm2718/minority-mirror"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main toolkit.MLSystemManager
  :aot [perceptron.Perceptron]
  :source-paths ["src" "src/perceptron"]
  :java-source-paths ["src/toolkit"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
