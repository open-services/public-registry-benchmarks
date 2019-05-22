#! /usr/bin/env bash

# Does the following:
# take `report.md`
#   sort it
#   add it to `reports/$date.md`
#   replace latest report in README.md

sort -t "|" -n -k 3 report.md > report-sorted.md
mv report-sorted.md report.md

today=$(date "+%Y-%m-%d-%H:%M")
header="## Report from $today

Sorted by fastest install time. Lower is better.

"

if [ -f "reports/$today.md" ]; then
  echo "Report for $today already exists"
  exit 0
fi


echo "reports/$today.md"

mkdir reports || true
echo "$header" | cat - report.md > reports/$today.md

lead='^<!-- REPORT -->$'
tail='^<!-- REPORT_END -->$'
sed -i -e "/$lead/,/$tail/{ /$lead/{p; r reports/$today.md
        }; /$tail/p; d }" README.md

