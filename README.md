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
## Report from 2020-06-04

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.629 ± 0.116 | 8.522 | 8.752 | 1.00 |
| `docker run -t yarn--pnpm` | 8.920 ± 0.186 | 8.784 | 9.132 | 1.03 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.174 ± 0.526 | 9.807 | 10.776 | 1.18 ± 0.06 |
| `docker run -t npm--yarn` | 11.185 ± 0.315 | 11.001 | 11.548 | 1.30 ± 0.04 |
| `docker run -t yarn--yarn` | 11.486 ± 0.440 | 11.215 | 11.994 | 1.33 ± 0.05 |
| `docker run -t npm--npm` | 12.368 ± 0.100 | 12.255 | 12.442 | 1.43 ± 0.02 |
| `docker run -t yarn--npm` | 12.442 ± 0.119 | 12.339 | 12.573 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.263 ± 0.235 | 15.993 | 16.420 | 1.88 ± 0.04 |
| `docker run -t open-registry--npm` | 16.871 ± 0.025 | 16.845 | 16.895 | 1.96 ± 0.03 |
| `docker run -t ipfs--pnpm` | 17.537 ± 1.726 | 16.357 | 19.518 | 2.03 ± 0.20 |
| `docker run -t bolivar--pnpm` | 18.088 ± 0.297 | 17.802 | 18.396 | 2.10 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 20.492 ± 0.276 | 20.319 | 20.811 | 2.37 ± 0.05 |
| `docker run -t cnpmjs--npm` | 27.130 ± 3.265 | 23.362 | 29.132 | 3.14 ± 0.38 |
| `docker run -t bolivar--npm` | 34.939 ± 0.635 | 34.272 | 35.536 | 4.05 ± 0.09 |
| `docker run -t bolivar--yarn` | 38.460 ± 1.006 | 37.644 | 39.584 | 4.46 ± 0.13 |
| `docker run -t cnpmjs--yarn` | 39.732 ± 0.415 | 39.473 | 40.211 | 4.60 ± 0.08 |
| `docker run -t ipfs--yarn` | 47.832 ± 0.614 | 47.140 | 48.310 | 5.54 ± 0.10 |
| `docker run -t ipfs--npm` | 50.361 ± 9.904 | 43.710 | 61.743 | 5.84 ± 1.15 |
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
