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
## Report from 2020-06-30

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 10.642 ± 0.136 | 10.542 | 10.796 | 1.00 |
| `docker run -t npm--pnpm` | 10.976 ± 0.519 | 10.581 | 11.564 | 1.03 ± 0.05 |
| `docker run -t open-registry--pnpm` | 12.012 ± 0.283 | 11.775 | 12.325 | 1.13 ± 0.03 |
| `docker run -t npm--yarn` | 13.325 ± 0.214 | 13.192 | 13.572 | 1.25 ± 0.03 |
| `docker run -t yarn--yarn` | 13.576 ± 0.450 | 13.152 | 14.048 | 1.28 ± 0.05 |
| `docker run -t npm--npm` | 14.360 ± 0.254 | 14.184 | 14.651 | 1.35 ± 0.03 |
| `docker run -t yarn--npm` | 15.828 ± 1.027 | 14.695 | 16.699 | 1.49 ± 0.10 |
| `docker run -t open-registry--yarn` | 18.488 ± 0.169 | 18.312 | 18.648 | 1.74 ± 0.03 |
| `docker run -t open-registry--npm` | 19.875 ± 0.441 | 19.401 | 20.273 | 1.87 ± 0.05 |
| `docker run -t ipfs--pnpm` | 21.022 ± 2.019 | 19.763 | 23.351 | 1.98 ± 0.19 |
| `docker run -t cnpmjs--pnpm` | 21.198 ± 1.289 | 20.016 | 22.572 | 1.99 ± 0.12 |
| `docker run -t bolivar--pnpm` | 21.332 ± 0.823 | 20.577 | 22.210 | 2.00 ± 0.08 |
| `docker run -t cnpmjs--npm` | 24.679 ± 0.435 | 24.212 | 25.073 | 2.32 ± 0.05 |
| `docker run -t bolivar--npm` | 42.452 ± 0.981 | 41.357 | 43.249 | 3.99 ± 0.11 |
| `docker run -t cnpmjs--yarn` | 46.315 ± 11.493 | 39.533 | 59.585 | 4.35 ± 1.08 |
| `docker run -t bolivar--yarn` | 47.070 ± 1.453 | 45.532 | 48.420 | 4.42 ± 0.15 |
| `docker run -t ipfs--yarn` | 92.901 ± 6.561 | 85.684 | 98.505 | 8.73 ± 0.63 |
| `docker run -t ipfs--npm` | 117.742 ± 53.547 | 58.526 | 162.755 | 11.06 ± 5.03 |
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
