#!/usr/bin/env bash

if [ ! -d "$HOME/temp/docker/data/mysql/8.3.0" ]; then
  mkdir -p "$HOME/temp/docker/data/mysql/8.3.0"
fi

docker run -p "3307:3306" --name txn-mysql-db -v "$HOME/temp/docker/data/mysql/8.3.0:/var/lib/mysql" \
  -e MYSQL_DATABASE=txn-schema \
  -e MYSQL_ROOT_PASSWORD=root@981 \
  -e MYSQL_ROOT_HOST=% \
  -e MYSQL_HOST=% \
  -e MYSQL_USER=txnusr \
  -e MYSQL_PASSWORD=txnp$5wd \
  -d mysql:8.3.0

