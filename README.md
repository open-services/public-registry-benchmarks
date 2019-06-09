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
## Report from 2019-06-09

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 7.973 ± 0.093 | 7.866…8.033 |
| `docker run -t npm--pnpm` | 8.333 ± 0.807 | 7.831…9.264 |
| `docker run -t node-modules--pnpm` | 9.027 ± 0.142 | 8.864…9.128 |
| `docker run -t open-registry--pnpm` | 9.376 ± 0.108 | 9.290…9.497 |
| `docker run -t npm--yarn` | 10.534 ± 0.122 | 10.419…10.662 |
| `docker run -t yarn--yarn` | 10.669 ± 0.255 | 10.484…10.959 |
| `docker run -t npm--npm` | 10.914 ± 0.110 | 10.812…11.031 |
| `docker run -t yarn--npm` | 11.398 ± 0.317 | 11.076…11.709 |
| `docker run -t open-registry--yarn` | 15.746 ± 0.173 | 15.599…15.936 |
| `docker run -t open-registry--npm` | 16.046 ± 0.097 | 15.934…16.107 |
| `docker run -t cnpmjs--pnpm` | 17.997 ± 0.302 | 17.654…18.221 |
| `docker run -t ipfs--pnpm` | 19.034 ± 0.211 | 18.806…19.224 |
| `docker run -t cnpmjs--npm` | 21.071 ± 0.204 | 20.854…21.258 |
| `docker run -t node-modules--npm` | 21.452 ± 0.427 | 20.963…21.744 |
| `docker run -t node-modules--yarn` | 22.809 ± 0.698 | 22.008…23.282 |
| `docker run -t cnpmjs--yarn` | 35.553 ± 0.511 | 35.014…36.031 |
| `docker run -t ipfs--npm` | 47.548 ± 1.218 | 46.600…48.922 |
| `docker run -t ipfs--yarn` | 55.323 ± 1.640 | 53.756…57.028 |
| `docker run -t bolivar--pnpm` | 115.993 ± 14.398 | 99.961…127.821 |
| `docker run -t bolivar--npm` | 145.122 ± 56.824 | 104.957…210.138 |
| `docker run -t bolivar--yarn` | 176.576 ± 27.467 | 153.230…206.840 |
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
