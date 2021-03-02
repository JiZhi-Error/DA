package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> wOF = new HashMap<Integer, String>() {
        /* class com.tencent.mm.plugin.freewifi.model.d.AnonymousClass1 */

        {
            AppMethodBeat.i(24775);
            put(-1, "CONNECT_STATE_NOT_CONNECT");
            put(0, "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(1, "CONNECT_STATE_CONNECTING");
            put(2, "CONNECT_STATE_CONNECT_SUCCESS");
            put(3, "CONNECT_STATE_CONNECT_FAILED");
            put(4, "CONNECT_STATE_WAIT_START");
            AppMethodBeat.o(24775);
        }
    };

    public static int axR(String str) {
        AppMethodBeat.i(24776);
        if (Util.isNullOrNil(str)) {
            Log.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            AppMethodBeat.o(24776);
            return 0;
        }
        c aya = j.dNn().aya(str);
        if (aya == null || !str.equalsIgnoreCase(aya.field_ssid)) {
            AppMethodBeat.o(24776);
            return 0;
        }
        if (aya.field_connectState == 2 && aya.field_expiredTime > 0 && aya.field_expiredTime - Util.nowSecond() <= 0) {
            aya.field_connectState = 1;
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", Long.valueOf(aya.field_expiredTime), Long.valueOf(Util.nowSecond()), Boolean.valueOf(j.dNn().update(aya, new String[0])));
        }
        int i2 = aya.field_connectState;
        AppMethodBeat.o(24776);
        return i2;
    }

    public static boolean axS(String str) {
        AppMethodBeat.i(24777);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", str);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            AppMethodBeat.o(24777);
            return false;
        }
        String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        if (Util.isNullOrNil(connectedWifiSsid) || !connectedWifiSsid.equals(str)) {
            AppMethodBeat.o(24777);
            return false;
        }
        AppMethodBeat.o(24777);
        return true;
    }

    public static int axT(String str) {
        AppMethodBeat.i(24778);
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            AppMethodBeat.o(24778);
            return -11;
        }
        int axV = axV(str);
        if (axV > 0) {
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", Boolean.valueOf(axU(str)));
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            axV = wifiManager.addNetwork(wifiConfiguration);
        }
        boolean enableNetwork = wifiManager.enableNetwork(axV, true);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", Integer.valueOf(axV), Boolean.valueOf(enableNetwork));
        if (enableNetwork) {
            AppMethodBeat.o(24778);
            return 0;
        }
        AppMethodBeat.o(24778);
        return -14;
    }

    public static int d(String str, String str2, int i2, boolean z) {
        int addNetwork;
        WifiConfiguration next;
        AppMethodBeat.i(24779);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", str, str2, Integer.valueOf(i2), Boolean.valueOf(z));
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            AppMethodBeat.o(24779);
            return -12;
        } else if (i2 == 0) {
            int axT = axT(str);
            AppMethodBeat.o(24779);
            return axT;
        } else if (Util.isNullOrNil(str2)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
            AppMethodBeat.o(24779);
            return -15;
        } else {
            WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                Log.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                AppMethodBeat.o(24779);
                return -11;
            }
            if (com.tencent.mm.compatible.util.d.oD(21)) {
                if (!Util.isNullOrNil(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi")).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
                        Iterator<WifiConfiguration> it = configuredNetworks.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            next = it.next();
                            if (next.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    } else {
                        Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                    }
                } else {
                    Log.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                next = null;
                if (next == null) {
                    WifiConfiguration T = T(str, str2, i2);
                    T.hiddenSSID = z;
                    addNetwork = wifiManager.addNetwork(T);
                } else {
                    if (next != null) {
                        next.SSID = "\"" + str + "\"";
                        next.status = 2;
                        switch (i2) {
                            case 1:
                                next.wepKeys = new String[]{"\"" + str2 + "\""};
                                next.allowedKeyManagement.set(0);
                                break;
                            case 2:
                            case 3:
                                next.preSharedKey = "\"" + str2 + "\"";
                                next.allowedKeyManagement.set(1);
                                break;
                            default:
                                Log.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i2));
                                break;
                        }
                    }
                    next.hiddenSSID = z;
                    addNetwork = next.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                int axV = axV(str);
                if (axV > 0) {
                    Log.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", str, Boolean.valueOf(wifiManager.removeNetwork(axV)));
                }
                WifiConfiguration T2 = T(str, str2, i2);
                T2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(T2);
                wifiManager.saveConfiguration();
            }
            boolean enableNetwork = wifiManager.enableNetwork(addNetwork, true);
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", Integer.valueOf(addNetwork), Boolean.valueOf(enableNetwork));
            if (enableNetwork) {
                AppMethodBeat.o(24779);
                return 0;
            }
            AppMethodBeat.o(24779);
            return -14;
        }
    }

    private static WifiConfiguration T(String str, String str2, int i2) {
        AppMethodBeat.i(24780);
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.status = 2;
        switch (i2) {
            case 1:
                wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 2:
            case 3:
                wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                wifiConfiguration.allowedKeyManagement.set(1);
                break;
            default:
                Log.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i2));
                break;
        }
        AppMethodBeat.o(24780);
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        AppMethodBeat.i(24781);
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(24781);
            return false;
        }
        boolean isWifiEnabled = wifiManager.isWifiEnabled();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", Boolean.valueOf(isWifiEnabled));
        AppMethodBeat.o(24781);
        return isWifiEnabled;
    }

    public static boolean dNa() {
        AppMethodBeat.i(24782);
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(24782);
            return false;
        }
        boolean wifiEnabled = wifiManager.setWifiEnabled(true);
        AppMethodBeat.o(24782);
        return wifiEnabled;
    }

    public static boolean axU(String str) {
        AppMethodBeat.i(24783);
        int axV = axV(str);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", str, Integer.valueOf(axV));
        if (axV == -1) {
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", str);
            AppMethodBeat.o(24783);
            return false;
        }
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(axV);
        wifiManager.saveConfiguration();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", str, Boolean.valueOf(removeNetwork));
        AppMethodBeat.o(24783);
        return removeNetwork;
    }

    private static int axV(String str) {
        AppMethodBeat.i(24784);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            AppMethodBeat.o(24784);
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) MMApplicationContext.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            AppMethodBeat.o(24784);
            return -1;
        }
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                int i2 = wifiConfiguration.networkId;
                AppMethodBeat.o(24784);
                return i2;
            }
        }
        AppMethodBeat.o(24784);
        return -1;
    }

    static {
        AppMethodBeat.i(24793);
        AppMethodBeat.o(24793);
    }

    public static String Ne(int i2) {
        AppMethodBeat.i(24785);
        String str = wOF.get(Integer.valueOf(i2));
        if (str == null) {
            AppMethodBeat.o(24785);
            return "";
        }
        AppMethodBeat.o(24785);
        return str;
    }

    public static void a(String str, int i2, Intent intent) {
        AppMethodBeat.i(24786);
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", m.aw(intent), Integer.valueOf(m.ax(intent)), Ne(i2), Integer.valueOf(i2));
        c aya = j.dNn().aya(str);
        if (aya != null) {
            aya.field_connectState = i2;
            Log.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", str, Integer.valueOf(i2), Boolean.valueOf(j.dNn().update(aya, new String[0])));
        }
        AppMethodBeat.o(24786);
    }

    public static WifiInfo dNd() {
        AppMethodBeat.i(24789);
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(24789);
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.o(24789);
            return connectionInfo;
        } catch (Exception e2) {
            Log.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", e2.getMessage());
            AppMethodBeat.o(24789);
            return null;
        }
    }

    public static String dNe() {
        AppMethodBeat.i(24790);
        String connectedWifiBssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
        AppMethodBeat.o(24790);
        return connectedWifiBssid;
    }

    public static String dNf() {
        AppMethodBeat.i(258842);
        String connectedWifiSsid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
        AppMethodBeat.o(258842);
        return connectedWifiSsid;
    }

    public static int getNetworkType() {
        AppMethodBeat.i(258843);
        int netType = NetStatusUtil.getNetType(MMApplicationContext.getContext());
        AppMethodBeat.o(258843);
        return netType;
    }

    public static String dNb() {
        WifiInfo dNd;
        AppMethodBeat.i(24787);
        if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) != 0 || (dNd = dNd()) == null || dNd.getBSSID() == null) {
            AppMethodBeat.o(24787);
            return null;
        }
        String bssid = dNd.getBSSID();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", bssid);
        AppMethodBeat.o(24787);
        return bssid;
    }

    public static int dNc() {
        WifiInfo dNd;
        AppMethodBeat.i(24788);
        if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) != 0 || (dNd = dNd()) == null) {
            AppMethodBeat.o(24788);
            return 0;
        }
        int rssi = dNd.getRssi();
        Log.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", Integer.valueOf(rssi));
        AppMethodBeat.o(24788);
        return rssi;
    }
}
