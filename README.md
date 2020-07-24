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
## Report from 2020-07-24

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.672 ± 0.073 | 8.628 | 8.757 | 1.00 |
| `docker run -t yarn--pnpm` | 8.827 ± 0.004 | 8.822 | 8.830 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.363 ± 0.134 | 10.208 | 10.443 | 1.19 ± 0.02 |
| `docker run -t npm--yarn` | 11.153 ± 0.197 | 11.023 | 11.379 | 1.29 ± 0.03 |
| `docker run -t yarn--yarn` | 11.316 ± 0.323 | 11.055 | 11.677 | 1.30 ± 0.04 |
| `docker run -t npm--npm` | 12.309 ± 0.159 | 12.167 | 12.481 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.508 ± 0.023 | 12.482 | 12.522 | 1.44 ± 0.01 |
| `docker run -t open-registry--yarn` | 17.425 ± 0.286 | 17.237 | 17.753 | 2.01 ± 0.04 |
| `docker run -t open-registry--npm` | 17.810 ± 0.192 | 17.618 | 18.002 | 2.05 ± 0.03 |
| `docker run -t ipfs--pnpm` | 18.817 ± 0.008 | 18.808 | 18.823 | 2.17 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.394 ± 1.597 | 17.867 | 21.054 | 2.24 ± 0.19 |
| `docker run -t cnpmjs--npm` | 25.584 ± 2.700 | 22.689 | 28.033 | 2.95 ± 0.31 |
| `docker run -t cnpmjs--yarn` | 36.684 ± 0.442 | 36.183 | 37.015 | 4.23 ± 0.06 |
| `docker run -t bolivar--npm` | 37.865 ± 0.363 | 37.613 | 38.282 | 4.37 ± 0.06 |
| `docker run -t bolivar--yarn` | 41.546 ± 1.313 | 40.076 | 42.602 | 4.79 ± 0.16 |
| `docker run -t cnpmjs--pnpm` | 63.715 ± 37.457 | 20.465 | 85.655 | 7.35 ± 4.32 |
| `docker run -t ipfs--yarn` | 69.626 ± 30.803 | 51.629 | 105.193 | 8.03 ± 3.55 |
| `docker run -t ipfs--npm` | 105.758 ± 104.369 | 45.149 | 226.273 | 12.20 ± 12.04 |
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
