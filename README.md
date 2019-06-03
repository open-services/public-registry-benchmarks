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
## Report from 2019-06-03

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.289 ± 0.252 | 8.124…8.579 |
| `docker run -t yarn--pnpm` | 8.378 ± 0.128 | 8.249…8.504 |
| `docker run -t node-modules--pnpm` | 9.405 ± 0.077 | 9.351…9.493 |
| `docker run -t open-registry--pnpm` | 9.459 ± 0.063 | 9.387…9.501 |
| `docker run -t npm--yarn` | 10.937 ± 0.157 | 10.830…11.118 |
| `docker run -t yarn--yarn` | 11.024 ± 0.239 | 10.813…11.284 |
| `docker run -t npm--npm` | 11.437 ± 0.187 | 11.264…11.636 |
| `docker run -t yarn--npm` | 11.838 ± 0.209 | 11.713…12.080 |
| `docker run -t open-registry--yarn` | 15.937 ± 0.030 | 15.904…15.962 |
| `docker run -t open-registry--npm` | 16.536 ± 0.028 | 16.510…16.565 |
| `docker run -t cnpmjs--pnpm` | 18.105 ± 0.190 | 17.934…18.310 |
| `docker run -t ipfs--pnpm` | 20.000 ± 1.156 | 19.131…21.312 |
| `docker run -t node-modules--npm` | 21.825 ± 0.230 | 21.659…22.087 |
| `docker run -t cnpmjs--npm` | 22.208 ± 0.341 | 21.816…22.433 |
| `docker run -t node-modules--yarn` | 22.725 ± 0.513 | 22.133…23.035 |
| `docker run -t cnpmjs--yarn` | 35.576 ± 0.139 | 35.418…35.681 |
| `docker run -t ipfs--npm` | 53.005 ± 7.665 | 48.377…61.852 |
| `docker run -t ipfs--yarn` | 64.503 ± 2.341 | 62.423…67.039 |
| `docker run -t bolivar--pnpm` | 99.778 ± 14.713 | 85.724…115.073 |
| `docker run -t bolivar--npm` | 136.623 ± 21.198 | 121.626…160.875 |
| `docker run -t bolivar--yarn` | 161.857 ± 3.662 | 158.169…165.493 |
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
