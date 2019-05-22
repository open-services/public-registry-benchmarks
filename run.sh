#! /usr/bin/env bash

# This file executes the tests

set -ex

CMD="hyperfine --style basic --warmup 1 --min-runs 3 --export-markdown report.md"

cd tests/

for filename in *; do
  CMD+=" 'docker run -t $filename'"
done

cd ../

eval $CMD
