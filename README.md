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
## Report from 2020-07-08

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.324 ± 0.023 | 8.301 | 8.346 | 1.00 |
| `docker run -t yarn--pnpm` | 8.723 ± 0.104 | 8.609 | 8.813 | 1.05 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.756 ± 0.024 | 9.734 | 9.781 | 1.17 ± 0.00 |
| `docker run -t npm--yarn` | 11.124 ± 0.712 | 10.648 | 11.942 | 1.34 ± 0.09 |
| `docker run -t yarn--yarn` | 11.447 ± 0.121 | 11.356 | 11.584 | 1.38 ± 0.02 |
| `docker run -t npm--npm` | 11.903 ± 0.037 | 11.860 | 11.928 | 1.43 ± 0.01 |
| `docker run -t yarn--npm` | 12.189 ± 0.175 | 12.074 | 12.391 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 15.872 ± 0.033 | 15.852 | 15.910 | 1.91 ± 0.01 |
| `docker run -t open-registry--npm` | 16.363 ± 0.103 | 16.292 | 16.481 | 1.97 ± 0.01 |
| `docker run -t ipfs--pnpm` | 17.742 ± 1.188 | 16.692 | 19.031 | 2.13 ± 0.14 |
| `docker run -t bolivar--pnpm` | 20.273 ± 1.037 | 19.170 | 21.226 | 2.44 ± 0.12 |
| `docker run -t cnpmjs--yarn` | 38.269 ± 0.955 | 37.578 | 39.359 | 4.60 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 38.765 ± 32.671 | 19.706 | 76.489 | 4.66 ± 3.93 |
| `docker run -t bolivar--yarn` | 38.838 ± 0.739 | 38.379 | 39.690 | 4.67 ± 0.09 |
| `docker run -t bolivar--npm` | 39.238 ± 0.600 | 38.549 | 39.646 | 4.71 ± 0.07 |
| `docker run -t cnpmjs--npm` | 49.396 ± 39.920 | 23.785 | 95.393 | 5.93 ± 4.80 |
| `docker run -t ipfs--npm` | 109.931 ± 9.051 | 99.485 | 115.445 | 13.21 ± 1.09 |
| `docker run -t ipfs--yarn` | 111.246 ± 16.196 | 101.602 | 129.945 | 13.37 ± 1.95 |
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
