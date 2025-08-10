@ECHO OFF
set DIR=%~dp0
mvn -s "%DIR%settings.xml" %*
