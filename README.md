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
## Report from 2020-07-02

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.666 ± 0.071 | 8.595 | 8.737 | 1.00 |
| `docker run -t yarn--pnpm` | 9.022 ± 0.769 | 8.572 | 9.909 | 1.04 ± 0.09 |
| `docker run -t open-registry--pnpm` | 10.015 ± 0.207 | 9.776 | 10.147 | 1.16 ± 0.03 |
| `docker run -t npm--yarn` | 11.240 ± 0.193 | 11.073 | 11.451 | 1.30 ± 0.02 |
| `docker run -t yarn--npm` | 12.107 ± 0.081 | 12.015 | 12.169 | 1.40 ± 0.01 |
| `docker run -t npm--npm` | 12.575 ± 0.050 | 12.524 | 12.623 | 1.45 ± 0.01 |
| `docker run -t open-registry--yarn` | 16.815 ± 0.312 | 16.530 | 17.147 | 1.94 ± 0.04 |
| `docker run -t ipfs--pnpm` | 17.036 ± 0.628 | 16.558 | 17.748 | 1.97 ± 0.07 |
| `docker run -t open-registry--npm` | 17.110 ± 0.386 | 16.729 | 17.501 | 1.97 ± 0.05 |
| `docker run -t yarn--yarn` | 17.828 ± 12.102 | 10.831 | 31.802 | 2.06 ± 1.40 |
| `docker run -t bolivar--pnpm` | 18.755 ± 1.386 | 17.282 | 20.033 | 2.16 ± 0.16 |
| `docker run -t cnpmjs--pnpm` | 20.068 ± 0.154 | 19.977 | 20.246 | 2.32 ± 0.03 |
| `docker run -t cnpmjs--npm` | 25.521 ± 2.215 | 23.588 | 27.937 | 2.94 ± 0.26 |
| `docker run -t bolivar--npm` | 36.245 ± 0.647 | 35.499 | 36.647 | 4.18 ± 0.08 |
| `docker run -t cnpmjs--yarn` | 37.803 ± 0.035 | 37.776 | 37.842 | 4.36 ± 0.04 |
| `docker run -t bolivar--yarn` | 41.145 ± 0.455 | 40.632 | 41.500 | 4.75 ± 0.07 |
| `docker run -t ipfs--npm` | 58.858 ± 6.258 | 52.665 | 65.178 | 6.79 ± 0.72 |
| `docker run -t ipfs--yarn` | 84.197 ± 27.123 | 65.632 | 115.323 | 9.72 ± 3.13 |
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
