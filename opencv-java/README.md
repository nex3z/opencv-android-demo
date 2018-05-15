# opencv-java


## 1. Download OpenCV Android

Download OpenCV Android pack from [here](https://opencv.org/releases.html).


## 2. Import OpenCV as a module

Import the downloaded `OpenCV-android-sdk/sdk/java` to the project. (In Android Studio, click `File / New / Import Module...`). An `openCvLibraryXXX` (eg. `openCVLibrary341`) module will appear in the project view. Open `openCvLibraryXXX/build.gradle` and update `compileSdkVersion`, `buildToolsVersion`, `minSdkVersion`, `targetSdkVersion` to match the application's settings.

Copy the content in `OpenCV-android-sdk/sdk/native/libs` to `PROJECT_DIR/app/src/main/jniLibs`. This project only includes `armeabi` and `armeabi-v7a`.


## 3. Add dependency

Add the `openCvLibraryXXX` dependency. For example, add the following line to the `dependencies` block in `app/build.gradle`:

```gradle
implementation project(':openCVLibrary341')
```
