@echo off
setlocal

chcp 65001 > nul

REM ===========================================
REM JDK 설정
REM ===========================================
set "JAVA_HOME=D:\JDK\jdk_window\jdk-21.0.9_prodoceye"
set "PATH=%JAVA_HOME%\bin;%PATH%"

REM ===========================================
REM 실행 package, class 설정
REM ===========================================
set "MAIN_CLASS=MyTest"
set "PACKAGE_NAME=test"

REM ===========================================
REM 경로 설정
REM ===========================================
set "ROOT_DIR=%~dp0"
set "CLASS_DIR=%ROOT_DIR%class"

echo [INFO] Run Start

if "%PACKAGE_NAME%"=="" (
    java -cp "%CLASS_DIR%" %MAIN_CLASS%
) else (
    java -cp "%CLASS_DIR%" %PACKAGE_NAME%.%MAIN_CLASS%
)

if errorlevel 1 (
    echo [ERROR] Run Failed
    pause
    exit /b 1
)

echo.
echo [INFO] Program Finished
pause