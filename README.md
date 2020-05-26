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
## Report from 2020-05-26

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.667 ± 0.179 | 8.529 | 8.869 | 1.00 |
| `docker run -t yarn--pnpm` | 8.826 ± 0.086 | 8.759 | 8.923 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.084 ± 0.094 | 9.977 | 10.157 | 1.16 ± 0.03 |
| `docker run -t yarn--yarn` | 11.174 ± 0.057 | 11.114 | 11.227 | 1.29 ± 0.03 |
| `docker run -t npm--yarn` | 11.220 ± 0.182 | 11.031 | 11.395 | 1.29 ± 0.03 |
| `docker run -t npm--npm` | 12.287 ± 0.070 | 12.214 | 12.353 | 1.42 ± 0.03 |
| `docker run -t yarn--npm` | 12.670 ± 0.398 | 12.356 | 13.117 | 1.46 ± 0.05 |
| `docker run -t open-registry--yarn` | 16.144 ± 0.285 | 15.972 | 16.473 | 1.86 ± 0.05 |
| `docker run -t open-registry--npm` | 16.780 ± 0.067 | 16.708 | 16.840 | 1.94 ± 0.04 |
| `docker run -t bolivar--pnpm` | 19.222 ± 0.896 | 18.235 | 19.985 | 2.22 ± 0.11 |
| `docker run -t ipfs--pnpm` | 19.363 ± 0.847 | 18.775 | 20.333 | 2.23 ± 0.11 |
| `docker run -t cnpmjs--npm` | 25.179 ± 2.653 | 23.341 | 28.221 | 2.91 ± 0.31 |
| `docker run -t bolivar--npm` | 35.968 ± 0.515 | 35.378 | 36.323 | 4.15 ± 0.10 |
| `docker run -t bolivar--yarn` | 39.427 ± 0.316 | 39.064 | 39.640 | 4.55 ± 0.10 |
| `docker run -t cnpmjs--pnpm` | 41.560 ± 33.112 | 22.329 | 79.794 | 4.80 ± 3.82 |
| `docker run -t ipfs--npm` | 66.158 ± 10.317 | 58.595 | 77.911 | 7.63 ± 1.20 |
| `docker run -t cnpmjs--yarn` | 68.824 ± 30.557 | 39.031 | 100.091 | 7.94 ± 3.53 |
| `docker run -t ipfs--yarn` | 76.284 ± 26.474 | 53.675 | 105.407 | 8.80 ± 3.06 |
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
