package com.tencent.mm.protocal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class a {
    public static int gtq() {
        if (CrashReportFactory.foreground) {
            return 1;
        }
        return 2;
    }

    public static int getNetType(Context context) {
        int i2;
        AppMethodBeat.i(133037);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(133037);
                return 0;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (activeNetworkInfo.getType() == 1) {
                i2 = 1;
            } else if (subtype == 13 || subtype == 15 || subtype == 14) {
                i2 = 4;
            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                i2 = 3;
            } else if (subtype == 1 || subtype == 2) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            AppMethodBeat.o(133037);
            return i2;
        } catch (Exception e2) {
            Log.e("MicroMsg.BgFgBase", "getNetType: %s", Util.stackTraceToString(e2));
            i2 = 1;
        }
    }
}
