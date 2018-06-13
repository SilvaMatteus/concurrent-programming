#!/bin/bash

case $1 in
    start)
        if [ $# -ne 2 ]
          then
             echo "Usage: ./run.sh start [port]"
        fi
        java -classpath nanoHTTPd-modified/bin nanohttp.NanoHTTPd $2 &
        ;;
    *) echo "Option $1 not recognized." ;;
esac
