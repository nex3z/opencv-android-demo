package com.nex3z.examples.opencvjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ImageActivity extends AppCompatActivity {

    private ImageView mIvImage;
    private Button mBtnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
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
                Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY);
                Utils.matToBitmap(grayMat, grayBitmap);
                mIvImage.setImageBitmap(grayBitmap);
            }
        });
    }
}
