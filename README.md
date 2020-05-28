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
## Report from 2020-05-28

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.091 ± 0.069 | 9.046 | 9.170 | 1.00 |
| `docker run -t yarn--pnpm` | 10.756 ± 0.263 | 10.489 | 11.014 | 1.18 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.601 ± 0.950 | 10.799 | 12.650 | 1.28 ± 0.10 |
| `docker run -t npm--yarn` | 11.771 ± 0.214 | 11.608 | 12.013 | 1.29 ± 0.03 |
| `docker run -t yarn--yarn` | 13.045 ± 0.280 | 12.871 | 13.368 | 1.44 ± 0.03 |
| `docker run -t npm--npm` | 13.435 ± 0.051 | 13.398 | 13.493 | 1.48 ± 0.01 |
| `docker run -t yarn--npm` | 14.558 ± 0.788 | 13.800 | 15.373 | 1.60 ± 0.09 |
| `docker run -t open-registry--yarn` | 17.648 ± 0.178 | 17.480 | 17.834 | 1.94 ± 0.02 |
| `docker run -t open-registry--npm` | 18.138 ± 0.045 | 18.090 | 18.180 | 2.00 ± 0.02 |
| `docker run -t bolivar--pnpm` | 20.824 ± 1.638 | 19.695 | 22.703 | 2.29 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 22.163 ± 1.953 | 20.464 | 24.297 | 2.44 ± 0.22 |
| `docker run -t ipfs--pnpm` | 35.449 ± 23.717 | 21.740 | 62.835 | 3.90 ± 2.61 |
| `docker run -t bolivar--npm` | 41.760 ± 0.780 | 41.238 | 42.657 | 4.59 ± 0.09 |
| `docker run -t cnpmjs--yarn` | 43.321 ± 11.946 | 36.390 | 57.114 | 4.77 ± 1.31 |
| `docker run -t bolivar--yarn` | 46.313 ± 0.931 | 45.243 | 46.933 | 5.09 ± 0.11 |
| `docker run -t cnpmjs--npm` | 63.650 ± 32.514 | 26.213 | 84.819 | 7.00 ± 3.58 |
| `docker run -t ipfs--npm` | 122.863 ± 64.403 | 53.059 | 179.975 | 13.52 ± 7.09 |
| `docker run -t ipfs--yarn` | 196.613 ± 40.531 | 170.830 | 243.330 | 21.63 ± 4.46 |
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
