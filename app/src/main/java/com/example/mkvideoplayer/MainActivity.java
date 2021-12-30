package com.example.mkvideoplayer;
//https://github.com/khizar1556/MKVideoPlayer
//https://github.com/alhazmy13/MediaPicker
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.khizar1556.mkvideoplayer.MKPlayerActivity;

import net.alhazmy13.mediapicker.Image.ImagePicker;
import net.alhazmy13.mediapicker.Video.VideoPicker;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView img = findViewById(R.id.imageView);
        img.animate().translationXBy(1200f).setDuration(800);
        ImageView img2 = findViewById(R.id.imageView3);
        img2.animate().translationYBy(-70f).setDuration(800);
    }

    public void btnSelectionVideo(View view) {
        new VideoPicker.Builder(MainActivity.this)
                .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
                .directory(VideoPicker.Directory.DEFAULT)
                .extension(VideoPicker.Extension.MP4)
                .enableDebuggingMode(true)
                .build();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);
            //Your Code
            MKPlayerActivity.configPlayer(this).play(mPaths.get(0));
        }
    }
}