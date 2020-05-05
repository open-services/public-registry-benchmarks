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
## Report from 2020-05-05

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 9.252 ± 0.144 | 9.145 | 9.415 | 1.00 |
| `docker run -t yarn--pnpm` | 9.328 ± 0.128 | 9.184 | 9.427 | 1.01 ± 0.02 |
| `docker run -t open-registry--pnpm` | 10.752 ± 0.172 | 10.594 | 10.936 | 1.16 ± 0.03 |
| `docker run -t npm--yarn` | 11.802 ± 0.181 | 11.599 | 11.949 | 1.28 ± 0.03 |
| `docker run -t yarn--yarn` | 11.934 ± 0.164 | 11.748 | 12.058 | 1.29 ± 0.03 |
| `docker run -t npm--npm` | 13.125 ± 0.075 | 13.039 | 13.176 | 1.42 ± 0.02 |
| `docker run -t yarn--npm` | 13.543 ± 0.115 | 13.463 | 13.675 | 1.46 ± 0.03 |
| `docker run -t open-registry--yarn` | 17.338 ± 0.299 | 17.160 | 17.683 | 1.87 ± 0.04 |
| `docker run -t open-registry--npm` | 17.971 ± 0.320 | 17.653 | 18.293 | 1.94 ± 0.05 |
| `docker run -t bolivar--pnpm` | 19.564 ± 1.486 | 17.857 | 20.575 | 2.11 ± 0.16 |
| `docker run -t ipfs--pnpm` | 20.536 ± 0.243 | 20.361 | 20.814 | 2.22 ± 0.04 |
| `docker run -t cnpmjs--npm` | 25.611 ± 1.412 | 24.007 | 26.664 | 2.77 ± 0.16 |
| `docker run -t cnpmjs--pnpm` | 39.549 ± 34.235 | 19.754 | 79.080 | 4.27 ± 3.70 |
| `docker run -t bolivar--npm` | 42.136 ± 2.720 | 39.671 | 45.054 | 4.55 ± 0.30 |
| `docker run -t bolivar--yarn` | 43.882 ± 2.899 | 41.676 | 47.166 | 4.74 ± 0.32 |
| `docker run -t cnpmjs--yarn` | 53.088 ± 16.745 | 33.754 | 62.968 | 5.74 ± 1.81 |
| `docker run -t ipfs--yarn` | 58.164 ± 1.830 | 56.962 | 60.269 | 6.29 ± 0.22 |
| `docker run -t ipfs--npm` | 58.718 ± 2.822 | 55.484 | 60.681 | 6.35 ± 0.32 |
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
