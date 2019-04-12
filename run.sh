#! /usr/bin/env sh

# This file executes the tests

set -ex

hyperfine \
  --warmup 1 \
  --min-runs 3 \
  --export-markdown report.md \
  "docker run -t ipfs--npm" \
  "docker run -t ipfs--yarn" \
  "docker run -t node-modules--npm" \
  "docker run -t node-modules--yarn" \
  "docker run -t npm--npm" \
  "docker run -t npm--yarn" \
  "docker run -t open-registry--npm" \
  "docker run -t open-registry--yarn" \
  "docker run -t yarn--npm" \
  "docker run -t yarn--yarn"
