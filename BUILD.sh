#!/bin/bash
startBuild = "kotlinc ./src/task$i.kt -include-runtime -d ./out/task$i.jar"
for ((i = 1; i <= 6; i++))
do
  $startBuild
done