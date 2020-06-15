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
## Report from 2020-06-15

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.559 ± 0.045 | 8.507 | 8.593 | 1.00 |
| `docker run -t yarn--pnpm` | 8.721 ± 0.120 | 8.582 | 8.793 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.057 ± 0.451 | 9.795 | 10.578 | 1.18 ± 0.05 |
| `docker run -t yarn--yarn` | 11.037 ± 0.287 | 10.745 | 11.319 | 1.29 ± 0.03 |
| `docker run -t npm--yarn` | 11.180 ± 0.293 | 10.991 | 11.517 | 1.31 ± 0.03 |
| `docker run -t yarn--npm` | 12.343 ± 0.043 | 12.315 | 12.392 | 1.44 ± 0.01 |
| `docker run -t npm--npm` | 12.425 ± 0.204 | 12.305 | 12.661 | 1.45 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.978 ± 0.165 | 15.840 | 16.161 | 1.87 ± 0.02 |
| `docker run -t open-registry--npm` | 16.756 ± 0.114 | 16.651 | 16.877 | 1.96 ± 0.02 |
| `docker run -t ipfs--pnpm` | 19.119 ± 0.616 | 18.514 | 19.747 | 2.23 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.377 ± 0.734 | 18.847 | 20.215 | 2.26 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 20.158 ± 0.384 | 19.765 | 20.533 | 2.36 ± 0.05 |
| `docker run -t cnpmjs--npm` | 24.847 ± 1.730 | 22.861 | 26.026 | 2.90 ± 0.20 |
| `docker run -t bolivar--npm` | 36.874 ± 0.455 | 36.514 | 37.385 | 4.31 ± 0.06 |
| `docker run -t cnpmjs--yarn` | 39.104 ± 0.082 | 39.034 | 39.194 | 4.57 ± 0.03 |
| `docker run -t bolivar--yarn` | 40.735 ± 1.044 | 39.529 | 41.364 | 4.76 ± 0.12 |
| `docker run -t ipfs--npm` | 79.823 ± 30.989 | 45.877 | 106.598 | 9.33 ± 3.62 |
| `docker run -t ipfs--yarn` | 106.019 ± 0.513 | 105.434 | 106.389 | 12.39 ± 0.09 |
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
