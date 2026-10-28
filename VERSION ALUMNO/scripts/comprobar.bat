@echo off
if not exist gradlew.bat (
 echo Falta wrapper. Ejecuta con Gradle 8.9: gradle wrapper --gradle-version 8.9
 exit /b 2
)
call gradlew.bat testDebugUnitTest assembleDebug
if errorlevel 1 exit /b 1
echo Para instrumentadas: gradlew.bat connectedDebugAndroidTest
