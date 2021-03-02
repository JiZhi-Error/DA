package com.tencent.mm.plugin.appbrand.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w {
    public static boolean Pk() {
        AppMethodBeat.i(204370);
        Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
        boolean booleanValue = ((Boolean) cls.getMethod("getBoolean", String.class, Boolean.TYPE).invoke(cls.newInstance(), "ro.config.hw_magic_window_enable", Boolean.FALSE)).booleanValue();
        AppMethodBeat.o(204370);
        return booleanValue;
    }
}
