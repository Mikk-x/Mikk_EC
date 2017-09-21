package com.mikk.mikk.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Mikk on 2017/9/19.
 */

public class Mikk {

    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getMikkConfigs();
    }


    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

}
