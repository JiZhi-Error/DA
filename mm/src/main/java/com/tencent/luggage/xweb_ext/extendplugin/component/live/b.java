package com.tencent.luggage.xweb_ext.extendplugin.component.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;

public final class b {
    private static boolean cEy;

    public static void PP() {
        AppMethodBeat.i(138810);
        if (cEy) {
            AppMethodBeat.o(138810);
            return;
        }
        TXLiveBase.setLogLevel(1);
        TXLiveBase.setConsoleEnabled(false);
        TXLiveBase.setListener(new ITXLiveBaseListener() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.b.AnonymousClass1 */

            @Override // com.tencent.rtmp.ITXLiveBaseListener
            public final void OnLog(int i2, String str, String str2) {
                AppMethodBeat.i(138809);
                switch (i2) {
                    case 0:
                        Log.v(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    case 1:
                        Log.d(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    case 2:
                        Log.i(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    case 3:
                        Log.w(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    case 4:
                        Log.e(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    case 5:
                        Log.e(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                    default:
                        Log.d(str, str2);
                        AppMethodBeat.o(138809);
                        return;
                }
            }
        });
        cEy = true;
        AppMethodBeat.o(138810);
    }
}
