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
## Report from 2020-08-11

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 10.482 ± 0.177 | 10.348 | 10.683 | 1.00 |
| `docker run -t yarn--pnpm` | 10.682 ± 0.237 | 10.409 | 10.829 | 1.02 ± 0.03 |
| `docker run -t open-registry--pnpm` | 11.759 ± 0.017 | 11.749 | 11.779 | 1.12 ± 0.02 |
| `docker run -t npm--yarn` | 13.748 ± 0.746 | 13.182 | 14.593 | 1.31 ± 0.07 |
| `docker run -t yarn--yarn` | 13.792 ± 0.095 | 13.691 | 13.878 | 1.32 ± 0.02 |
| `docker run -t npm--npm` | 14.661 ± 0.196 | 14.436 | 14.792 | 1.40 ± 0.03 |
| `docker run -t yarn--npm` | 15.408 ± 0.183 | 15.295 | 15.619 | 1.47 ± 0.03 |
| `docker run -t ipfs--pnpm` | 17.216 ± 0.436 | 16.829 | 17.689 | 1.64 ± 0.05 |
| `docker run -t open-registry--yarn` | 18.363 ± 0.472 | 17.931 | 18.867 | 1.75 ± 0.05 |
| `docker run -t open-registry--npm` | 19.105 ± 0.166 | 18.965 | 19.289 | 1.82 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 19.253 ± 0.117 | 19.164 | 19.385 | 1.84 ± 0.03 |
| `docker run -t bolivar--pnpm` | 20.697 ± 0.052 | 20.651 | 20.754 | 1.97 ± 0.03 |
| `docker run -t cnpmjs--npm` | 23.685 ± 0.293 | 23.516 | 24.023 | 2.26 ± 0.05 |
| `docker run -t cnpmjs--yarn` | 37.974 ± 1.079 | 37.207 | 39.208 | 3.62 ± 0.12 |
| `docker run -t bolivar--npm` | 42.012 ± 0.464 | 41.478 | 42.323 | 4.01 ± 0.08 |
| `docker run -t bolivar--yarn` | 44.572 ± 0.337 | 44.216 | 44.886 | 4.25 ± 0.08 |
| `docker run -t ipfs--npm` | 46.170 ± 4.735 | 43.348 | 51.636 | 4.40 ± 0.46 |
| `docker run -t ipfs--yarn` | 67.634 ± 20.406 | 51.114 | 90.445 | 6.45 ± 1.95 |
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
