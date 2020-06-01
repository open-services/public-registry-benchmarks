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
## Report from 2020-06-01

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.895 ± 0.112 | 8.806 | 9.021 | 1.00 |
| `docker run -t yarn--pnpm` | 9.065 ± 0.130 | 8.959 | 9.210 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 11.064 ± 0.607 | 10.385 | 11.554 | 1.24 ± 0.07 |
| `docker run -t yarn--yarn` | 11.567 ± 0.137 | 11.416 | 11.684 | 1.30 ± 0.02 |
| `docker run -t npm--yarn` | 11.589 ± 0.332 | 11.376 | 11.971 | 1.30 ± 0.04 |
| `docker run -t npm--npm` | 12.383 ± 0.064 | 12.310 | 12.431 | 1.39 ± 0.02 |
| `docker run -t yarn--npm` | 12.628 ± 0.134 | 12.480 | 12.742 | 1.42 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.309 ± 0.174 | 16.119 | 16.461 | 1.83 ± 0.03 |
| `docker run -t open-registry--npm` | 16.925 ± 0.216 | 16.691 | 17.119 | 1.90 ± 0.03 |
| `docker run -t bolivar--pnpm` | 17.877 ± 0.679 | 17.323 | 18.635 | 2.01 ± 0.08 |
| `docker run -t ipfs--pnpm` | 19.296 ± 0.456 | 18.885 | 19.786 | 2.17 ± 0.06 |
| `docker run -t cnpmjs--npm` | 23.550 ± 0.232 | 23.415 | 23.818 | 2.65 ± 0.04 |
| `docker run -t bolivar--npm` | 35.475 ± 0.430 | 35.153 | 35.963 | 3.99 ± 0.07 |
| `docker run -t bolivar--yarn` | 37.790 ± 1.159 | 36.984 | 39.119 | 4.25 ± 0.14 |
| `docker run -t cnpmjs--pnpm` | 59.786 ± 33.030 | 22.027 | 83.328 | 6.72 ± 3.71 |
| `docker run -t cnpmjs--yarn` | 65.758 ± 2.685 | 63.657 | 68.783 | 7.39 ± 0.32 |
| `docker run -t ipfs--npm` | 74.503 ± 44.662 | 47.698 | 126.061 | 8.38 ± 5.02 |
| `docker run -t ipfs--yarn` | 83.201 ± 54.627 | 50.364 | 146.261 | 9.35 ± 6.14 |
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
