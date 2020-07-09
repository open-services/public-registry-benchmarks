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
## Report from 2020-07-09

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.976 ± 0.040 | 8.930 | 9.005 | 1.00 |
| `docker run -t yarn--pnpm` | 9.329 ± 0.095 | 9.220 | 9.387 | 1.04 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.676 ± 0.108 | 10.601 | 10.799 | 1.19 ± 0.01 |
| `docker run -t npm--yarn` | 12.314 ± 0.352 | 12.045 | 12.713 | 1.37 ± 0.04 |
| `docker run -t yarn--yarn` | 12.707 ± 0.873 | 12.075 | 13.703 | 1.42 ± 0.10 |
| `docker run -t npm--npm` | 13.243 ± 0.273 | 13.071 | 13.557 | 1.48 ± 0.03 |
| `docker run -t yarn--npm` | 13.697 ± 0.289 | 13.513 | 14.030 | 1.53 ± 0.03 |
| `docker run -t open-registry--yarn` | 16.816 ± 0.100 | 16.723 | 16.922 | 1.87 ± 0.01 |
| `docker run -t ipfs--pnpm` | 17.164 ± 0.227 | 16.931 | 17.384 | 1.91 ± 0.03 |
| `docker run -t open-registry--npm` | 17.337 ± 0.120 | 17.208 | 17.444 | 1.93 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.393 ± 0.266 | 19.229 | 19.700 | 2.16 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 19.448 ± 0.128 | 19.353 | 19.593 | 2.17 ± 0.02 |
| `docker run -t cnpmjs--npm` | 23.718 ± 0.229 | 23.483 | 23.940 | 2.64 ± 0.03 |
| `docker run -t bolivar--npm` | 37.283 ± 0.432 | 36.790 | 37.589 | 4.15 ± 0.05 |
| `docker run -t bolivar--yarn` | 39.949 ± 0.535 | 39.422 | 40.491 | 4.45 ± 0.06 |
| `docker run -t cnpmjs--yarn` | 48.239 ± 18.674 | 36.902 | 69.792 | 5.37 ± 2.08 |
| `docker run -t ipfs--npm` | 52.208 ± 18.633 | 41.204 | 73.722 | 5.82 ± 2.08 |
| `docker run -t ipfs--yarn` | 97.412 ± 35.659 | 62.933 | 134.145 | 10.85 ± 3.97 |
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
