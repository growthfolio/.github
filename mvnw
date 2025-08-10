#!/usr/bin/env sh
DIR="$(cd "$(dirname "$0")"; pwd -P)"
exec mvn -s "$DIR/settings.xml" "$@"
