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
## Report from 2020-06-29

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.291 ± 0.084 | 8.194 | 8.346 | 1.00 |
| `docker run -t yarn--pnpm` | 8.376 ± 0.210 | 8.159 | 8.579 | 1.01 ± 0.03 |
| `docker run -t open-registry--pnpm` | 9.639 ± 0.092 | 9.559 | 9.740 | 1.16 ± 0.02 |
| `docker run -t npm--yarn` | 10.678 ± 0.232 | 10.500 | 10.940 | 1.29 ± 0.03 |
| `docker run -t yarn--yarn` | 10.854 ± 0.194 | 10.631 | 10.985 | 1.31 ± 0.03 |
| `docker run -t npm--npm` | 11.973 ± 0.308 | 11.690 | 12.301 | 1.44 ± 0.04 |
| `docker run -t yarn--npm` | 12.187 ± 0.202 | 11.954 | 12.312 | 1.47 ± 0.03 |
| `docker run -t open-registry--yarn` | 15.898 ± 0.028 | 15.875 | 15.928 | 1.92 ± 0.02 |
| `docker run -t open-registry--npm` | 16.409 ± 0.172 | 16.227 | 16.568 | 1.98 ± 0.03 |
| `docker run -t ipfs--pnpm` | 17.599 ± 0.103 | 17.524 | 17.716 | 2.12 ± 0.02 |
| `docker run -t bolivar--pnpm` | 18.898 ± 0.737 | 18.055 | 19.418 | 2.28 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 20.335 ± 0.108 | 20.214 | 20.420 | 2.45 ± 0.03 |
| `docker run -t cnpmjs--npm` | 24.122 ± 1.093 | 23.156 | 25.308 | 2.91 ± 0.14 |
| `docker run -t bolivar--npm` | 35.882 ± 0.329 | 35.613 | 36.249 | 4.33 ± 0.06 |
| `docker run -t bolivar--yarn` | 39.602 ± 0.571 | 38.957 | 40.043 | 4.78 ± 0.08 |
| `docker run -t cnpmjs--yarn` | 40.060 ± 1.171 | 39.182 | 41.390 | 4.83 ± 0.15 |
| `docker run -t ipfs--npm` | 83.798 ± 47.839 | 44.940 | 137.229 | 10.11 ± 5.77 |
| `docker run -t ipfs--yarn` | 110.340 ± 33.903 | 89.109 | 149.439 | 13.31 ± 4.09 |
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
