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
## Report from 2019-05-28

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.377 ± 0.160 | 8.247…8.556 |
| `docker run -t yarn--pnpm` | 8.548 ± 0.057 | 8.499…8.610 |
| `docker run -t node-modules--pnpm` | 9.299 ± 0.028 | 9.269…9.324 |
| `docker run -t open-registry--pnpm` | 9.624 ± 0.215 | 9.463…9.868 |
| `docker run -t npm--yarn` | 11.099 ± 0.092 | 11.005…11.189 |
| `docker run -t yarn--yarn` | 11.235 ± 0.060 | 11.187…11.302 |
| `docker run -t npm--npm` | 11.557 ± 0.057 | 11.493…11.600 |
| `docker run -t yarn--npm` | 12.165 ± 0.235 | 11.895…12.324 |
| `docker run -t open-registry--yarn` | 16.038 ± 0.110 | 15.911…16.103 |
| `docker run -t open-registry--npm` | 16.841 ± 0.402 | 16.604…17.305 |
| `docker run -t cnpmjs--pnpm` | 18.371 ± 0.203 | 18.190…18.590 |
| `docker run -t ipfs--pnpm` | 20.204 ± 0.327 | 19.910…20.557 |
| `docker run -t cnpmjs--npm` | 21.912 ± 0.175 | 21.768…22.107 |
| `docker run -t node-modules--npm` | 22.185 ± 0.186 | 22.000…22.372 |
| `docker run -t node-modules--yarn` | 24.278 ± 0.359 | 24.038…24.691 |
| `docker run -t cnpmjs--yarn` | 35.233 ± 0.254 | 35.046…35.523 |
| `docker run -t ipfs--npm` | 53.662 ± 3.478 | 50.183…57.140 |
| `docker run -t ipfs--yarn` | 57.877 ± 2.128 | 56.620…60.334 |
| `docker run -t bolivar--pnpm` | 108.494 ± 3.517 | 104.735…111.705 |
| `docker run -t bolivar--npm` | 120.531 ± 26.782 | 98.204…150.226 |
| `docker run -t bolivar--yarn` | 155.667 ± 17.904 | 135.455…169.538 |
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
