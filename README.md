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
## Report from 2020-07-03

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.143 ± 0.270 | 8.916 | 9.442 | 1.00 |
| `docker run -t yarn--pnpm` | 10.687 ± 0.207 | 10.449 | 10.830 | 1.17 ± 0.04 |
| `docker run -t open-registry--pnpm` | 10.722 ± 0.112 | 10.647 | 10.851 | 1.17 ± 0.04 |
| `docker run -t npm--yarn` | 11.289 ± 0.090 | 11.237 | 11.392 | 1.23 ± 0.04 |
| `docker run -t npm--npm` | 12.492 ± 0.065 | 12.443 | 12.566 | 1.37 ± 0.04 |
| `docker run -t yarn--yarn` | 13.302 ± 0.430 | 13.022 | 13.796 | 1.45 ± 0.06 |
| `docker run -t yarn--npm` | 13.596 ± 0.268 | 13.403 | 13.902 | 1.49 ± 0.05 |
| `docker run -t ipfs--pnpm` | 17.457 ± 0.701 | 16.678 | 18.039 | 1.91 ± 0.10 |
| `docker run -t open-registry--yarn` | 17.618 ± 0.273 | 17.368 | 17.909 | 1.93 ± 0.06 |
| `docker run -t open-registry--npm` | 18.003 ± 0.177 | 17.827 | 18.182 | 1.97 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.384 ± 0.629 | 18.692 | 19.919 | 2.12 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 21.606 ± 0.478 | 21.054 | 21.903 | 2.36 ± 0.09 |
| `docker run -t cnpmjs--npm` | 25.838 ± 2.603 | 23.191 | 28.394 | 2.83 ± 0.30 |
| `docker run -t cnpmjs--yarn` | 36.065 ± 0.369 | 35.680 | 36.415 | 3.94 ± 0.12 |
| `docker run -t bolivar--npm` | 38.753 ± 1.203 | 37.448 | 39.819 | 4.24 ± 0.18 |
| `docker run -t bolivar--yarn` | 43.309 ± 0.215 | 43.063 | 43.466 | 4.74 ± 0.14 |
| `docker run -t ipfs--npm` | 65.907 ± 20.690 | 45.319 | 86.697 | 7.21 ± 2.27 |
| `docker run -t ipfs--yarn` | 107.608 ± 18.996 | 91.237 | 128.436 | 11.77 ± 2.11 |
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
