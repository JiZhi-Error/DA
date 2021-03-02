package com.tencent.liteav.trtc.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCVideoServerConfig {
    private static final String KEY_ENABLE_DEC_VUI = "enable_hw_vui";
    private static final String VIDEO_SERVER_CONFIG = "trtc_video_server_config";
    public boolean enableHWVUI = true;

    public String toString() {
        AppMethodBeat.i(222574);
        String str = "enableHWVUI: " + this.enableHWVUI;
        AppMethodBeat.o(222574);
        return str;
    }

    public static void saveToSharedPreferences(Context context, TRTCVideoServerConfig tRTCVideoServerConfig) {
        AppMethodBeat.i(222575);
        synchronized (TRTCVideoServerConfig.class) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(VIDEO_SERVER_CONFIG, 0).edit();
                edit.putBoolean(KEY_ENABLE_DEC_VUI, tRTCVideoServerConfig.enableHWVUI);
                edit.apply();
            } finally {
                AppMethodBeat.o(222575);
            }
        }
    }

    public static TRTCVideoServerConfig loadFromSharedPreferences(Context context) {
        TRTCVideoServerConfig tRTCVideoServerConfig;
        AppMethodBeat.i(222576);
        synchronized (TRTCVideoServerConfig.class) {
            try {
                tRTCVideoServerConfig = new TRTCVideoServerConfig();
                tRTCVideoServerConfig.enableHWVUI = context.getSharedPreferences(VIDEO_SERVER_CONFIG, 0).getBoolean(KEY_ENABLE_DEC_VUI, true);
            } finally {
                AppMethodBeat.o(222576);
            }
        }
        return tRTCVideoServerConfig;
    }
}
