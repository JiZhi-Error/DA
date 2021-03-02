package com.tencent.mm.plugin.flutter.e.a.a;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.util.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class e {
    public static int bAX() {
        AppMethodBeat.i(240952);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(240952);
                return 0;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                AppMethodBeat.o(240952);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(240952);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                AppMethodBeat.o(240952);
                return 2;
            } else if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                AppMethodBeat.o(240952);
                return 3;
            } else if (activeNetworkInfo.getSubtype() < 13 || activeNetworkInfo.getSubtype() >= 20) {
                if (activeNetworkInfo.getSubtype() >= 20) {
                    AppMethodBeat.o(240952);
                    return 5;
                }
                AppMethodBeat.o(240952);
                return 0;
            } else {
                AppMethodBeat.o(240952);
                return 4;
            }
        } catch (Exception e2) {
        }
    }

    public static String eK(List<String> list) {
        AppMethodBeat.i(240953);
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            StringBuilder sb2 = new StringBuilder();
            a aVar = a.GQC;
            sb.append(sb2.append(a.aUr(str)).append("#").toString());
        }
        String sb3 = sb.toString();
        AppMethodBeat.o(240953);
        return sb3;
    }
}
