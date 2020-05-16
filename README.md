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
## Report from 2020-05-16

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.267 ± 0.066 | 8.191 | 8.308 | 1.00 |
| `docker run -t yarn--pnpm` | 8.470 ± 0.296 | 8.252 | 8.806 | 1.02 ± 0.04 |
| `docker run -t open-registry--pnpm` | 9.693 ± 0.188 | 9.491 | 9.863 | 1.17 ± 0.02 |
| `docker run -t yarn--yarn` | 10.783 ± 0.090 | 10.681 | 10.852 | 1.30 ± 0.02 |
| `docker run -t npm--yarn` | 11.163 ± 0.390 | 10.923 | 11.613 | 1.35 ± 0.05 |
| `docker run -t npm--npm` | 11.886 ± 0.066 | 11.816 | 11.947 | 1.44 ± 0.01 |
| `docker run -t yarn--npm` | 12.067 ± 0.076 | 11.981 | 12.124 | 1.46 ± 0.01 |
| `docker run -t open-registry--yarn` | 15.884 ± 0.146 | 15.761 | 16.045 | 1.92 ± 0.02 |
| `docker run -t open-registry--npm` | 16.267 ± 0.139 | 16.184 | 16.428 | 1.97 ± 0.02 |
| `docker run -t bolivar--pnpm` | 18.855 ± 1.039 | 17.655 | 19.464 | 2.28 ± 0.13 |
| `docker run -t ipfs--pnpm` | 19.144 ± 0.335 | 18.940 | 19.531 | 2.32 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 22.751 ± 1.026 | 21.717 | 23.769 | 2.75 ± 0.13 |
| `docker run -t bolivar--npm` | 36.712 ± 0.253 | 36.425 | 36.904 | 4.44 ± 0.05 |
| `docker run -t bolivar--yarn` | 40.410 ± 0.461 | 40.110 | 40.941 | 4.89 ± 0.07 |
| `docker run -t cnpmjs--npm` | 44.130 ± 34.816 | 23.871 | 84.331 | 5.34 ± 4.21 |
| `docker run -t cnpmjs--yarn` | 48.676 ± 16.393 | 38.932 | 67.602 | 5.89 ± 1.98 |
| `docker run -t ipfs--npm` | 66.883 ± 16.317 | 48.182 | 78.224 | 8.09 ± 1.97 |
| `docker run -t ipfs--yarn` | 81.389 ± 28.685 | 51.800 | 109.076 | 9.84 ± 3.47 |
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
