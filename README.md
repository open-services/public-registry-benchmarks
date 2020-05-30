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
## Report from 2020-05-30

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.945 ± 0.274 | 8.783 | 9.262 | 1.00 |
| `docker run -t yarn--pnpm` | 9.395 ± 0.392 | 9.098 | 9.840 | 1.05 ± 0.05 |
| `docker run -t open-registry--pnpm` | 10.243 ± 0.081 | 10.195 | 10.336 | 1.15 ± 0.04 |
| `docker run -t yarn--yarn` | 11.414 ± 0.207 | 11.243 | 11.644 | 1.28 ± 0.05 |
| `docker run -t npm--yarn` | 11.430 ± 0.270 | 11.230 | 11.737 | 1.28 ± 0.05 |
| `docker run -t npm--npm` | 12.496 ± 0.082 | 12.414 | 12.578 | 1.40 ± 0.04 |
| `docker run -t yarn--npm` | 12.758 ± 0.108 | 12.636 | 12.841 | 1.43 ± 0.05 |
| `docker run -t open-registry--yarn` | 17.076 ± 0.079 | 16.990 | 17.146 | 1.91 ± 0.06 |
| `docker run -t open-registry--npm` | 17.508 ± 0.224 | 17.257 | 17.689 | 1.96 ± 0.06 |
| `docker run -t bolivar--pnpm` | 19.148 ± 1.053 | 18.275 | 20.317 | 2.14 ± 0.13 |
| `docker run -t ipfs--pnpm` | 22.706 ± 1.500 | 21.641 | 24.421 | 2.54 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 23.153 ± 2.036 | 21.032 | 25.090 | 2.59 ± 0.24 |
| `docker run -t bolivar--npm` | 38.006 ± 0.704 | 37.253 | 38.648 | 4.25 ± 0.15 |
| `docker run -t bolivar--yarn` | 41.845 ± 0.502 | 41.396 | 42.387 | 4.68 ± 0.15 |
| `docker run -t cnpmjs--npm` | 47.065 ± 33.982 | 24.279 | 86.123 | 5.26 ± 3.80 |
| `docker run -t cnpmjs--yarn` | 56.649 ± 15.486 | 38.771 | 65.925 | 6.33 ± 1.74 |
| `docker run -t ipfs--yarn` | 138.940 ± 33.752 | 106.629 | 173.969 | 15.53 ± 3.80 |
| `docker run -t ipfs--npm` | 152.490 ± 50.770 | 99.937 | 201.266 | 17.05 ± 5.70 |
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
