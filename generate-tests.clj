;; /usr/bin/env sh
;;
;; Benchmarks are generated from two lists of clients + registries
;; So having the lists ["npm" "yarn"] and ["npm-reg" "yarn-reg"] should generate
;; one list of ["npm--npm-reg"]

;; (def projects [
;;   "freeCodeCamp/freeCodeCamp#35cfffebd5db40837e285a8731eadc1a2d99f7c1"
;;   "vuejs/vue"
;;   "twbs/bootstrap"
;;   "facebook/react"
;;   "getify/You-Dont-Know-JS"
;;   "airbnb/javascript"
;;   "electron/electron"
;;   "nodejs/node"
;;   "axios/axios"
;;   "mrdoob/three.js"
;;   "justjavac/free-programming-books-zh_CN"
;;   "atom/atom"
;;   "webpack/webpack"
;;   "trekhleb/javascript-algorithms"
;;   "Microsoft/TypeScript"
;;   "angular/angular"
;;   "mui-org/material-ui"
;;   "expressjs/express"
;;   "30-seconds/30-seconds-of-code"
;;   "chartjs/Chart.js"
;;   "h5bp/html5-boilerplate"
;;   "meteor/meteor"
;;   "lodash/lodash"
;;   "ionic-team/ionic"
;;   "ElemeFE/element"
;;   "storybooks/storybook"
;;   "Dogfalo/materialize"
;;   "yarnpkg/yarn"
;;   "nwjs/nw.js"
;;   "thedaviddias/Front-End-Checklist"
;; ])

;; (def packages ["lodash"
;;                "request"
;;                "chalk"
;;                "react"
;;                "express"
;;                "commander"
;;                "moment"
;;                "debug"
;;                "async"
;;                "bluebird"
;;                "prop-types"
;;                "react-dom"])

(def clients {:yarn "1.15.2"
              :npm "6.9.0"
              :pnpm "3.1.0"})

(def registries {:yarn "https://registry.yarnpkg.com"
                 :npm "https://registry.npmjs.org"
                 :ipfs "https://registry.js.ipfs.io"
                 :node-modules "https://registry.node-modules.io"
                 :cnpmjs "https://r.cnpmjs.org"
                 :open-registry "https://npm.open-registry.dev"})

(def dockerfile-template
  (clojure.string/join "\n"
                       ["FROM benchmarks-base"
                        "RUN npm install -g $client@$version"
                        "RUN $client config set registry $registry"
                        "CMD $client install --verbose"]))

(defn cartesian-product
  "All the ways to take one item from each sequence"
  [& seqs]
  (let [v-original-seqs (vec seqs)
        step
        (fn step [v-seqs]
          (let [increment
                (fn [v-seqs]
                  (loop [i (dec (count v-seqs)), v-seqs v-seqs]
                    (if (= i -1) nil
                      (if-let [rst (next (v-seqs i))]
                        (assoc v-seqs i rst)
                        (recur (dec i) (assoc v-seqs i (v-original-seqs i)))))))]
            (when v-seqs
              (cons (map first v-seqs)
                    (lazy-seq (step (increment v-seqs)))))))]
    (when (every? seq seqs)
      (lazy-seq (step v-original-seqs)))))

(def versions (cartesian-product (keys clients) (keys registries)))

(defn new-dockerfile [template client version registry]
  (-> template
      (clojure.string/replace "$client" client)
      (clojure.string/replace "$version" version)
      (clojure.string/replace "$registry" registry)))

(println "Different versions:")
(println versions)

(doseq [[client registry] versions]
  (println (format "### Generating for test = Client: %s Registry %s" client registry))
  (let [client-version (client clients)
        registry-url (registry registries)
        image-name (format "%s--%s" (name registry) (name client))]
    (println image-name)
    (spit (str "tests/" image-name)
          (new-dockerfile dockerfile-template
                          (name client)
                          client-version
                          registry-url))))
