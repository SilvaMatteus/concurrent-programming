#!/bin/bash

case $1 in
    start)
        if [ $# -ne 2 ]
          then
             echo "Usage: ./run.sh start [port]"
        fi
        java -classpath nanoHTTPd-modified/bin nanohttp.NanoHTTPd $2 &
        ;;
    stop)
        pid=$(ps aux | grep "java -classpath nanoHTTPd-modified/bin nanohttp.NanoHTTPd" | grep -v grep | awk '{print $2}')
        if [ -n "$pid" ]; then
          kill -9 $pid
        fi
        ;;
    *) echo "Option $1 not recognized." ;;
esac
