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
## Report from 2020-07-13

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.121 ± 0.116 | 8.990 | 9.210 | 1.00 |
| `docker run -t yarn--pnpm` | 10.534 ± 0.218 | 10.302 | 10.735 | 1.15 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.882 ± 0.223 | 10.683 | 11.123 | 1.19 ± 0.03 |
| `docker run -t npm--yarn` | 12.417 ± 0.070 | 12.364 | 12.497 | 1.36 ± 0.02 |
| `docker run -t npm--npm` | 13.217 ± 0.212 | 13.056 | 13.458 | 1.45 ± 0.03 |
| `docker run -t yarn--yarn` | 13.288 ± 0.764 | 12.522 | 14.050 | 1.46 ± 0.09 |
| `docker run -t yarn--npm` | 15.143 ± 0.303 | 14.829 | 15.433 | 1.66 ± 0.04 |
| `docker run -t open-registry--yarn` | 17.679 ± 0.273 | 17.393 | 17.936 | 1.94 ± 0.04 |
| `docker run -t open-registry--npm` | 18.246 ± 0.405 | 18.007 | 18.714 | 2.00 ± 0.05 |
| `docker run -t ipfs--pnpm` | 18.267 ± 1.016 | 17.611 | 19.437 | 2.00 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 19.343 ± 0.136 | 19.186 | 19.422 | 2.12 ± 0.03 |
| `docker run -t bolivar--pnpm` | 19.623 ± 0.561 | 19.272 | 20.270 | 2.15 ± 0.07 |
| `docker run -t cnpmjs--npm` | 24.605 ± 0.815 | 23.696 | 25.272 | 2.70 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 38.107 ± 0.764 | 37.308 | 38.829 | 4.18 ± 0.10 |
| `docker run -t bolivar--npm` | 39.204 ± 1.506 | 37.473 | 40.212 | 4.30 ± 0.17 |
| `docker run -t bolivar--yarn` | 42.384 ± 1.355 | 40.906 | 43.566 | 4.65 ± 0.16 |
| `docker run -t ipfs--npm` | 55.440 ± 11.636 | 43.502 | 66.748 | 6.08 ± 1.28 |
| `docker run -t ipfs--yarn` | 102.048 ± 2.658 | 99.074 | 104.192 | 11.19 ± 0.32 |
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
