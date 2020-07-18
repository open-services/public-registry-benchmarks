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
## Report from 2020-07-18

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.015 ± 0.149 | 7.843 | 8.104 | 1.00 |
| `docker run -t yarn--pnpm` | 8.268 ± 0.007 | 8.260 | 8.272 | 1.03 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.606 ± 0.226 | 9.448 | 9.864 | 1.20 ± 0.04 |
| `docker run -t npm--yarn` | 10.403 ± 0.154 | 10.227 | 10.515 | 1.30 ± 0.03 |
| `docker run -t yarn--yarn` | 10.463 ± 0.008 | 10.454 | 10.471 | 1.31 ± 0.02 |
| `docker run -t npm--npm` | 11.517 ± 0.133 | 11.394 | 11.658 | 1.44 ± 0.03 |
| `docker run -t yarn--npm` | 11.665 ± 0.103 | 11.546 | 11.732 | 1.46 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.604 ± 0.095 | 15.518 | 15.707 | 1.95 ± 0.04 |
| `docker run -t open-registry--npm` | 16.141 ± 0.330 | 15.839 | 16.494 | 2.01 ± 0.06 |
| `docker run -t ipfs--pnpm` | 17.896 ± 0.938 | 17.075 | 18.918 | 2.23 ± 0.12 |
| `docker run -t bolivar--pnpm` | 18.804 ± 0.795 | 18.310 | 19.720 | 2.35 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 19.296 ± 0.395 | 18.903 | 19.692 | 2.41 ± 0.07 |
| `docker run -t cnpmjs--npm` | 22.425 ± 0.480 | 21.969 | 22.927 | 2.80 ± 0.08 |
| `docker run -t bolivar--npm` | 35.442 ± 0.720 | 34.729 | 36.169 | 4.42 ± 0.12 |
| `docker run -t bolivar--yarn` | 38.651 ± 0.668 | 38.238 | 39.422 | 4.82 ± 0.12 |
| `docker run -t cnpmjs--yarn` | 65.122 ± 47.180 | 37.583 | 119.599 | 8.13 ± 5.89 |
| `docker run -t ipfs--npm` | 75.165 ± 18.639 | 63.018 | 96.625 | 9.38 ± 2.33 |
| `docker run -t ipfs--yarn` | 83.745 ± 22.746 | 65.267 | 109.149 | 10.45 ± 2.84 |
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
