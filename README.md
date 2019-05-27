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
## Report from 2019-05-27

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.084 ± 0.026 | 8.062…8.112 |
| `docker run -t yarn--pnpm` | 8.372 ± 0.151 | 8.269…8.546 |
| `docker run -t node-modules--pnpm` | 9.195 ± 0.118 | 9.095…9.326 |
| `docker run -t open-registry--pnpm` | 9.371 ± 0.151 | 9.256…9.541 |
| `docker run -t yarn--yarn` | 10.714 ± 0.064 | 10.675…10.787 |
| `docker run -t npm--yarn` | 10.869 ± 0.125 | 10.727…10.961 |
| `docker run -t npm--npm` | 11.288 ± 0.174 | 11.167…11.488 |
| `docker run -t yarn--npm` | 11.854 ± 0.315 | 11.649…12.217 |
| `docker run -t open-registry--yarn` | 15.806 ± 0.022 | 15.784…15.828 |
| `docker run -t open-registry--npm` | 16.375 ± 0.080 | 16.283…16.433 |
| `docker run -t cnpmjs--pnpm` | 18.282 ± 0.208 | 18.060…18.473 |
| `docker run -t ipfs--pnpm` | 20.172 ± 0.988 | 19.436…21.295 |
| `docker run -t node-modules--npm` | 21.280 ± 0.229 | 21.121…21.543 |
| `docker run -t cnpmjs--npm` | 21.846 ± 0.643 | 21.331…22.567 |
| `docker run -t node-modules--yarn` | 22.584 ± 0.336 | 22.311…22.959 |
| `docker run -t cnpmjs--yarn` | 35.183 ± 0.509 | 34.598…35.528 |
| `docker run -t ipfs--npm` | 56.541 ± 4.970 | 50.809…59.658 |
| `docker run -t ipfs--yarn` | 66.463 ± 10.800 | 54.076…73.908 |
| `docker run -t bolivar--pnpm` | 92.905 ± 22.698 | 69.888…115.270 |
| `docker run -t bolivar--npm` | 145.165 ± 47.579 | 90.333…175.542 |
| `docker run -t bolivar--yarn` | 159.185 ± 17.868 | 140.233…175.724 |
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
