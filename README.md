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
## Report from 2020-06-24

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.543 ± 0.116 | 8.411 | 8.630 | 1.00 |
| `docker run -t yarn--pnpm` | 8.656 ± 0.008 | 8.648 | 8.663 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.988 ± 0.318 | 9.742 | 10.347 | 1.17 ± 0.04 |
| `docker run -t npm--yarn` | 11.107 ± 0.282 | 10.847 | 11.407 | 1.30 ± 0.04 |
| `docker run -t yarn--yarn` | 11.249 ± 0.287 | 11.000 | 11.563 | 1.32 ± 0.04 |
| `docker run -t npm--npm` | 12.167 ± 0.025 | 12.141 | 12.190 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.325 ± 0.116 | 12.191 | 12.394 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.679 ± 0.185 | 16.534 | 16.888 | 1.95 ± 0.03 |
| `docker run -t open-registry--npm` | 17.125 ± 0.344 | 16.882 | 17.519 | 2.00 ± 0.05 |
| `docker run -t bolivar--pnpm` | 19.696 ± 1.629 | 18.653 | 21.573 | 2.31 ± 0.19 |
| `docker run -t ipfs--pnpm` | 20.500 ± 0.411 | 20.197 | 20.968 | 2.40 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 20.729 ± 0.149 | 20.566 | 20.859 | 2.43 ± 0.04 |
| `docker run -t cnpmjs--npm` | 27.343 ± 3.360 | 23.511 | 29.788 | 3.20 ± 0.40 |
| `docker run -t bolivar--npm` | 37.910 ± 1.687 | 36.927 | 39.859 | 4.44 ± 0.21 |
| `docker run -t cnpmjs--yarn` | 38.467 ± 0.664 | 37.815 | 39.142 | 4.50 ± 0.10 |
| `docker run -t bolivar--yarn` | 42.245 ± 0.660 | 41.527 | 42.825 | 4.94 ± 0.10 |
| `docker run -t ipfs--yarn` | 75.675 ± 18.486 | 55.043 | 90.733 | 8.86 ± 2.17 |
| `docker run -t ipfs--npm` | 104.618 ± 44.304 | 54.428 | 138.289 | 12.25 ± 5.19 |
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
