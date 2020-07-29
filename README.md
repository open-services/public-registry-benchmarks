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
## Report from 2020-07-29

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.545 ± 0.017 | 8.528 | 8.562 | 1.00 |
| `docker run -t yarn--pnpm` | 8.778 ± 0.034 | 8.757 | 8.817 | 1.03 ± 0.00 |
| `docker run -t open-registry--pnpm` | 10.032 ± 0.073 | 9.977 | 10.115 | 1.17 ± 0.01 |
| `docker run -t npm--yarn` | 11.178 ± 0.101 | 11.087 | 11.287 | 1.31 ± 0.01 |
| `docker run -t yarn--yarn` | 11.265 ± 0.300 | 10.941 | 11.534 | 1.32 ± 0.04 |
| `docker run -t npm--npm` | 12.395 ± 0.065 | 12.349 | 12.468 | 1.45 ± 0.01 |
| `docker run -t yarn--npm` | 12.429 ± 0.072 | 12.348 | 12.486 | 1.45 ± 0.01 |
| `docker run -t open-registry--npm` | 17.251 ± 0.380 | 16.974 | 17.684 | 2.02 ± 0.04 |
| `docker run -t open-registry--yarn` | 17.301 ± 0.125 | 17.226 | 17.444 | 2.02 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.498 ± 0.816 | 19.007 | 20.441 | 2.28 ± 0.10 |
| `docker run -t ipfs--pnpm` | 20.751 ± 0.351 | 20.347 | 20.980 | 2.43 ± 0.04 |
| `docker run -t cnpmjs--yarn` | 36.598 ± 0.460 | 36.075 | 36.941 | 4.28 ± 0.05 |
| `docker run -t bolivar--npm` | 38.953 ± 0.347 | 38.556 | 39.197 | 4.56 ± 0.04 |
| `docker run -t bolivar--yarn` | 43.988 ± 0.895 | 43.071 | 44.859 | 5.15 ± 0.11 |
| `docker run -t cnpmjs--pnpm` | 46.041 ± 32.981 | 22.590 | 83.753 | 5.39 ± 3.86 |
| `docker run -t cnpmjs--npm` | 46.322 ± 36.958 | 24.191 | 88.987 | 5.42 ± 4.33 |
| `docker run -t ipfs--yarn` | 104.897 ± 34.744 | 69.044 | 138.414 | 12.28 ± 4.07 |
| `docker run -t ipfs--npm` | 166.423 ± 73.178 | 82.307 | 215.438 | 19.48 ± 8.56 |
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
