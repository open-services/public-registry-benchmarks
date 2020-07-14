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
## Report from 2020-07-14

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.654 ± 0.144 | 8.561 | 8.820 | 1.00 |
| `docker run -t npm--pnpm` | 8.764 ± 0.016 | 8.748 | 8.780 | 1.01 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.166 ± 0.210 | 9.947 | 10.367 | 1.17 ± 0.03 |
| `docker run -t yarn--yarn` | 11.063 ± 0.081 | 10.970 | 11.119 | 1.28 ± 0.02 |
| `docker run -t npm--yarn` | 11.223 ± 0.116 | 11.093 | 11.315 | 1.30 ± 0.03 |
| `docker run -t yarn--npm` | 12.393 ± 0.142 | 12.229 | 12.477 | 1.43 ± 0.03 |
| `docker run -t npm--npm` | 12.466 ± 0.026 | 12.446 | 12.495 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.869 ± 0.310 | 16.629 | 17.219 | 1.95 ± 0.05 |
| `docker run -t open-registry--npm` | 17.807 ± 0.396 | 17.351 | 18.067 | 2.06 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 19.181 ± 0.295 | 18.864 | 19.449 | 2.22 ± 0.05 |
| `docker run -t ipfs--pnpm` | 19.978 ± 1.869 | 18.735 | 22.127 | 2.31 ± 0.22 |
| `docker run -t bolivar--pnpm` | 20.560 ± 1.329 | 19.560 | 22.068 | 2.38 ± 0.16 |
| `docker run -t cnpmjs--npm` | 22.892 ± 1.073 | 22.266 | 24.131 | 2.65 ± 0.13 |
| `docker run -t cnpmjs--yarn` | 36.293 ± 0.472 | 35.959 | 36.833 | 4.19 ± 0.09 |
| `docker run -t bolivar--npm` | 38.823 ± 2.201 | 37.392 | 41.358 | 4.49 ± 0.27 |
| `docker run -t bolivar--yarn` | 43.106 ± 1.058 | 42.441 | 44.326 | 4.98 ± 0.15 |
| `docker run -t ipfs--yarn` | 105.437 ± 1.257 | 104.438 | 106.848 | 12.18 ± 0.25 |
| `docker run -t ipfs--npm` | 141.940 ± 19.046 | 124.333 | 162.156 | 16.40 ± 2.22 |
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
