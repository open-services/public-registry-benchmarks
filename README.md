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
## Report from 2020-06-11

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.838 ± 0.057 | 8.799 | 8.903 | 1.00 |
| `docker run -t yarn--pnpm` | 9.244 ± 0.396 | 9.015 | 9.701 | 1.05 ± 0.05 |
| `docker run -t open-registry--pnpm` | 10.614 ± 0.526 | 10.219 | 11.211 | 1.20 ± 0.06 |
| `docker run -t yarn--yarn` | 11.333 ± 0.097 | 11.274 | 11.446 | 1.28 ± 0.01 |
| `docker run -t npm--yarn` | 11.398 ± 0.079 | 11.338 | 11.488 | 1.29 ± 0.01 |
| `docker run -t npm--npm` | 12.586 ± 0.168 | 12.448 | 12.774 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.603 ± 0.084 | 12.507 | 12.658 | 1.43 ± 0.01 |
| `docker run -t open-registry--yarn` | 17.475 ± 0.091 | 17.375 | 17.553 | 1.98 ± 0.02 |
| `docker run -t open-registry--npm` | 17.531 ± 0.397 | 17.215 | 17.977 | 1.98 ± 0.05 |
| `docker run -t bolivar--pnpm` | 18.828 ± 1.030 | 17.642 | 19.496 | 2.13 ± 0.12 |
| `docker run -t ipfs--pnpm` | 20.264 ± 1.620 | 18.754 | 21.976 | 2.29 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 23.012 ± 0.609 | 22.404 | 23.621 | 2.60 ± 0.07 |
| `docker run -t cnpmjs--npm` | 24.659 ± 1.581 | 23.537 | 26.467 | 2.79 ± 0.18 |
| `docker run -t bolivar--npm` | 36.792 ± 0.760 | 36.063 | 37.580 | 4.16 ± 0.09 |
| `docker run -t cnpmjs--yarn` | 38.433 ± 0.287 | 38.102 | 38.622 | 4.35 ± 0.04 |
| `docker run -t bolivar--yarn` | 40.069 ± 1.014 | 39.440 | 41.240 | 4.53 ± 0.12 |
| `docker run -t ipfs--npm` | 72.132 ± 27.052 | 48.073 | 101.414 | 8.16 ± 3.06 |
| `docker run -t ipfs--yarn` | 145.539 ± 17.116 | 134.484 | 165.254 | 16.47 ± 1.94 |
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
