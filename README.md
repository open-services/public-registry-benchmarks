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
## Report from 2020-06-23

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 10.490 ± 0.089 | 10.404 | 10.581 | 1.00 |
| `docker run -t yarn--pnpm` | 11.105 ± 0.432 | 10.766 | 11.591 | 1.06 ± 0.04 |
| `docker run -t open-registry--pnpm` | 11.982 ± 0.041 | 11.937 | 12.014 | 1.14 ± 0.01 |
| `docker run -t npm--yarn` | 14.433 ± 0.276 | 14.240 | 14.749 | 1.38 ± 0.03 |
| `docker run -t yarn--yarn` | 14.503 ± 0.064 | 14.442 | 14.570 | 1.38 ± 0.01 |
| `docker run -t yarn--npm` | 15.758 ± 0.123 | 15.615 | 15.836 | 1.50 ± 0.02 |
| `docker run -t npm--npm` | 15.940 ± 1.002 | 15.235 | 17.087 | 1.52 ± 0.10 |
| `docker run -t open-registry--yarn` | 19.614 ± 0.738 | 19.075 | 20.454 | 1.87 ± 0.07 |
| `docker run -t open-registry--npm` | 20.049 ± 0.570 | 19.621 | 20.696 | 1.91 ± 0.06 |
| `docker run -t cnpmjs--pnpm` | 20.532 ± 0.014 | 20.521 | 20.548 | 1.96 ± 0.02 |
| `docker run -t ipfs--pnpm` | 21.428 ± 2.203 | 20.009 | 23.966 | 2.04 ± 0.21 |
| `docker run -t bolivar--pnpm` | 22.073 ± 0.155 | 21.968 | 22.251 | 2.10 ± 0.02 |
| `docker run -t cnpmjs--npm` | 25.965 ± 0.133 | 25.816 | 26.074 | 2.48 ± 0.02 |
| `docker run -t cnpmjs--yarn` | 40.769 ± 0.177 | 40.616 | 40.962 | 3.89 ± 0.04 |
| `docker run -t bolivar--npm` | 43.685 ± 0.384 | 43.247 | 43.965 | 4.16 ± 0.05 |
| `docker run -t bolivar--yarn` | 45.836 ± 0.526 | 45.230 | 46.178 | 4.37 ± 0.06 |
| `docker run -t ipfs--yarn` | 91.864 ± 43.442 | 56.989 | 140.527 | 8.76 ± 4.14 |
| `docker run -t ipfs--npm` | 94.819 ± 18.776 | 78.879 | 115.516 | 9.04 ± 1.79 |
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
