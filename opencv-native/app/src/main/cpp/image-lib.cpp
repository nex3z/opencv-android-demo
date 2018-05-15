#include <jni.h>
#include <opencv2/core.hpp>
#include <opencv2/imgproc/imgproc.hpp>


extern "C" JNIEXPORT void JNICALL
Java_com_nex3z_examples_opencvnative_ImageUtil_rgbToGray(
        JNIEnv *env, jobject, jlong addrRgb, jlong addrGray) {
    cv::Mat& matRgb = *(cv::Mat*)addrRgb;
    cv::Mat& matGray = *(cv::Mat*)addrGray;
    cv::cvtColor(matRgb, matGray, cv::COLOR_RGB2GRAY);
}
