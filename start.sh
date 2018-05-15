#!/bin/bash
echo "======================================================="
echo "inicia instalacion contenedor!"
echo "======================================================="
echo "compila aplicacion"
mvn clean package -Dmaven.test.skip=true
echo "======================================================="
echo "======================================================="
echo "compila imagen docker - terceros_avianca"
docker build -t terceros_avianca .
echo "======================================================="
echo "======================================================="
echo "corre imagen del contenedor"
docker run \
 --name terceros_avianca \
 -p 9094:7001 \
 terceros_avianca
echo "======================================================="
echo "======================================================="
echo "fin"
exit
