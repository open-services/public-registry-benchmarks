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
## Report from 2020-06-16

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.941 ± 0.036 | 8.913 | 8.982 | 1.00 |
| `docker run -t yarn--pnpm` | 9.063 ± 0.112 | 8.934 | 9.131 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.230 ± 0.139 | 10.134 | 10.389 | 1.14 ± 0.02 |
| `docker run -t npm--yarn` | 12.105 ± 0.500 | 11.715 | 12.669 | 1.35 ± 0.06 |
| `docker run -t yarn--yarn` | 12.308 ± 0.342 | 12.024 | 12.688 | 1.38 ± 0.04 |
| `docker run -t yarn--npm` | 13.227 ± 0.123 | 13.128 | 13.365 | 1.48 ± 0.02 |
| `docker run -t npm--npm` | 13.308 ± 0.081 | 13.237 | 13.396 | 1.49 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.702 ± 0.103 | 16.620 | 16.817 | 1.87 ± 0.01 |
| `docker run -t open-registry--npm` | 17.176 ± 0.138 | 17.029 | 17.303 | 1.92 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.535 ± 0.956 | 18.785 | 20.612 | 2.18 ± 0.11 |
| `docker run -t ipfs--pnpm` | 19.825 ± 0.611 | 19.161 | 20.365 | 2.22 ± 0.07 |
| `docker run -t cnpmjs--pnpm` | 20.644 ± 0.517 | 20.245 | 21.227 | 2.31 ± 0.06 |
| `docker run -t cnpmjs--npm` | 25.865 ± 2.109 | 24.610 | 28.300 | 2.89 ± 0.24 |
| `docker run -t bolivar--npm` | 37.800 ± 0.351 | 37.422 | 38.116 | 4.23 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 39.860 ± 0.029 | 39.837 | 39.893 | 4.46 ± 0.02 |
| `docker run -t bolivar--yarn` | 40.810 ± 0.471 | 40.329 | 41.270 | 4.56 ± 0.06 |
| `docker run -t ipfs--npm` | 109.429 ± 55.094 | 48.308 | 155.269 | 12.24 ± 6.16 |
| `docker run -t ipfs--yarn` | 110.644 ± 60.436 | 52.405 | 173.061 | 12.37 ± 6.76 |
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
