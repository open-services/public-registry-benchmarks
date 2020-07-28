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
## Report from 2020-07-28

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.555 ± 0.028 | 8.527 | 8.583 | 1.00 |
| `docker run -t yarn--pnpm` | 8.762 ± 0.434 | 8.477 | 9.262 | 1.02 ± 0.05 |
| `docker run -t open-registry--pnpm` | 10.000 ± 0.109 | 9.916 | 10.124 | 1.17 ± 0.01 |
| `docker run -t yarn--yarn` | 11.009 ± 0.163 | 10.893 | 11.196 | 1.29 ± 0.02 |
| `docker run -t npm--yarn` | 11.104 ± 0.230 | 10.941 | 11.367 | 1.30 ± 0.03 |
| `docker run -t npm--npm` | 12.064 ± 0.182 | 11.919 | 12.269 | 1.41 ± 0.02 |
| `docker run -t yarn--npm` | 12.186 ± 0.025 | 12.158 | 12.204 | 1.42 ± 0.01 |
| `docker run -t open-registry--yarn` | 17.410 ± 0.263 | 17.222 | 17.710 | 2.04 ± 0.03 |
| `docker run -t open-registry--npm` | 17.465 ± 0.253 | 17.314 | 17.757 | 2.04 ± 0.03 |
| `docker run -t ipfs--pnpm` | 20.016 ± 0.464 | 19.508 | 20.416 | 2.34 ± 0.05 |
| `docker run -t bolivar--pnpm` | 20.102 ± 0.123 | 20.006 | 20.240 | 2.35 ± 0.02 |
| `docker run -t cnpmjs--pnpm` | 39.691 ± 34.483 | 19.550 | 79.508 | 4.64 ± 4.03 |
| `docker run -t bolivar--npm` | 40.131 ± 1.000 | 38.976 | 40.729 | 4.69 ± 0.12 |
| `docker run -t bolivar--yarn` | 43.527 ± 0.410 | 43.257 | 43.999 | 5.09 ± 0.05 |
| `docker run -t cnpmjs--npm` | 44.949 ± 38.456 | 21.600 | 89.335 | 5.25 ± 4.50 |
| `docker run -t cnpmjs--yarn` | 45.964 ± 16.871 | 36.080 | 65.445 | 5.37 ± 1.97 |
| `docker run -t ipfs--yarn` | 92.228 ± 21.124 | 67.838 | 104.610 | 10.78 ± 2.47 |
| `docker run -t ipfs--npm` | 203.151 ± 64.048 | 129.774 | 247.838 | 23.75 ± 7.49 |
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
