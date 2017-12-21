package com.example.junjie.learning;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.example.junjie.learning.Util.ToastUtils;
import com.example.junjie.learning.Util.ToolUtil;

/**
 * <p>Class: com.example.junjie.learning.BaseActivity</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/20/10:34
 */


public class BaseActivity extends AppCompatActivity {
    private boolean mAllowFullScreen = true;
    private boolean isSetStatusBar = true;
    private boolean isAllowScreenRoate = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
        initList();
        if (mAllowFullScreen) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        if (isSetStatusBar) {
            steepStatusBar();
        }
        if(!isAllowScreenRoate){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

    }

    protected void initView() {

    }

    protected void initData() {

    }

    protected void initEvent() {

    }

    protected void initList() {

    }

    protected <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    /**
     * below commented code will be used to get user id
     * @return
     */
/*    public int getUid(){
        if(UserManager().getUid()!=null){
            return 0;
        }
        return Integer.parseInt(UserManager().getUid());
    }*/

    /**
     * used to control print log or not
     *
     * @param message
     */
    public void TLog(String message) {
        if (MainAppplication.getIsDebug()) {
            Log.d(MainAppplication.APP_NAME, message);
        }
    }

    public void toast(String text) {
        ToastUtils.show(text);
    }

    public void toast(int resId) {
        ToastUtils.show(String.valueOf(resId));
    }

    /**
     * hide soft input
     */

    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (ToolUtil.isShouldHideInput(this, v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        /**
         * below code is always implement, or all components will lose touch event
         */
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     * show soft input
     */

    public void showSoftInput() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * below commented code is used to forbid fast click
     * @return
     */

    /*public boolean fastClick(){
        long lastClick = 0;
        if(System.currentTimeMillis()-lastClick<=1000){
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }*/

    /**
     * set allow full screen or not
     *
     * @param allowFullScreen
     */
    public void setAllowFullScreen(boolean allowFullScreen) {
        this.mAllowFullScreen = allowFullScreen;
    }

    private void steepStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    public void setSteepStatusBar(boolean isSetStatusBar) {
        this.isSetStatusBar = isSetStatusBar;
    }

    public void setAllowScreenRoate(boolean isAllowScreenRoate){
        this.isAllowScreenRoate = isAllowScreenRoate;
    }
}
