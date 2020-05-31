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
## Report from 2020-05-31

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.783 ± 0.009 | 8.774 | 8.791 | 1.00 |
| `docker run -t npm--pnpm` | 8.917 ± 0.096 | 8.839 | 9.024 | 1.02 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.382 ± 0.211 | 10.170 | 10.592 | 1.18 ± 0.02 |
| `docker run -t yarn--yarn` | 11.176 ± 0.103 | 11.114 | 11.294 | 1.27 ± 0.01 |
| `docker run -t npm--yarn` | 11.204 ± 0.085 | 11.106 | 11.257 | 1.28 ± 0.01 |
| `docker run -t npm--npm` | 12.445 ± 0.106 | 12.344 | 12.556 | 1.42 ± 0.01 |
| `docker run -t yarn--npm` | 12.607 ± 0.266 | 12.302 | 12.793 | 1.44 ± 0.03 |
| `docker run -t open-registry--yarn` | 16.940 ± 0.137 | 16.827 | 17.093 | 1.93 ± 0.02 |
| `docker run -t open-registry--npm` | 17.903 ± 0.506 | 17.501 | 18.472 | 2.04 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.287 ± 0.923 | 18.289 | 20.110 | 2.20 ± 0.11 |
| `docker run -t ipfs--pnpm` | 19.437 ± 0.021 | 19.417 | 19.458 | 2.21 ± 0.00 |
| `docker run -t cnpmjs--pnpm` | 20.634 ± 1.416 | 19.783 | 22.269 | 2.35 ± 0.16 |
| `docker run -t bolivar--npm` | 40.094 ± 2.288 | 38.642 | 42.732 | 4.57 ± 0.26 |
| `docker run -t cnpmjs--npm` | 41.870 ± 34.030 | 22.074 | 81.163 | 4.77 ± 3.87 |
| `docker run -t bolivar--yarn` | 48.583 ± 11.196 | 41.814 | 61.506 | 5.53 ± 1.27 |
| `docker run -t cnpmjs--yarn` | 50.336 ± 12.004 | 36.578 | 58.678 | 5.73 ± 1.37 |
| `docker run -t ipfs--yarn` | 65.118 ± 11.921 | 51.410 | 73.055 | 7.41 ± 1.36 |
| `docker run -t ipfs--npm` | 131.742 ± 60.691 | 68.891 | 190.013 | 15.00 ± 6.91 |
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
