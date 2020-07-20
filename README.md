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
## Report from 2020-07-20

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.963 ± 0.026 | 8.943 | 8.992 | 1.00 |
| `docker run -t yarn--pnpm` | 9.199 ± 0.038 | 9.167 | 9.240 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.487 ± 0.092 | 10.421 | 10.592 | 1.17 ± 0.01 |
| `docker run -t yarn--yarn` | 12.353 ± 0.090 | 12.254 | 12.430 | 1.38 ± 0.01 |
| `docker run -t npm--yarn` | 12.399 ± 0.217 | 12.201 | 12.631 | 1.38 ± 0.02 |
| `docker run -t npm--npm` | 12.940 ± 0.102 | 12.824 | 13.011 | 1.44 ± 0.01 |
| `docker run -t yarn--npm` | 13.480 ± 0.058 | 13.414 | 13.520 | 1.50 ± 0.01 |
| `docker run -t open-registry--yarn` | 17.012 ± 0.165 | 16.832 | 17.154 | 1.90 ± 0.02 |
| `docker run -t open-registry--npm` | 17.523 ± 0.200 | 17.346 | 17.740 | 1.96 ± 0.02 |
| `docker run -t ipfs--pnpm` | 18.634 ± 0.507 | 18.137 | 19.151 | 2.08 ± 0.06 |
| `docker run -t bolivar--pnpm` | 21.839 ± 0.391 | 21.439 | 22.219 | 2.44 ± 0.04 |
| `docker run -t cnpmjs--npm` | 24.328 ± 1.294 | 23.561 | 25.821 | 2.71 ± 0.14 |
| `docker run -t cnpmjs--yarn` | 38.197 ± 0.588 | 37.523 | 38.607 | 4.26 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 41.073 ± 37.527 | 19.199 | 84.405 | 4.58 ± 4.19 |
| `docker run -t bolivar--npm` | 41.146 ± 0.421 | 40.669 | 41.470 | 4.59 ± 0.05 |
| `docker run -t bolivar--yarn` | 43.731 ± 1.091 | 42.578 | 44.746 | 4.88 ± 0.12 |
| `docker run -t ipfs--yarn` | 83.193 ± 52.610 | 51.097 | 143.908 | 9.28 ± 5.87 |
| `docker run -t ipfs--npm` | 89.602 ± 20.688 | 75.994 | 113.409 | 10.00 ± 2.31 |
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
