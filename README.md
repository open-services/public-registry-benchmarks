## open-registry-benchmarks

This tests the performance of open-registry

## Usage

Run `clojure generate-tests.clj`

Run `./build.sh`

Run `./run.sh`

Look at `report.md`

## Requirements

- A shell
- Docker
- Hyperfine
- Clojure (to compile the testcases)
- Parallel
- Patience

<!-- REPORT -->
## Report from 2019-05-30

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 8.801 ± 0.046 | 8.771…8.854 |
| `docker run -t npm--pnpm` | 8.999 ± 0.330 | 8.618…9.199 |
| `docker run -t open-registry--pnpm` | 9.854 ± 0.096 | 9.749…9.939 |
| `docker run -t node-modules--pnpm` | 9.920 ± 0.069 | 9.848…9.985 |
| `docker run -t npm--yarn` | 11.366 ± 0.142 | 11.236…11.518 |
| `docker run -t yarn--yarn` | 11.421 ± 0.042 | 11.395…11.469 |
| `docker run -t npm--npm` | 12.011 ± 0.206 | 11.787…12.193 |
| `docker run -t yarn--npm` | 12.615 ± 0.399 | 12.191…12.983 |
| `docker run -t open-registry--yarn` | 16.206 ± 0.088 | 16.128…16.301 |
| `docker run -t open-registry--npm` | 17.080 ± 0.251 | 16.798…17.277 |
| `docker run -t cnpmjs--pnpm` | 18.462 ± 0.364 | 18.055…18.758 |
| `docker run -t ipfs--pnpm` | 21.416 ± 1.134 | 20.353…22.609 |
| `docker run -t cnpmjs--npm` | 22.405 ± 0.288 | 22.188…22.732 |
| `docker run -t node-modules--yarn` | 23.191 ± 0.808 | 22.487…24.073 |
| `docker run -t node-modules--npm` | 23.377 ± 1.073 | 22.447…24.551 |
| `docker run -t cnpmjs--yarn` | 35.789 ± 0.308 | 35.434…35.991 |
| `docker run -t ipfs--npm` | 73.057 ± 12.223 | 63.604…86.860 |
| `docker run -t ipfs--yarn` | 91.244 ± 46.342 | 62.722…144.715 |
| `docker run -t bolivar--pnpm` | 94.726 ± 2.390 | 92.292…97.070 |
| `docker run -t bolivar--npm` | 117.562 ± 25.067 | 99.829…146.241 |
| `docker run -t bolivar--yarn` | 160.905 ± 23.411 | 134.226…178.022 |
<!-- REPORT_END -->

### List of registries

Here is a list of some public npm registries:

- https://registry.npmjs.org
- https://registry.yarnpkg.com
- https://registry.node-modules.io
- https://r.cnpmjs.org
- https://registry.js.ipfs.io
- http://registry.npmjs.eu - Broken: self-signed cert
- https://registry.nodejitsu.com - Broken: no response
- https://npm.strongloop.com - Broken: invalid cert

## Adding new registries/clients

You can add your own registry/client if you follow the format in
`generate-tests.clj` and send a PR.

### `tests/`

The `tests/` directory contains one Dockerfile per test. The Dockerfile
sets everything up for the test. The naming convention is "$registry--$client"
so `npm--npm` would mean using the `npm` client to request from `registry.npmjs.org`,
the file `yarn--npm` would mean using the `npm` client to request from `registry.yarnpkg.com`

All of these are generated from running `clojure generate-tests.clj`, so don't
change them directly.

## License

Copyright 2019 Open-Registry

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
