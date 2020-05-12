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
## Report from 2020-05-12

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.669 ± 0.096 | 8.559 | 8.725 | 1.00 |
| `docker run -t npm--pnpm` | 8.721 ± 0.202 | 8.523 | 8.926 | 1.01 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.062 ± 0.144 | 9.901 | 10.177 | 1.16 ± 0.02 |
| `docker run -t npm--yarn` | 11.196 ± 0.095 | 11.113 | 11.299 | 1.29 ± 0.02 |
| `docker run -t yarn--yarn` | 11.278 ± 0.035 | 11.239 | 11.304 | 1.30 ± 0.01 |
| `docker run -t npm--npm` | 12.197 ± 0.069 | 12.118 | 12.244 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.394 ± 0.100 | 12.283 | 12.477 | 1.43 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.050 ± 0.209 | 16.809 | 17.179 | 1.97 ± 0.03 |
| `docker run -t open-registry--npm` | 17.314 ± 0.247 | 17.151 | 17.599 | 2.00 ± 0.04 |
| `docker run -t bolivar--pnpm` | 17.362 ± 0.471 | 16.940 | 17.870 | 2.00 ± 0.06 |
| `docker run -t ipfs--pnpm` | 20.630 ± 1.040 | 19.495 | 21.538 | 2.38 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 20.783 ± 0.295 | 20.505 | 21.093 | 2.40 ± 0.04 |
| `docker run -t cnpmjs--npm` | 26.905 ± 4.122 | 22.464 | 30.609 | 3.10 ± 0.48 |
| `docker run -t bolivar--npm` | 35.590 ± 0.837 | 34.745 | 36.418 | 4.11 ± 0.11 |
| `docker run -t bolivar--yarn` | 38.728 ± 0.310 | 38.456 | 39.065 | 4.47 ± 0.06 |
| `docker run -t cnpmjs--yarn` | 46.071 ± 17.372 | 35.934 | 66.130 | 5.31 ± 2.00 |
| `docker run -t ipfs--npm` | 66.128 ± 21.624 | 51.971 | 91.019 | 7.63 ± 2.50 |
| `docker run -t ipfs--yarn` | 90.871 ± 23.336 | 67.595 | 114.266 | 10.48 ± 2.69 |
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
