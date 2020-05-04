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
## Report from 2020-05-04

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.274 ± 0.049 | 8.217 | 8.304 | 1.00 |
| `docker run -t yarn--pnpm` | 8.571 ± 0.230 | 8.413 | 8.834 | 1.04 ± 0.03 |
| `docker run -t open-registry--pnpm` | 9.948 ± 0.106 | 9.868 | 10.068 | 1.20 ± 0.01 |
| `docker run -t npm--yarn` | 10.914 ± 0.091 | 10.815 | 10.993 | 1.32 ± 0.01 |
| `docker run -t yarn--yarn` | 10.937 ± 0.101 | 10.859 | 11.051 | 1.32 ± 0.01 |
| `docker run -t npm--npm` | 12.043 ± 0.057 | 11.986 | 12.099 | 1.46 ± 0.01 |
| `docker run -t yarn--npm` | 12.145 ± 0.185 | 12.030 | 12.358 | 1.47 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.619 ± 0.073 | 16.550 | 16.696 | 2.01 ± 0.01 |
| `docker run -t open-registry--npm` | 17.096 ± 0.289 | 16.873 | 17.423 | 2.07 ± 0.04 |
| `docker run -t bolivar--pnpm` | 18.814 ± 0.311 | 18.569 | 19.164 | 2.27 ± 0.04 |
| `docker run -t ipfs--pnpm` | 19.191 ± 0.134 | 19.037 | 19.270 | 2.32 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 19.276 ± 0.346 | 18.877 | 19.495 | 2.33 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 34.130 ± 0.919 | 33.573 | 35.190 | 4.12 ± 0.11 |
| `docker run -t bolivar--npm` | 35.171 ± 0.368 | 34.819 | 35.553 | 4.25 ± 0.05 |
| `docker run -t bolivar--yarn` | 39.756 ± 1.101 | 38.673 | 40.873 | 4.80 ± 0.14 |
| `docker run -t ipfs--npm` | 49.165 ± 2.188 | 46.686 | 50.830 | 5.94 ± 0.27 |
| `docker run -t ipfs--yarn` | 59.159 ± 6.582 | 51.828 | 64.560 | 7.15 ± 0.80 |
| `docker run -t cnpmjs--npm` | 62.891 ± 35.088 | 22.469 | 85.493 | 7.60 ± 4.24 |
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
