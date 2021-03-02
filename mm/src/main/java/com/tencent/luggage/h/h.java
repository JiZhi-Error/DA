package com.tencent.luggage.h;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public final class h {
    public static String aN(Context context) {
        WifiInfo wifiInfo;
        AppMethodBeat.i(221207);
        try {
            wifiInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        } catch (Exception e2) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            AppMethodBeat.o(221207);
            return "127.0.0.1";
        }
        int ipAddress = wifiInfo.getIpAddress();
        String format = String.format("%d.%d.%d.%d", Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255));
        AppMethodBeat.o(221207);
        return format;
    }

    public static String Ph() {
        int i2 = 0;
        AppMethodBeat.i(221208);
        try {
            i2 = ab.ape();
        } catch (Exception e2) {
            Log.e("Luggage.LuggageNetUtil", "getSelfIp, call NetworkDetailInfo.getNetType(), exp = %s", e2);
        }
        if (i2 == 0) {
            AppMethodBeat.o(221208);
            return "127.0.0.1";
        } else if (i2 == 1) {
            String aN = aN(MMApplicationContext.getContext());
            AppMethodBeat.o(221208);
            return aN;
        } else {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement != null) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (nextElement2 != null && !nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                if (Util.isNullOrNil(nextElement2.getHostAddress())) {
                                    AppMethodBeat.o(221208);
                                    return "127.0.0.1";
                                }
                                String hostAddress = nextElement2.getHostAddress();
                                AppMethodBeat.o(221208);
                                return hostAddress;
                            }
                        }
                        continue;
                    }
                }
            } catch (Exception e3) {
            }
            AppMethodBeat.o(221208);
            return "127.0.0.1";
        }
    }

    public static boolean aO(Context context) {
        boolean z;
        NetworkInfo networkInfo;
        AppMethodBeat.i(221209);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null) {
            z = false;
        } else {
            z = networkInfo.isConnected();
        }
        AppMethodBeat.o(221209);
        return z;
    }
}
