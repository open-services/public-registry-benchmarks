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
## Report from 2020-07-30

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.708 ± 0.756 | 9.167 | 10.571 | 1.00 |
| `docker run -t yarn--pnpm` | 9.976 ± 0.180 | 9.808 | 10.167 | 1.03 ± 0.08 |
| `docker run -t open-registry--pnpm` | 10.700 ± 0.153 | 10.587 | 10.873 | 1.10 ± 0.09 |
| `docker run -t open-registry--yarn` | 17.002 ± 0.130 | 16.860 | 17.117 | 1.75 ± 0.14 |
| `docker run -t open-registry--npm` | 17.401 ± 0.108 | 17.286 | 17.500 | 1.79 ± 0.14 |
| `docker run -t cnpmjs--pnpm` | 19.373 ± 0.266 | 19.112 | 19.643 | 2.00 ± 0.16 |
| `docker run -t yarn--yarn` | 19.837 ± 0.821 | 18.961 | 20.589 | 2.04 ± 0.18 |
| `docker run -t npm--yarn` | 19.841 ± 0.479 | 19.485 | 20.386 | 2.04 ± 0.17 |
| `docker run -t yarn--npm` | 20.586 ± 0.796 | 19.721 | 21.286 | 2.12 ± 0.18 |
| `docker run -t bolivar--pnpm` | 21.209 ± 1.704 | 20.181 | 23.177 | 2.18 ± 0.24 |
| `docker run -t npm--npm` | 21.599 ± 1.167 | 20.703 | 22.919 | 2.22 ± 0.21 |
| `docker run -t ipfs--pnpm` | 30.365 ± 2.303 | 28.573 | 32.962 | 3.13 ± 0.34 |
| `docker run -t bolivar--npm` | 40.672 ± 0.561 | 40.292 | 41.317 | 4.19 ± 0.33 |
| `docker run -t bolivar--yarn` | 42.773 ± 0.503 | 42.241 | 43.239 | 4.41 ± 0.35 |
| `docker run -t cnpmjs--yarn` | 43.855 ± 9.641 | 37.878 | 54.978 | 4.52 ± 1.05 |
| `docker run -t cnpmjs--npm` | 47.213 ± 34.757 | 25.312 | 87.289 | 4.86 ± 3.60 |
| `docker run -t ipfs--yarn` | 91.086 ± 6.856 | 85.292 | 98.654 | 9.38 ± 1.02 |
| `docker run -t ipfs--npm` | 93.368 ± 34.520 | 72.360 | 133.209 | 9.62 ± 3.63 |
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
