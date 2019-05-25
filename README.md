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
## Report from 2019-05-25

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 8.382 ± 0.477 | 8.103…8.933 |
| `docker run -t npm--pnpm` | 8.505 ± 0.360 | 8.142…8.862 |
| `docker run -t node-modules--pnpm` | 9.108 ± 0.028 | 9.091…9.140 |
| `docker run -t open-registry--pnpm` | 9.571 ± 0.292 | 9.292…9.874 |
| `docker run -t npm--yarn` | 10.762 ± 0.030 | 10.727…10.782 |
| `docker run -t yarn--yarn` | 10.998 ± 0.502 | 10.693…11.577 |
| `docker run -t npm--npm` | 11.228 ± 0.095 | 11.135…11.325 |
| `docker run -t yarn--npm` | 11.802 ± 0.196 | 11.617…12.007 |
| `docker run -t open-registry--yarn` | 15.904 ± 0.101 | 15.810…16.011 |
| `docker run -t open-registry--npm` | 16.484 ± 0.189 | 16.317…16.688 |
| `docker run -t cnpmjs--pnpm` | 18.271 ± 0.295 | 17.977…18.566 |
| `docker run -t ipfs--pnpm` | 20.804 ± 1.987 | 18.909…22.871 |
| `docker run -t node-modules--npm` | 21.238 ± 0.119 | 21.113…21.350 |
| `docker run -t node-modules--yarn` | 22.665 ± 0.695 | 21.863…23.089 |
| `docker run -t cnpmjs--npm` | 23.227 ± 3.139 | 21.385…26.851 |
| `docker run -t cnpmjs--yarn` | 35.045 ± 0.491 | 34.753…35.612 |
| `docker run -t ipfs--npm` | 50.973 ± 5.545 | 47.368…57.359 |
| `docker run -t ipfs--yarn` | 62.785 ± 5.031 | 56.976…65.733 |
| `docker run -t bolivar--pnpm` | 105.710 ± 0.900 | 104.756…106.543 |
| `docker run -t bolivar--yarn` | 186.948 ± 21.135 | 165.194…207.404 |
| `docker run -t bolivar--npm` | 220.188 ± 19.157 | 200.561…238.838 |
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
