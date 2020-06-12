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
## Report from 2020-06-12

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.662 ± 0.097 | 8.603 | 8.774 | 1.00 |
| `docker run -t yarn--pnpm` | 8.876 ± 0.105 | 8.759 | 8.961 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.387 ± 0.175 | 10.234 | 10.577 | 1.20 ± 0.02 |
| `docker run -t npm--yarn` | 11.391 ± 0.318 | 11.115 | 11.740 | 1.32 ± 0.04 |
| `docker run -t yarn--yarn` | 11.711 ± 0.325 | 11.359 | 12.000 | 1.35 ± 0.04 |
| `docker run -t npm--npm` | 12.174 ± 0.141 | 12.046 | 12.325 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.467 ± 0.156 | 12.325 | 12.635 | 1.44 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.438 ± 0.250 | 17.240 | 17.719 | 2.01 ± 0.04 |
| `docker run -t open-registry--npm` | 17.815 ± 0.320 | 17.601 | 18.182 | 2.06 ± 0.04 |
| `docker run -t bolivar--pnpm` | 18.844 ± 1.064 | 17.634 | 19.637 | 2.18 ± 0.13 |
| `docker run -t ipfs--pnpm` | 18.855 ± 0.217 | 18.604 | 18.992 | 2.18 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 22.328 ± 0.834 | 21.581 | 23.228 | 2.58 ± 0.10 |
| `docker run -t cnpmjs--npm` | 23.672 ± 0.782 | 23.137 | 24.569 | 2.73 ± 0.10 |
| `docker run -t bolivar--npm` | 35.045 ± 0.172 | 34.876 | 35.220 | 4.05 ± 0.05 |
| `docker run -t cnpmjs--yarn` | 38.584 ± 0.798 | 38.003 | 39.494 | 4.45 ± 0.10 |
| `docker run -t bolivar--yarn` | 39.080 ± 0.438 | 38.610 | 39.477 | 4.51 ± 0.07 |
| `docker run -t ipfs--npm` | 63.656 ± 27.595 | 47.275 | 95.516 | 7.35 ± 3.19 |
| `docker run -t ipfs--yarn` | 124.092 ± 13.895 | 108.223 | 134.071 | 14.33 ± 1.61 |
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
