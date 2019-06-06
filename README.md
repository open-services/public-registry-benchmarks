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
## Report from 2019-06-06

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t npm--pnpm` | 8.200 ± 0.154 | 8.066…8.368 |
| `docker run -t yarn--pnpm` | 8.348 ± 0.414 | 8.094…8.825 |
| `docker run -t node-modules--pnpm` | 9.145 ± 0.143 | 9.052…9.310 |
| `docker run -t open-registry--pnpm` | 9.391 ± 0.135 | 9.295…9.545 |
| `docker run -t npm--yarn` | 10.975 ± 0.142 | 10.878…11.138 |
| `docker run -t yarn--yarn` | 11.066 ± 0.061 | 11.005…11.126 |
| `docker run -t npm--npm` | 11.380 ± 0.055 | 11.317…11.417 |
| `docker run -t yarn--npm` | 11.597 ± 0.086 | 11.515…11.687 |
| `docker run -t open-registry--yarn` | 15.829 ± 0.064 | 15.782…15.901 |
| `docker run -t open-registry--npm` | 16.488 ± 0.092 | 16.397…16.580 |
| `docker run -t cnpmjs--pnpm` | 18.397 ± 0.097 | 18.288…18.474 |
| `docker run -t ipfs--pnpm` | 19.753 ± 1.834 | 18.669…21.870 |
| `docker run -t node-modules--npm` | 21.652 ± 0.176 | 21.450…21.771 |
| `docker run -t node-modules--yarn` | 24.290 ± 1.254 | 23.106…25.604 |
| `docker run -t cnpmjs--npm` | 26.216 ± 0.234 | 26.054…26.484 |
| `docker run -t cnpmjs--yarn` | 35.748 ± 0.363 | 35.451…36.152 |
| `docker run -t ipfs--npm` | 65.238 ± 19.749 | 45.789…85.274 |
| `docker run -t ipfs--yarn` | 79.092 ± 30.773 | 54.821…113.703 |
| `docker run -t bolivar--pnpm` | 100.119 ± 4.972 | 97.017…105.854 |
| `docker run -t bolivar--npm` | 173.954 ± 2.010 | 172.655…176.269 |
| `docker run -t bolivar--yarn` | 193.778 ± 12.076 | 186.552…207.719 |
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
