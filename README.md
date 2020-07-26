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
## Report from 2020-07-26

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.196 ± 0.015 | 9.183 | 9.213 | 1.00 |
| `docker run -t yarn--pnpm` | 9.360 ± 0.132 | 9.208 | 9.443 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.866 ± 0.260 | 10.621 | 11.138 | 1.18 ± 0.03 |
| `docker run -t yarn--yarn` | 11.844 ± 0.044 | 11.793 | 11.872 | 1.29 ± 0.01 |
| `docker run -t npm--yarn` | 11.981 ± 0.263 | 11.769 | 12.275 | 1.30 ± 0.03 |
| `docker run -t npm--npm` | 12.911 ± 0.130 | 12.763 | 13.005 | 1.40 ± 0.01 |
| `docker run -t yarn--npm` | 13.436 ± 0.143 | 13.309 | 13.590 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.231 ± 0.274 | 16.914 | 17.403 | 1.87 ± 0.03 |
| `docker run -t open-registry--npm` | 18.633 ± 0.390 | 18.190 | 18.922 | 2.03 ± 0.04 |
| `docker run -t ipfs--pnpm` | 19.075 ± 0.229 | 18.812 | 19.220 | 2.07 ± 0.03 |
| `docker run -t bolivar--pnpm` | 23.403 ± 2.521 | 21.909 | 26.314 | 2.54 ± 0.27 |
| `docker run -t cnpmjs--pnpm` | 41.305 ± 35.286 | 20.836 | 82.050 | 4.49 ± 3.84 |
| `docker run -t bolivar--npm` | 42.487 ± 0.480 | 42.094 | 43.022 | 4.62 ± 0.05 |
| `docker run -t cnpmjs--yarn` | 44.914 ± 15.835 | 35.381 | 63.193 | 4.88 ± 1.72 |
| `docker run -t cnpmjs--npm` | 46.335 ± 39.686 | 23.207 | 92.159 | 5.04 ± 4.32 |
| `docker run -t bolivar--yarn` | 46.390 ± 1.211 | 44.992 | 47.097 | 5.04 ± 0.13 |
| `docker run -t ipfs--yarn` | 70.902 ± 29.208 | 53.688 | 104.626 | 7.71 ± 3.18 |
| `docker run -t ipfs--npm` | 75.406 ± 23.828 | 47.896 | 89.575 | 8.20 ± 2.59 |
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
