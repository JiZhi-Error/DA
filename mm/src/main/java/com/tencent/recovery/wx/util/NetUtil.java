package com.tencent.recovery.wx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    private static final String NON_NETWORK = "NOT_NETWORK";
    private static final String OTHER = "other";
    private static final String TAG = "Recovery.NetUtil";
    private static final String WIFI = "WIFI";
    private static final String _3G = "3G";
    private static final String _4G = "4G";

    public static String getCurrentNetWorkStatus(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return NON_NETWORK;
        }
        if (activeNetworkInfo.getType() == 1) {
            return WIFI;
        }
        if (activeNetworkInfo.getSubtype() >= 13) {
            return _4G;
        }
        if (activeNetworkInfo.getSubtype() < 5 || activeNetworkInfo.getSubtype() >= 13) {
            return "other";
        }
        return _3G;
    }

    public static boolean isConnected(Context context) {
        return !getCurrentNetWorkStatus(context).equals(NON_NETWORK);
    }
}
