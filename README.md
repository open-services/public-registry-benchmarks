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
## Report from 2019-06-04

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.309 ± 0.077 | 8.220…8.362 |
| `docker run -t yarn--pnpm` | 8.394 ± 0.154 | 8.299…8.571 |
| `docker run -t open-registry--pnpm` | 9.499 ± 0.009 | 9.488…9.505 |
| `docker run -t node-modules--pnpm` | 9.609 ± 0.119 | 9.530…9.746 |
| `docker run -t yarn--yarn` | 11.070 ± 0.083 | 10.974…11.120 |
| `docker run -t npm--yarn` | 11.187 ± 0.132 | 11.062…11.325 |
| `docker run -t npm--npm` | 11.510 ± 0.164 | 11.322…11.628 |
| `docker run -t yarn--npm` | 12.106 ± 0.342 | 11.789…12.468 |
| `docker run -t open-registry--yarn` | 15.856 ± 0.103 | 15.780…15.973 |
| `docker run -t open-registry--npm` | 16.477 ± 0.110 | 16.351…16.547 |
| `docker run -t cnpmjs--pnpm` | 18.670 ± 0.467 | 18.396…19.209 |
| `docker run -t ipfs--pnpm` | 21.630 ± 1.637 | 19.909…23.166 |
| `docker run -t cnpmjs--npm` | 21.768 ± 0.344 | 21.439…22.126 |
| `docker run -t node-modules--npm` | 22.513 ± 0.666 | 22.096…23.281 |
| `docker run -t node-modules--yarn` | 24.012 ± 0.429 | 23.700…24.502 |
| `docker run -t cnpmjs--yarn` | 35.773 ± 0.165 | 35.652…35.961 |
| `docker run -t ipfs--npm` | 70.165 ± 16.552 | 51.802…83.934 |
| `docker run -t ipfs--yarn` | 77.919 ± 30.648 | 58.267…113.233 |
| `docker run -t bolivar--pnpm` | 105.905 ± 18.734 | 85.749…122.786 |
| `docker run -t bolivar--npm` | 147.863 ± 28.885 | 114.575…166.321 |
| `docker run -t bolivar--yarn` | 175.970 ± 45.503 | 139.382…226.922 |
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
