package com.example.junjie.learning;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

/**
 * <p>Class: com.example.junjie.learning.SplashActivity</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/16/14:02
 */


public class SplashActivity extends AppCompatActivity {
    private Handler mHandler;
    private final int SPLASH_DELAY_LONG = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent lIntent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(lIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DELAY_LONG);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
