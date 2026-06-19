#!/bin/bash
set -e

echo "Building android app..."
adb install -r ./app/build/outputs/apk/debug/app-debug.apk
echo "Build done!"

echo "Starting on device..."
adb shell am start -n com.morse.app/.MainActivity
echo "App started!"
