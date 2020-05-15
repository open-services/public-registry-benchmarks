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
## Report from 2020-05-15

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 10.425 ± 0.160 | 10.240 | 10.529 | 1.00 |
| `docker run -t yarn--pnpm` | 10.553 ± 0.055 | 10.505 | 10.613 | 1.01 ± 0.02 |
| `docker run -t open-registry--pnpm` | 11.875 ± 0.237 | 11.646 | 12.119 | 1.14 ± 0.03 |
| `docker run -t npm--yarn` | 14.242 ± 0.511 | 13.934 | 14.831 | 1.37 ± 0.05 |
| `docker run -t yarn--yarn` | 14.273 ± 0.102 | 14.167 | 14.370 | 1.37 ± 0.02 |
| `docker run -t npm--npm` | 14.958 ± 0.099 | 14.846 | 15.034 | 1.43 ± 0.02 |
| `docker run -t yarn--npm` | 15.506 ± 0.133 | 15.353 | 15.597 | 1.49 ± 0.03 |
| `docker run -t ipfs--pnpm` | 18.851 ± 0.897 | 18.110 | 19.848 | 1.81 ± 0.09 |
| `docker run -t open-registry--yarn` | 18.897 ± 0.652 | 18.500 | 19.650 | 1.81 ± 0.07 |
| `docker run -t open-registry--npm` | 19.315 ± 0.314 | 19.114 | 19.677 | 1.85 ± 0.04 |
| `docker run -t bolivar--pnpm` | 21.377 ± 1.551 | 19.732 | 22.812 | 2.05 ± 0.15 |
| `docker run -t cnpmjs--pnpm` | 22.544 ± 0.440 | 22.058 | 22.915 | 2.16 ± 0.05 |
| `docker run -t bolivar--npm` | 41.140 ± 1.634 | 40.156 | 43.026 | 3.95 ± 0.17 |
| `docker run -t bolivar--yarn` | 42.680 ± 1.219 | 41.349 | 43.742 | 4.09 ± 0.13 |
| `docker run -t cnpmjs--npm` | 47.700 ± 36.626 | 25.532 | 89.976 | 4.58 ± 3.51 |
| `docker run -t cnpmjs--yarn` | 51.498 ± 9.820 | 40.279 | 58.532 | 4.94 ± 0.95 |
| `docker run -t ipfs--yarn` | 75.712 ± 23.373 | 54.729 | 100.904 | 7.26 ± 2.24 |
| `docker run -t ipfs--npm` | 76.123 ± 13.542 | 60.836 | 86.619 | 7.30 ± 1.30 |
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
