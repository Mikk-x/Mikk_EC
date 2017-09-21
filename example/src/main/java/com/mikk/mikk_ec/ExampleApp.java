package com.mikk.mikk_ec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.mikk.mikk.app.Mikk;
import com.mikk.mikk.ec.icon.FontEcModule;

/**
 * Created by Mikk on 2017/9/19.
 */

public class ExampleApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Mikk.init(this)
                .withApiHost("http://127.0.0.1/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .configure();

    }
}
