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
## Report from 2020-06-14

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.652 ± 0.332 | 8.345 | 9.004 | 1.00 |
| `docker run -t yarn--pnpm` | 8.920 ± 0.127 | 8.774 | 9.003 | 1.03 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.211 ± 0.333 | 9.915 | 10.572 | 1.18 ± 0.06 |
| `docker run -t yarn--yarn` | 11.091 ± 0.178 | 10.891 | 11.235 | 1.28 ± 0.05 |
| `docker run -t npm--yarn` | 11.144 ± 0.185 | 10.984 | 11.346 | 1.29 ± 0.05 |
| `docker run -t npm--npm` | 12.140 ± 0.063 | 12.068 | 12.177 | 1.40 ± 0.05 |
| `docker run -t yarn--npm` | 12.307 ± 0.103 | 12.212 | 12.416 | 1.42 ± 0.06 |
| `docker run -t open-registry--yarn` | 17.414 ± 0.040 | 17.375 | 17.455 | 2.01 ± 0.08 |
| `docker run -t open-registry--npm` | 17.582 ± 0.249 | 17.425 | 17.869 | 2.03 ± 0.08 |
| `docker run -t bolivar--pnpm` | 18.367 ± 0.939 | 17.393 | 19.266 | 2.12 ± 0.14 |
| `docker run -t ipfs--pnpm` | 22.947 ± 0.764 | 22.182 | 23.710 | 2.65 ± 0.13 |
| `docker run -t cnpmjs--pnpm` | 23.060 ± 0.332 | 22.786 | 23.429 | 2.67 ± 0.11 |
| `docker run -t cnpmjs--npm` | 24.331 ± 1.832 | 23.167 | 26.442 | 2.81 ± 0.24 |
| `docker run -t bolivar--npm` | 36.287 ± 0.161 | 36.166 | 36.470 | 4.19 ± 0.16 |
| `docker run -t cnpmjs--yarn` | 38.107 ± 0.366 | 37.876 | 38.528 | 4.40 ± 0.17 |
| `docker run -t bolivar--yarn` | 58.653 ± 28.691 | 41.733 | 91.781 | 6.78 ± 3.33 |
| `docker run -t ipfs--yarn` | 99.097 ± 40.242 | 55.835 | 135.417 | 11.45 ± 4.67 |
| `docker run -t ipfs--npm` | 112.405 ± 35.444 | 72.044 | 138.459 | 12.99 ± 4.13 |
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
