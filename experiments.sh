#!/bin/bash

# Build and run nanoHTTPd
./build.sh
./run.sh start > /dev/null

# Waiting for HTTPd initialization
sleep 5

# Configure Python Virtual Environment
if [ ! -d "venv" ]; then
    virtualenv .env
fi
source .env/bin/activate

pids=()

# Start consumers
for i in `seq 1 10`; do
    python consumer.py $i &
    pids[${i}]=$!
done

# wait for all pids
for pid in ${pids[*]}; do
    wait $pid
done
