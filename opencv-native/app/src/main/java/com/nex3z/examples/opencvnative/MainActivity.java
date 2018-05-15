package com.nex3z.examples.opencvnative;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private ImageView mIvImage;
    private Button mBtnConvert;

    static {
        if(!OpenCVLoader.initDebug()) {
            Log.d(LOG_TAG, "OpenCV not loaded");
        } else {
            Log.d(LOG_TAG, "OpenCV loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIvImage = findViewById(R.id.iv_image);
        mBtnConvert = findViewById(R.id.btn_convert);
        init();
    }

    private void init() {
        mBtnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap rgbBitmap = BitmapFactory.decodeResource(getResources(),
                        R.drawable.lenna);
                Bitmap grayBitmap = Bitmap.createBitmap(rgbBitmap.getWidth(), rgbBitmap.getHeight(),
                        Bitmap.Config.RGB_565);
                Mat rgbMat = new Mat();
                Utils.bitmapToMat(rgbBitmap, rgbMat);
                Mat grayMat = new Mat();
                ImageUtil.rgbToGray(rgbMat, grayMat);
                Utils.matToBitmap(grayMat, grayBitmap);
                mIvImage.setImageBitmap(grayBitmap);
            }
        });
    }
}
