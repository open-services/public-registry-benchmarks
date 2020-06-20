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
## Report from 2020-06-20

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.781 ± 0.325 | 8.407 | 8.975 | 1.00 |
| `docker run -t yarn--pnpm` | 8.892 ± 0.284 | 8.602 | 9.171 | 1.01 ± 0.05 |
| `docker run -t open-registry--pnpm` | 10.083 ± 0.236 | 9.937 | 10.355 | 1.15 ± 0.05 |
| `docker run -t yarn--yarn` | 11.155 ± 0.185 | 11.011 | 11.363 | 1.27 ± 0.05 |
| `docker run -t npm--yarn` | 11.245 ± 0.014 | 11.233 | 11.261 | 1.28 ± 0.05 |
| `docker run -t npm--npm` | 12.133 ± 0.067 | 12.074 | 12.206 | 1.38 ± 0.05 |
| `docker run -t yarn--npm` | 12.291 ± 0.033 | 12.259 | 12.324 | 1.40 ± 0.05 |
| `docker run -t open-registry--yarn` | 16.687 ± 0.155 | 16.571 | 16.863 | 1.90 ± 0.07 |
| `docker run -t open-registry--npm` | 17.141 ± 0.150 | 17.008 | 17.304 | 1.95 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.062 ± 1.237 | 18.193 | 20.478 | 2.17 ± 0.16 |
| `docker run -t cnpmjs--pnpm` | 19.913 ± 0.112 | 19.785 | 19.994 | 2.27 ± 0.08 |
| `docker run -t ipfs--pnpm` | 22.671 ± 0.450 | 22.152 | 22.949 | 2.58 ± 0.11 |
| `docker run -t cnpmjs--npm` | 24.892 ± 3.132 | 22.962 | 28.506 | 2.83 ± 0.37 |
| `docker run -t bolivar--npm` | 38.099 ± 0.421 | 37.779 | 38.576 | 4.34 ± 0.17 |
| `docker run -t bolivar--yarn` | 44.338 ± 0.637 | 43.771 | 45.027 | 5.05 ± 0.20 |
| `docker run -t cnpmjs--yarn` | 49.061 ± 18.984 | 37.909 | 70.981 | 5.59 ± 2.17 |
| `docker run -t ipfs--yarn` | 108.687 ± 0.839 | 107.922 | 109.584 | 12.38 ± 0.47 |
| `docker run -t ipfs--npm` | 127.364 ± 51.612 | 71.681 | 173.600 | 14.50 ± 5.90 |
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
