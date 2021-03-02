package com.tencent.mm.network;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.a.b;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public final class ag {
    public b jFR = null;
    public boolean jFS = false;

    public static boolean dl(Context context) {
        AppMethodBeat.i(132931);
        if (context == null || NetStatusUtil.isWap(context)) {
            AppMethodBeat.o(132931);
            return false;
        }
        AppMethodBeat.o(132931);
        return true;
    }

    public static boolean dm(Context context) {
        AppMethodBeat.i(132932);
        if (context == null || !NetStatusUtil.isWifi(context)) {
            AppMethodBeat.o(132932);
            return false;
        }
        AppMethodBeat.o(132932);
        return true;
    }
}
