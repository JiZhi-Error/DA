package com.tencent.smtt.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Apn {
    public static final int APN_2G = 1;
    public static final int APN_3G = 2;
    public static final int APN_4G = 4;
    public static final int APN_UNKNOWN = 0;
    public static final int APN_WIFI = 3;

    public static String getApnInfo(Context context) {
        String str;
        AppMethodBeat.i(54006);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                switch (activeNetworkInfo.getType()) {
                    case 0:
                        str = activeNetworkInfo.getExtraInfo();
                        break;
                    case 1:
                        str = "wifi";
                        break;
                }
                AppMethodBeat.o(54006);
                return str;
            }
        } catch (Exception e2) {
        }
        str = "unknown";
        AppMethodBeat.o(54006);
        return str;
    }

    public static int getApnType(Context context) {
        int i2;
        AppMethodBeat.i(54007);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            switch (activeNetworkInfo.getType()) {
                case 0:
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i2 = 1;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i2 = 2;
                            break;
                        case 13:
                            i2 = 4;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                case 1:
                    i2 = 3;
                    break;
                default:
                    i2 = 0;
                    break;
            }
        } else {
            i2 = 0;
        }
        AppMethodBeat.o(54007);
        return i2;
    }

    public static boolean isNetworkAvailable(Context context) {
        AppMethodBeat.i(54008);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(54008);
            return false;
        } else if (activeNetworkInfo.isConnected() || activeNetworkInfo.isAvailable()) {
            AppMethodBeat.o(54008);
            return true;
        } else {
            AppMethodBeat.o(54008);
            return false;
        }
    }

    public static String getWifiSSID(Context context) {
        String str;
        AppMethodBeat.i(54009);
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getBSSID();
            } else {
                str = null;
            }
            AppMethodBeat.o(54009);
            return str;
        } catch (Throwable th) {
            AppMethodBeat.o(54009);
            return "";
        }
    }
}
