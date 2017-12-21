package com.example.junjie.learning.Util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * <p>Class: com.example.junjie.learning.Util.ToolUtil</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/20/14:15
 */


public class ToolUtil {

    public static boolean isShouldHideInput(Context mContext, View v, MotionEvent ev) {
        if (v != null && (v instanceof EditText)) {
            int[] leftop = {0, 0};

            v.getLocationInWindow(leftop);
            int left = leftop[0];
            int top = leftop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();

            if(ev.getX()>left && ev.getX()<right
                    && ev.getY()>top && ev.getY()<bottom){
                return false;
            }else{
                return true;
            }

        }
        return false;
    }


}
