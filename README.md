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
## Report from 2020-06-19

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.817 ± 0.066 | 8.772 | 8.892 | 1.00 |
| `docker run -t yarn--pnpm` | 9.475 ± 0.429 | 9.226 | 9.970 | 1.07 ± 0.05 |
| `docker run -t open-registry--pnpm` | 11.035 ± 0.755 | 10.424 | 11.879 | 1.25 ± 0.09 |
| `docker run -t npm--yarn` | 11.459 ± 0.211 | 11.296 | 11.697 | 1.30 ± 0.03 |
| `docker run -t yarn--yarn` | 11.697 ± 0.172 | 11.509 | 11.848 | 1.33 ± 0.02 |
| `docker run -t npm--npm` | 12.261 ± 0.085 | 12.171 | 12.339 | 1.39 ± 0.01 |
| `docker run -t yarn--npm` | 13.309 ± 0.396 | 13.034 | 13.763 | 1.51 ± 0.05 |
| `docker run -t open-registry--yarn` | 17.280 ± 0.198 | 17.058 | 17.441 | 1.96 ± 0.03 |
| `docker run -t open-registry--npm` | 18.107 ± 0.144 | 18.024 | 18.274 | 2.05 ± 0.02 |
| `docker run -t bolivar--pnpm` | 18.852 ± 0.027 | 18.823 | 18.877 | 2.14 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 20.245 ± 0.218 | 20.032 | 20.467 | 2.30 ± 0.03 |
| `docker run -t ipfs--pnpm` | 22.557 ± 2.106 | 20.971 | 24.947 | 2.56 ± 0.24 |
| `docker run -t cnpmjs--npm` | 24.860 ± 1.121 | 23.874 | 26.079 | 2.82 ± 0.13 |
| `docker run -t bolivar--npm` | 36.710 ± 0.439 | 36.425 | 37.215 | 4.16 ± 0.06 |
| `docker run -t cnpmjs--yarn` | 38.305 ± 0.910 | 37.680 | 39.349 | 4.34 ± 0.11 |
| `docker run -t bolivar--yarn` | 42.079 ± 0.479 | 41.527 | 42.391 | 4.77 ± 0.06 |
| `docker run -t ipfs--yarn` | 145.735 ± 59.232 | 111.122 | 214.128 | 16.53 ± 6.72 |
| `docker run -t ipfs--npm` | 213.766 ± 11.387 | 201.669 | 224.277 | 24.24 ± 1.30 |
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
