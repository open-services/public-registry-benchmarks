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
## Report from 2020-06-06

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 7.893 ± 0.054 | 7.833 | 7.937 | 1.00 |
| `docker run -t yarn--pnpm` | 8.520 ± 0.199 | 8.305 | 8.698 | 1.08 ± 0.03 |
| `docker run -t open-registry--pnpm` | 9.490 ± 0.203 | 9.301 | 9.705 | 1.20 ± 0.03 |
| `docker run -t npm--yarn` | 10.295 ± 0.080 | 10.231 | 10.384 | 1.30 ± 0.01 |
| `docker run -t yarn--yarn` | 10.695 ± 0.233 | 10.447 | 10.911 | 1.35 ± 0.03 |
| `docker run -t npm--npm` | 11.271 ± 0.207 | 11.087 | 11.495 | 1.43 ± 0.03 |
| `docker run -t yarn--npm` | 11.802 ± 0.220 | 11.579 | 12.019 | 1.50 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.755 ± 0.072 | 15.705 | 15.838 | 2.00 ± 0.02 |
| `docker run -t open-registry--npm` | 15.887 ± 0.100 | 15.808 | 16.000 | 2.01 ± 0.02 |
| `docker run -t ipfs--pnpm` | 17.490 ± 0.303 | 17.299 | 17.840 | 2.22 ± 0.04 |
| `docker run -t bolivar--pnpm` | 17.786 ± 0.784 | 16.888 | 18.338 | 2.25 ± 0.10 |
| `docker run -t cnpmjs--pnpm` | 19.904 ± 0.369 | 19.672 | 20.329 | 2.52 ± 0.05 |
| `docker run -t cnpmjs--npm` | 26.514 ± 2.024 | 24.281 | 28.228 | 3.36 ± 0.26 |
| `docker run -t bolivar--npm` | 34.424 ± 0.407 | 34.082 | 34.874 | 4.36 ± 0.06 |
| `docker run -t bolivar--yarn` | 38.692 ± 0.765 | 37.909 | 39.438 | 4.90 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 39.391 ± 0.038 | 39.348 | 39.420 | 4.99 ± 0.03 |
| `docker run -t ipfs--npm` | 44.440 ± 1.435 | 42.969 | 45.836 | 5.63 ± 0.19 |
| `docker run -t ipfs--yarn` | 87.250 ± 29.894 | 59.751 | 119.069 | 11.05 ± 3.79 |
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
