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
## Report from 2020-07-22

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.831 ± 0.125 | 8.742 | 8.975 | 1.00 |
| `docker run -t yarn--pnpm` | 8.951 ± 0.009 | 8.941 | 8.960 | 1.01 ± 0.01 |
| `docker run -t open-registry--pnpm` | 10.622 ± 0.608 | 10.168 | 11.313 | 1.20 ± 0.07 |
| `docker run -t npm--yarn` | 11.920 ± 0.341 | 11.696 | 12.312 | 1.35 ± 0.04 |
| `docker run -t yarn--yarn` | 11.951 ± 0.107 | 11.856 | 12.066 | 1.35 ± 0.02 |
| `docker run -t npm--npm` | 12.745 ± 0.162 | 12.558 | 12.850 | 1.44 ± 0.03 |
| `docker run -t yarn--npm` | 12.964 ± 0.148 | 12.849 | 13.131 | 1.47 ± 0.03 |
| `docker run -t open-registry--yarn` | 16.921 ± 0.290 | 16.685 | 17.245 | 1.92 ± 0.04 |
| `docker run -t open-registry--npm` | 17.341 ± 0.145 | 17.230 | 17.505 | 1.96 ± 0.03 |
| `docker run -t bolivar--pnpm` | 19.446 ± 0.206 | 19.209 | 19.569 | 2.20 ± 0.04 |
| `docker run -t ipfs--pnpm` | 19.794 ± 2.921 | 18.096 | 23.166 | 2.24 ± 0.33 |
| `docker run -t cnpmjs--npm` | 23.114 ± 0.489 | 22.780 | 23.675 | 2.62 ± 0.07 |
| `docker run -t cnpmjs--yarn` | 37.858 ± 0.252 | 37.650 | 38.138 | 4.29 ± 0.07 |
| `docker run -t bolivar--npm` | 38.988 ± 0.952 | 38.206 | 40.048 | 4.41 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 40.095 ± 36.093 | 18.901 | 81.770 | 4.54 ± 4.09 |
| `docker run -t bolivar--yarn` | 41.962 ± 0.290 | 41.716 | 42.282 | 4.75 ± 0.08 |
| `docker run -t ipfs--yarn` | 122.230 ± 17.956 | 110.663 | 142.916 | 13.84 ± 2.04 |
| `docker run -t ipfs--npm` | 133.995 ± 22.456 | 119.298 | 159.844 | 15.17 ± 2.55 |
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
