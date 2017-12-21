package com.example.junjie.learning.Util;

import android.content.Context;
import android.widget.Toast;

import com.example.junjie.learning.MainAppplication;

/**
 * <p>Class: com.example.junjie.learning.Util.ToastUtils</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author lujunjie
 * @date 2017/12/20/13:23
 */


public class ToastUtils  {

    public ToastUtils(){

    }

    public static void show(String text){
        Toast.makeText(MainAppplication.getContext(),text, Toast.LENGTH_LONG);

    }

}
