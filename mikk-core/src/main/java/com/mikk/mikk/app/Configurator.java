package com.mikk.mikk.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mikk on 2017/9/19.
 */

public class Configurator {
    // 键值对，不适用就回收
    private static final HashMap<String, Object> MIKK_CONFIGS = new HashMap<>();
    // 字体，图标
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        MIKK_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    // 静态内部类，单例模式
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getMikkConfigs() {
        return MIKK_CONFIGS;
    }

    public final void configure() {
        initIcons();
        MIKK_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;

    }


    public final Configurator withApiHost(String host) {

        MIKK_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;

    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) MIKK_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) MIKK_CONFIGS.get(key.name());
    }

}
