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
## Report from 2020-05-21

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 9.917 ± 0.548 | 9.408 | 10.498 | 1.00 |
| `docker run -t npm--pnpm` | 10.081 ± 0.247 | 9.847 | 10.338 | 1.02 ± 0.06 |
| `docker run -t open-registry--pnpm` | 10.947 ± 0.127 | 10.827 | 11.081 | 1.10 ± 0.06 |
| `docker run -t yarn--yarn` | 12.334 ± 0.088 | 12.244 | 12.420 | 1.24 ± 0.07 |
| `docker run -t npm--yarn` | 12.610 ± 0.074 | 12.538 | 12.685 | 1.27 ± 0.07 |
| `docker run -t npm--npm` | 13.204 ± 0.264 | 12.936 | 13.465 | 1.33 ± 0.08 |
| `docker run -t yarn--npm` | 14.647 ± 0.356 | 14.396 | 15.055 | 1.48 ± 0.09 |
| `docker run -t open-registry--yarn` | 17.749 ± 0.252 | 17.565 | 18.036 | 1.79 ± 0.10 |
| `docker run -t open-registry--npm` | 18.448 ± 0.317 | 18.229 | 18.811 | 1.86 ± 0.11 |
| `docker run -t bolivar--pnpm` | 19.662 ± 0.408 | 19.261 | 20.076 | 1.98 ± 0.12 |
| `docker run -t ipfs--pnpm` | 21.196 ± 1.087 | 20.166 | 22.331 | 2.14 ± 0.16 |
| `docker run -t cnpmjs--npm` | 22.912 ± 0.507 | 22.500 | 23.479 | 2.31 ± 0.14 |
| `docker run -t bolivar--npm` | 40.924 ± 1.122 | 40.168 | 42.213 | 4.13 ± 0.25 |
| `docker run -t bolivar--yarn` | 43.047 ± 0.804 | 42.137 | 43.659 | 4.34 ± 0.25 |
| `docker run -t cnpmjs--yarn` | 46.277 ± 16.393 | 36.239 | 65.195 | 4.67 ± 1.67 |
| `docker run -t cnpmjs--pnpm` | 54.287 ± 28.862 | 21.518 | 75.928 | 5.47 ± 2.93 |
| `docker run -t ipfs--yarn` | 83.282 ± 27.261 | 59.198 | 112.877 | 8.40 ± 2.79 |
| `docker run -t ipfs--npm` | 113.490 ± 60.258 | 49.830 | 169.642 | 11.44 ± 6.11 |
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
