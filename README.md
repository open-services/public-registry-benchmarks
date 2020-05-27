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
## Report from 2020-05-27

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.540 ± 0.054 | 8.487 | 8.595 | 1.00 |
| `docker run -t yarn--pnpm` | 9.199 ± 0.588 | 8.795 | 9.874 | 1.08 ± 0.07 |
| `docker run -t open-registry--pnpm` | 10.226 ± 0.131 | 10.137 | 10.376 | 1.20 ± 0.02 |
| `docker run -t npm--yarn` | 11.035 ± 0.030 | 11.010 | 11.068 | 1.29 ± 0.01 |
| `docker run -t yarn--yarn` | 11.331 ± 0.160 | 11.179 | 11.498 | 1.33 ± 0.02 |
| `docker run -t npm--npm` | 11.839 ± 0.093 | 11.734 | 11.911 | 1.39 ± 0.01 |
| `docker run -t yarn--npm` | 12.414 ± 0.076 | 12.338 | 12.490 | 1.45 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.120 ± 0.220 | 15.972 | 16.372 | 1.89 ± 0.03 |
| `docker run -t open-registry--npm` | 16.793 ± 0.216 | 16.588 | 17.019 | 1.97 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.241 ± 0.846 | 17.624 | 19.205 | 2.14 ± 0.10 |
| `docker run -t ipfs--pnpm` | 19.612 ± 0.893 | 18.746 | 20.530 | 2.30 ± 0.11 |
| `docker run -t cnpmjs--npm` | 23.340 ± 0.272 | 23.047 | 23.584 | 2.73 ± 0.04 |
| `docker run -t cnpmjs--pnpm` | 23.521 ± 1.624 | 22.581 | 25.396 | 2.75 ± 0.19 |
| `docker run -t bolivar--npm` | 35.730 ± 0.436 | 35.231 | 36.038 | 4.18 ± 0.06 |
| `docker run -t bolivar--yarn` | 39.093 ± 0.022 | 39.068 | 39.109 | 4.58 ± 0.03 |
| `docker run -t cnpmjs--yarn` | 48.606 ± 16.895 | 38.743 | 68.115 | 5.69 ± 1.98 |
| `docker run -t ipfs--npm` | 103.951 ± 27.188 | 72.560 | 120.006 | 12.17 ± 3.18 |
| `docker run -t ipfs--yarn` | 133.684 ± 66.975 | 56.351 | 172.964 | 15.65 ± 7.84 |
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
