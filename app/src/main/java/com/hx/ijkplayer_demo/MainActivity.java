package com.hx.ijkplayer_demo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

import com.hx.ijkplayer_demo.common.PlayerManager;

public class MainActivity extends AppCompatActivity implements PlayerManager.PlayerStateListener {
    private String url1 = "http://hc.yinyuetai.com/uploads/videos/common/E49E014999C93F5A88EA01B2B48161CE.flv?sc=fc5276d37b6cd89c&br=775&vid=2178416&aid=2650&area=Other&vst=3";
    private String url2 = "http://zv.3gv.ifeng.com/live/zhongwen800k.m3u8";
    private String url3 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
    private String url4 = "http://42.96.249.166/live/24035.m3u8";
    private PlayerManager player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlayer();
    }

    private void initPlayer() {
        player = new PlayerManager(this);
        player.setFullScreenOnly(true);
        player.setScaleType(PlayerManager.SCALETYPE_FITXY);
        player.playInFullScreen(true);
        player.setPlayerStateListener(this);
        player.play(url1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (player.gestureDetector.onTouchEvent(event))
            return true;
        return super.onTouchEvent(event);
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onError() {
    }

    @Override
    public void onLoading() {
    }

    @Override
    public void onPlay() {

    }
}
