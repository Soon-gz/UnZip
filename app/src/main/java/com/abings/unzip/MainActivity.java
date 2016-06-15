package com.abings.unzip;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String zipPath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "myfile.zip";
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "file";
        imageView = (ImageView) findViewById(R.id.imageView);
        try {
            ZipFloderUtil.upZipFile(zipPath,filePath);
            Bitmap bitmap = BitmapFactory.decodeFile(filePath+File.separator+"myskin/main.jpg");
            imageView.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
