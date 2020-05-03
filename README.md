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
## Report from 2020-05-03

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 10.057 ± 0.067 | 10.016 | 10.135 | 1.00 |
| `docker run -t npm--pnpm` | 10.368 ± 0.339 | 10.103 | 10.751 | 1.03 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.749 ± 0.691 | 11.288 | 12.543 | 1.17 ± 0.07 |
| `docker run -t yarn--yarn` | 12.832 ± 0.067 | 12.770 | 12.903 | 1.28 ± 0.01 |
| `docker run -t npm--yarn` | 13.114 ± 0.472 | 12.630 | 13.574 | 1.30 ± 0.05 |
| `docker run -t npm--npm` | 14.208 ± 0.465 | 13.919 | 14.744 | 1.41 ± 0.05 |
| `docker run -t yarn--npm` | 14.286 ± 0.402 | 13.914 | 14.712 | 1.42 ± 0.04 |
| `docker run -t open-registry--yarn` | 18.277 ± 0.661 | 17.861 | 19.039 | 1.82 ± 0.07 |
| `docker run -t open-registry--npm` | 18.756 ± 0.379 | 18.476 | 19.188 | 1.86 ± 0.04 |
| `docker run -t bolivar--pnpm` | 19.174 ± 0.282 | 18.986 | 19.499 | 1.91 ± 0.03 |
| `docker run -t ipfs--pnpm` | 20.726 ± 1.998 | 19.328 | 23.015 | 2.06 ± 0.20 |
| `docker run -t cnpmjs--yarn` | 34.574 ± 0.414 | 34.258 | 35.042 | 3.44 ± 0.05 |
| `docker run -t bolivar--npm` | 38.522 ± 0.987 | 37.856 | 39.656 | 3.83 ± 0.10 |
| `docker run -t bolivar--yarn` | 42.854 ± 0.140 | 42.724 | 43.002 | 4.26 ± 0.03 |
| `docker run -t ipfs--npm` | 52.195 ± 6.877 | 47.538 | 60.093 | 5.19 ± 0.68 |
| `docker run -t ipfs--yarn` | 54.455 ± 0.938 | 53.803 | 55.530 | 5.41 ± 0.10 |
| `docker run -t cnpmjs--pnpm` | 58.826 ± 31.873 | 22.235 | 80.543 | 5.85 ± 3.17 |
| `docker run -t cnpmjs--npm` | 74.588 ± 60.474 | 24.309 | 141.693 | 7.42 ± 6.01 |
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
