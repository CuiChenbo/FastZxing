package com.ccb.zxinglibrary.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast toast = null;

    public static void show(Context c , String tip) {
        if (toast == null) {
            toast = Toast.makeText(c, tip, Toast.LENGTH_SHORT);
        } else {
            toast.setText(tip);
        }
        toast.show();
    }

}
