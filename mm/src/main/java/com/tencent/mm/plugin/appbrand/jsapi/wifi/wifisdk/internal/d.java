package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class d {
    public static WifiManager chC;

    public static List<WifiConfiguration> getConfiguredNetworks() {
        AppMethodBeat.i(144718);
        try {
            List<WifiConfiguration> configuredNetworks = chC.getConfiguredNetworks();
            AppMethodBeat.o(144718);
            return configuredNetworks;
        } catch (Throwable th) {
            AppMethodBeat.o(144718);
            return null;
        }
    }

    public static int addNetwork(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(144719);
        try {
            int addNetwork = chC.addNetwork(wifiConfiguration);
            AppMethodBeat.o(144719);
            return addNetwork;
        } catch (Throwable th) {
            int i2 = e.mIE;
            AppMethodBeat.o(144719);
            return i2;
        }
    }

    public static boolean removeNetwork(int i2) {
        AppMethodBeat.i(144720);
        try {
            boolean removeNetwork = chC.removeNetwork(i2);
            AppMethodBeat.o(144720);
            return removeNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(144720);
            return false;
        }
    }

    public static boolean xQ(int i2) {
        AppMethodBeat.i(144721);
        try {
            boolean enableNetwork = chC.enableNetwork(i2, true);
            AppMethodBeat.o(144721);
            return enableNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(144721);
            return false;
        }
    }

    public static boolean disableNetwork(int i2) {
        AppMethodBeat.i(144722);
        try {
            boolean disableNetwork = chC.disableNetwork(i2);
            AppMethodBeat.o(144722);
            return disableNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(144722);
            return false;
        }
    }

    public static boolean startScan() {
        AppMethodBeat.i(144723);
        try {
            boolean startScan = chC.startScan();
            AppMethodBeat.o(144723);
            return startScan;
        } catch (Throwable th) {
            AppMethodBeat.o(144723);
            return false;
        }
    }

    public static WifiInfo getConnectionInfo() {
        AppMethodBeat.i(144724);
        try {
            WifiInfo connectionInfo = chC.getConnectionInfo();
            AppMethodBeat.o(144724);
            return connectionInfo;
        } catch (Throwable th) {
            AppMethodBeat.o(144724);
            return null;
        }
    }

    public static List<ScanResult> getScanResults() {
        AppMethodBeat.i(144725);
        try {
            List<ScanResult> scanResults = chC.getScanResults();
            AppMethodBeat.o(144725);
            return scanResults;
        } catch (Throwable th) {
            AppMethodBeat.o(144725);
            return null;
        }
    }

    public static boolean saveConfiguration() {
        AppMethodBeat.i(144726);
        try {
            boolean saveConfiguration = chC.saveConfiguration();
            AppMethodBeat.o(144726);
            return saveConfiguration;
        } catch (Throwable th) {
            AppMethodBeat.o(144726);
            return false;
        }
    }

    public static boolean isWifiEnabled() {
        AppMethodBeat.i(144727);
        try {
            boolean isWifiEnabled = chC.isWifiEnabled();
            AppMethodBeat.o(144727);
            return isWifiEnabled;
        } catch (Throwable th) {
            AppMethodBeat.o(144727);
            return false;
        }
    }

    public static int xR(int i2) {
        if (i2 <= -100) {
            return 0;
        }
        if (i2 >= -55) {
            return 99;
        }
        return (int) ((((float) (i2 + 100)) * 99.0f) / 45.0f);
    }
}
