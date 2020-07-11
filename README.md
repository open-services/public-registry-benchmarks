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
## Report from 2020-07-11

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.329 ± 0.018 | 8.309 | 8.342 | 1.00 |
| `docker run -t yarn--pnpm` | 8.578 ± 0.057 | 8.522 | 8.636 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.008 ± 0.106 | 9.940 | 10.129 | 1.20 ± 0.01 |
| `docker run -t npm--yarn` | 10.870 ± 0.018 | 10.856 | 10.890 | 1.31 ± 0.00 |
| `docker run -t yarn--yarn` | 11.072 ± 0.157 | 10.894 | 11.193 | 1.33 ± 0.02 |
| `docker run -t npm--npm` | 11.870 ± 0.048 | 11.821 | 11.916 | 1.43 ± 0.01 |
| `docker run -t yarn--npm` | 12.184 ± 0.125 | 12.040 | 12.258 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.928 ± 0.195 | 16.782 | 17.149 | 2.03 ± 0.02 |
| `docker run -t open-registry--npm` | 17.197 ± 0.186 | 17.020 | 17.390 | 2.06 ± 0.02 |
| `docker run -t ipfs--pnpm` | 18.847 ± 0.518 | 18.302 | 19.334 | 2.26 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.218 ± 1.029 | 18.241 | 20.293 | 2.31 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 19.233 ± 0.154 | 19.126 | 19.410 | 2.31 ± 0.02 |
| `docker run -t cnpmjs--npm` | 24.542 ± 4.012 | 21.872 | 29.155 | 2.95 ± 0.48 |
| `docker run -t bolivar--npm` | 37.840 ± 0.976 | 37.213 | 38.965 | 4.54 ± 0.12 |
| `docker run -t bolivar--yarn` | 42.229 ± 0.293 | 41.934 | 42.520 | 5.07 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 43.966 ± 13.579 | 35.971 | 59.645 | 5.28 ± 1.63 |
| `docker run -t ipfs--npm` | 95.406 ± 29.335 | 64.356 | 122.653 | 11.46 ± 3.52 |
| `docker run -t ipfs--yarn` | 103.572 ± 0.121 | 103.450 | 103.691 | 12.44 ± 0.03 |
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
