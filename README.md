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
## Report from 2020-05-10

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.830 ± 0.130 | 9.708 | 9.967 | 1.00 |
| `docker run -t yarn--pnpm` | 10.256 ± 0.231 | 10.116 | 10.523 | 1.04 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.214 ± 0.156 | 11.102 | 11.392 | 1.14 ± 0.02 |
| `docker run -t npm--yarn` | 13.492 ± 0.319 | 13.270 | 13.858 | 1.37 ± 0.04 |
| `docker run -t yarn--yarn` | 13.784 ± 0.116 | 13.662 | 13.894 | 1.40 ± 0.02 |
| `docker run -t npm--npm` | 14.320 ± 0.199 | 14.107 | 14.502 | 1.46 ± 0.03 |
| `docker run -t yarn--npm` | 14.999 ± 0.190 | 14.806 | 15.186 | 1.53 ± 0.03 |
| `docker run -t ipfs--pnpm` | 17.859 ± 0.493 | 17.341 | 18.322 | 1.82 ± 0.06 |
| `docker run -t open-registry--yarn` | 18.083 ± 0.034 | 18.059 | 18.122 | 1.84 ± 0.02 |
| `docker run -t open-registry--npm` | 18.630 ± 0.268 | 18.323 | 18.816 | 1.90 ± 0.04 |
| `docker run -t bolivar--pnpm` | 19.810 ± 0.534 | 19.406 | 20.415 | 2.02 ± 0.06 |
| `docker run -t bolivar--npm` | 41.422 ± 1.577 | 39.642 | 42.642 | 4.21 ± 0.17 |
| `docker run -t bolivar--yarn` | 44.343 ± 0.802 | 43.608 | 45.198 | 4.51 ± 0.10 |
| `docker run -t cnpmjs--pnpm` | 55.414 ± 28.949 | 22.051 | 73.882 | 5.64 ± 2.95 |
| `docker run -t ipfs--npm` | 56.076 ± 14.869 | 46.979 | 73.236 | 5.70 ± 1.51 |
| `docker run -t cnpmjs--yarn` | 60.607 ± 17.679 | 40.268 | 72.290 | 6.17 ± 1.80 |
| `docker run -t cnpmjs--npm` | 61.803 ± 63.489 | 24.863 | 135.113 | 6.29 ± 6.46 |
| `docker run -t ipfs--yarn` | 79.977 ± 29.857 | 58.655 | 114.099 | 8.14 ± 3.04 |
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
