package com.tinkerboots.sdk.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static ConnectivityManager SKL = null;

    public static boolean isConnected(Context context) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(3459);
        if (SKL == null) {
            SKL = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (SKL == null) {
            AppMethodBeat.o(3459);
        } else {
            NetworkInfo activeNetworkInfo = SKL.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                try {
                    if (activeNetworkInfo.isConnected()) {
                        z = true;
                        z2 = z;
                        AppMethodBeat.o(3459);
                    }
                } catch (Exception e2) {
                }
            }
            z = false;
            z2 = z;
            AppMethodBeat.o(3459);
        }
        return z2;
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.i(3460);
        if (SKL == null) {
            SKL = (ConnectivityManager) context.getSystemService("connectivity");
        }
        if (SKL == null) {
            AppMethodBeat.o(3460);
            return false;
        }
        NetworkInfo activeNetworkInfo = SKL.getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            AppMethodBeat.o(3460);
            return false;
        }
        AppMethodBeat.o(3460);
        return true;
    }
}
