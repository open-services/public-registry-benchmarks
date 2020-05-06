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
## Report from 2020-05-06

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.412 ± 0.091 | 8.308 | 8.477 | 1.00 |
| `docker run -t yarn--pnpm` | 8.689 ± 0.047 | 8.636 | 8.724 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.643 ± 0.116 | 9.517 | 9.746 | 1.15 ± 0.02 |
| `docker run -t yarn--yarn` | 10.982 ± 0.347 | 10.700 | 11.370 | 1.31 ± 0.04 |
| `docker run -t npm--yarn` | 11.048 ± 0.091 | 10.966 | 11.146 | 1.31 ± 0.02 |
| `docker run -t npm--npm` | 12.054 ± 0.185 | 11.891 | 12.256 | 1.43 ± 0.03 |
| `docker run -t yarn--npm` | 12.632 ± 0.231 | 12.383 | 12.840 | 1.50 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.932 ± 0.030 | 15.898 | 15.950 | 1.89 ± 0.02 |
| `docker run -t open-registry--npm` | 16.468 ± 0.154 | 16.345 | 16.641 | 1.96 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.100 ± 0.576 | 17.721 | 18.763 | 2.15 ± 0.07 |
| `docker run -t ipfs--pnpm` | 20.351 ± 0.261 | 20.055 | 20.547 | 2.42 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 22.537 ± 1.366 | 21.468 | 24.076 | 2.68 ± 0.16 |
| `docker run -t cnpmjs--npm` | 26.483 ± 2.332 | 23.791 | 27.899 | 3.15 ± 0.28 |
| `docker run -t bolivar--npm` | 35.371 ± 2.143 | 33.741 | 37.799 | 4.20 ± 0.26 |
| `docker run -t bolivar--yarn` | 40.334 ± 2.367 | 38.282 | 42.924 | 4.79 ± 0.29 |
| `docker run -t cnpmjs--yarn` | 43.061 ± 8.160 | 38.341 | 52.484 | 5.12 ± 0.97 |
| `docker run -t ipfs--npm` | 56.190 ± 6.968 | 51.810 | 64.225 | 6.68 ± 0.83 |
| `docker run -t ipfs--yarn` | 66.147 ± 16.135 | 56.113 | 84.759 | 7.86 ± 1.92 |
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
