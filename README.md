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
## Report from 2020-07-23

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.498 ± 0.132 | 8.345 | 8.574 | 1.00 |
| `docker run -t yarn--pnpm` | 8.663 ± 0.061 | 8.598 | 8.720 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.900 ± 0.088 | 9.799 | 9.964 | 1.17 ± 0.02 |
| `docker run -t npm--yarn` | 11.063 ± 0.228 | 10.863 | 11.311 | 1.30 ± 0.03 |
| `docker run -t yarn--yarn` | 11.207 ± 0.158 | 11.095 | 11.387 | 1.32 ± 0.03 |
| `docker run -t npm--npm` | 11.968 ± 0.034 | 11.940 | 12.006 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.416 ± 0.403 | 12.112 | 12.874 | 1.46 ± 0.05 |
| `docker run -t open-registry--yarn` | 17.158 ± 0.160 | 17.048 | 17.341 | 2.02 ± 0.04 |
| `docker run -t open-registry--npm` | 17.723 ± 0.349 | 17.327 | 17.983 | 2.09 ± 0.05 |
| `docker run -t ipfs--pnpm` | 18.927 ± 0.505 | 18.393 | 19.396 | 2.23 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.364 ± 0.570 | 19.004 | 20.021 | 2.28 ± 0.08 |
| `docker run -t cnpmjs--pnpm` | 22.254 ± 1.213 | 21.548 | 23.654 | 2.62 ± 0.15 |
| `docker run -t bolivar--npm` | 36.953 ± 0.515 | 36.377 | 37.367 | 4.35 ± 0.09 |
| `docker run -t bolivar--yarn` | 40.912 ± 1.004 | 40.087 | 42.030 | 4.81 ± 0.14 |
| `docker run -t cnpmjs--npm` | 45.824 ± 38.643 | 21.862 | 90.403 | 5.39 ± 4.55 |
| `docker run -t cnpmjs--yarn` | 53.238 ± 13.026 | 38.370 | 62.642 | 6.26 ± 1.54 |
| `docker run -t ipfs--yarn` | 97.420 ± 40.178 | 51.038 | 121.515 | 11.46 ± 4.73 |
| `docker run -t ipfs--npm` | 137.335 ± 40.319 | 90.930 | 163.774 | 16.16 ± 4.75 |
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
