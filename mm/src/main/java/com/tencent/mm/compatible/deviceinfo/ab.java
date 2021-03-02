package com.tencent.mm.compatible.deviceinfo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ab {
    private static ab gKj = null;
    public static int gKk = 0;
    public static int gKl = 1;
    public static int gKm = 2;
    public static int gKn = 3;
    public static int gKo = 4;
    public static int gKp = 5;

    public static int ape() {
        AppMethodBeat.i(155821);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) MMApplicationContext.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(155821);
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(155821);
            return 1;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 7:
            case 11:
                AppMethodBeat.o(155821);
                return 2;
            case 3:
            case 4:
            case 5:
            case 6:
            case 12:
            case 17:
                AppMethodBeat.o(155821);
                return 3;
            case 8:
            case 9:
            case 10:
            case 16:
            default:
                if (subtype >= 20) {
                    int i2 = gKp;
                    AppMethodBeat.o(155821);
                    return i2;
                }
                AppMethodBeat.o(155821);
                return 0;
            case 13:
            case 14:
            case 15:
                AppMethodBeat.o(155821);
                return 4;
        }
    }
}
