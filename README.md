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
## Report from 2020-08-08

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 11.118 ± 0.083 | 11.023 | 11.168 | 1.00 |
| `docker run -t yarn--pnpm` | 12.200 ± 0.133 | 12.067 | 12.333 | 1.10 ± 0.01 |
| `docker run -t open-registry--pnpm` | 12.572 ± 0.079 | 12.490 | 12.646 | 1.13 ± 0.01 |
| `docker run -t npm--yarn` | 15.712 ± 1.384 | 14.685 | 17.286 | 1.41 ± 0.12 |
| `docker run -t npm--npm` | 15.884 ± 0.282 | 15.633 | 16.190 | 1.43 ± 0.03 |
| `docker run -t yarn--yarn` | 16.170 ± 0.256 | 15.906 | 16.417 | 1.45 ± 0.03 |
| `docker run -t yarn--npm` | 17.826 ± 0.564 | 17.359 | 18.453 | 1.60 ± 0.05 |
| `docker run -t ipfs--pnpm` | 19.803 ± 1.729 | 17.819 | 20.994 | 1.78 ± 0.16 |
| `docker run -t cnpmjs--pnpm` | 19.876 ± 0.565 | 19.530 | 20.528 | 1.79 ± 0.05 |
| `docker run -t open-registry--npm` | 20.456 ± 0.331 | 20.178 | 20.821 | 1.84 ± 0.03 |
| `docker run -t open-registry--yarn` | 20.526 ± 0.259 | 20.286 | 20.801 | 1.85 ± 0.03 |
| `docker run -t bolivar--pnpm` | 26.508 ± 1.302 | 25.532 | 27.987 | 2.38 ± 0.12 |
| `docker run -t cnpmjs--npm` | 26.621 ± 0.709 | 25.872 | 27.281 | 2.39 ± 0.07 |
| `docker run -t cnpmjs--yarn` | 40.581 ± 2.455 | 38.585 | 43.322 | 3.65 ± 0.22 |
| `docker run -t bolivar--npm` | 47.323 ± 0.593 | 46.796 | 47.964 | 4.26 ± 0.06 |
| `docker run -t bolivar--yarn` | 50.243 ± 0.456 | 49.880 | 50.755 | 4.52 ± 0.05 |
| `docker run -t ipfs--npm` | 64.875 ± 17.115 | 49.289 | 83.192 | 5.83 ± 1.54 |
| `docker run -t ipfs--yarn` | 64.936 ± 16.609 | 53.500 | 83.987 | 5.84 ± 1.49 |
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
