package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class j {
    private static boolean cEy;

    public static void PP() {
        AppMethodBeat.i(145902);
        if (cEy) {
            AppMethodBeat.o(145902);
            return;
        }
        TXLiveBase.setLogLevel(1);
        TXLiveBase.setConsoleEnabled(false);
        TXLiveBase.setListener(new ITXLiveBaseListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.j.AnonymousClass1 */

            @Override // com.tencent.rtmp.ITXLiveBaseListener
            public final void OnLog(int i2, String str, String str2) {
                AppMethodBeat.i(145901);
                switch (i2) {
                    case 0:
                        Log.v(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    case 1:
                        Log.d(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    case 2:
                        Log.i(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    case 3:
                        Log.w(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    case 4:
                        Log.e(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    case 5:
                        Log.f(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                    default:
                        Log.d(str, str2);
                        AppMethodBeat.o(145901);
                        return;
                }
            }
        });
        cEy = true;
        AppMethodBeat.o(145902);
    }
}
