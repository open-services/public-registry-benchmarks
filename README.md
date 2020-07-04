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
## Report from 2020-07-04

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.871 ± 0.084 | 8.788 | 8.957 | 1.00 |
| `docker run -t yarn--pnpm` | 8.955 ± 0.056 | 8.890 | 8.987 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.321 ± 0.115 | 10.193 | 10.419 | 1.16 ± 0.02 |
| `docker run -t npm--yarn` | 11.217 ± 0.090 | 11.113 | 11.270 | 1.26 ± 0.02 |
| `docker run -t yarn--yarn` | 11.443 ± 0.081 | 11.379 | 11.534 | 1.29 ± 0.02 |
| `docker run -t npm--npm` | 12.482 ± 0.094 | 12.384 | 12.571 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.752 ± 0.071 | 12.674 | 12.812 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.877 ± 0.037 | 16.838 | 16.912 | 1.90 ± 0.02 |
| `docker run -t open-registry--npm` | 17.661 ± 0.279 | 17.341 | 17.853 | 1.99 ± 0.04 |
| `docker run -t ipfs--pnpm` | 17.758 ± 0.193 | 17.599 | 17.973 | 2.00 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.345 ± 1.109 | 17.589 | 19.618 | 2.07 ± 0.13 |
| `docker run -t bolivar--npm` | 35.843 ± 0.635 | 35.110 | 36.232 | 4.04 ± 0.08 |
| `docker run -t cnpmjs--yarn` | 37.016 ± 1.224 | 35.854 | 38.293 | 4.17 ± 0.14 |
| `docker run -t bolivar--yarn` | 40.601 ± 0.319 | 40.391 | 40.968 | 4.58 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 41.853 ± 34.935 | 20.812 | 82.179 | 4.72 ± 3.94 |
| `docker run -t cnpmjs--npm` | 45.926 ± 40.766 | 22.049 | 92.997 | 5.18 ± 4.60 |
| `docker run -t ipfs--npm` | 68.544 ± 20.991 | 44.412 | 82.576 | 7.73 ± 2.37 |
| `docker run -t ipfs--yarn` | 98.730 ± 35.499 | 57.760 | 120.334 | 11.13 ± 4.00 |
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
