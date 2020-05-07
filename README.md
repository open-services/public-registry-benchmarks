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
## Report from 2020-05-07

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.572 ± 0.113 | 8.504 | 8.702 | 1.00 |
| `docker run -t yarn--pnpm` | 9.113 ± 0.369 | 8.688 | 9.351 | 1.06 ± 0.05 |
| `docker run -t open-registry--pnpm` | 10.329 ± 0.337 | 10.119 | 10.718 | 1.21 ± 0.04 |
| `docker run -t npm--yarn` | 11.207 ± 0.130 | 11.061 | 11.310 | 1.31 ± 0.02 |
| `docker run -t yarn--yarn` | 11.272 ± 0.087 | 11.177 | 11.348 | 1.31 ± 0.02 |
| `docker run -t yarn--npm` | 12.488 ± 0.322 | 12.241 | 12.852 | 1.46 ± 0.04 |
| `docker run -t npm--npm` | 12.489 ± 0.210 | 12.278 | 12.699 | 1.46 ± 0.03 |
| `docker run -t open-registry--yarn` | 17.079 ± 0.031 | 17.057 | 17.114 | 1.99 ± 0.03 |
| `docker run -t open-registry--npm` | 17.623 ± 0.202 | 17.391 | 17.758 | 2.06 ± 0.04 |
| `docker run -t bolivar--pnpm` | 17.792 ± 0.652 | 17.356 | 18.542 | 2.08 ± 0.08 |
| `docker run -t ipfs--pnpm` | 19.764 ± 0.627 | 19.260 | 20.467 | 2.31 ± 0.08 |
| `docker run -t cnpmjs--npm` | 22.668 ± 3.037 | 20.756 | 26.170 | 2.64 ± 0.36 |
| `docker run -t bolivar--npm` | 37.958 ± 0.955 | 37.382 | 39.060 | 4.43 ± 0.13 |
| `docker run -t cnpmjs--pnpm` | 40.130 ± 35.386 | 19.472 | 80.989 | 4.68 ± 4.13 |
| `docker run -t cnpmjs--yarn` | 42.175 ± 15.708 | 33.006 | 60.313 | 4.92 ± 1.83 |
| `docker run -t bolivar--yarn` | 44.346 ± 2.111 | 42.018 | 46.139 | 5.17 ± 0.26 |
| `docker run -t ipfs--npm` | 49.866 ± 2.489 | 48.065 | 52.707 | 5.82 ± 0.30 |
| `docker run -t ipfs--yarn` | 77.535 ± 5.311 | 71.584 | 81.792 | 9.05 ± 0.63 |
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
