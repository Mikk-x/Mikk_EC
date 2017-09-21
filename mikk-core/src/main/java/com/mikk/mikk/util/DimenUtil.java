package com.mikk.mikk.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.mikk.mikk.app.Mikk;

/**
 * Created by Mikk on 2017/9/20.
 */

public class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Mikk.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Mikk.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
