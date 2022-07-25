#!/bin/bash
echo "movie_id	crew_id"
while read -r line; do
  NID=$(echo "$line" | cut -f1)  
  ROLE=$(echo "$line" | cut -f5)
  TIDS=$(echo "$line" | cut -f6 | tr ',' '\n')
  for ID in $TIDS; do
    grep $ID $2 > /dev/null || break
    echo "$ID	$NID"
  done
done < $1
