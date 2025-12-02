#1/bin/bash

while [ true ]; do
  curl --request GET -sl -I \
  --url 'http://localhost:8080/api/hero/1'
done