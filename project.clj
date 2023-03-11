(defproject precisely/rapids-chatgpt "0.0.1"
  :description "A Rapids library for integrating with the OpenAI GPT-3 API"
  :url "https://github.com/precisely/rapids-chatgpt"
  :license {:name "All Rights Reserved"
            :url  "https://precise.ly/rapids"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [precisely/rapids "LATEST"]
                 #_[potemkin "0.4.5"]]
  :repositories {"precisely" {:url        "s3p://precisely-maven-repo/"
                              :username   :env/maven_repo_aws_access_key_id
                              :passphrase :env/maven_repo_aws_access_key_secret}}

  :aot []
  :clean-targets ^{:protect false} ["target"]
  :profiles {:dev {
                   :source-paths ["src"]
                   :dependencies [[expectations/clojure-test "1.2.1"]
                                  [org.clojure/tools.macro "0.1.5"]
                                  [philoskim/debux "0.8.2"]]
                   :plugins      [[lein-dotenv "RELEASE"]
                                  [lein-ancient "1.0.0-RC3"]
                                  [lein-cloverage "1.2.4"]
                                  [s3-wagon-private "1.3.4"]]
                   :cloverage    {:exclude-call     []
                                  :ns-exclude-regex []}}}

  :repl-options {:init-ns rapids-chatgpt.support.repl}
  :codox {:doc-paths []}
  :plugins [[lein-codox "0.10.6"]
            [lein-ancient "1.0.0-RC3"]
            [lein-cloverage "1.2.4"]
            [s3-wagon-private "1.3.4"]]

  :foo :bar
  :deploy-repositories [["precisely" {:url           "s3p://precisely-maven-repo/"
                                      :username      :env/maven_repo_aws_access_key_id
                                      :passphrase    :env/maven_repo_aws_access_key_secret
                                      :sign-releases false}]]

  :test-selectors {:default     (complement :integration)
                   :integration :integration
                   :unit        :unit
                   :all         (constantly true)}

  :main rapids-chatgpt.main)
