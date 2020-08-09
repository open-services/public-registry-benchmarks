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
## Report from 2020-08-09

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.304 ± 0.040 | 8.257 | 8.327 | 1.00 |
| `docker run -t npm--pnpm` | 8.317 ± 0.344 | 8.116 | 8.714 | 1.00 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.307 ± 0.911 | 9.694 | 11.353 | 1.24 ± 0.11 |
| `docker run -t npm--yarn` | 10.559 ± 0.134 | 10.404 | 10.638 | 1.27 ± 0.02 |
| `docker run -t yarn--yarn` | 10.857 ± 0.263 | 10.668 | 11.157 | 1.31 ± 0.03 |
| `docker run -t yarn--npm` | 11.755 ± 0.103 | 11.691 | 11.874 | 1.42 ± 0.01 |
| `docker run -t npm--npm` | 12.160 ± 0.838 | 11.627 | 13.125 | 1.46 ± 0.10 |
| `docker run -t open-registry--yarn` | 16.232 ± 0.021 | 16.211 | 16.253 | 1.95 ± 0.01 |
| `docker run -t open-registry--npm` | 17.091 ± 0.152 | 17.000 | 17.266 | 2.06 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.331 ± 0.120 | 17.255 | 17.469 | 2.09 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.706 ± 1.149 | 18.740 | 20.977 | 2.37 ± 0.14 |
| `docker run -t cnpmjs--pnpm` | 20.506 ± 0.524 | 20.088 | 21.093 | 2.47 ± 0.06 |
| `docker run -t cnpmjs--npm` | 22.385 ± 0.316 | 22.028 | 22.624 | 2.70 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 35.802 ± 0.564 | 35.162 | 36.222 | 4.31 ± 0.07 |
| `docker run -t bolivar--npm` | 38.328 ± 1.759 | 37.278 | 40.359 | 4.62 ± 0.21 |
| `docker run -t bolivar--yarn` | 41.806 ± 0.368 | 41.441 | 42.177 | 5.03 ± 0.05 |
| `docker run -t ipfs--npm` | 49.753 ± 6.562 | 43.009 | 56.118 | 5.99 ± 0.79 |
| `docker run -t ipfs--yarn` | 58.255 ± 14.310 | 49.885 | 74.778 | 7.02 ± 1.72 |
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
