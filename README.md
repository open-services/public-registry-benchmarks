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
## Report from 2020-06-28

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.671 ± 0.178 | 8.559 | 8.876 | 1.00 |
| `docker run -t yarn--pnpm` | 8.810 ± 0.026 | 8.781 | 8.831 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.052 ± 0.121 | 9.967 | 10.190 | 1.16 ± 0.03 |
| `docker run -t yarn--yarn` | 11.250 ± 0.326 | 10.930 | 11.582 | 1.30 ± 0.05 |
| `docker run -t npm--yarn` | 11.419 ± 0.344 | 11.156 | 11.808 | 1.32 ± 0.05 |
| `docker run -t npm--npm` | 12.364 ± 0.240 | 12.115 | 12.594 | 1.43 ± 0.04 |
| `docker run -t yarn--npm` | 12.530 ± 0.606 | 12.176 | 13.230 | 1.45 ± 0.08 |
| `docker run -t open-registry--yarn` | 16.660 ± 0.023 | 16.641 | 16.685 | 1.92 ± 0.04 |
| `docker run -t open-registry--npm` | 17.466 ± 0.455 | 17.005 | 17.915 | 2.01 ± 0.07 |
| `docker run -t bolivar--pnpm` | 18.502 ± 0.029 | 18.474 | 18.532 | 2.13 ± 0.04 |
| `docker run -t ipfs--pnpm` | 18.976 ± 0.694 | 18.369 | 19.732 | 2.19 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 22.340 ± 1.041 | 21.193 | 23.224 | 2.58 ± 0.13 |
| `docker run -t cnpmjs--npm` | 25.146 ± 1.321 | 23.958 | 26.569 | 2.90 ± 0.16 |
| `docker run -t bolivar--npm` | 38.781 ± 0.293 | 38.445 | 38.980 | 4.47 ± 0.10 |
| `docker run -t bolivar--yarn` | 42.762 ± 0.904 | 41.859 | 43.668 | 4.93 ± 0.15 |
| `docker run -t cnpmjs--yarn` | 43.636 ± 9.612 | 38.081 | 54.734 | 5.03 ± 1.11 |
| `docker run -t ipfs--npm` | 55.190 ± 13.269 | 46.539 | 70.467 | 6.37 ± 1.54 |
| `docker run -t ipfs--yarn` | 67.597 ± 18.167 | 53.118 | 87.982 | 7.80 ± 2.10 |
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
