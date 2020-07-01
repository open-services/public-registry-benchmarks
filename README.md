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
## Report from 2020-07-01

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.455 ± 0.091 | 8.350 | 8.518 | 1.00 |
| `docker run -t yarn--pnpm` | 8.618 ± 0.090 | 8.560 | 8.722 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.801 ± 0.099 | 9.709 | 9.905 | 1.16 ± 0.02 |
| `docker run -t yarn--yarn` | 11.457 ± 0.720 | 10.990 | 12.287 | 1.36 ± 0.09 |
| `docker run -t npm--yarn` | 11.518 ± 0.430 | 11.064 | 11.920 | 1.36 ± 0.05 |
| `docker run -t yarn--npm` | 12.279 ± 0.084 | 12.183 | 12.339 | 1.45 ± 0.02 |
| `docker run -t npm--npm` | 12.332 ± 0.130 | 12.183 | 12.425 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 15.977 ± 0.122 | 15.837 | 16.056 | 1.89 ± 0.02 |
| `docker run -t open-registry--npm` | 16.396 ± 0.102 | 16.291 | 16.494 | 1.94 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.107 ± 0.562 | 16.470 | 17.531 | 2.02 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.504 ± 0.558 | 19.135 | 20.146 | 2.31 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 20.055 ± 0.125 | 19.912 | 20.136 | 2.37 ± 0.03 |
| `docker run -t bolivar--npm` | 36.110 ± 0.320 | 35.904 | 36.479 | 4.27 ± 0.06 |
| `docker run -t bolivar--yarn` | 38.902 ± 0.445 | 38.642 | 39.415 | 4.60 ± 0.07 |
| `docker run -t cnpmjs--yarn` | 40.331 ± 1.156 | 39.401 | 41.625 | 4.77 ± 0.15 |
| `docker run -t ipfs--npm` | 46.756 ± 5.262 | 41.696 | 52.199 | 5.53 ± 0.63 |
| `docker run -t ipfs--yarn` | 57.234 ± 13.830 | 48.258 | 73.160 | 6.77 ± 1.64 |
| `docker run -t cnpmjs--npm` | 72.870 ± 42.092 | 24.327 | 99.246 | 8.62 ± 4.98 |
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
