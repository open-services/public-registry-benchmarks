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
## Report from 2020-07-10

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.159 ± 0.140 | 8.998 | 9.258 | 1.00 |
| `docker run -t yarn--pnpm` | 9.177 ± 0.017 | 9.159 | 9.191 | 1.00 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.468 ± 0.098 | 10.403 | 10.581 | 1.14 ± 0.02 |
| `docker run -t yarn--yarn` | 12.281 ± 0.062 | 12.222 | 12.345 | 1.34 ± 0.02 |
| `docker run -t npm--yarn` | 12.492 ± 0.250 | 12.329 | 12.780 | 1.36 ± 0.03 |
| `docker run -t yarn--npm` | 13.400 ± 0.304 | 13.101 | 13.709 | 1.46 ± 0.04 |
| `docker run -t npm--npm` | 14.028 ± 0.292 | 13.745 | 14.328 | 1.53 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.699 ± 0.078 | 16.613 | 16.766 | 1.82 ± 0.03 |
| `docker run -t open-registry--npm` | 17.566 ± 0.187 | 17.352 | 17.697 | 1.92 ± 0.04 |
| `docker run -t ipfs--pnpm` | 18.266 ± 0.737 | 17.421 | 18.778 | 1.99 ± 0.09 |
| `docker run -t cnpmjs--pnpm` | 19.444 ± 0.241 | 19.166 | 19.600 | 2.12 ± 0.04 |
| `docker run -t bolivar--pnpm` | 20.142 ± 0.070 | 20.098 | 20.224 | 2.20 ± 0.03 |
| `docker run -t cnpmjs--npm` | 25.124 ± 2.834 | 23.265 | 28.386 | 2.74 ± 0.31 |
| `docker run -t cnpmjs--yarn` | 37.729 ± 0.083 | 37.642 | 37.808 | 4.12 ± 0.06 |
| `docker run -t bolivar--npm` | 39.785 ± 0.288 | 39.562 | 40.110 | 4.34 ± 0.07 |
| `docker run -t bolivar--yarn` | 43.259 ± 0.506 | 42.892 | 43.836 | 4.72 ± 0.09 |
| `docker run -t ipfs--npm` | 53.927 ± 13.581 | 45.622 | 69.600 | 5.89 ± 1.49 |
| `docker run -t ipfs--yarn` | 110.645 ± 30.987 | 75.084 | 131.856 | 12.08 ± 3.39 |
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
