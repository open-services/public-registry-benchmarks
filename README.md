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
## Report from 2020-07-21

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.264 ± 0.121 | 8.124 | 8.335 | 1.00 |
| `docker run -t yarn--pnpm` | 8.529 ± 0.049 | 8.500 | 8.585 | 1.03 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.732 ± 0.120 | 9.594 | 9.812 | 1.18 ± 0.02 |
| `docker run -t npm--yarn` | 10.827 ± 0.073 | 10.760 | 10.905 | 1.31 ± 0.02 |
| `docker run -t yarn--yarn` | 11.381 ± 0.316 | 11.126 | 11.734 | 1.38 ± 0.04 |
| `docker run -t npm--npm` | 11.921 ± 0.358 | 11.702 | 12.334 | 1.44 ± 0.05 |
| `docker run -t yarn--npm` | 12.017 ± 0.136 | 11.883 | 12.156 | 1.45 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.966 ± 0.310 | 15.779 | 16.324 | 1.93 ± 0.05 |
| `docker run -t open-registry--npm` | 16.815 ± 0.658 | 16.276 | 17.549 | 2.03 ± 0.09 |
| `docker run -t ipfs--pnpm` | 17.786 ± 0.580 | 17.116 | 18.123 | 2.15 ± 0.08 |
| `docker run -t bolivar--pnpm` | 19.000 ± 1.767 | 17.971 | 21.040 | 2.30 ± 0.22 |
| `docker run -t cnpmjs--pnpm` | 19.098 ± 0.207 | 18.901 | 19.313 | 2.31 ± 0.04 |
| `docker run -t bolivar--npm` | 35.245 ± 0.845 | 34.665 | 36.214 | 4.26 ± 0.12 |
| `docker run -t bolivar--yarn` | 39.051 ± 0.078 | 38.968 | 39.122 | 4.73 ± 0.07 |
| `docker run -t cnpmjs--npm` | 44.717 ± 39.214 | 22.011 | 89.998 | 5.41 ± 4.75 |
| `docker run -t cnpmjs--yarn` | 46.225 ± 16.095 | 36.491 | 64.803 | 5.59 ± 1.95 |
| `docker run -t ipfs--npm` | 64.496 ± 17.050 | 44.825 | 75.036 | 7.80 ± 2.07 |
| `docker run -t ipfs--yarn` | 111.960 ± 61.054 | 52.479 | 174.474 | 13.55 ± 7.39 |
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
