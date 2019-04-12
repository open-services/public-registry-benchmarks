## open-registry-benchmarks

This tests the performance of open-registry

## Usage

Run `./build.sh`

Run `./run.sh`

Look at `report.md`

## Requirements

- A shell
- Docker
- Hyperfine
- Patience

## Report from 2019-04-12

| Command | Mean [s] | Min…Max [s] |
|:---|---:|---:|
| `docker run -t ipfs--npm` | 40.439 ± 0.423 | 40.080…40.905 |
| `docker run -t ipfs--yarn` | 39.454 ± 2.738 | 37.557…42.593 |
| `docker run -t node-modules--npm` | 21.297 ± 0.309 | 21.009…21.623 |
| `docker run -t node-modules--yarn` | 25.872 ± 0.164 | 25.685…25.988 |
| `docker run -t npm--npm` | 6.278 ± 0.390 | 5.994…6.723 |
| `docker run -t npm--yarn` | 6.116 ± 0.400 | 5.743…6.538 |
| `docker run -t open-registry--npm` | 8.530 ± 0.110 | 8.406…8.618 |
| `docker run -t open-registry--yarn` | 8.430 ± 0.254 | 8.137…8.585 |
| `docker run -t yarn--npm` | 7.691 ± 2.014 | 6.521…10.016 |
| `docker run -t yarn--yarn` | 6.170 ± 0.050 | 6.135…6.227 |

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

### `tests/`

The `tests/` directory contains one Dockerfile per test. The Dockerfile
sets everything up for the test. The naming convention is "$registry--$client"
so `npm--npm` would mean using the `npm` client to request from `registry.npmjs.org`,
the file `yarn--npm` would mean using the `npm` client to request from `registry.yarnpkg.com`

## License

Copyright 2019 Open-Registry

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
