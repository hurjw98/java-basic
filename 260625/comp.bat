@echo off
setlocal

chcp 65001 > nul

REM ===========================================
REM JDK 설정
REM ===========================================
set "JAVA_HOME=D:\JDK\jdk_window\jdk-21.0.9_prodoceye"
set "PATH=%JAVA_HOME%\bin;%PATH%"

REM ===========================================
REM 프로젝트 설정
REM ===========================================
set "MAIN_CLASS=MyTest"
set "PACKAGE_NAME=test"

REM ===========================================
REM 경로 설정
REM ===========================================
set "ROOT_DIR=%~dp0"
set "SRC_DIR=%ROOT_DIR%java"
set "CLASS_DIR=%ROOT_DIR%class"

echo [INFO] Compile Start

REM class 폴더 생성
if not exist "%CLASS_DIR%" (
    mkdir "%CLASS_DIR%"
)

REM 이전 컴파일 결과 삭제
if exist "%CLASS_DIR%" (
    rmdir /s /q "%CLASS_DIR%"
)

mkdir "%CLASS_DIR%"

REM 메인 Java 파일 경로
if "%PACKAGE_NAME%"=="" (
    set "JAVA_FILE=%SRC_DIR%\%MAIN_CLASS%.java"
) else (
    set "JAVA_FILE=%SRC_DIR%\%PACKAGE_NAME%\%MAIN_CLASS%.java"
)

REM 컴파일
javac ^
    -encoding UTF-8 ^
    -sourcepath "%SRC_DIR%" ^
    -d "%CLASS_DIR%" ^
    "%JAVA_FILE%"

if errorlevel 1 (
    echo [ERROR] Compile Failed
    pause
    exit /b 1
)

echo [INFO] Compile Success
pause