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
## Report from 2020-05-08

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.766 ± 0.120 | 8.672 | 8.902 | 1.00 |
| `docker run -t yarn--pnpm` | 8.849 ± 0.228 | 8.704 | 9.112 | 1.01 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.062 ± 0.252 | 9.889 | 10.351 | 1.15 ± 0.03 |
| `docker run -t npm--yarn` | 11.243 ± 0.154 | 11.129 | 11.418 | 1.28 ± 0.02 |
| `docker run -t yarn--yarn` | 11.248 ± 0.107 | 11.181 | 11.372 | 1.28 ± 0.02 |
| `docker run -t npm--npm` | 12.234 ± 0.073 | 12.157 | 12.303 | 1.40 ± 0.02 |
| `docker run -t yarn--npm` | 12.593 ± 0.311 | 12.267 | 12.886 | 1.44 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.375 ± 0.191 | 16.165 | 16.537 | 1.87 ± 0.03 |
| `docker run -t open-registry--npm` | 16.834 ± 0.103 | 16.729 | 16.936 | 1.92 ± 0.03 |
| `docker run -t bolivar--pnpm` | 17.922 ± 0.605 | 17.571 | 18.620 | 2.04 ± 0.07 |
| `docker run -t ipfs--pnpm` | 19.238 ± 0.238 | 19.071 | 19.511 | 2.19 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 22.290 ± 0.191 | 22.104 | 22.486 | 2.54 ± 0.04 |
| `docker run -t cnpmjs--npm` | 23.270 ± 0.117 | 23.165 | 23.396 | 2.65 ± 0.04 |
| `docker run -t bolivar--npm` | 36.803 ± 1.365 | 35.656 | 38.313 | 4.20 ± 0.17 |
| `docker run -t bolivar--yarn` | 40.926 ± 2.657 | 39.369 | 43.994 | 4.67 ± 0.31 |
| `docker run -t ipfs--npm` | 46.720 ± 2.580 | 43.770 | 48.551 | 5.33 ± 0.30 |
| `docker run -t cnpmjs--yarn` | 49.590 ± 19.076 | 38.180 | 71.613 | 5.66 ± 2.18 |
| `docker run -t ipfs--yarn` | 58.353 ± 2.894 | 56.033 | 61.596 | 6.66 ± 0.34 |
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
