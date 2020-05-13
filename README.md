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
## Report from 2020-05-13

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.965 ± 0.036 | 8.936 | 9.005 | 1.00 |
| `docker run -t yarn--pnpm` | 8.995 ± 0.117 | 8.927 | 9.130 | 1.00 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.401 ± 0.121 | 10.308 | 10.538 | 1.16 ± 0.01 |
| `docker run -t npm--yarn` | 11.322 ± 0.254 | 11.036 | 11.520 | 1.26 ± 0.03 |
| `docker run -t yarn--yarn` | 11.482 ± 0.122 | 11.369 | 11.612 | 1.28 ± 0.01 |
| `docker run -t npm--npm` | 12.443 ± 0.107 | 12.322 | 12.524 | 1.39 ± 0.01 |
| `docker run -t yarn--npm` | 12.867 ± 0.128 | 12.726 | 12.976 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.008 ± 0.106 | 16.901 | 17.113 | 1.90 ± 0.01 |
| `docker run -t open-registry--npm` | 18.323 ± 0.477 | 17.798 | 18.729 | 2.04 ± 0.05 |
| `docker run -t bolivar--pnpm` | 18.987 ± 1.438 | 17.553 | 20.429 | 2.12 ± 0.16 |
| `docker run -t ipfs--pnpm` | 19.334 ± 0.514 | 18.967 | 19.922 | 2.16 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 36.897 ± 27.180 | 20.181 | 68.259 | 4.12 ± 3.03 |
| `docker run -t bolivar--npm` | 37.134 ± 0.460 | 36.605 | 37.427 | 4.14 ± 0.05 |
| `docker run -t bolivar--yarn` | 41.655 ± 0.531 | 41.335 | 42.268 | 4.65 ± 0.06 |
| `docker run -t cnpmjs--npm` | 45.178 ± 32.509 | 23.386 | 82.544 | 5.04 ± 3.63 |
| `docker run -t cnpmjs--yarn` | 51.922 ± 14.423 | 35.918 | 63.914 | 5.79 ± 1.61 |
| `docker run -t ipfs--npm` | 64.448 ± 20.533 | 49.445 | 87.849 | 7.19 ± 2.29 |
| `docker run -t ipfs--yarn` | 72.616 ± 27.463 | 50.994 | 103.516 | 8.10 ± 3.06 |
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
