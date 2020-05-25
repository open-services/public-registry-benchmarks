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
## Report from 2020-05-25

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.838 ± 0.128 | 8.762 | 8.986 | 1.00 |
| `docker run -t yarn--pnpm` | 9.202 ± 0.374 | 8.937 | 9.629 | 1.04 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.425 ± 0.134 | 10.304 | 10.569 | 1.18 ± 0.02 |
| `docker run -t yarn--yarn` | 11.353 ± 0.199 | 11.173 | 11.567 | 1.28 ± 0.03 |
| `docker run -t npm--yarn` | 11.409 ± 0.336 | 11.121 | 11.778 | 1.29 ± 0.04 |
| `docker run -t npm--npm` | 12.789 ± 0.471 | 12.431 | 13.323 | 1.45 ± 0.06 |
| `docker run -t yarn--npm` | 12.878 ± 0.258 | 12.704 | 13.174 | 1.46 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.869 ± 0.221 | 16.620 | 17.040 | 1.91 ± 0.04 |
| `docker run -t open-registry--npm` | 17.513 ± 0.325 | 17.234 | 17.870 | 1.98 ± 0.05 |
| `docker run -t bolivar--pnpm` | 20.170 ± 0.175 | 20.008 | 20.355 | 2.28 ± 0.04 |
| `docker run -t ipfs--pnpm` | 22.061 ± 0.784 | 21.358 | 22.907 | 2.50 ± 0.10 |
| `docker run -t cnpmjs--pnpm` | 38.772 ± 28.809 | 21.104 | 72.016 | 4.39 ± 3.26 |
| `docker run -t bolivar--npm` | 39.027 ± 0.653 | 38.357 | 39.662 | 4.42 ± 0.10 |
| `docker run -t bolivar--yarn` | 41.702 ± 0.641 | 41.265 | 42.437 | 4.72 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 45.418 ± 16.035 | 35.960 | 63.932 | 5.14 ± 1.82 |
| `docker run -t cnpmjs--npm` | 61.091 ± 30.317 | 26.093 | 79.288 | 6.91 ± 3.43 |
| `docker run -t ipfs--yarn` | 81.009 ± 27.640 | 60.003 | 112.322 | 9.17 ± 3.13 |
| `docker run -t ipfs--npm` | 105.557 ± 35.910 | 64.367 | 130.285 | 11.94 ± 4.07 |
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
