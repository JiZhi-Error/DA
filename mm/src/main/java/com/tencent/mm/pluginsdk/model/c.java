package com.tencent.mm.pluginsdk.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    private static int JUK = 0;
    private static int JUL = 1;
    private static String TAG = "MicroMsg.C2CTransferConfig";

    public static boolean kz(int i2, int i3) {
        boolean z;
        AppMethodBeat.i(240890);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_c2c_video_compress_type, JUK);
        String lowerCase = Build.MODEL.toLowerCase();
        String str = TAG;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(a2);
        objArr[1] = lowerCase;
        objArr[2] = a2 == JUL ? "mediaCodec" : "x264";
        Log.i(str, "transferType:%s model:%s select %s mode", objArr);
        if (a2 == JUL) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(240890);
            return true;
        }
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_mediacodec_side_limit, 3000);
        Log.i(TAG, "rawWidth %d rawHeight:%d limit:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a3));
        if (Math.max(i3, i2) >= a3) {
            AppMethodBeat.o(240890);
            return true;
        }
        AppMethodBeat.o(240890);
        return false;
    }
}
