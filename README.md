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
## Report from 2020-05-14

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.546 ± 0.105 | 8.476 | 8.667 | 1.00 |
| `docker run -t yarn--pnpm` | 8.635 ± 0.229 | 8.459 | 8.894 | 1.01 ± 0.03 |
| `docker run -t open-registry--pnpm` | 9.889 ± 0.019 | 9.868 | 9.906 | 1.16 ± 0.01 |
| `docker run -t yarn--yarn` | 11.250 ± 0.053 | 11.190 | 11.292 | 1.32 ± 0.02 |
| `docker run -t npm--yarn` | 11.264 ± 0.053 | 11.206 | 11.311 | 1.32 ± 0.02 |
| `docker run -t npm--npm` | 12.169 ± 0.043 | 12.131 | 12.215 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.416 ± 0.102 | 12.303 | 12.503 | 1.45 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.095 ± 0.039 | 16.051 | 16.127 | 1.88 ± 0.02 |
| `docker run -t open-registry--npm` | 16.874 ± 0.480 | 16.445 | 17.393 | 1.97 ± 0.06 |
| `docker run -t bolivar--pnpm` | 17.166 ± 0.826 | 16.268 | 17.894 | 2.01 ± 0.10 |
| `docker run -t ipfs--pnpm` | 20.501 ± 0.967 | 19.664 | 21.559 | 2.40 ± 0.12 |
| `docker run -t bolivar--npm` | 34.594 ± 0.272 | 34.288 | 34.807 | 4.05 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 37.228 ± 26.077 | 22.108 | 67.339 | 4.36 ± 3.05 |
| `docker run -t bolivar--yarn` | 38.528 ± 0.745 | 37.831 | 39.314 | 4.51 ± 0.10 |
| `docker run -t cnpmjs--npm` | 43.986 ± 33.372 | 23.344 | 82.487 | 5.15 ± 3.91 |
| `docker run -t cnpmjs--yarn` | 51.238 ± 16.898 | 39.641 | 70.626 | 6.00 ± 1.98 |
| `docker run -t ipfs--yarn` | 69.593 ± 15.144 | 53.934 | 84.163 | 8.14 ± 1.77 |
| `docker run -t ipfs--npm` | 76.947 ± 20.719 | 64.898 | 100.871 | 9.00 ± 2.43 |
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
