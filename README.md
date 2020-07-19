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
## Report from 2020-07-19

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.314 ± 0.004 | 8.310 | 8.319 | 1.00 |
| `docker run -t yarn--pnpm` | 8.519 ± 0.015 | 8.505 | 8.535 | 1.02 ± 0.00 |
| `docker run -t open-registry--pnpm` | 9.726 ± 0.014 | 9.710 | 9.738 | 1.17 ± 0.00 |
| `docker run -t yarn--yarn` | 11.234 ± 0.491 | 10.860 | 11.790 | 1.35 ± 0.06 |
| `docker run -t npm--npm` | 11.835 ± 0.086 | 11.738 | 11.902 | 1.42 ± 0.01 |
| `docker run -t npm--yarn` | 12.049 ± 1.505 | 11.131 | 13.786 | 1.45 ± 0.18 |
| `docker run -t yarn--npm` | 12.099 ± 0.016 | 12.082 | 12.114 | 1.46 ± 0.00 |
| `docker run -t open-registry--yarn` | 15.865 ± 0.188 | 15.674 | 16.050 | 1.91 ± 0.02 |
| `docker run -t open-registry--npm` | 16.356 ± 0.350 | 16.027 | 16.723 | 1.97 ± 0.04 |
| `docker run -t ipfs--pnpm` | 17.651 ± 0.754 | 17.101 | 18.510 | 2.12 ± 0.09 |
| `docker run -t bolivar--pnpm` | 19.481 ± 1.259 | 18.163 | 20.671 | 2.34 ± 0.15 |
| `docker run -t cnpmjs--npm` | 22.574 ± 0.471 | 22.123 | 23.062 | 2.72 ± 0.06 |
| `docker run -t cnpmjs--yarn` | 37.417 ± 0.495 | 37.007 | 37.966 | 4.50 ± 0.06 |
| `docker run -t bolivar--npm` | 38.525 ± 0.664 | 37.798 | 39.100 | 4.63 ± 0.08 |
| `docker run -t cnpmjs--pnpm` | 39.073 ± 34.189 | 19.138 | 78.550 | 4.70 ± 4.11 |
| `docker run -t bolivar--yarn` | 39.859 ± 0.798 | 39.012 | 40.598 | 4.79 ± 0.10 |
| `docker run -t ipfs--yarn` | 81.399 ± 27.093 | 51.534 | 104.400 | 9.79 ± 3.26 |
| `docker run -t ipfs--npm` | 101.259 ± 52.365 | 44.754 | 148.152 | 12.18 ± 6.30 |
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
