#!/bin/bash
echo "id  name birth death profession movies poster"
while read -r line; do
  NID=$(echo "$line" | cut -f1)  
  poster=$(curl -s "https://www.imdb.com/name/$NID/" | grep name-poster -A5 | grep src | cut -d '"' -f2)
  echo $line  $poster
  sleep 1
done < $1
