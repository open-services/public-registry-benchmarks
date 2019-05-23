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
              :pnpm "3.1.0"
              })

(def registries {;; https://yarnpkg.com/
                 :yarn "https://registry.yarnpkg.com"
                 ;; https://www.npmjs.com/
                 :npm "https://registry.npmjs.org"
                 ;; https://github.com/ipfs-shipyard/npm-on-ipfs
                 :ipfs "https://registry.js.ipfs.io"
                 ;; http://node-modules.io/
                 :node-modules "https://registry.node-modules.io"
                 ;; https://cnpmjs.org/
                 :cnpmjs "https://r.cnpmjs.org"
                 ;; https://github.com/open-services/open-registry
                 :open-registry "https://npm.open-registry.dev"
                 ;; https://github.com/open-services/bolivar
                 :bolivar "http://localhost:8080"
                 ;; :github "https://npm.pkg.github.com"
                 })

;; Bolivar-specifics
(def bolivar-dist "https://github.com/open-services/bolivar/releases/download/0.1.0/bolivar-0.1.0-linux-amd64")
(def fetch-bolivar (str "RUN wget " bolivar-dist))
(def make-bolivar+x "RUN chmod +x bolivar-0.1.0-linux-amd64")
(def move-bolivar "RUN mv bolivar-0.1.0-linux-amd64 /usr/local/bin/bolivar")
(def start-and-wait "until tail -f bolivar.log | grep -m 1 \"Starting server\"; do : ; done")
(def run-bolivar+client-install
  (format "bash -c 'bolivar > bolivar.log & %s && $client install --verbose'" start-and-wait))

;; Here you can add any specific steps a registry needs
(def special-build-steps {:bolivar [fetch-bolivar
                                    make-bolivar+x
                                    move-bolivar]})

;; Here you can define a separate command for running the test. It should,
;; as a last action, install all dependences for the project in WORKDIR
(def run-cmds {:bolivar run-bolivar+client-install})

(def default-run-cmd "$client install --verbose")

(defn get-run-cmd [registry]
  (let [run-cmd (registry run-cmds)]
    (if (nil? run-cmd)
      default-run-cmd
      run-cmd)))

(defn dockerfile-template [extra-steps cmd]
  (clojure.string/join "\n"
                       (vec (concat ["FROM benchmarks-base"
                                     "RUN npm install -g $client@$version"]
                                    extra-steps
                                    ["RUN $client config set registry $registry"
                                     (str "CMD " cmd)]))))

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
        image-name (format "%s--%s" (name registry) (name client))
        extra-steps (registry special-build-steps)
        run-cmd (get-run-cmd registry)]
    (println image-name)
    (spit (str "tests/" image-name)
          (new-dockerfile (dockerfile-template extra-steps run-cmd)
                          (name client)
                          client-version
                          registry-url))))
