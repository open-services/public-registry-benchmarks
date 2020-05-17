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
## Report from 2020-05-17

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.551 ± 0.114 | 8.479 | 8.682 | 1.00 |
| `docker run -t yarn--pnpm` | 8.843 ± 0.284 | 8.678 | 9.171 | 1.03 ± 0.04 |
| `docker run -t open-registry--pnpm` | 9.930 ± 0.195 | 9.779 | 10.151 | 1.16 ± 0.03 |
| `docker run -t npm--yarn` | 10.958 ± 0.109 | 10.886 | 11.084 | 1.28 ± 0.02 |
| `docker run -t yarn--yarn` | 11.198 ± 0.201 | 11.002 | 11.405 | 1.31 ± 0.03 |
| `docker run -t npm--npm` | 12.179 ± 0.081 | 12.122 | 12.271 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 12.646 ± 0.218 | 12.409 | 12.839 | 1.48 ± 0.03 |
| `docker run -t open-registry--yarn` | 16.274 ± 0.222 | 16.032 | 16.470 | 1.90 ± 0.04 |
| `docker run -t open-registry--npm` | 16.747 ± 0.133 | 16.598 | 16.856 | 1.96 ± 0.03 |
| `docker run -t ipfs--pnpm` | 19.176 ± 1.802 | 17.498 | 21.081 | 2.24 ± 0.21 |
| `docker run -t bolivar--pnpm` | 19.529 ± 0.765 | 18.987 | 20.404 | 2.28 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 22.309 ± 0.783 | 21.651 | 23.175 | 2.61 ± 0.10 |
| `docker run -t cnpmjs--npm` | 25.388 ± 2.976 | 23.594 | 28.824 | 2.97 ± 0.35 |
| `docker run -t bolivar--npm` | 36.722 ± 0.951 | 35.671 | 37.522 | 4.29 ± 0.13 |
| `docker run -t cnpmjs--yarn` | 38.571 ± 0.086 | 38.509 | 38.669 | 4.51 ± 0.06 |
| `docker run -t bolivar--yarn` | 39.361 ± 0.605 | 38.691 | 39.868 | 4.60 ± 0.09 |
| `docker run -t ipfs--yarn` | 76.359 ± 29.359 | 53.506 | 109.472 | 8.93 ± 3.44 |
| `docker run -t ipfs--npm` | 78.671 ± 27.603 | 46.801 | 95.011 | 9.20 ± 3.23 |
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
