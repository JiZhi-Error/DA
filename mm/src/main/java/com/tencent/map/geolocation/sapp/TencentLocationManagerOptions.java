package com.tencent.map.geolocation.sapp;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TencentLocationManagerOptions {
    public static String mKey = "";
    public static boolean sLoadLibrary = true;

    public static String getKey() {
        return mKey;
    }

    public static boolean isLoadLibraryEnabled() {
        return sLoadLibrary;
    }

    public static boolean setKey(String str) {
        AppMethodBeat.i(223083);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(223083);
            return false;
        }
        mKey = str;
        AppMethodBeat.o(223083);
        return true;
    }

    public static void setLoadLibraryEnabled(boolean z) {
        sLoadLibrary = z;
    }
}
