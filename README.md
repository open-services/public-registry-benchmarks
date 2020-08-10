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
## Report from 2020-08-10

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.769 ± 0.030 | 8.748 | 8.803 | 1.00 |
| `docker run -t npm--pnpm` | 8.869 ± 0.099 | 8.807 | 8.983 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.178 ± 0.024 | 10.154 | 10.203 | 1.16 ± 0.00 |
| `docker run -t yarn--yarn` | 11.280 ± 0.063 | 11.236 | 11.352 | 1.29 ± 0.01 |
| `docker run -t npm--yarn` | 11.606 ± 0.141 | 11.470 | 11.752 | 1.32 ± 0.02 |
| `docker run -t yarn--npm` | 12.654 ± 0.163 | 12.520 | 12.835 | 1.44 ± 0.02 |
| `docker run -t npm--npm` | 12.776 ± 0.228 | 12.577 | 13.025 | 1.46 ± 0.03 |
| `docker run -t open-registry--yarn` | 17.277 ± 0.153 | 17.180 | 17.453 | 1.97 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.612 ± 0.210 | 17.396 | 17.816 | 2.01 ± 0.02 |
| `docker run -t open-registry--npm` | 18.193 ± 0.236 | 18.005 | 18.458 | 2.07 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 19.137 ± 0.559 | 18.809 | 19.783 | 2.18 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.332 ± 1.293 | 18.006 | 20.590 | 2.20 ± 0.15 |
| `docker run -t cnpmjs--npm` | 22.777 ± 1.006 | 21.925 | 23.886 | 2.60 ± 0.12 |
| `docker run -t cnpmjs--yarn` | 35.911 ± 0.045 | 35.860 | 35.941 | 4.10 ± 0.01 |
| `docker run -t bolivar--npm` | 38.883 ± 0.950 | 38.121 | 39.947 | 4.43 ± 0.11 |
| `docker run -t bolivar--yarn` | 42.300 ± 0.996 | 41.605 | 43.441 | 4.82 ± 0.11 |
| `docker run -t ipfs--yarn` | 48.420 ± 0.609 | 47.776 | 48.985 | 5.52 ± 0.07 |
| `docker run -t ipfs--npm` | 58.091 ± 10.023 | 47.617 | 67.593 | 6.62 ± 1.14 |
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
