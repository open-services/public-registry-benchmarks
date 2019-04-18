#! /usr/bin/env bash

# This file prepares and builds all the tests

set -ex

docker build -f Dockerfile.base -t benchmarks-base .

cd tests/

ARGS=""

for filename in *; do
  ARGS+="$filename "
done

parallel -j 4 -k docker build -f {} -t {} . ::: $ARGS
