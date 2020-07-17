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
## Report from 2020-07-17

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.500 ± 0.096 | 8.390 | 8.572 | 1.00 |
| `docker run -t yarn--pnpm` | 8.600 ± 0.008 | 8.591 | 8.607 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.955 ± 0.026 | 9.934 | 9.984 | 1.17 ± 0.01 |
| `docker run -t npm--yarn` | 11.133 ± 0.449 | 10.801 | 11.644 | 1.31 ± 0.05 |
| `docker run -t yarn--yarn` | 11.191 ± 0.130 | 11.111 | 11.341 | 1.32 ± 0.02 |
| `docker run -t yarn--npm` | 12.078 ± 0.080 | 12.017 | 12.168 | 1.42 ± 0.02 |
| `docker run -t npm--npm` | 12.164 ± 0.035 | 12.143 | 12.205 | 1.43 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.132 ± 0.105 | 17.068 | 17.254 | 2.02 ± 0.03 |
| `docker run -t open-registry--npm` | 17.336 ± 0.439 | 16.978 | 17.825 | 2.04 ± 0.06 |
| `docker run -t ipfs--pnpm` | 18.194 ± 0.578 | 17.527 | 18.546 | 2.14 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 19.214 ± 0.107 | 19.109 | 19.323 | 2.26 ± 0.03 |
| `docker run -t bolivar--pnpm` | 19.701 ± 0.987 | 18.566 | 20.360 | 2.32 ± 0.12 |
| `docker run -t cnpmjs--npm` | 21.696 ± 0.367 | 21.384 | 22.100 | 2.55 ± 0.05 |
| `docker run -t bolivar--npm` | 37.516 ± 0.546 | 37.106 | 38.136 | 4.41 ± 0.08 |
| `docker run -t bolivar--yarn` | 40.980 ± 0.775 | 40.454 | 41.870 | 4.82 ± 0.11 |
| `docker run -t cnpmjs--yarn` | 43.675 ± 12.256 | 36.097 | 57.816 | 5.14 ± 1.44 |
| `docker run -t ipfs--yarn` | 51.530 ± 0.593 | 51.124 | 52.210 | 6.06 ± 0.10 |
| `docker run -t ipfs--npm` | 62.758 ± 33.992 | 42.989 | 102.009 | 7.38 ± 4.00 |
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
