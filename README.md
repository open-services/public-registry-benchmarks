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
## Report from 2019-05-24

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.097 ± 0.039 | 8.073…8.141 |
| `docker run -t yarn--pnpm` | 8.114 ± 0.015 | 8.099…8.129 |
| `docker run -t node-modules--pnpm` | 9.117 ± 0.034 | 9.078…9.139 |
| `docker run -t open-registry--pnpm` | 9.380 ± 0.078 | 9.330…9.470 |
| `docker run -t npm--yarn` | 10.933 ± 0.117 | 10.800…11.022 |
| `docker run -t npm--npm` | 11.247 ± 0.254 | 11.013…11.517 |
| `docker run -t yarn--yarn` | 11.315 ± 0.348 | 10.916…11.559 |
| `docker run -t yarn--npm` | 12.127 ± 0.526 | 11.593…12.644 |
| `docker run -t open-registry--yarn` | 15.736 ± 0.123 | 15.596…15.825 |
| `docker run -t open-registry--npm` | 16.423 ± 0.309 | 16.159…16.764 |
| `docker run -t cnpmjs--pnpm` | 18.228 ± 0.207 | 18.089…18.466 |
| `docker run -t ipfs--pnpm` | 19.386 ± 0.765 | 18.656…20.182 |
| `docker run -t bolivar--pnpm` | 20.339 ± 6.244 | 16.518…27.545 |
| `docker run -t node-modules--npm` | 21.168 ± 0.387 | 20.743…21.499 |
| `docker run -t node-modules--yarn` | 22.153 ± 0.822 | 21.573…23.093 |
| `docker run -t cnpmjs--npm` | 23.908 ± 2.621 | 21.744…26.823 |
| `docker run -t cnpmjs--yarn` | 35.349 ± 0.786 | 34.788…36.247 |
| `docker run -t ipfs--npm` | 50.898 ± 9.127 | 45.557…61.436 |
| `docker run -t ipfs--yarn` | 55.496 ± 2.051 | 53.137…56.861 |
| `docker run -t bolivar--yarn` | 75.110 ± 19.590 | 57.978…96.468 |
| `docker run -t bolivar--npm` | 84.853 ± 23.998 | 61.172…109.156 |
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
