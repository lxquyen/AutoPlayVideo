package com.quyenlx.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class JCVideoPlayerSimple extends JCVideoPlayerStandard {
    public ImageView audioButton;
    private boolean isMute = true;


    public JCVideoPlayerSimple(Context context) {
        super(context);
    }

    public JCVideoPlayerSimple(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.jc_layout_custom;
    }

    @Override
    public void init(Context context) {
        super.init(context);
        audioButton = findViewById(R.id.audio);
        audioButton.setOnClickListener(this);
//        JCMediaManager.instance().mediaPlayer.setVolume(0f, 0f);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        int i = v.getId();
        if (i == R.id.audio) {
            if (isMute) {
                JCMediaManager.instance().mediaPlayer.setVolume(1f, 1f);
            } else {
                JCMediaManager.instance().mediaPlayer.setVolume(0f, 0f);
            }
            isMute = !isMute;
        }
    }

    @Override
    public void setAllControlsVisible(int topCon, int bottomCon, int startBtn, int loadingPro, int thumbImg, int coverImg, int bottomPro) {
        super.setAllControlsVisible(INVISIBLE, INVISIBLE, startBtn, loadingPro, thumbImg, coverImg, INVISIBLE);
    }

    @Override
    public void updateStartImage() {
        super.updateStartImage();
        if (currentState == CURRENT_STATE_AUTO_COMPLETE) {
            startButton.setImageResource(R.drawable.jc_click_replay_selector);
            retryTextView.setVisibility(INVISIBLE);
        }
    }

}