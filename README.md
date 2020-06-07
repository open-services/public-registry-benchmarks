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
## Report from 2020-06-07

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.717 ± 0.112 | 8.592 | 8.806 | 1.00 |
| `docker run -t yarn--pnpm` | 8.996 ± 0.358 | 8.764 | 9.408 | 1.03 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.354 ± 0.101 | 10.245 | 10.443 | 1.19 ± 0.02 |
| `docker run -t npm--yarn` | 11.230 ± 0.072 | 11.177 | 11.312 | 1.29 ± 0.02 |
| `docker run -t yarn--yarn` | 11.296 ± 0.046 | 11.265 | 11.349 | 1.30 ± 0.02 |
| `docker run -t yarn--npm` | 12.797 ± 0.699 | 12.390 | 13.605 | 1.47 ± 0.08 |
| `docker run -t npm--npm` | 13.013 ± 1.133 | 12.290 | 14.319 | 1.49 ± 0.13 |
| `docker run -t open-registry--yarn` | 17.369 ± 0.187 | 17.154 | 17.490 | 1.99 ± 0.03 |
| `docker run -t open-registry--npm` | 17.818 ± 0.203 | 17.679 | 18.051 | 2.04 ± 0.04 |
| `docker run -t ipfs--pnpm` | 17.955 ± 0.457 | 17.575 | 18.463 | 2.06 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.063 ± 0.537 | 18.461 | 19.492 | 2.19 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 24.049 ± 0.725 | 23.612 | 24.886 | 2.76 ± 0.09 |
| `docker run -t cnpmjs--npm` | 24.088 ± 0.532 | 23.581 | 24.642 | 2.76 ± 0.07 |
| `docker run -t bolivar--npm` | 36.643 ± 0.827 | 35.689 | 37.131 | 4.20 ± 0.11 |
| `docker run -t cnpmjs--yarn` | 38.448 ± 0.146 | 38.320 | 38.607 | 4.41 ± 0.06 |
| `docker run -t bolivar--yarn` | 40.521 ± 0.667 | 39.812 | 41.136 | 4.65 ± 0.10 |
| `docker run -t ipfs--npm` | 66.543 ± 19.757 | 51.496 | 88.916 | 7.63 ± 2.27 |
| `docker run -t ipfs--yarn` | 82.550 ± 25.605 | 58.124 | 109.190 | 9.47 ± 2.94 |
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
