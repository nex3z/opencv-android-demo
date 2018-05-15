cmake_minimum_required(VERSION 3.4.1)

add_library(image-lib SHARED src/main/cpp/image-lib.cpp)

add_library(opencv-lib SHARED IMPORTED)
include_directories(SYSTEM ${PROJECT_SOURCE_DIR}/src/main/cpp/include)
set_target_properties(opencv-lib PROPERTIES
    IMPORTED_LOCATION ${PROJECT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_java3.so)

find_library(log-lib log)

target_link_libraries(image-lib opencv-lib ${log-lib})
