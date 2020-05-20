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
## Report from 2020-05-20

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t yarn--pnpm` | 8.780 ± 0.022 | 8.765 | 8.806 | 1.00 |
| `docker run -t npm--pnpm` | 9.001 ± 0.001 | 8.999 | 9.002 | 1.03 ± 0.00 |
| `docker run -t open-registry--pnpm` | 10.510 ± 0.189 | 10.302 | 10.671 | 1.20 ± 0.02 |
| `docker run -t yarn--yarn` | 11.130 ± 0.104 | 11.066 | 11.250 | 1.27 ± 0.01 |
| `docker run -t npm--yarn` | 11.535 ± 0.168 | 11.388 | 11.719 | 1.31 ± 0.02 |
| `docker run -t npm--npm` | 12.740 ± 0.171 | 12.588 | 12.926 | 1.45 ± 0.02 |
| `docker run -t yarn--npm` | 13.727 ± 1.941 | 12.578 | 15.968 | 1.56 ± 0.22 |
| `docker run -t open-registry--yarn` | 16.925 ± 0.017 | 16.905 | 16.937 | 1.93 ± 0.01 |
| `docker run -t bolivar--pnpm` | 17.848 ± 0.273 | 17.675 | 18.163 | 2.03 ± 0.03 |
| `docker run -t open-registry--npm` | 17.873 ± 0.141 | 17.752 | 18.029 | 2.04 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 20.901 ± 0.212 | 20.684 | 21.108 | 2.38 ± 0.02 |
| `docker run -t ipfs--pnpm` | 32.359 ± 19.107 | 21.156 | 54.421 | 3.69 ± 2.18 |
| `docker run -t bolivar--npm` | 37.784 ± 1.101 | 36.844 | 38.995 | 4.30 ± 0.13 |
| `docker run -t bolivar--yarn` | 40.896 ± 0.797 | 40.347 | 41.810 | 4.66 ± 0.09 |
| `docker run -t cnpmjs--npm` | 46.112 ± 34.394 | 24.235 | 85.757 | 5.25 ± 3.92 |
| `docker run -t cnpmjs--yarn` | 46.485 ± 15.406 | 37.084 | 64.264 | 5.29 ± 1.75 |
| `docker run -t ipfs--npm` | 54.812 ± 7.293 | 49.634 | 63.153 | 6.24 ± 0.83 |
| `docker run -t ipfs--yarn` | 74.244 ± 30.069 | 56.726 | 108.964 | 8.46 ± 3.42 |
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
