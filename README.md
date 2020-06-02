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
## Report from 2020-06-02

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.946 ± 0.111 | 8.818 | 9.014 | 1.00 |
| `docker run -t yarn--pnpm` | 9.232 ± 0.178 | 9.052 | 9.409 | 1.03 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.493 ± 0.099 | 10.417 | 10.605 | 1.17 ± 0.02 |
| `docker run -t npm--yarn` | 11.418 ± 0.311 | 11.065 | 11.648 | 1.28 ± 0.04 |
| `docker run -t npm--npm` | 12.510 ± 0.083 | 12.418 | 12.581 | 1.40 ± 0.02 |
| `docker run -t yarn--yarn` | 12.956 ± 1.270 | 11.490 | 13.733 | 1.45 ± 0.14 |
| `docker run -t yarn--npm` | 13.518 ± 1.238 | 12.721 | 14.944 | 1.51 ± 0.14 |
| `docker run -t open-registry--yarn` | 17.175 ± 0.144 | 17.049 | 17.332 | 1.92 ± 0.03 |
| `docker run -t open-registry--npm` | 17.888 ± 0.191 | 17.733 | 18.101 | 2.00 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.882 ± 1.009 | 18.252 | 20.047 | 2.11 ± 0.12 |
| `docker run -t ipfs--pnpm` | 20.605 ± 0.356 | 20.398 | 21.016 | 2.30 ± 0.05 |
| `docker run -t cnpmjs--npm` | 22.461 ± 0.133 | 22.333 | 22.598 | 2.51 ± 0.03 |
| `docker run -t bolivar--npm` | 37.534 ± 1.221 | 36.820 | 38.944 | 4.20 ± 0.15 |
| `docker run -t cnpmjs--pnpm` | 40.693 ± 33.374 | 20.805 | 79.223 | 4.55 ± 3.73 |
| `docker run -t bolivar--yarn` | 43.039 ± 0.728 | 42.202 | 43.524 | 4.81 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 47.322 ± 18.849 | 36.196 | 69.086 | 5.29 ± 2.11 |
| `docker run -t ipfs--yarn` | 76.867 ± 31.394 | 51.904 | 112.112 | 8.59 ± 3.51 |
| `docker run -t ipfs--npm` | 82.259 ± 31.469 | 47.340 | 108.424 | 9.19 ± 3.52 |
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
