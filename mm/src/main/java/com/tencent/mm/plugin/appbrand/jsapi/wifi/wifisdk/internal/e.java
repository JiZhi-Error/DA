package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    public static int mIE = -1;

    public static String abJ(String str) {
        AppMethodBeat.i(144728);
        if (str == null) {
            AppMethodBeat.o(144728);
            return "";
        }
        int length = str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            String substring = str.substring(1, length - 1);
            AppMethodBeat.o(144728);
            return substring;
        }
        AppMethodBeat.o(144728);
        return str;
    }

    public static int d(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(144729);
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            AppMethodBeat.o(144729);
            return 2;
        } else if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            AppMethodBeat.o(144729);
            return 3;
        } else if (wifiConfiguration.wepKeys[0] != null) {
            AppMethodBeat.o(144729);
            return 1;
        } else {
            AppMethodBeat.o(144729);
            return 0;
        }
    }

    public static int a(ScanResult scanResult) {
        AppMethodBeat.i(144730);
        if (scanResult == null || scanResult.capabilities == null) {
            AppMethodBeat.o(144730);
            return -1;
        } else if (scanResult.capabilities.contains("WEP")) {
            AppMethodBeat.o(144730);
            return 1;
        } else if (scanResult.capabilities.contains("PSK")) {
            AppMethodBeat.o(144730);
            return 2;
        } else if (scanResult.capabilities.contains("EAP")) {
            AppMethodBeat.o(144730);
            return 3;
        } else {
            AppMethodBeat.o(144730);
            return 0;
        }
    }

    public static int abK(String str) {
        AppMethodBeat.i(215176);
        WifiInfo connectionInfo = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getBSSID() == null || !connectionInfo.getBSSID().equals(str)) {
            AppMethodBeat.o(215176);
            return 0;
        }
        int xR = d.xR(connectionInfo.getRssi());
        AppMethodBeat.o(215176);
        return xR;
    }
}
