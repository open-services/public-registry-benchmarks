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
## Report from 2020-08-12

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.347 ± 0.073 | 9.279 | 9.425 | 1.00 |
| `docker run -t yarn--pnpm` | 9.642 ± 0.111 | 9.515 | 9.716 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.939 ± 0.129 | 10.819 | 11.075 | 1.17 ± 0.02 |
| `docker run -t yarn--yarn` | 12.934 ± 0.091 | 12.830 | 12.993 | 1.38 ± 0.01 |
| `docker run -t npm--yarn` | 12.971 ± 0.536 | 12.586 | 13.582 | 1.39 ± 0.06 |
| `docker run -t npm--npm` | 13.583 ± 0.164 | 13.448 | 13.766 | 1.45 ± 0.02 |
| `docker run -t yarn--npm` | 14.397 ± 0.436 | 13.948 | 14.820 | 1.54 ± 0.05 |
| `docker run -t ipfs--pnpm` | 17.163 ± 0.475 | 16.615 | 17.453 | 1.84 ± 0.05 |
| `docker run -t open-registry--yarn` | 17.299 ± 0.120 | 17.210 | 17.435 | 1.85 ± 0.02 |
| `docker run -t open-registry--npm` | 18.902 ± 0.719 | 18.191 | 19.629 | 2.02 ± 0.08 |
| `docker run -t cnpmjs--pnpm` | 19.317 ± 0.191 | 19.097 | 19.440 | 2.07 ± 0.03 |
| `docker run -t bolivar--pnpm` | 22.733 ± 1.283 | 21.825 | 24.201 | 2.43 ± 0.14 |
| `docker run -t cnpmjs--npm` | 25.323 ± 3.019 | 23.357 | 28.799 | 2.71 ± 0.32 |
| `docker run -t cnpmjs--yarn` | 37.587 ± 0.468 | 37.100 | 38.034 | 4.02 ± 0.06 |
| `docker run -t bolivar--npm` | 42.990 ± 0.448 | 42.556 | 43.452 | 4.60 ± 0.06 |
| `docker run -t bolivar--yarn` | 44.530 ± 0.967 | 43.734 | 45.606 | 4.76 ± 0.11 |
| `docker run -t ipfs--npm` | 47.532 ± 2.919 | 45.654 | 50.894 | 5.09 ± 0.31 |
| `docker run -t ipfs--yarn` | 55.354 ± 14.781 | 46.741 | 72.421 | 5.92 ± 1.58 |
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
