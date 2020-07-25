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
## Report from 2020-07-25

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.040 ± 0.050 | 8.982 | 9.071 | 1.00 |
| `docker run -t yarn--pnpm` | 9.224 ± 0.021 | 9.200 | 9.239 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.702 ± 0.432 | 10.449 | 11.201 | 1.18 ± 0.05 |
| `docker run -t yarn--yarn` | 12.236 ± 0.175 | 12.062 | 12.411 | 1.35 ± 0.02 |
| `docker run -t npm--yarn` | 12.277 ± 0.471 | 11.942 | 12.816 | 1.36 ± 0.05 |
| `docker run -t npm--npm` | 13.238 ± 0.268 | 13.064 | 13.547 | 1.46 ± 0.03 |
| `docker run -t yarn--npm` | 13.405 ± 0.082 | 13.322 | 13.487 | 1.48 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.772 ± 0.075 | 16.690 | 16.835 | 1.86 ± 0.01 |
| `docker run -t open-registry--npm` | 17.605 ± 0.112 | 17.511 | 17.729 | 1.95 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 19.284 ± 0.286 | 19.082 | 19.611 | 2.13 ± 0.03 |
| `docker run -t ipfs--pnpm` | 19.606 ± 2.118 | 18.013 | 22.009 | 2.17 ± 0.23 |
| `docker run -t bolivar--pnpm` | 21.270 ± 1.405 | 20.236 | 22.870 | 2.35 ± 0.16 |
| `docker run -t bolivar--npm` | 39.886 ± 0.960 | 38.801 | 40.625 | 4.41 ± 0.11 |
| `docker run -t bolivar--yarn` | 43.115 ± 0.401 | 42.662 | 43.427 | 4.77 ± 0.05 |
| `docker run -t cnpmjs--npm` | 45.308 ± 37.866 | 23.403 | 89.032 | 5.01 ± 4.19 |
| `docker run -t cnpmjs--yarn` | 48.159 ± 18.108 | 37.363 | 69.065 | 5.33 ± 2.00 |
| `docker run -t ipfs--yarn` | 100.415 ± 28.213 | 77.789 | 132.027 | 11.11 ± 3.12 |
| `docker run -t ipfs--npm` | 109.039 ± 60.279 | 46.018 | 166.139 | 12.06 ± 6.67 |
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
