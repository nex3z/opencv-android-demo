package com.nex3z.examples.opencvjava;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.core.Mat;

public class CameraActivity extends AppCompatActivity {
    private static final String LOG_TAG = CameraActivity.class.getSimpleName();
    private static final int RC_PERMISSION = 1;
    private static final String[] PERMISSIONS = { Manifest.permission.CAMERA };

    private JavaCameraView mJcvCameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mJcvCameraView = findViewById(R.id.jcv_camera_view);

        if (!PermissionUtil.hasPermission(this, PERMISSIONS)) {
            PermissionUtil.requestPermission(this, RC_PERMISSION, PERMISSIONS);
        } else {
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == RC_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            }
        }
    }

    private void openCamera() {
        mJcvCameraView.enableView();
        mJcvCameraView.setCvCameraViewListener(new CameraBridgeViewBase.CvCameraViewListener2() {
            @Override
            public void onCameraViewStarted(int width, int height) {
                Log.v(LOG_TAG, "onCameraViewStarted(): width = " + width + ", height = " + height);
            }

            @Override
            public void onCameraViewStopped() {
                Log.v(LOG_TAG, "onCameraViewStopped()");
            }

            @Override
            public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
                Log.v(LOG_TAG, "onCameraFrame(): inputFrame = " + inputFrame);
                return inputFrame.rgba();
            }
        });
    }
}
