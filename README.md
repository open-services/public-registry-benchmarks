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
## Report from 2020-06-25

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.797 ± 0.439 | 8.520 | 9.303 | 1.00 |
| `docker run -t yarn--pnpm` | 8.844 ± 0.257 | 8.627 | 9.127 | 1.01 ± 0.06 |
| `docker run -t open-registry--pnpm` | 9.802 ± 0.003 | 9.799 | 9.806 | 1.11 ± 0.06 |
| `docker run -t yarn--yarn` | 11.009 ± 0.154 | 10.832 | 11.103 | 1.25 ± 0.06 |
| `docker run -t npm--yarn` | 11.223 ± 0.117 | 11.142 | 11.357 | 1.28 ± 0.06 |
| `docker run -t npm--npm` | 12.033 ± 0.074 | 11.982 | 12.118 | 1.37 ± 0.07 |
| `docker run -t yarn--npm` | 12.117 ± 0.038 | 12.079 | 12.154 | 1.38 ± 0.07 |
| `docker run -t open-registry--yarn` | 15.920 ± 0.052 | 15.860 | 15.953 | 1.81 ± 0.09 |
| `docker run -t open-registry--npm` | 16.440 ± 0.066 | 16.391 | 16.515 | 1.87 ± 0.09 |
| `docker run -t bolivar--pnpm` | 17.582 ± 0.405 | 17.202 | 18.008 | 2.00 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 20.082 ± 0.422 | 19.749 | 20.557 | 2.28 ± 0.12 |
| `docker run -t ipfs--pnpm` | 20.874 ± 0.839 | 19.931 | 21.539 | 2.37 ± 0.15 |
| `docker run -t cnpmjs--npm` | 27.214 ± 2.668 | 24.245 | 29.410 | 3.09 ± 0.34 |
| `docker run -t bolivar--npm` | 35.572 ± 0.713 | 35.070 | 36.388 | 4.04 ± 0.22 |
| `docker run -t bolivar--yarn` | 39.302 ± 2.111 | 37.717 | 41.699 | 4.47 ± 0.33 |
| `docker run -t cnpmjs--yarn` | 39.788 ± 0.600 | 39.235 | 40.427 | 4.52 ± 0.24 |
| `docker run -t ipfs--yarn` | 92.559 ± 44.499 | 57.675 | 142.673 | 10.52 ± 5.09 |
| `docker run -t ipfs--npm` | 146.761 ± 89.383 | 50.942 | 227.886 | 16.68 ± 10.19 |
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
