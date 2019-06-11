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
## Report from 2019-06-11

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.288 ± 0.044 | 8.242…8.330 |
| `docker run -t yarn--pnpm` | 8.427 ± 0.091 | 8.369…8.532 |
| `docker run -t node-modules--pnpm` | 9.371 ± 0.222 | 9.115…9.508 |
| `docker run -t open-registry--pnpm` | 9.565 ± 0.122 | 9.489…9.706 |
| `docker run -t npm--yarn` | 11.058 ± 0.219 | 10.851…11.288 |
| `docker run -t yarn--yarn` | 11.273 ± 0.175 | 11.131…11.468 |
| `docker run -t npm--npm` | 11.312 ± 0.040 | 11.281…11.357 |
| `docker run -t yarn--npm` | 12.414 ± 0.367 | 12.117…12.824 |
| `docker run -t open-registry--yarn` | 15.942 ± 0.125 | 15.800…16.035 |
| `docker run -t open-registry--npm` | 16.493 ± 0.226 | 16.284…16.734 |
| `docker run -t ipfs--pnpm` | 17.110 ± 0.176 | 16.936…17.288 |
| `docker run -t cnpmjs--pnpm` | 18.845 ± 0.577 | 18.497…19.511 |
| `docker run -t node-modules--npm` | 21.072 ± 0.240 | 20.795…21.212 |
| `docker run -t node-modules--yarn` | 22.074 ± 0.238 | 21.831…22.306 |
| `docker run -t cnpmjs--npm` | 23.695 ± 2.889 | 21.518…26.972 |
| `docker run -t cnpmjs--yarn` | 35.350 ± 0.114 | 35.220…35.431 |
| `docker run -t ipfs--npm` | 42.961 ± 1.236 | 42.057…44.369 |
| `docker run -t ipfs--yarn` | 56.595 ± 1.086 | 55.374…57.454 |
| `docker run -t bolivar--pnpm` | 101.715 ± 6.416 | 95.133…107.950 |
| `docker run -t bolivar--yarn` | 157.778 ± 29.436 | 123.791…175.158 |
| `docker run -t bolivar--npm` | 188.006 ± 22.362 | 162.240…202.354 |
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
