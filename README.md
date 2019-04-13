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

## Report from 2019-04-13

Sorted by fastest install time. Lower is better.

| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 4.874 ± 0.087 | 4.791…4.965 |
| `docker run -t npm--pnpm` | 4.899 ± 0.070 | 4.855…4.979 |
| `docker run -t open-registry--pnpm` | 5.114 ± 0.228 | 4.890…5.346 |
| `docker run -t npm--yarn` | 5.954 ± 0.108 | 5.879…6.079 |
| `docker run -t npm--npm` | 6.331 ± 0.260 | 6.129…6.624 |
| `docker run -t yarn--yarn` | 6.369 ± 0.115 | 6.238…6.453 |
| `docker run -t yarn--npm` | 6.643 ± 0.183 | 6.454…6.820 |
| `docker run -t open-registry--npm` | 8.887 ± 0.176 | 8.705…9.057 |
| `docker run -t open-registry--yarn` | 8.617 ± 0.182 | 8.490…8.825 |
| `docker run -t node-modules--pnpm` | 9.447 ± 0.542 | 8.824…9.813 |
| `docker run -t ipfs--pnpm` | 13.213 ± 0.225 | 12.965…13.403 |
| `docker run -t node-modules--npm` | 20.699 ± 0.297 | 20.359…20.909 |
| `docker run -t cnpmjs--pnpm` | 24.116 ± 0.511 | 23.543…24.522 |
| `docker run -t node-modules--yarn` | 24.792 ± 0.259 | 24.528…25.045 |
| `docker run -t cnpmjs--npm` | 28.835 ± 3.273 | 25.577…32.122 |
| `docker run -t ipfs--npm` | 40.835 ± 11.920 | 32.554…54.497 |
| `docker run -t cnpmjs--yarn` | 43.500 ± 0.162 | 43.349…43.671 |
| `docker run -t ipfs--yarn` | 44.517 ± 3.429 | 41.839…48.382 |

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
