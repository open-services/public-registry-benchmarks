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
## Report from 2020-06-10

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.281 ± 0.054 | 9.224 | 9.332 | 1.00 |
| `docker run -t yarn--pnpm` | 9.696 ± 0.163 | 9.510 | 9.818 | 1.04 ± 0.02 |
| `docker run -t open-registry--pnpm` | 11.201 ± 0.420 | 10.930 | 11.685 | 1.21 ± 0.05 |
| `docker run -t npm--yarn` | 12.300 ± 0.221 | 12.073 | 12.514 | 1.33 ± 0.03 |
| `docker run -t yarn--yarn` | 12.389 ± 0.181 | 12.181 | 12.495 | 1.33 ± 0.02 |
| `docker run -t yarn--npm` | 13.527 ± 0.151 | 13.368 | 13.670 | 1.46 ± 0.02 |
| `docker run -t npm--npm` | 14.600 ± 0.729 | 14.097 | 15.437 | 1.57 ± 0.08 |
| `docker run -t open-registry--yarn` | 17.588 ± 0.192 | 17.387 | 17.769 | 1.90 ± 0.02 |
| `docker run -t open-registry--npm` | 18.865 ± 0.322 | 18.582 | 19.215 | 2.03 ± 0.04 |
| `docker run -t bolivar--pnpm` | 19.239 ± 0.399 | 18.957 | 19.696 | 2.07 ± 0.04 |
| `docker run -t ipfs--pnpm` | 19.583 ± 0.537 | 19.064 | 20.137 | 2.11 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 23.874 ± 0.056 | 23.809 | 23.909 | 2.57 ± 0.02 |
| `docker run -t cnpmjs--npm` | 25.027 ± 0.396 | 24.754 | 25.481 | 2.70 ± 0.05 |
| `docker run -t bolivar--npm` | 37.629 ± 1.396 | 36.564 | 39.210 | 4.05 ± 0.15 |
| `docker run -t cnpmjs--yarn` | 39.008 ± 0.497 | 38.526 | 39.519 | 4.20 ± 0.06 |
| `docker run -t bolivar--yarn` | 41.791 ± 0.839 | 40.881 | 42.534 | 4.50 ± 0.09 |
| `docker run -t ipfs--npm` | 86.668 ± 15.870 | 71.461 | 103.127 | 9.34 ± 1.71 |
| `docker run -t ipfs--yarn` | 111.038 ± 34.262 | 71.546 | 132.822 | 11.96 ± 3.69 |
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
