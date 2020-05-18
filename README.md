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
## Report from 2020-05-18

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.200 ± 0.272 | 8.890 | 9.399 | 1.00 |
| `docker run -t yarn--pnpm` | 9.271 ± 0.151 | 9.112 | 9.413 | 1.01 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.320 ± 0.223 | 10.101 | 10.547 | 1.12 ± 0.04 |
| `docker run -t yarn--yarn` | 11.501 ± 0.118 | 11.365 | 11.579 | 1.25 ± 0.04 |
| `docker run -t npm--yarn` | 11.719 ± 0.069 | 11.641 | 11.770 | 1.27 ± 0.04 |
| `docker run -t yarn--npm` | 12.460 ± 0.212 | 12.270 | 12.689 | 1.35 ± 0.05 |
| `docker run -t npm--npm` | 12.720 ± 0.151 | 12.608 | 12.891 | 1.38 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.914 ± 0.323 | 16.647 | 17.272 | 1.84 ± 0.06 |
| `docker run -t open-registry--npm` | 17.509 ± 0.329 | 17.317 | 17.889 | 1.90 ± 0.07 |
| `docker run -t bolivar--pnpm` | 19.163 ± 1.763 | 17.904 | 21.178 | 2.08 ± 0.20 |
| `docker run -t ipfs--pnpm` | 19.771 ± 0.398 | 19.323 | 20.085 | 2.15 ± 0.08 |
| `docker run -t cnpmjs--pnpm` | 20.201 ± 0.254 | 19.966 | 20.470 | 2.20 ± 0.07 |
| `docker run -t bolivar--npm` | 36.494 ± 0.813 | 35.556 | 36.983 | 3.97 ± 0.15 |
| `docker run -t cnpmjs--yarn` | 39.980 ± 6.810 | 35.569 | 47.823 | 4.35 ± 0.75 |
| `docker run -t bolivar--yarn` | 40.681 ± 0.439 | 40.373 | 41.183 | 4.42 ± 0.14 |
| `docker run -t cnpmjs--npm` | 43.185 ± 31.737 | 22.295 | 79.705 | 4.69 ± 3.45 |
| `docker run -t ipfs--npm` | 79.304 ± 28.225 | 48.366 | 103.650 | 8.62 ± 3.08 |
| `docker run -t ipfs--yarn` | 136.093 ± 2.340 | 133.458 | 137.927 | 14.79 ± 0.51 |
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
