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
## Report from 2020-06-18

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.408 ± 0.095 | 8.331 | 8.514 | 1.00 |
| `docker run -t yarn--pnpm` | 8.613 ± 0.125 | 8.489 | 8.738 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.745 ± 0.032 | 9.725 | 9.782 | 1.16 ± 0.01 |
| `docker run -t npm--yarn` | 11.081 ± 0.433 | 10.799 | 11.580 | 1.32 ± 0.05 |
| `docker run -t yarn--yarn` | 11.442 ± 0.450 | 11.005 | 11.905 | 1.36 ± 0.06 |
| `docker run -t npm--npm` | 11.964 ± 0.058 | 11.901 | 12.014 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.349 ± 0.085 | 12.271 | 12.440 | 1.47 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.133 ± 0.041 | 16.089 | 16.170 | 1.92 ± 0.02 |
| `docker run -t open-registry--npm` | 16.580 ± 0.122 | 16.498 | 16.719 | 1.97 ± 0.03 |
| `docker run -t bolivar--pnpm` | 17.631 ± 0.685 | 17.027 | 18.375 | 2.10 ± 0.08 |
| `docker run -t ipfs--pnpm` | 19.894 ± 0.345 | 19.689 | 20.292 | 2.37 ± 0.05 |
| `docker run -t cnpmjs--pnpm` | 20.719 ± 0.360 | 20.509 | 21.135 | 2.46 ± 0.05 |
| `docker run -t cnpmjs--npm` | 30.357 ± 2.427 | 28.252 | 33.012 | 3.61 ± 0.29 |
| `docker run -t bolivar--npm` | 35.198 ± 0.098 | 35.132 | 35.310 | 4.19 ± 0.05 |
| `docker run -t bolivar--yarn` | 38.349 ± 0.786 | 37.520 | 39.082 | 4.56 ± 0.11 |
| `docker run -t cnpmjs--yarn` | 39.770 ± 0.408 | 39.526 | 40.241 | 4.73 ± 0.07 |
| `docker run -t ipfs--npm` | 146.550 ± 21.648 | 125.370 | 168.639 | 17.43 ± 2.58 |
| `docker run -t ipfs--yarn` | 172.676 ± 72.564 | 99.504 | 244.616 | 20.54 ± 8.63 |
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
