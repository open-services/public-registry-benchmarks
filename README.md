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
## Report from 2020-06-17

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 9.744 ± 0.916 | 9.209 | 10.802 | 1.00 |
| `docker run -t open-registry--pnpm` | 10.974 ± 0.255 | 10.814 | 11.268 | 1.13 ± 0.11 |
| `docker run -t npm--pnpm` | 11.321 ± 0.265 | 11.029 | 11.546 | 1.16 ± 0.11 |
| `docker run -t yarn--yarn` | 12.076 ± 0.210 | 11.844 | 12.252 | 1.24 ± 0.12 |
| `docker run -t npm--yarn` | 12.820 ± 0.687 | 12.368 | 13.610 | 1.32 ± 0.14 |
| `docker run -t yarn--npm` | 12.929 ± 0.207 | 12.785 | 13.166 | 1.33 ± 0.13 |
| `docker run -t npm--npm` | 14.707 ± 0.242 | 14.525 | 14.982 | 1.51 ± 0.14 |
| `docker run -t open-registry--yarn` | 17.256 ± 0.302 | 17.063 | 17.604 | 1.77 ± 0.17 |
| `docker run -t open-registry--npm` | 18.653 ± 0.384 | 18.357 | 19.086 | 1.91 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 20.130 ± 0.126 | 19.985 | 20.207 | 2.07 ± 0.19 |
| `docker run -t ipfs--pnpm` | 20.761 ± 0.709 | 20.349 | 21.580 | 2.13 ± 0.21 |
| `docker run -t bolivar--pnpm` | 20.799 ± 2.409 | 18.936 | 23.519 | 2.13 ± 0.32 |
| `docker run -t cnpmjs--npm` | 26.554 ± 2.167 | 24.242 | 28.539 | 2.73 ± 0.34 |
| `docker run -t bolivar--npm` | 38.749 ± 1.187 | 37.404 | 39.649 | 3.98 ± 0.39 |
| `docker run -t cnpmjs--yarn` | 40.433 ± 2.380 | 38.402 | 43.052 | 4.15 ± 0.46 |
| `docker run -t bolivar--yarn` | 43.160 ± 1.176 | 42.297 | 44.500 | 4.43 ± 0.43 |
| `docker run -t ipfs--yarn` | 80.079 ± 26.700 | 55.053 | 108.185 | 8.22 ± 2.85 |
| `docker run -t ipfs--npm` | 110.301 ± 20.561 | 88.863 | 129.854 | 11.32 ± 2.36 |
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
