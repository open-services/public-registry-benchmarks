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
## Report from 2020-05-19

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.458 ± 0.029 | 8.441 | 8.491 | 1.00 |
| `docker run -t yarn--pnpm` | 8.756 ± 0.087 | 8.696 | 8.855 | 1.04 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.111 ± 0.372 | 9.895 | 10.541 | 1.20 ± 0.04 |
| `docker run -t npm--yarn` | 11.103 ± 0.104 | 11.036 | 11.223 | 1.31 ± 0.01 |
| `docker run -t yarn--yarn` | 11.416 ± 0.251 | 11.192 | 11.688 | 1.35 ± 0.03 |
| `docker run -t npm--npm` | 12.107 ± 0.054 | 12.051 | 12.158 | 1.43 ± 0.01 |
| `docker run -t yarn--npm` | 12.358 ± 0.125 | 12.273 | 12.502 | 1.46 ± 0.02 |
| `docker run -t open-registry--yarn` | 16.746 ± 0.088 | 16.650 | 16.822 | 1.98 ± 0.01 |
| `docker run -t open-registry--npm` | 17.208 ± 0.340 | 16.999 | 17.601 | 2.03 ± 0.04 |
| `docker run -t bolivar--pnpm` | 18.976 ± 0.246 | 18.740 | 19.231 | 2.24 ± 0.03 |
| `docker run -t cnpmjs--pnpm` | 20.863 ± 0.106 | 20.758 | 20.971 | 2.47 ± 0.02 |
| `docker run -t ipfs--pnpm` | 21.012 ± 1.334 | 19.887 | 22.485 | 2.48 ± 0.16 |
| `docker run -t cnpmjs--yarn` | 35.979 ± 0.439 | 35.616 | 36.467 | 4.25 ± 0.05 |
| `docker run -t bolivar--npm` | 38.433 ± 0.757 | 37.570 | 38.980 | 4.54 ± 0.09 |
| `docker run -t bolivar--yarn` | 42.152 ± 1.270 | 40.712 | 43.111 | 4.98 ± 0.15 |
| `docker run -t ipfs--npm` | 63.968 ± 18.123 | 52.639 | 84.869 | 7.56 ± 2.14 |
| `docker run -t cnpmjs--npm` | 81.265 ± 56.928 | 24.296 | 138.152 | 9.61 ± 6.73 |
| `docker run -t ipfs--yarn` | 119.570 ± 17.275 | 109.536 | 139.517 | 14.14 ± 2.04 |
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
