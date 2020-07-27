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
## Report from 2020-07-27

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.023 ± 0.120 | 8.950 | 9.162 | 1.00 |
| `docker run -t yarn--pnpm` | 9.111 ± 0.072 | 9.035 | 9.178 | 1.01 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.429 ± 0.137 | 10.345 | 10.587 | 1.16 ± 0.02 |
| `docker run -t npm--yarn` | 11.946 ± 0.051 | 11.889 | 11.985 | 1.32 ± 0.02 |
| `docker run -t yarn--yarn` | 12.250 ± 0.050 | 12.203 | 12.302 | 1.36 ± 0.02 |
| `docker run -t npm--npm` | 13.030 ± 0.216 | 12.789 | 13.206 | 1.44 ± 0.03 |
| `docker run -t yarn--npm` | 13.226 ± 0.045 | 13.198 | 13.278 | 1.47 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.845 ± 0.204 | 16.692 | 17.076 | 1.87 ± 0.03 |
| `docker run -t open-registry--npm` | 17.410 ± 0.034 | 17.380 | 17.446 | 1.93 ± 0.03 |
| `docker run -t ipfs--pnpm` | 18.418 ± 0.438 | 18.140 | 18.923 | 2.04 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 19.129 ± 0.201 | 18.985 | 19.358 | 2.12 ± 0.04 |
| `docker run -t bolivar--pnpm` | 20.321 ± 0.355 | 20.001 | 20.702 | 2.25 ± 0.05 |
| `docker run -t cnpmjs--npm` | 25.529 ± 2.674 | 23.839 | 28.612 | 2.83 ± 0.30 |
| `docker run -t cnpmjs--yarn` | 37.426 ± 0.317 | 37.201 | 37.789 | 4.15 ± 0.07 |
| `docker run -t bolivar--npm` | 40.082 ± 0.077 | 40.005 | 40.159 | 4.44 ± 0.06 |
| `docker run -t bolivar--yarn` | 42.901 ± 0.692 | 42.106 | 43.367 | 4.75 ± 0.10 |
| `docker run -t ipfs--npm` | 61.363 ± 16.874 | 47.709 | 80.228 | 6.80 ± 1.87 |
| `docker run -t ipfs--yarn` | 137.485 ± 58.427 | 102.539 | 204.936 | 15.24 ± 6.48 |
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
