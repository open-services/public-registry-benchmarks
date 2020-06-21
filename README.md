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
## Report from 2020-06-21

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.380 ± 0.107 | 9.287 | 9.497 | 1.00 |
| `docker run -t yarn--pnpm` | 9.410 ± 0.171 | 9.213 | 9.513 | 1.00 ± 0.02 |
| `docker run -t open-registry--pnpm` | 11.035 ± 0.261 | 10.805 | 11.318 | 1.18 ± 0.03 |
| `docker run -t yarn--yarn` | 11.998 ± 0.029 | 11.969 | 12.027 | 1.28 ± 0.01 |
| `docker run -t npm--yarn` | 12.119 ± 0.096 | 12.029 | 12.219 | 1.29 ± 0.02 |
| `docker run -t npm--npm` | 13.307 ± 0.311 | 13.046 | 13.651 | 1.42 ± 0.04 |
| `docker run -t yarn--npm` | 13.608 ± 0.015 | 13.594 | 13.624 | 1.45 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.750 ± 0.442 | 17.447 | 18.257 | 1.89 ± 0.05 |
| `docker run -t open-registry--npm` | 18.307 ± 0.407 | 18.028 | 18.774 | 1.95 ± 0.05 |
| `docker run -t ipfs--pnpm` | 18.679 ± 0.596 | 18.072 | 19.263 | 1.99 ± 0.07 |
| `docker run -t bolivar--pnpm` | 20.090 ± 1.026 | 18.954 | 20.951 | 2.14 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 22.963 ± 0.233 | 22.695 | 23.098 | 2.45 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 38.318 ± 0.349 | 37.929 | 38.603 | 4.08 ± 0.06 |
| `docker run -t bolivar--npm` | 41.804 ± 1.605 | 40.316 | 43.504 | 4.46 ± 0.18 |
| `docker run -t bolivar--yarn` | 46.530 ± 1.200 | 45.387 | 47.780 | 4.96 ± 0.14 |
| `docker run -t cnpmjs--npm` | 48.912 ± 37.184 | 25.514 | 91.788 | 5.21 ± 3.96 |
| `docker run -t ipfs--yarn` | 57.426 ± 12.738 | 49.623 | 72.125 | 6.12 ± 1.36 |
| `docker run -t ipfs--npm` | 119.846 ± 62.558 | 47.666 | 158.393 | 12.78 ± 6.67 |
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
