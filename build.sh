#! /usr/bin/env sh

# This file prepares and builds all the tests

set -ex

docker build -f Dockerfile.base -t benchmarks-base .

cd tests/

for filename in *; do
  docker build -f $filename -t $filename .
done
