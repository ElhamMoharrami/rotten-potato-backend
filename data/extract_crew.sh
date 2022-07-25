#!/bin/bash
while read -r line; do
  NID=$(echo "$line" | cut -f1)  
  ROLE=$(echo "$line" | cut -f5)
  TIDS=$(echo "$line" | cut -f6 | tr ',' '\n')
  for ID in $TIDS; do
    echo "$NID	$ROLE	$ID"
  done
done < $1
