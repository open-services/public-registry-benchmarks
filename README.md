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
## Report from 2019-06-01

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.000 ± 0.125 | 7.861…8.104 |
| `docker run -t yarn--pnpm` | 8.208 ± 0.055 | 8.145…8.247 |
| `docker run -t node-modules--pnpm` | 9.165 ± 0.105 | 9.089…9.285 |
| `docker run -t open-registry--pnpm` | 9.400 ± 0.119 | 9.283…9.520 |
| `docker run -t npm--yarn` | 10.712 ± 0.131 | 10.630…10.863 |
| `docker run -t npm--npm` | 10.892 ± 0.098 | 10.817…11.002 |
| `docker run -t yarn--yarn` | 10.982 ± 0.640 | 10.480…11.703 |
| `docker run -t yarn--npm` | 11.861 ± 0.424 | 11.374…12.151 |
| `docker run -t open-registry--yarn` | 15.762 ± 0.076 | 15.716…15.850 |
| `docker run -t open-registry--npm` | 16.262 ± 0.101 | 16.146…16.326 |
| `docker run -t cnpmjs--pnpm` | 18.196 ± 0.178 | 18.023…18.378 |
| `docker run -t ipfs--pnpm` | 20.992 ± 0.665 | 20.225…21.405 |
| `docker run -t node-modules--npm` | 21.822 ± 0.348 | 21.466…22.162 |
| `docker run -t node-modules--yarn` | 23.099 ± 0.356 | 22.755…23.466 |
| `docker run -t cnpmjs--npm` | 23.451 ± 3.517 | 21.063…27.489 |
| `docker run -t cnpmjs--yarn` | 35.033 ± 0.565 | 34.606…35.674 |
| `docker run -t ipfs--npm` | 71.009 ± 17.995 | 52.748…88.725 |
| `docker run -t ipfs--yarn` | 86.048 ± 37.084 | 58.613…128.238 |
| `docker run -t bolivar--pnpm` | 97.567 ± 9.918 | 89.890…108.765 |
| `docker run -t bolivar--yarn` | 146.255 ± 8.465 | 136.873…153.320 |
| `docker run -t bolivar--npm` | 169.172 ± 1.215 | 168.255…170.550 |
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
