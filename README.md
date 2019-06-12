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
## Report from 2019-06-12

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.522 ± 0.129 | 8.420…8.667 |
| `docker run -t yarn--pnpm` | 8.548 ± 0.084 | 8.457…8.624 |
| `docker run -t open-registry--pnpm` | 9.724 ± 0.030 | 9.706…9.758 |
| `docker run -t node-modules--pnpm` | 10.399 ± 0.283 | 10.150…10.706 |
| `docker run -t npm--yarn` | 11.366 ± 0.115 | 11.297…11.499 |
| `docker run -t yarn--yarn` | 11.509 ± 0.105 | 11.437…11.629 |
| `docker run -t npm--npm` | 11.702 ± 0.073 | 11.619…11.749 |
| `docker run -t yarn--npm` | 12.425 ± 0.238 | 12.156…12.609 |
| `docker run -t open-registry--yarn` | 16.133 ± 0.178 | 15.943…16.297 |
| `docker run -t open-registry--npm` | 17.046 ± 0.489 | 16.672…17.600 |
| `docker run -t ipfs--pnpm` | 18.240 ± 0.445 | 17.835…18.715 |
| `docker run -t cnpmjs--pnpm` | 19.656 ± 2.674 | 18.112…22.743 |
| `docker run -t node-modules--npm` | 19.993 ± 0.365 | 19.761…20.414 |
| `docker run -t node-modules--yarn` | 21.777 ± 0.442 | 21.358…22.239 |
| `docker run -t cnpmjs--npm` | 22.218 ± 0.629 | 21.722…22.925 |
| `docker run -t cnpmjs--yarn` | 35.607 ± 0.118 | 35.501…35.734 |
| `docker run -t ipfs--npm` | 54.892 ± 7.635 | 46.488…61.401 |
| `docker run -t ipfs--yarn` | 62.192 ± 10.787 | 51.438…73.012 |
| `docker run -t bolivar--pnpm` | 100.118 ± 10.965 | 87.497…107.306 |
| `docker run -t bolivar--yarn` | 176.619 ± 27.030 | 150.592…204.551 |
| `docker run -t bolivar--npm` | 212.261 ± 15.413 | 199.092…229.213 |
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
