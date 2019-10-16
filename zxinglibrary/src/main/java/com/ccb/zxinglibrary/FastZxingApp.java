package com.ccb.zxinglibrary;

import android.app.Application;
import android.util.DisplayMetrics;

import com.ccb.zxinglibrary.utils.DisplayUtil;

public class FastZxingApp {

    public static void init(Application application) {
        DisplayMetrics dm = application.getResources().getDisplayMetrics();
        DisplayUtil.density = dm.density;
        DisplayUtil.densityDPI = dm.densityDpi;
        DisplayUtil.screenWidthPx = dm.widthPixels;
        DisplayUtil.screenhightPx = dm.heightPixels;
        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(application, dm.widthPixels);
        DisplayUtil.screenHightDip = DisplayUtil.px2dip(application, dm.heightPixels);
    }
}
