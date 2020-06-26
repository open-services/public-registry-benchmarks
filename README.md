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
## Report from 2020-06-26

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.129 ± 0.081 | 9.040 | 9.198 | 1.00 |
| `docker run -t yarn--pnpm` | 9.299 ± 0.095 | 9.238 | 9.409 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.594 ± 0.177 | 10.418 | 10.771 | 1.16 ± 0.02 |
| `docker run -t npm--yarn` | 12.222 ± 0.137 | 12.086 | 12.360 | 1.34 ± 0.02 |
| `docker run -t yarn--yarn` | 12.439 ± 0.165 | 12.287 | 12.615 | 1.36 ± 0.02 |
| `docker run -t npm--npm` | 13.267 ± 0.059 | 13.209 | 13.326 | 1.45 ± 0.01 |
| `docker run -t yarn--npm` | 13.686 ± 0.455 | 13.405 | 14.210 | 1.50 ± 0.05 |
| `docker run -t open-registry--yarn` | 17.189 ± 0.066 | 17.126 | 17.259 | 1.88 ± 0.02 |
| `docker run -t open-registry--npm` | 17.996 ± 0.283 | 17.795 | 18.320 | 1.97 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 19.886 ± 0.156 | 19.783 | 20.065 | 2.18 ± 0.03 |
| `docker run -t ipfs--pnpm` | 19.973 ± 1.514 | 18.370 | 21.378 | 2.19 ± 0.17 |
| `docker run -t bolivar--pnpm` | 20.508 ± 0.235 | 20.245 | 20.696 | 2.25 ± 0.03 |
| `docker run -t cnpmjs--npm` | 24.668 ± 0.227 | 24.459 | 24.909 | 2.70 ± 0.03 |
| `docker run -t cnpmjs--yarn` | 39.092 ± 0.260 | 38.794 | 39.268 | 4.28 ± 0.05 |
| `docker run -t bolivar--npm` | 40.193 ± 0.497 | 39.622 | 40.526 | 4.40 ± 0.07 |
| `docker run -t bolivar--yarn` | 42.194 ± 0.368 | 41.970 | 42.619 | 4.62 ± 0.06 |
| `docker run -t ipfs--npm` | 83.586 ± 8.920 | 77.373 | 93.807 | 9.16 ± 0.98 |
| `docker run -t ipfs--yarn` | 137.906 ± 32.252 | 111.715 | 173.930 | 15.11 ± 3.54 |
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
