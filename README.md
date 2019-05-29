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
## Report from 2019-05-29

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 9.052 ± 0.290 | 8.790…9.364 |
| `docker run -t yarn--pnpm` | 9.156 ± 0.242 | 8.877…9.297 |
| `docker run -t node-modules--pnpm` | 9.658 ± 0.109 | 9.577…9.782 |
| `docker run -t open-registry--pnpm` | 9.798 ± 0.034 | 9.766…9.834 |
| `docker run -t yarn--yarn` | 11.470 ± 0.116 | 11.349…11.581 |
| `docker run -t npm--yarn` | 11.589 ± 0.202 | 11.428…11.815 |
| `docker run -t npm--npm` | 11.915 ± 0.086 | 11.865…12.014 |
| `docker run -t yarn--npm` | 12.277 ± 0.180 | 12.139…12.481 |
| `docker run -t open-registry--yarn` | 16.304 ± 0.070 | 16.224…16.353 |
| `docker run -t open-registry--npm` | 16.886 ± 0.055 | 16.841…16.948 |
| `docker run -t cnpmjs--pnpm` | 18.900 ± 0.279 | 18.694…19.217 |
| `docker run -t ipfs--pnpm` | 20.856 ± 0.773 | 20.397…21.748 |
| `docker run -t node-modules--npm` | 21.320 ± 0.085 | 21.222…21.371 |
| `docker run -t node-modules--yarn` | 23.512 ± 0.099 | 23.409…23.606 |
| `docker run -t cnpmjs--npm` | 32.068 ± 0.576 | 31.658…32.726 |
| `docker run -t cnpmjs--yarn` | 36.137 ± 0.559 | 35.506…36.568 |
| `docker run -t ipfs--npm` | 73.094 ± 27.014 | 48.751…102.157 |
| `docker run -t ipfs--yarn` | 82.719 ± 25.618 | 58.800…109.751 |
| `docker run -t bolivar--pnpm` | 99.515 ± 21.457 | 77.135…119.911 |
| `docker run -t bolivar--npm` | 142.269 ± 24.861 | 113.790…159.635 |
| `docker run -t bolivar--yarn` | 171.244 ± 13.470 | 156.047…181.713 |
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
