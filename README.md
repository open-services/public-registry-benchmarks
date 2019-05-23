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
## Report from 2019-05-23

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.160 ± 0.047 | 8.123…8.214 |
| `docker run -t yarn--pnpm` | 8.244 ± 0.141 | 8.153…8.406 |
| `docker run -t node-modules--pnpm` | 9.666 ± 0.464 | 9.371…10.200 |
| `docker run -t open-registry--pnpm` | 9.671 ± 0.103 | 9.593…9.787 |
| `docker run -t yarn--yarn` | 10.857 ± 0.180 | 10.737…11.064 |
| `docker run -t npm--yarn` | 10.967 ± 0.053 | 10.905…11.001 |
| `docker run -t npm--npm` | 11.532 ± 0.270 | 11.354…11.842 |
| `docker run -t yarn--npm` | 11.900 ± 0.217 | 11.678…12.111 |
| `docker run -t open-registry--yarn` | 16.696 ± 0.319 | 16.401…17.034 |
| `docker run -t open-registry--npm` | 16.723 ± 0.133 | 16.616…16.872 |
| `docker run -t cnpmjs--pnpm` | 18.528 ± 0.318 | 18.170…18.779 |
| `docker run -t ipfs--pnpm` | 20.019 ± 0.757 | 19.155…20.571 |
| `docker run -t node-modules--npm` | 21.195 ± 0.309 | 20.927…21.533 |
| `docker run -t node-modules--yarn` | 23.435 ± 0.210 | 23.200…23.604 |
| `docker run -t cnpmjs--npm` | 31.423 ± 0.180 | 31.221…31.564 |
| `docker run -t cnpmjs--yarn` | 34.980 ± 0.465 | 34.704…35.517 |
| `docker run -t ipfs--yarn` | 53.683 ± 1.828 | 51.599…55.012 |
| `docker run -t ipfs--npm` | 55.790 ± 9.185 | 47.622…65.733 |
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
