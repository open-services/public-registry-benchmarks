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
## Report from 2020-05-09

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 10.205 ± 0.184 | 10.084 | 10.416 | 1.00 |
| `docker run -t yarn--pnpm` | 10.444 ± 0.191 | 10.300 | 10.660 | 1.02 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.521 ± 0.124 | 11.409 | 11.654 | 1.13 ± 0.02 |
| `docker run -t yarn--yarn` | 13.978 ± 0.104 | 13.869 | 14.076 | 1.37 ± 0.03 |
| `docker run -t npm--yarn` | 14.176 ± 0.763 | 13.618 | 15.046 | 1.39 ± 0.08 |
| `docker run -t yarn--npm` | 15.068 ± 0.178 | 14.879 | 15.231 | 1.48 ± 0.03 |
| `docker run -t npm--npm` | 15.141 ± 0.203 | 14.916 | 15.313 | 1.48 ± 0.03 |
| `docker run -t ipfs--pnpm` | 18.594 ± 0.408 | 18.179 | 18.996 | 1.82 ± 0.05 |
| `docker run -t open-registry--yarn` | 18.687 ± 0.424 | 18.413 | 19.176 | 1.83 ± 0.05 |
| `docker run -t open-registry--npm` | 19.193 ± 0.446 | 18.726 | 19.615 | 1.88 ± 0.06 |
| `docker run -t bolivar--pnpm` | 20.858 ± 0.781 | 20.058 | 21.619 | 2.04 ± 0.08 |
| `docker run -t cnpmjs--pnpm` | 38.395 ± 27.655 | 22.413 | 70.328 | 3.76 ± 2.71 |
| `docker run -t bolivar--npm` | 41.979 ± 3.194 | 39.391 | 45.548 | 4.11 ± 0.32 |
| `docker run -t bolivar--yarn` | 46.819 ± 2.715 | 44.288 | 49.687 | 4.59 ± 0.28 |
| `docker run -t cnpmjs--npm` | 47.049 ± 36.650 | 25.694 | 89.368 | 4.61 ± 3.59 |
| `docker run -t ipfs--npm` | 48.710 ± 3.729 | 44.923 | 52.378 | 4.77 ± 0.38 |
| `docker run -t ipfs--yarn` | 54.196 ± 0.227 | 53.940 | 54.374 | 5.31 ± 0.10 |
| `docker run -t cnpmjs--yarn` | 68.731 ± 6.399 | 61.344 | 72.535 | 6.74 ± 0.64 |
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
