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
## Report from 2020-06-05

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.852 ± 0.076 | 8.784 | 8.934 | 1.00 |
| `docker run -t yarn--pnpm` | 9.195 ± 0.246 | 8.962 | 9.452 | 1.04 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.187 ± 0.035 | 10.167 | 10.227 | 1.15 ± 0.01 |
| `docker run -t yarn--yarn` | 11.923 ± 0.597 | 11.440 | 12.590 | 1.35 ± 0.07 |
| `docker run -t npm--yarn` | 12.132 ± 0.663 | 11.522 | 12.838 | 1.37 ± 0.08 |
| `docker run -t npm--npm` | 12.505 ± 0.151 | 12.353 | 12.656 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.758 ± 0.089 | 12.672 | 12.849 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.754 ± 0.208 | 16.608 | 16.992 | 1.89 ± 0.03 |
| `docker run -t open-registry--npm` | 16.974 ± 0.035 | 16.936 | 17.004 | 1.92 ± 0.02 |
| `docker run -t ipfs--pnpm` | 18.098 ± 0.632 | 17.545 | 18.787 | 2.04 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.554 ± 1.569 | 18.146 | 21.245 | 2.21 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 20.499 ± 0.223 | 20.337 | 20.753 | 2.32 ± 0.03 |
| `docker run -t cnpmjs--npm` | 24.015 ± 0.326 | 23.728 | 24.370 | 2.71 ± 0.04 |
| `docker run -t bolivar--npm` | 36.464 ± 0.633 | 35.745 | 36.937 | 4.12 ± 0.08 |
| `docker run -t bolivar--yarn` | 38.422 ± 0.322 | 38.129 | 38.766 | 4.34 ± 0.05 |
| `docker run -t cnpmjs--yarn` | 40.215 ± 0.642 | 39.711 | 40.938 | 4.54 ± 0.08 |
| `docker run -t ipfs--yarn` | 69.336 ± 11.305 | 56.511 | 77.858 | 7.83 ± 1.28 |
| `docker run -t ipfs--npm` | 75.170 ± 32.468 | 45.903 | 110.096 | 8.49 ± 3.67 |
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
