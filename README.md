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
## Report from 2020-05-24

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.349 ± 0.095 | 8.278 | 8.458 | 1.00 |
| `docker run -t yarn--pnpm` | 8.478 ± 0.009 | 8.467 | 8.484 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.760 ± 0.117 | 9.683 | 9.895 | 1.17 ± 0.02 |
| `docker run -t npm--yarn` | 10.943 ± 0.097 | 10.863 | 11.051 | 1.31 ± 0.02 |
| `docker run -t yarn--yarn` | 11.115 ± 0.178 | 10.971 | 11.314 | 1.33 ± 0.03 |
| `docker run -t npm--npm` | 11.956 ± 0.149 | 11.850 | 12.127 | 1.43 ± 0.02 |
| `docker run -t yarn--npm` | 12.309 ± 0.030 | 12.276 | 12.333 | 1.47 ± 0.02 |
| `docker run -t open-registry--yarn` | 15.933 ± 0.053 | 15.897 | 15.994 | 1.91 ± 0.02 |
| `docker run -t open-registry--npm` | 16.458 ± 0.219 | 16.303 | 16.708 | 1.97 ± 0.03 |
| `docker run -t bolivar--pnpm` | 17.138 ± 0.342 | 16.745 | 17.365 | 2.05 ± 0.05 |
| `docker run -t ipfs--pnpm` | 20.582 ± 0.435 | 20.079 | 20.841 | 2.47 ± 0.06 |
| `docker run -t cnpmjs--npm` | 24.995 ± 2.793 | 23.064 | 28.197 | 2.99 ± 0.34 |
| `docker run -t bolivar--npm` | 34.625 ± 0.577 | 34.275 | 35.291 | 4.15 ± 0.08 |
| `docker run -t bolivar--yarn` | 38.937 ± 0.840 | 37.982 | 39.556 | 4.66 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 41.577 ± 33.640 | 22.049 | 80.421 | 4.98 ± 4.03 |
| `docker run -t cnpmjs--yarn` | 53.645 ± 13.555 | 39.282 | 66.214 | 6.43 ± 1.63 |
| `docker run -t ipfs--npm` | 92.542 ± 36.126 | 52.671 | 123.099 | 11.08 ± 4.33 |
| `docker run -t ipfs--yarn` | 140.515 ± 12.484 | 132.875 | 154.922 | 16.83 ± 1.51 |
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
