package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class b {
    public static int c(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(144714);
        if (wifiConfiguration == null || wifiConfiguration.networkId >= 0) {
            AppMethodBeat.o(144714);
            return -1;
        }
        wifiConfiguration.networkId = d.addNetwork(wifiConfiguration);
        int i2 = wifiConfiguration.networkId;
        AppMethodBeat.o(144714);
        return i2;
    }

    public static boolean bR(String str, int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(144715);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(144715);
        } else {
            List<WifiConfiguration> configuredNetworks = d.getConfiguredNetworks();
            if (configuredNetworks != null) {
                Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                while (true) {
                    z = z2;
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration next = it.next();
                    if (e.abJ(next.SSID).compareTo(str) == 0 && e.d(next) == i2) {
                        z |= d.removeNetwork(next.networkId);
                    }
                    z2 = z;
                }
                z2 = z;
            }
            if (z2) {
                d.saveConfiguration();
            }
            AppMethodBeat.o(144715);
        }
        return z2;
    }

    public static WifiConfiguration a(String str, int i2, List<WifiConfiguration> list) {
        AppMethodBeat.i(144716);
        if (list != null) {
            for (WifiConfiguration wifiConfiguration : list) {
                if (e.abJ(wifiConfiguration.SSID).compareTo(str) == 0 && e.d(wifiConfiguration) == i2) {
                    AppMethodBeat.o(144716);
                    return wifiConfiguration;
                }
            }
        }
        AppMethodBeat.o(144716);
        return null;
    }

    public static boolean xP(int i2) {
        AppMethodBeat.i(144717);
        boolean z = false;
        if (d.removeNetwork(i2) || d.disableNetwork(i2)) {
            z = true;
            d.saveConfiguration();
        }
        AppMethodBeat.o(144717);
        return z;
    }
}
