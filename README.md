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
## Report from 2020-07-12

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.003 ± 0.046 | 8.968 | 9.056 | 1.00 |
| `docker run -t yarn--pnpm` | 9.299 ± 0.090 | 9.227 | 9.400 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.459 ± 0.098 | 10.375 | 10.566 | 1.16 ± 0.01 |
| `docker run -t yarn--yarn` | 12.546 ± 0.272 | 12.328 | 12.851 | 1.39 ± 0.03 |
| `docker run -t npm--yarn` | 12.595 ± 0.584 | 12.143 | 13.255 | 1.40 ± 0.07 |
| `docker run -t npm--npm` | 13.164 ± 0.150 | 13.036 | 13.330 | 1.46 ± 0.02 |
| `docker run -t yarn--npm` | 13.271 ± 0.133 | 13.155 | 13.416 | 1.47 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.876 ± 0.253 | 16.710 | 17.168 | 1.87 ± 0.03 |
| `docker run -t open-registry--npm` | 17.555 ± 0.068 | 17.500 | 17.632 | 1.95 ± 0.01 |
| `docker run -t ipfs--pnpm` | 18.316 ± 0.395 | 17.992 | 18.756 | 2.03 ± 0.05 |
| `docker run -t cnpmjs--pnpm` | 19.250 ± 0.333 | 18.866 | 19.461 | 2.14 ± 0.04 |
| `docker run -t bolivar--pnpm` | 21.287 ± 1.921 | 20.124 | 23.505 | 2.36 ± 0.21 |
| `docker run -t cnpmjs--yarn` | 38.318 ± 0.711 | 37.667 | 39.076 | 4.26 ± 0.08 |
| `docker run -t bolivar--npm` | 38.444 ± 0.158 | 38.322 | 38.623 | 4.27 ± 0.03 |
| `docker run -t bolivar--yarn` | 42.395 ± 0.922 | 41.712 | 43.444 | 4.71 ± 0.11 |
| `docker run -t cnpmjs--npm` | 47.702 ± 38.004 | 24.175 | 91.546 | 5.30 ± 4.22 |
| `docker run -t ipfs--yarn` | 57.711 ± 10.361 | 50.558 | 69.592 | 6.41 ± 1.15 |
| `docker run -t ipfs--npm` | 104.350 ± 49.086 | 47.676 | 133.399 | 11.59 ± 5.45 |
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
