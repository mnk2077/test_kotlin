#!/bin/bash
declare -a expectedData
expectedData[1]="the\nquick\nbrown\nfox\njumps\nover\nthe\nlazy\ndog"
expectedData[2]="brown\ndog\nfox\njumps\nlazy\nover\nquick\nthe\nthe"
expectedData[3]="brown\ndog\nfox\njumps\nlazy\nover\nquick\nthe"
expectedData[4]="brown 1\ndog 1\nfox 1\njumps 1\nlazy 1\nover 1\nquick 1\nthe 2"
expectedData[5]="the 2\nbrown 1\ndog 1\nfox 1\njumps 1\nlazy 1\nover 1\nquick 1"
expectedData[6]="the 2\nbrown 1\ndog 1\nfox 1\njumps 1\nlazy 1\nover 1\nquick 1"

DataTest="the quick brown fox jumps over the lazy dog"

for (( i=1; i <= 6; i++ ))
do
    printf "task$i test\n"
    printf "input data: %s\n" "$DataTest"
    out=$(java -jar task$i.jar $DataTest)
    printf "\noutput data:\n\n$out"
    echo -e "\n"
    echo -e "${expectedData[$i]}"
done