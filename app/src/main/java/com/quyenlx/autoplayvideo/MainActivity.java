package com.quyenlx.autoplayvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.quyenlx.autoplayvideo.video.VideoFragment;
import com.quyenlx.autoplayvideo.visibility.VisibilityFragment;

public class MainActivity extends AppCompatActivity {

    VideoFragment videoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoFragment = new VideoFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, videoFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        videoFragment.onBackPressed();
        super.onBackPressed();
    }
}
