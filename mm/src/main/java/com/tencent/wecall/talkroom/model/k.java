package com.tencent.wecall.talkroom.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;
import java.io.BufferedOutputStream;

public final class k {
    public static boolean HgV = false;
    static BufferedOutputStream mOutputStream = null;

    public static int lx(Context context) {
        AppMethodBeat.i(62689);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(62689);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(62689);
                return 4;
            } else if (activeNetworkInfo.getSubtype() == 3) {
                AppMethodBeat.o(62689);
                return 3;
            } else if (activeNetworkInfo.getSubtype() > 0 && activeNetworkInfo.getSubtype() < 5) {
                AppMethodBeat.o(62689);
                return 1;
            } else if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                AppMethodBeat.o(62689);
                return 3;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(62689);
                return 5;
            } else {
                AppMethodBeat.o(62689);
                return 2;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(62689);
            return 2;
        }
    }

    private static int getNetType(Context context) {
        AppMethodBeat.i(62690);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(62690);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(62690);
                return 4;
            } else if (activeNetworkInfo.getSubtype() == 3) {
                AppMethodBeat.o(62690);
                return 3;
            } else if (activeNetworkInfo.getSubtype() > 0 && activeNetworkInfo.getSubtype() < 5) {
                AppMethodBeat.o(62690);
                return 1;
            } else if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                AppMethodBeat.o(62690);
                return 3;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(62690);
                return 5;
            } else {
                AppMethodBeat.o(62690);
                return 2;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(62690);
            return 2;
        }
    }

    public static boolean hrC() {
        AppMethodBeat.i(62691);
        if (getNetType(c.Hhs) == 4) {
            AppMethodBeat.o(62691);
            return true;
        }
        AppMethodBeat.o(62691);
        return false;
    }
}
