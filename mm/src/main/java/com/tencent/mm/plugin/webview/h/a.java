package com.tencent.mm.plugin.webview.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class a {
    public static final String pFm = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/__tmpl__/");

    static {
        AppMethodBeat.i(224502);
        AppMethodBeat.o(224502);
    }

    public static void pl(int i2) {
        AppMethodBeat.i(103127);
        e(908, i2, 1, true);
        AppMethodBeat.o(103127);
    }

    public static void agh(int i2) {
        AppMethodBeat.i(103128);
        e(974, i2, 1, false);
        AppMethodBeat.o(103128);
    }

    public static void kh(int i2, int i3) {
        AppMethodBeat.i(103130);
        e(908, i2, i3, true);
        AppMethodBeat.o(103130);
    }

    private static void e(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(103131);
        Log.i("ConstantsPreload", "id:%d, key:%d, valye:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i2 > 0) {
            h.INSTANCE.idkeyStat((long) i2, (long) i3, (long) i4, false);
        }
        if (!(!z || i2 == 908 || i2 == 0)) {
            h.INSTANCE.idkeyStat(908, (long) i3, (long) i4, false);
        }
        h.INSTANCE.a(15792, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(103131);
    }

    public static void agi(int i2) {
        AppMethodBeat.i(103132);
        aP(i2, 1);
        AppMethodBeat.o(103132);
    }

    public static void aP(int i2, long j2) {
        AppMethodBeat.i(103133);
        h.INSTANCE.n(1009, (long) i2, j2);
        AppMethodBeat.o(103133);
    }

    public static void gH(int i2, int i3) {
        AppMethodBeat.i(186127);
        e(i2, i3, 1, true);
        AppMethodBeat.o(186127);
    }
}
