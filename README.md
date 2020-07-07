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
## Report from 2020-07-07

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.471 ± 0.069 | 8.412 | 8.547 | 1.00 |
| `docker run -t yarn--pnpm` | 8.728 ± 0.064 | 8.654 | 8.771 | 1.03 ± 0.01 |
| `docker run -t open-registry--pnpm` | 9.779 ± 0.001 | 9.778 | 9.780 | 1.15 ± 0.01 |
| `docker run -t npm--yarn` | 10.950 ± 0.097 | 10.892 | 11.062 | 1.29 ± 0.02 |
| `docker run -t yarn--yarn` | 11.078 ± 0.226 | 10.929 | 11.338 | 1.31 ± 0.03 |
| `docker run -t npm--npm` | 12.114 ± 0.053 | 12.082 | 12.175 | 1.43 ± 0.01 |
| `docker run -t yarn--npm` | 12.483 ± 0.335 | 12.274 | 12.870 | 1.47 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.094 ± 0.152 | 15.944 | 16.247 | 1.90 ± 0.02 |
| `docker run -t open-registry--npm` | 16.501 ± 0.104 | 16.433 | 16.620 | 1.95 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.306 ± 0.599 | 16.949 | 17.998 | 2.04 ± 0.07 |
| `docker run -t bolivar--pnpm` | 17.814 ± 1.236 | 16.842 | 19.205 | 2.10 ± 0.15 |
| `docker run -t cnpmjs--pnpm` | 19.159 ± 0.031 | 19.125 | 19.185 | 2.26 ± 0.02 |
| `docker run -t cnpmjs--npm` | 24.257 ± 3.115 | 22.375 | 27.852 | 2.86 ± 0.37 |
| `docker run -t bolivar--npm` | 35.396 ± 0.792 | 34.791 | 36.293 | 4.18 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 37.518 ± 0.078 | 37.431 | 37.582 | 4.43 ± 0.04 |
| `docker run -t bolivar--yarn` | 39.152 ± 0.465 | 38.616 | 39.435 | 4.62 ± 0.07 |
| `docker run -t ipfs--npm` | 63.584 ± 24.816 | 43.720 | 91.402 | 7.51 ± 2.93 |
| `docker run -t ipfs--yarn` | 73.207 ± 26.408 | 51.598 | 102.645 | 8.64 ± 3.12 |
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
