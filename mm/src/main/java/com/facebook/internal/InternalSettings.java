package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class InternalSettings {
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String mCustomUserAgent;

    public static void setCustomUserAgent(String str) {
        mCustomUserAgent = str;
    }

    public static String getCustomUserAgent() {
        return mCustomUserAgent;
    }

    public static boolean isUnityApp() {
        AppMethodBeat.i(17835);
        if (mCustomUserAgent == null || !mCustomUserAgent.startsWith(UNITY_PREFIX)) {
            AppMethodBeat.o(17835);
            return false;
        }
        AppMethodBeat.o(17835);
        return true;
    }
}
