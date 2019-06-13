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
## Report from 2019-06-13

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 7.799 ± 0.038 | 7.775…7.843 |
| `docker run -t npm--pnpm` | 7.928 ± 0.310 | 7.580…8.173 |
| `docker run -t open-registry--pnpm` | 9.000 ± 0.031 | 8.970…9.032 |
| `docker run -t node-modules--pnpm` | 9.051 ± 0.069 | 8.973…9.100 |
| `docker run -t npm--npm` | 10.579 ± 0.182 | 10.441…10.786 |
| `docker run -t yarn--yarn` | 10.767 ± 0.650 | 10.342…11.516 |
| `docker run -t npm--yarn` | 10.955 ± 0.119 | 10.838…11.076 |
| `docker run -t yarn--npm` | 11.252 ± 0.130 | 11.106…11.353 |
| `docker run -t open-registry--yarn` | 15.467 ± 0.148 | 15.377…15.638 |
| `docker run -t open-registry--npm` | 16.124 ± 0.307 | 15.778…16.362 |
| `docker run -t ipfs--pnpm` | 17.755 ± 0.368 | 17.348…18.063 |
| `docker run -t cnpmjs--pnpm` | 18.499 ± 0.393 | 18.260…18.953 |
| `docker run -t node-modules--npm` | 19.884 ± 0.283 | 19.635…20.191 |
| `docker run -t node-modules--yarn` | 20.610 ± 0.546 | 20.177…21.223 |
| `docker run -t cnpmjs--npm` | 33.057 ± 2.842 | 31.308…36.336 |
| `docker run -t cnpmjs--yarn` | 35.006 ± 0.235 | 34.735…35.157 |
| `docker run -t ipfs--npm` | 46.061 ± 4.389 | 42.963…51.084 |
| `docker run -t ipfs--yarn` | 62.402 ± 18.439 | 51.282…83.686 |
| `docker run -t bolivar--pnpm` | 104.574 ± 7.027 | 99.854…112.650 |
| `docker run -t bolivar--npm` | 160.672 ± 55.292 | 99.032…205.901 |
| `docker run -t bolivar--yarn` | 165.673 ± 11.797 | 153.080…176.468 |
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
