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
## Report from 2020-05-11

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.620 ± 0.128 | 8.527 | 8.766 | 1.00 |
| `docker run -t yarn--pnpm` | 8.824 ± 0.168 | 8.715 | 9.018 | 1.02 ± 0.02 |
| `docker run -t open-registry--pnpm` | 9.944 ± 0.025 | 9.923 | 9.971 | 1.15 ± 0.02 |
| `docker run -t yarn--yarn` | 11.136 ± 0.119 | 11.055 | 11.273 | 1.29 ± 0.02 |
| `docker run -t npm--yarn` | 11.485 ± 0.472 | 11.176 | 12.027 | 1.33 ± 0.06 |
| `docker run -t npm--npm` | 12.879 ± 0.689 | 12.259 | 13.621 | 1.49 ± 0.08 |
| `docker run -t yarn--npm` | 12.992 ± 0.131 | 12.915 | 13.143 | 1.51 ± 0.03 |
| `docker run -t open-registry--yarn` | 16.195 ± 0.039 | 16.156 | 16.233 | 1.88 ± 0.03 |
| `docker run -t open-registry--npm` | 16.634 ± 0.130 | 16.520 | 16.776 | 1.93 ± 0.03 |
| `docker run -t bolivar--pnpm` | 18.075 ± 0.467 | 17.549 | 18.443 | 2.10 ± 0.06 |
| `docker run -t ipfs--pnpm` | 21.784 ± 1.490 | 20.769 | 23.495 | 2.53 ± 0.18 |
| `docker run -t cnpmjs--pnpm` | 21.984 ± 0.399 | 21.539 | 22.308 | 2.55 ± 0.06 |
| `docker run -t bolivar--npm` | 37.406 ± 3.556 | 35.068 | 41.498 | 4.34 ± 0.42 |
| `docker run -t bolivar--yarn` | 42.333 ± 1.014 | 41.422 | 43.426 | 4.91 ± 0.14 |
| `docker run -t cnpmjs--yarn` | 49.416 ± 17.614 | 39.031 | 69.753 | 5.73 ± 2.05 |
| `docker run -t cnpmjs--npm` | 63.532 ± 33.206 | 25.190 | 82.837 | 7.37 ± 3.85 |
| `docker run -t ipfs--npm` | 65.699 ± 16.344 | 50.971 | 83.283 | 7.62 ± 1.90 |
| `docker run -t ipfs--yarn` | 109.578 ± 41.132 | 62.085 | 133.706 | 12.71 ± 4.78 |
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
