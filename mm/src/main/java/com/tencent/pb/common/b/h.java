package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.pb.common.c.b;
import com.tencent.pb.common.c.c;

public final class h {
    public static boolean RDd = true;
    private static long RDe = -1;
    public static a RDf = a.NOT_CONNECTED;
    private static a RDg = a.NOT_CONNECTED;

    public enum a {
        NOT_CONNECTED,
        CONNECTED,
        CONNECTING
    }

    private static NetworkInfo hja() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        try {
            connectivityManager = (ConnectivityManager) c.Hhs.getSystemService("connectivity");
        } catch (Exception e2) {
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            b.w("getSystemService(Context.CONNECTIVITY_SERVICE) null", new Object[0]);
            return null;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th) {
            b.w("getActiveNetworkInfo exception:", th);
            networkInfo = null;
        }
        return networkInfo;
    }

    public static boolean isNetworkConnected() {
        try {
            NetworkInfo hja = hja();
            if (hja == null) {
                return false;
            }
            return hja.isConnected();
        } catch (Exception e2) {
            return true;
        }
    }
}
