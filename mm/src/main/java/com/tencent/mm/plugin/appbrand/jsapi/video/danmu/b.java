package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;

public final class b {
    public static int mAn = 18;
    public static int mAo = 10;
    private static int mAp = 3;

    public static float dW(Context context) {
        AppMethodBeat.i(137855);
        float fromDPToPix = ((float) a.fromDPToPix(context, mAn)) * 2.0f;
        AppMethodBeat.o(137855);
        return fromDPToPix;
    }

    public static int N(Context context, int i2) {
        AppMethodBeat.i(263552);
        int fromDPToPix = a.fromDPToPix(context, i2);
        AppMethodBeat.o(263552);
        return fromDPToPix;
    }

    public static int bKl() {
        return mAp;
    }
}
