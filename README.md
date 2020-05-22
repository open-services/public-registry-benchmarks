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
## Report from 2020-05-22

Sorted by fastest install time. Lower is better.


| Command | Mean [s] | Min [s] | Max [s] | Relative |
|:---|---:|---:|---:|---:|
| `docker run -t npm--pnpm` | 8.681 ± 0.234 | 8.468 | 8.931 | 1.00 |
| `docker run -t yarn--pnpm` | 8.837 ± 0.087 | 8.752 | 8.927 | 1.02 ± 0.03 |
| `docker run -t open-registry--pnpm` | 10.234 ± 0.319 | 9.890 | 10.519 | 1.18 ± 0.05 |
| `docker run -t npm--yarn` | 11.159 ± 0.079 | 11.103 | 11.250 | 1.29 ± 0.04 |
| `docker run -t yarn--yarn` | 11.318 ± 0.189 | 11.114 | 11.488 | 1.30 ± 0.04 |
| `docker run -t npm--npm` | 12.271 ± 0.085 | 12.210 | 12.368 | 1.41 ± 0.04 |
| `docker run -t yarn--npm` | 12.351 ± 0.182 | 12.213 | 12.557 | 1.42 ± 0.04 |
| `docker run -t open-registry--yarn` | 16.857 ± 0.046 | 16.810 | 16.902 | 1.94 ± 0.05 |
| `docker run -t open-registry--npm` | 17.300 ± 0.528 | 16.910 | 17.901 | 1.99 ± 0.08 |
| `docker run -t bolivar--pnpm` | 18.964 ± 0.935 | 17.949 | 19.790 | 2.18 ± 0.12 |
| `docker run -t cnpmjs--pnpm` | 21.937 ± 1.900 | 20.758 | 24.129 | 2.53 ± 0.23 |
| `docker run -t ipfs--pnpm` | 22.007 ± 1.496 | 20.497 | 23.489 | 2.54 ± 0.19 |
| `docker run -t cnpmjs--npm` | 25.754 ± 3.386 | 21.858 | 27.988 | 2.97 ± 0.40 |
| `docker run -t bolivar--npm` | 36.329 ± 0.404 | 36.079 | 36.794 | 4.18 ± 0.12 |
| `docker run -t bolivar--yarn` | 42.169 ± 1.023 | 40.995 | 42.863 | 4.86 ± 0.18 |
| `docker run -t cnpmjs--yarn` | 42.266 ± 10.967 | 35.370 | 54.912 | 4.87 ± 1.27 |
| `docker run -t ipfs--npm` | 92.472 ± 51.777 | 51.056 | 150.522 | 10.65 ± 5.97 |
| `docker run -t ipfs--yarn` | 113.525 ± 1.547 | 111.803 | 114.797 | 13.08 ± 0.39 |
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
