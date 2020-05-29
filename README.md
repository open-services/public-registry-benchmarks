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
## Report from 2020-05-29

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.792 ± 0.028 | 8.767 | 8.822 | 1.00 |
| `docker run -t npm--pnpm` | 8.819 ± 0.063 | 8.754 | 8.880 | 1.00 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.368 ± 0.177 | 10.190 | 10.545 | 1.18 ± 0.02 |
| `docker run -t npm--yarn` | 11.235 ± 0.148 | 11.088 | 11.384 | 1.28 ± 0.02 |
| `docker run -t yarn--yarn` | 11.370 ± 0.209 | 11.158 | 11.575 | 1.29 ± 0.02 |
| `docker run -t npm--npm` | 12.281 ± 0.133 | 12.179 | 12.432 | 1.40 ± 0.02 |
| `docker run -t yarn--npm` | 12.454 ± 0.046 | 12.408 | 12.500 | 1.42 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.843 ± 0.076 | 16.780 | 16.927 | 1.92 ± 0.01 |
| `docker run -t open-registry--npm` | 17.577 ± 0.219 | 17.405 | 17.824 | 2.00 ± 0.03 |
| `docker run -t bolivar--pnpm` | 19.431 ± 0.418 | 19.113 | 19.905 | 2.21 ± 0.05 |
| `docker run -t ipfs--pnpm` | 21.304 ± 1.677 | 19.963 | 23.184 | 2.42 ± 0.19 |
| `docker run -t cnpmjs--pnpm` | 21.696 ± 0.763 | 21.145 | 22.567 | 2.47 ± 0.09 |
| `docker run -t cnpmjs--npm` | 24.631 ± 2.949 | 22.804 | 28.033 | 2.80 ± 0.34 |
| `docker run -t bolivar--npm` | 38.429 ± 1.095 | 37.323 | 39.513 | 4.37 ± 0.13 |
| `docker run -t bolivar--yarn` | 42.794 ± 1.886 | 40.715 | 44.394 | 4.87 ± 0.22 |
| `docker run -t cnpmjs--yarn` | 50.070 ± 23.360 | 36.486 | 77.044 | 5.70 ± 2.66 |
| `docker run -t ipfs--npm` | 86.193 ± 46.543 | 47.579 | 137.872 | 9.80 ± 5.29 |
| `docker run -t ipfs--yarn` | 143.008 ± 77.180 | 56.907 | 205.976 | 16.27 ± 8.78 |
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
