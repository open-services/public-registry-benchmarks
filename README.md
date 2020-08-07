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
## Report from 2020-08-07

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.320 ± 0.011 | 8.308 | 8.329 | 1.00 |
| `docker run -t yarn--pnpm` | 8.613 ± 0.097 | 8.547 | 8.724 | 1.04 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.374 ± 0.393 | 9.995 | 10.780 | 1.25 ± 0.05 |
| `docker run -t npm--yarn` | 10.774 ± 0.008 | 10.768 | 10.783 | 1.30 ± 0.00 |
| `docker run -t yarn--yarn` | 10.996 ± 0.127 | 10.883 | 11.133 | 1.32 ± 0.02 |
| `docker run -t npm--npm` | 11.817 ± 0.068 | 11.743 | 11.875 | 1.42 ± 0.01 |
| `docker run -t yarn--npm` | 12.504 ± 0.161 | 12.326 | 12.642 | 1.50 ± 0.02 |
| `docker run -t open-registry--yarn` | 17.223 ± 0.144 | 17.102 | 17.382 | 2.07 ± 0.02 |
| `docker run -t open-registry--npm` | 17.596 ± 0.335 | 17.353 | 17.979 | 2.12 ± 0.04 |
| `docker run -t bolivar--pnpm` | 20.236 ± 1.628 | 18.760 | 21.983 | 2.43 ± 0.20 |
| `docker run -t cnpmjs--npm` | 24.353 ± 3.098 | 21.990 | 27.861 | 2.93 ± 0.37 |
| `docker run -t ipfs--pnpm` | 25.680 ± 16.227 | 16.129 | 44.415 | 3.09 ± 1.95 |
| `docker run -t bolivar--npm` | 37.611 ± 0.508 | 37.039 | 38.012 | 4.52 ± 0.06 |
| `docker run -t bolivar--yarn` | 42.160 ± 1.233 | 40.785 | 43.166 | 5.07 ± 0.15 |
| `docker run -t cnpmjs--pnpm` | 42.945 ± 33.855 | 21.895 | 81.998 | 5.16 ± 4.07 |
| `docker run -t ipfs--yarn` | 54.191 ± 10.661 | 46.779 | 66.408 | 6.51 ± 1.28 |
| `docker run -t cnpmjs--yarn` | 58.715 ± 20.618 | 36.973 | 77.985 | 7.06 ± 2.48 |
| `docker run -t ipfs--npm` | 67.890 ± 27.472 | 41.786 | 96.551 | 8.16 ± 3.30 |
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
