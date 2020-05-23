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
## Report from 2020-05-23

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.179 ± 0.042 | 9.153 | 9.228 | 1.00 |
| `docker run -t yarn--pnpm` | 9.470 ± 0.344 | 9.185 | 9.851 | 1.03 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.588 ± 0.113 | 10.517 | 10.718 | 1.15 ± 0.01 |
| `docker run -t npm--yarn` | 11.760 ± 0.173 | 11.658 | 11.960 | 1.28 ± 0.02 |
| `docker run -t yarn--yarn` | 12.136 ± 0.009 | 12.126 | 12.144 | 1.32 ± 0.01 |
| `docker run -t npm--npm` | 13.171 ± 0.119 | 13.042 | 13.276 | 1.43 ± 0.01 |
| `docker run -t yarn--npm` | 13.247 ± 0.070 | 13.166 | 13.288 | 1.44 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.733 ± 0.417 | 16.409 | 17.203 | 1.82 ± 0.05 |
| `docker run -t open-registry--npm` | 17.582 ± 0.232 | 17.314 | 17.733 | 1.92 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.836 ± 0.427 | 18.439 | 19.288 | 2.05 ± 0.05 |
| `docker run -t ipfs--pnpm` | 21.912 ± 1.194 | 21.119 | 23.285 | 2.39 ± 0.13 |
| `docker run -t cnpmjs--npm` | 25.659 ± 1.424 | 24.025 | 26.636 | 2.80 ± 0.16 |
| `docker run -t bolivar--npm` | 36.855 ± 0.544 | 36.246 | 37.294 | 4.02 ± 0.06 |
| `docker run -t bolivar--yarn` | 38.115 ± 0.221 | 37.949 | 38.365 | 4.15 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 39.763 ± 26.802 | 22.477 | 70.638 | 4.33 ± 2.92 |
| `docker run -t cnpmjs--yarn` | 49.063 ± 17.501 | 38.861 | 69.271 | 5.35 ± 1.91 |
| `docker run -t ipfs--npm` | 118.196 ± 22.803 | 103.328 | 144.449 | 12.88 ± 2.48 |
| `docker run -t ipfs--yarn` | 121.852 ± 20.594 | 109.743 | 145.630 | 13.28 ± 2.24 |
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
