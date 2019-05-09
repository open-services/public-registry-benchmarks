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

## Report from 2019-05-09

Sorted by fastest install time. Lower is better.

| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 5.086 ± 0.108 | 4.977…5.194 |
| `docker run -t yarn--pnpm` | 5.364 ± 0.438 | 5.044…5.863 |
| `docker run -t open-registry--pnpm` | 5.799 ± 0.027 | 5.783…5.830 |
| `docker run -t npm--npm` | 6.825 ± 0.135 | 6.678…6.942 |
| `docker run -t npm--yarn` | 6.994 ± 0.205 | 6.859…7.229 |
| `docker run -t yarn--yarn` | 7.134 ± 0.072 | 7.064…7.207 |
| `docker run -t yarn--npm` | 7.895 ± 0.901 | 7.111…8.880 |
| `docker run -t open-registry--yarn` | 9.726 ± 0.410 | 9.261…10.034 |
| `docker run -t node-modules--pnpm` | 11.995 ± 0.210 | 11.815…12.225 |
| `docker run -t ipfs--pnpm` | 16.792 ± 0.322 | 16.424…17.023 |
| `docker run -t open-registry--npm` | 19.621 ± 17.105 | 9.661…39.372 |
| `docker run -t node-modules--npm` | 29.778 ± 1.743 | 28.620…31.783 |
| `docker run -t node-modules--yarn` | 34.662 ± 1.319 | 33.605…36.140 |
| `docker run -t ipfs--npm` | 44.139 ± 2.959 | 40.741…46.145 |
| `docker run -t cnpmjs--yarn` | 45.248 ± 1.672 | 43.317…46.230 |
| `docker run -t ipfs--yarn` | 49.791 ± 2.725 | 47.292…52.697 |
| `docker run -t cnpmjs--npm` | 77.518 ± 83.204 | 27.280…173.560 |
| `docker run -t cnpmjs--pnpm` | 113.801 ± 75.418 | 27.236…165.316 |

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
