package com.tencent.mm.pluginsdk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

public final class z {
    private static String TAG = "MicroMsg.VideoUploadConfig";

    public static boolean bdv(String str) {
        AppMethodBeat.i(240892);
        long boW = s.boW(str);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_enable_c2c_100_video, true);
        Log.i(TAG, "C2C send big file:%s size:%s enable:%s", str, Long.valueOf(boW), Boolean.valueOf(a2));
        if (boW < 25165824 || !a2) {
            AppMethodBeat.o(240892);
            return false;
        }
        AppMethodBeat.o(240892);
        return true;
    }

    public static int gmL() {
        AppMethodBeat.i(240893);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_enable_c2c_100_video, true);
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_c2c_max_video_size, 100);
        Log.i(TAG, "getBigVideoSize  enable:%s configMB:%s", Boolean.valueOf(a2), Integer.valueOf(a3));
        if (a2) {
            int i2 = a3 * 1024 * 1024;
            AppMethodBeat.o(240893);
            return i2;
        }
        AppMethodBeat.o(240893);
        return 26214400;
    }

    public static boolean bdw(String str) {
        AppMethodBeat.i(240894);
        long boW = s.boW(str);
        boolean a2 = ((b) g.af(b.class)).a(b.a.clicfg_enable_sns_100_video, true);
        Log.i(TAG, "SNS send big file:%s size:%s enable:%s", str, Long.valueOf(boW), Boolean.valueOf(a2));
        if (boW < 25165824 || !a2) {
            AppMethodBeat.o(240894);
            return false;
        }
        AppMethodBeat.o(240894);
        return true;
    }
}
