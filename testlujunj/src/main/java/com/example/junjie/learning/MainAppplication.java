package com.example.junjie.learning;

import android.app.Application;
import android.content.Context;

/**
 * <p>Class: com.example.junjie.learning.MainAppplication</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/20/13:07
 */


public class MainAppplication extends Application {
    public static Context sContext;
    public static String APP_NAME = "EasyLearning";
    public static boolean isDebug = true;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this.getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getAppName(){
        return  APP_NAME;
    }

    public static boolean getIsDebug(){
        return isDebug;
    }
}
