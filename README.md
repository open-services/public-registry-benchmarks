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
## Report from 2020-06-13

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.347 ± 0.054 | 8.311 | 8.409 | 1.00 |
| `docker run -t yarn--pnpm` | 9.329 ± 0.061 | 9.261 | 9.379 | 1.12 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.678 ± 0.133 | 10.594 | 10.831 | 1.28 ± 0.02 |
| `docker run -t npm--yarn` | 10.890 ± 0.118 | 10.808 | 11.025 | 1.30 ± 0.02 |
| `docker run -t yarn--yarn` | 11.797 ± 0.099 | 11.727 | 11.910 | 1.41 ± 0.01 |
| `docker run -t npm--npm` | 12.086 ± 0.245 | 11.883 | 12.357 | 1.45 ± 0.03 |
| `docker run -t yarn--npm` | 13.263 ± 0.290 | 12.957 | 13.533 | 1.59 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.493 ± 0.076 | 16.439 | 16.580 | 1.98 ± 0.02 |
| `docker run -t open-registry--npm` | 17.060 ± 0.155 | 16.892 | 17.196 | 2.04 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.137 ± 1.915 | 17.168 | 20.994 | 2.29 ± 0.23 |
| `docker run -t ipfs--pnpm` | 19.363 ± 0.242 | 19.150 | 19.626 | 2.32 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 20.375 ± 0.342 | 19.980 | 20.586 | 2.44 ± 0.04 |
| `docker run -t cnpmjs--npm` | 23.731 ± 0.571 | 23.236 | 24.356 | 2.84 ± 0.07 |
| `docker run -t bolivar--npm` | 37.105 ± 1.870 | 35.058 | 38.725 | 4.45 ± 0.23 |
| `docker run -t bolivar--yarn` | 39.133 ± 0.742 | 38.277 | 39.582 | 4.69 ± 0.09 |
| `docker run -t cnpmjs--yarn` | 39.522 ± 0.659 | 39.043 | 40.274 | 4.73 ± 0.08 |
| `docker run -t ipfs--npm` | 80.373 ± 22.768 | 57.764 | 103.297 | 9.63 ± 2.73 |
| `docker run -t ipfs--yarn` | 127.069 ± 71.011 | 52.858 | 194.376 | 15.22 ± 8.51 |
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
