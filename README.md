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
## Report from 2019-06-05

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t yarn--pnpm` | 8.524 ± 0.088 | 8.447…8.620 |
| `docker run -t npm--pnpm` | 8.725 ± 0.216 | 8.549…8.966 |
| `docker run -t node-modules--pnpm` | 9.668 ± 0.145 | 9.503…9.769 |
| `docker run -t open-registry--pnpm` | 9.756 ± 0.044 | 9.704…9.781 |
| `docker run -t npm--yarn` | 11.395 ± 0.146 | 11.269…11.555 |
| `docker run -t yarn--yarn` | 11.594 ± 0.077 | 11.513…11.667 |
| `docker run -t npm--npm` | 11.781 ± 0.056 | 11.727…11.838 |
| `docker run -t yarn--npm` | 12.412 ± 0.346 | 12.151…12.805 |
| `docker run -t open-registry--yarn` | 16.169 ± 0.095 | 16.094…16.275 |
| `docker run -t open-registry--npm` | 16.725 ± 0.200 | 16.532…16.931 |
| `docker run -t cnpmjs--pnpm` | 18.572 ± 0.425 | 18.151…19.002 |
| `docker run -t ipfs--pnpm` | 20.924 ± 1.921 | 19.239…23.016 |
| `docker run -t node-modules--npm` | 21.692 ± 0.388 | 21.399…22.131 |
| `docker run -t cnpmjs--npm` | 22.602 ± 0.057 | 22.557…22.666 |
| `docker run -t node-modules--yarn` | 24.041 ± 0.432 | 23.624…24.487 |
| `docker run -t cnpmjs--yarn` | 35.898 ± 0.129 | 35.761…36.018 |
| `docker run -t ipfs--npm` | 54.336 ± 8.588 | 47.941…64.098 |
| `docker run -t ipfs--yarn` | 58.991 ± 9.330 | 50.422…68.931 |
| `docker run -t bolivar--pnpm` | 97.119 ± 0.528 | 96.524…97.533 |
| `docker run -t bolivar--yarn` | 176.648 ± 19.075 | 158.629…196.627 |
| `docker run -t bolivar--npm` | 211.523 ± 15.579 | 198.816…228.905 |
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
