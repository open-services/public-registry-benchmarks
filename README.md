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
## Report from 2020-06-09

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.538 ± 0.071 | 9.473 | 9.613 | 1.00 |
| `docker run -t yarn--pnpm` | 9.830 ± 0.071 | 9.780 | 9.912 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 11.552 ± 0.030 | 11.530 | 11.586 | 1.21 ± 0.01 |
| `docker run -t npm--yarn` | 12.827 ± 0.857 | 12.200 | 13.803 | 1.34 ± 0.09 |
| `docker run -t yarn--yarn` | 12.897 ± 0.532 | 12.416 | 13.469 | 1.35 ± 0.06 |
| `docker run -t npm--npm` | 13.700 ± 0.117 | 13.576 | 13.808 | 1.44 ± 0.02 |
| `docker run -t yarn--npm` | 13.755 ± 0.134 | 13.658 | 13.908 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 18.231 ± 0.069 | 18.155 | 18.292 | 1.91 ± 0.02 |
| `docker run -t ipfs--pnpm` | 18.637 ± 0.119 | 18.502 | 18.723 | 1.95 ± 0.02 |
| `docker run -t open-registry--npm` | 19.051 ± 0.155 | 18.911 | 19.218 | 2.00 ± 0.02 |
| `docker run -t bolivar--pnpm` | 21.180 ± 0.874 | 20.178 | 21.784 | 2.22 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 21.183 ± 0.626 | 20.716 | 21.894 | 2.22 ± 0.07 |
| `docker run -t cnpmjs--npm` | 26.709 ± 2.844 | 24.554 | 29.933 | 2.80 ± 0.30 |
| `docker run -t cnpmjs--yarn` | 39.024 ± 0.197 | 38.805 | 39.186 | 4.09 ± 0.04 |
| `docker run -t bolivar--npm` | 41.034 ± 0.315 | 40.752 | 41.374 | 4.30 ± 0.05 |
| `docker run -t bolivar--yarn` | 43.387 ± 0.863 | 42.461 | 44.167 | 4.55 ± 0.10 |
| `docker run -t ipfs--npm` | 83.361 ± 29.914 | 48.832 | 101.472 | 8.74 ± 3.14 |
| `docker run -t ipfs--yarn` | 132.364 ± 9.746 | 121.131 | 138.580 | 13.88 ± 1.03 |
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
