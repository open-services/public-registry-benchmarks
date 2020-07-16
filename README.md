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
## Report from 2020-07-16

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 10.425 ± 0.208 | 10.233 | 10.646 | 1.00 |
| `docker run -t npm--pnpm` | 10.494 ± 0.893 | 9.796 | 11.500 | 1.01 ± 0.09 |
| `docker run -t open-registry--pnpm` | 11.259 ± 0.169 | 11.063 | 11.361 | 1.08 ± 0.03 |
| `docker run -t npm--yarn` | 12.964 ± 0.251 | 12.676 | 13.139 | 1.24 ± 0.03 |
| `docker run -t yarn--yarn` | 13.037 ± 0.154 | 12.866 | 13.165 | 1.25 ± 0.03 |
| `docker run -t npm--npm` | 14.162 ± 0.118 | 14.039 | 14.273 | 1.36 ± 0.03 |
| `docker run -t yarn--npm` | 14.178 ± 0.037 | 14.140 | 14.214 | 1.36 ± 0.03 |
| `docker run -t open-registry--yarn` | 17.910 ± 0.068 | 17.837 | 17.973 | 1.72 ± 0.03 |
| `docker run -t open-registry--npm` | 19.049 ± 0.213 | 18.803 | 19.176 | 1.83 ± 0.04 |
| `docker run -t ipfs--pnpm` | 19.735 ± 0.626 | 19.301 | 20.452 | 1.89 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 20.568 ± 0.989 | 19.823 | 21.690 | 1.97 ± 0.10 |
| `docker run -t cnpmjs--npm` | 23.217 ± 0.225 | 23.009 | 23.455 | 2.23 ± 0.05 |
| `docker run -t bolivar--pnpm` | 23.239 ± 1.813 | 21.210 | 24.698 | 2.23 ± 0.18 |
| `docker run -t cnpmjs--yarn` | 39.607 ± 0.524 | 39.109 | 40.154 | 3.80 ± 0.09 |
| `docker run -t bolivar--npm` | 43.803 ± 1.152 | 42.518 | 44.743 | 4.20 ± 0.14 |
| `docker run -t bolivar--yarn` | 46.062 ± 0.599 | 45.691 | 46.753 | 4.42 ± 0.11 |
| `docker run -t ipfs--npm` | 62.979 ± 13.785 | 47.283 | 73.118 | 6.04 ± 1.33 |
| `docker run -t ipfs--yarn` | 86.966 ± 26.813 | 56.184 | 105.237 | 8.34 ± 2.58 |
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
