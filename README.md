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
- Clojure
- Parallel
- Patience

## Report from 2019-04-24

Sorted by fastest install time. Lower is better.

| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 4.724 ± 0.093 | 4.659…4.830 |
| `docker run -t yarn--pnpm` | 5.327 ± 0.100 | 5.238…5.435 |
| `docker run -t npm--npm` | 6.725 ± 0.133 | 6.599…6.865 |
| `docker run -t npm--yarn` | 6.749 ± 0.110 | 6.631…6.850 |
| `docker run -t yarn--npm` | 6.953 ± 0.201 | 6.722…7.085 |
| `docker run -t yarn--yarn` | 7.052 ± 0.203 | 6.868…7.270 |
| `docker run -t open-registry--pnpm` | 9.407 ± 0.011 | 9.396…9.418 |
| `docker run -t node-modules--pnpm` | 11.673 ± 0.138 | 11.522…11.794 |
| `docker run -t open-registry--npm` | 12.994 ± 0.571 | 12.525…13.630 |
| `docker run -t open-registry--yarn` | 13.113 ± 0.359 | 12.813…13.510 |
| `docker run -t ipfs--pnpm` | 18.828 ± 0.354 | 18.520…19.215 |
| `docker run -t cnpmjs--pnpm` | 25.297 ± 1.638 | 24.092…27.162 |
| `docker run -t cnpmjs--npm` | 26.599 ± 0.401 | 26.149…26.920 |
| `docker run -t node-modules--npm` | 27.722 ± 1.185 | 26.762…29.046 |
| `docker run -t node-modules--yarn` | 33.546 ± 0.335 | 33.276…33.921 |
| `docker run -t cnpmjs--yarn` | 45.627 ± 2.831 | 43.547…48.851 |
| `docker run -t ipfs--npm` | 73.845 ± 21.370 | 50.990…93.331 |
| `docker run -t ipfs--yarn` | 90.679 ± 33.722 | 55.575…122.824 |


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
