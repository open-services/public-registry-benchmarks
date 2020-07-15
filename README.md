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
## Report from 2020-07-15

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.357 ± 0.110 | 9.230 | 9.431 | 1.00 |
| `docker run -t yarn--pnpm` | 9.958 ± 0.305 | 9.610 | 10.177 | 1.06 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.203 ± 0.738 | 10.656 | 12.042 | 1.20 ± 0.08 |
| `docker run -t npm--yarn` | 12.459 ± 0.259 | 12.175 | 12.681 | 1.33 ± 0.03 |
| `docker run -t yarn--yarn` | 12.754 ± 0.044 | 12.703 | 12.781 | 1.36 ± 0.02 |
| `docker run -t npm--npm` | 13.466 ± 0.055 | 13.403 | 13.505 | 1.44 ± 0.02 |
| `docker run -t yarn--npm` | 13.831 ± 0.135 | 13.676 | 13.919 | 1.48 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.901 ± 0.338 | 16.511 | 17.106 | 1.81 ± 0.04 |
| `docker run -t open-registry--npm` | 18.105 ± 0.087 | 18.018 | 18.192 | 1.93 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 19.251 ± 0.232 | 19.063 | 19.510 | 2.06 ± 0.03 |
| `docker run -t bolivar--pnpm` | 19.492 ± 0.847 | 18.663 | 20.357 | 2.08 ± 0.09 |
| `docker run -t ipfs--pnpm` | 20.301 ± 1.884 | 19.203 | 22.476 | 2.17 ± 0.20 |
| `docker run -t cnpmjs--yarn` | 38.589 ± 0.531 | 38.129 | 39.170 | 4.12 ± 0.07 |
| `docker run -t bolivar--npm` | 39.551 ± 0.939 | 38.770 | 40.592 | 4.23 ± 0.11 |
| `docker run -t bolivar--yarn` | 44.216 ± 0.660 | 43.522 | 44.837 | 4.73 ± 0.09 |
| `docker run -t cnpmjs--npm` | 48.560 ± 38.937 | 23.322 | 93.402 | 5.19 ± 4.16 |
| `docker run -t ipfs--yarn` | 86.852 ± 29.685 | 52.577 | 104.299 | 9.28 ± 3.17 |
| `docker run -t ipfs--npm` | 121.452 ± 38.378 | 80.738 | 156.962 | 12.98 ± 4.10 |
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
