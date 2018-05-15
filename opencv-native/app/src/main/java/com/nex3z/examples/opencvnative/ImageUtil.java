package com.nex3z.examples.opencvnative;

import org.opencv.core.Mat;

public class ImageUtil {

    static {
        System.loadLibrary("image-lib");
        // System.loadLibrary("opencv_java3");
    }

    private ImageUtil() {}

    public static void rgbToGray(Mat rgb, Mat gray) {
        rgbToGray(rgb.nativeObj, gray.nativeObj);
    }

    public static native void rgbToGray(long matAddrRgb, long matAddrGray);

}
