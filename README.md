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
## Report from 2020-06-08

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.533 ± 0.018 | 8.512 | 8.545 | 1.00 |
| `docker run -t yarn--pnpm` | 8.680 ± 0.161 | 8.501 | 8.810 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.013 ± 0.116 | 9.945 | 10.147 | 1.17 ± 0.01 |
| `docker run -t yarn--yarn` | 11.169 ± 0.202 | 11.008 | 11.395 | 1.31 ± 0.02 |
| `docker run -t npm--yarn` | 11.277 ± 0.523 | 10.873 | 11.867 | 1.32 ± 0.06 |
| `docker run -t npm--npm` | 12.097 ± 0.081 | 12.008 | 12.167 | 1.42 ± 0.01 |
| `docker run -t yarn--npm` | 12.499 ± 0.142 | 12.363 | 12.647 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.057 ± 0.190 | 15.935 | 16.276 | 1.88 ± 0.02 |
| `docker run -t open-registry--npm` | 16.586 ± 0.134 | 16.481 | 16.737 | 1.94 ± 0.02 |
| `docker run -t ipfs--pnpm` | 18.130 ± 0.178 | 17.939 | 18.291 | 2.12 ± 0.02 |
| `docker run -t bolivar--pnpm` | 19.412 ± 1.188 | 18.682 | 20.783 | 2.28 ± 0.14 |
| `docker run -t cnpmjs--pnpm` | 20.339 ± 0.179 | 20.167 | 20.524 | 2.38 ± 0.02 |
| `docker run -t cnpmjs--npm` | 23.481 ± 0.206 | 23.336 | 23.717 | 2.75 ± 0.02 |
| `docker run -t bolivar--npm` | 35.461 ± 0.120 | 35.375 | 35.598 | 4.16 ± 0.02 |
| `docker run -t bolivar--yarn` | 38.485 ± 0.764 | 37.703 | 39.229 | 4.51 ± 0.09 |
| `docker run -t cnpmjs--yarn` | 39.602 ± 0.549 | 39.250 | 40.235 | 4.64 ± 0.07 |
| `docker run -t ipfs--yarn` | 51.060 ± 4.284 | 48.445 | 56.004 | 5.98 ± 0.50 |
| `docker run -t ipfs--npm` | 68.019 ± 21.228 | 50.166 | 91.491 | 7.97 ± 2.49 |
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
