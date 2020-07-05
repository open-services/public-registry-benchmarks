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
## Report from 2020-07-05

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.966 ± 0.083 | 9.885 | 10.051 | 1.00 |
| `docker run -t yarn--pnpm` | 10.467 ± 0.011 | 10.460 | 10.480 | 1.05 ± 0.01 |
| `docker run -t open-registry--pnpm` | 11.701 ± 0.431 | 11.222 | 12.059 | 1.17 ± 0.04 |
| `docker run -t npm--yarn` | 13.637 ± 0.097 | 13.560 | 13.746 | 1.37 ± 0.01 |
| `docker run -t yarn--yarn` | 13.877 ± 0.117 | 13.757 | 13.990 | 1.39 ± 0.02 |
| `docker run -t npm--npm` | 14.648 ± 0.214 | 14.453 | 14.877 | 1.47 ± 0.02 |
| `docker run -t yarn--npm` | 15.053 ± 0.122 | 14.925 | 15.169 | 1.51 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.520 ± 0.083 | 17.458 | 17.614 | 1.76 ± 0.02 |
| `docker run -t open-registry--yarn` | 18.282 ± 0.086 | 18.226 | 18.382 | 1.83 ± 0.02 |
| `docker run -t open-registry--npm` | 19.182 ± 0.571 | 18.774 | 19.834 | 1.92 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 19.556 ± 0.499 | 19.084 | 20.078 | 1.96 ± 0.05 |
| `docker run -t bolivar--pnpm` | 21.030 ± 0.746 | 20.187 | 21.604 | 2.11 ± 0.08 |
| `docker run -t cnpmjs--npm` | 26.100 ± 1.998 | 24.154 | 28.145 | 2.62 ± 0.20 |
| `docker run -t cnpmjs--yarn` | 38.652 ± 0.792 | 38.023 | 39.541 | 3.88 ± 0.09 |
| `docker run -t bolivar--npm` | 41.006 ± 1.051 | 39.820 | 41.821 | 4.11 ± 0.11 |
| `docker run -t bolivar--yarn` | 43.791 ± 1.356 | 42.824 | 45.341 | 4.39 ± 0.14 |
| `docker run -t ipfs--npm` | 82.642 ± 37.275 | 50.379 | 123.447 | 8.29 ± 3.74 |
| `docker run -t ipfs--yarn` | 118.997 ± 16.901 | 99.517 | 129.746 | 11.94 ± 1.70 |
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
