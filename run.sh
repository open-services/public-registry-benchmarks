#! /usr/bin/env sh

# This file executes the tests

set -ex

CMD="hyperfine --warmup 1 --min-runs 3 --export-markdown report.md"

cd tests/

for filename in *; do
  CMD+=" 'docker run -t $filename'"
done

eval $CMD
