
echo "[" > movies.json
for p in 1 2 3 4 5 6 7 8 9 10; do
  MOVIES=$(curl -s  'http://www.omdbapi.com/?s=%22Movie%22&page=$p&apikey=812313e3')
  IDS=$(echo $MOVIES | grep -o '"imdbID":"tt......."' | cut -d '"' -f4)
  for I in $IDS; do
    echo $I
    curl -s "http://www.omdbapi.com/?i=$I&apikey=812313e3" >> movies.json
    # awk '{ gsub(/"[^\"]*\":"/,"",$1); print $1 }'
    # sed -r 's|"([^"]*)":"|"\l\1":|g' >> movies.json
    echo "," >> movies.json 
  done
done
echo "]" >> movies.json

