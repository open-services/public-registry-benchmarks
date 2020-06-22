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
## Report from 2020-06-22

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 9.868 ± 1.245 | 9.000 | 11.294 | 1.00 |
| `docker run -t npm--pnpm` | 10.159 ± 0.086 | 10.092 | 10.256 | 1.03 ± 0.13 |
| `docker run -t open-registry--pnpm` | 10.672 ± 0.131 | 10.580 | 10.822 | 1.08 ± 0.14 |
| `docker run -t yarn--yarn` | 11.698 ± 0.099 | 11.590 | 11.785 | 1.19 ± 0.15 |
| `docker run -t npm--yarn` | 11.887 ± 0.020 | 11.875 | 11.909 | 1.20 ± 0.15 |
| `docker run -t npm--npm` | 12.702 ± 0.127 | 12.567 | 12.820 | 1.29 ± 0.16 |
| `docker run -t yarn--npm` | 12.980 ± 0.047 | 12.926 | 13.009 | 1.32 ± 0.17 |
| `docker run -t open-registry--yarn` | 17.342 ± 0.582 | 16.975 | 18.013 | 1.76 ± 0.23 |
| `docker run -t open-registry--npm` | 18.080 ± 0.096 | 17.996 | 18.185 | 1.83 ± 0.23 |
| `docker run -t bolivar--pnpm` | 19.245 ± 1.158 | 17.907 | 19.919 | 1.95 ± 0.27 |
| `docker run -t ipfs--pnpm` | 20.811 ± 1.053 | 19.595 | 21.443 | 2.11 ± 0.29 |
| `docker run -t cnpmjs--pnpm` | 21.065 ± 0.647 | 20.433 | 21.725 | 2.13 ± 0.28 |
| `docker run -t cnpmjs--npm` | 23.910 ± 0.552 | 23.430 | 24.513 | 2.42 ± 0.31 |
| `docker run -t bolivar--npm` | 38.574 ± 0.996 | 37.640 | 39.622 | 3.91 ± 0.50 |
| `docker run -t cnpmjs--yarn` | 38.647 ± 0.180 | 38.520 | 38.853 | 3.92 ± 0.49 |
| `docker run -t bolivar--yarn` | 44.167 ± 0.650 | 43.517 | 44.816 | 4.48 ± 0.57 |
| `docker run -t ipfs--npm` | 115.190 ± 43.289 | 77.960 | 162.691 | 11.67 ± 4.63 |
| `docker run -t ipfs--yarn` | 130.591 ± 39.887 | 101.662 | 176.093 | 13.23 ± 4.37 |
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
