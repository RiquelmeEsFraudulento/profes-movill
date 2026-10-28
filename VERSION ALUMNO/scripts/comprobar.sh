#!/usr/bin/env sh
set -eu
if [ ! -f gradlew ]; then echo "Falta wrapper: ejecuta con Gradle 8.9: gradle wrapper --gradle-version 8.9"; exit 2; fi
sh ./gradlew testDebugUnitTest assembleDebug
printf '
Para pruebas instrumentadas, conecta emulador/móvil y ejecuta: sh ./gradlew connectedDebugAndroidTest
'
