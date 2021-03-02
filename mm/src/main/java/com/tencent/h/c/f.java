package com.tencent.h.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public static byte lt(Context context) {
        AppMethodBeat.i(214641);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED)) {
                AppMethodBeat.o(214641);
                return -1;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(214641);
                return 0;
            } else if (activeNetworkInfo.getType() != 0) {
                if (Build.VERSION.SDK_INT >= 13 && activeNetworkInfo.getType() == 9) {
                    AppMethodBeat.o(214641);
                    return 0;
                }
                AppMethodBeat.o(214641);
                return -1;
            } else if (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) {
                AppMethodBeat.o(214641);
                return 1;
            } else {
                AppMethodBeat.o(214641);
                return 2;
            }
        } catch (Throwable th) {
            h.e("sensor_NetworkUtil", th);
        }
    }
}
