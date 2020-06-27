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
## Report from 2020-06-27

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.136 ± 0.116 | 9.006 | 9.228 | 1.00 |
| `docker run -t yarn--pnpm` | 9.600 ± 0.149 | 9.427 | 9.691 | 1.05 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.852 ± 0.368 | 10.604 | 11.274 | 1.19 ± 0.04 |
| `docker run -t npm--yarn` | 12.335 ± 0.133 | 12.218 | 12.479 | 1.35 ± 0.02 |
| `docker run -t yarn--yarn` | 12.626 ± 0.288 | 12.391 | 12.947 | 1.38 ± 0.04 |
| `docker run -t npm--npm` | 13.305 ± 0.214 | 13.061 | 13.465 | 1.46 ± 0.03 |
| `docker run -t yarn--npm` | 13.730 ± 0.080 | 13.678 | 13.822 | 1.50 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.856 ± 0.123 | 16.722 | 16.965 | 1.84 ± 0.03 |
| `docker run -t open-registry--npm` | 17.561 ± 0.077 | 17.485 | 17.639 | 1.92 ± 0.03 |
| `docker run -t ipfs--pnpm` | 19.981 ± 1.079 | 19.148 | 21.200 | 2.19 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 20.395 ± 0.206 | 20.214 | 20.619 | 2.23 ± 0.04 |
| `docker run -t bolivar--pnpm` | 20.955 ± 0.304 | 20.685 | 21.283 | 2.29 ± 0.04 |
| `docker run -t cnpmjs--npm` | 26.387 ± 1.722 | 24.437 | 27.697 | 2.89 ± 0.19 |
| `docker run -t bolivar--npm` | 40.019 ± 1.213 | 39.223 | 41.415 | 4.38 ± 0.14 |
| `docker run -t cnpmjs--yarn` | 40.053 ± 0.321 | 39.748 | 40.389 | 4.38 ± 0.07 |
| `docker run -t bolivar--yarn` | 41.867 ± 1.167 | 40.713 | 43.047 | 4.58 ± 0.14 |
| `docker run -t ipfs--yarn` | 120.891 ± 17.797 | 109.783 | 141.418 | 13.23 ± 1.96 |
| `docker run -t ipfs--npm` | 123.615 ± 67.326 | 57.169 | 191.787 | 13.53 ± 7.37 |
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
