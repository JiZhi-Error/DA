package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector$2;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static Context mContext;
    private static boolean mIf = false;
    private static WeakReference<com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a> mIg = null;
    private static c mIh = null;
    private static a mIi;
    private static BroadcastReceiver mIj = null;
    private static volatile b mIk = null;

    static /* synthetic */ d bLK() {
        AppMethodBeat.i(215172);
        d hT = hT(false);
        AppMethodBeat.o(215172);
        return hT;
    }

    public static void eb(Context context) {
        AppMethodBeat.i(144698);
        if (!mIf && context != null) {
            mContext = MMApplicationContext.getContext();
            Log.i("MicroMsg.WiFiManagerWrapper", "initSdk, register WifiScanResultBroadcastReceiver");
            if (mIj == null) {
                mIj = new a((byte) 0);
            }
            mContext.registerReceiver(mIj, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            WifiManager wifiManager = (WifiManager) mContext.getSystemService("wifi");
            if (wifiManager != null) {
                d.chC = wifiManager;
                mIf = true;
            }
        }
        AppMethodBeat.o(144698);
    }

    public static c bLG() {
        AppMethodBeat.i(144699);
        WifiInfo connectionInfo = d.getConnectionInfo();
        String str = "";
        String str2 = "";
        if (connectionInfo != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
            str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(connectionInfo.getSSID());
            str2 = Util.nullAs(connectionInfo.getBSSID(), "");
        }
        if (mIh != null && str.compareTo(mIh.mHX) == 0 && str2.compareTo(mIh.mHY) == 0) {
            c cVar = mIh;
            AppMethodBeat.o(144699);
            return cVar;
        } else if (connectionInfo != null) {
            Log.i("MicroMsg.WiFiManagerWrapper", "getCurrentWiFi, currentWiFiInfo is null, try getWifiList");
            hT(true);
            c cVar2 = mIh;
            AppMethodBeat.o(144699);
            return cVar2;
        } else {
            AppMethodBeat.o(144699);
            return null;
        }
    }

    public static d bLH() {
        AppMethodBeat.i(261602);
        d hT = hT(true);
        AppMethodBeat.o(261602);
        return hT;
    }

    private static d hT(boolean z) {
        String str;
        String str2;
        AppMethodBeat.i(215169);
        d dVar = new d();
        mIh = null;
        if (mIf && d.isWifiEnabled()) {
            if (z) {
                d.startScan();
            }
            List<ScanResult> scanResults = d.getScanResults();
            dVar.mIe = new ArrayList();
            dVar.jFn = "ok";
            if (scanResults != null) {
                Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", scanResults, Integer.valueOf(scanResults.size()));
                WifiInfo connectionInfo = d.getConnectionInfo();
                Log.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", connectionInfo);
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str = null;
                    str2 = null;
                } else {
                    str2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(connectionInfo.getSSID());
                    str = Util.nullAs(connectionInfo.getBSSID(), "");
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a2 = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.a(scanResult);
                        c cVar = new c();
                        cVar.mHX = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.abJ(scanResult.SSID);
                        cVar.mHY = Util.nullAs(scanResult.BSSID, "");
                        cVar.mHZ = d.xR(scanResult.level);
                        cVar.mIa = a2 == 2;
                        cVar.frequency = scanResult.frequency;
                        if (str2 != null && str != null && cVar.mHX.compareTo(str2) == 0 && cVar.mHY.compareTo(str) == 0) {
                            mIh = cVar;
                        }
                        if (a2 == 0 || a2 == 2) {
                            dVar.mIe.add(cVar);
                        }
                    }
                }
                Log.i("MicroMsg.WiFiManagerWrapper", "[getWifiList] mCurrentWiFi: " + mIh);
            } else {
                Log.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (mIf) {
            dVar.jFn = "wifi is disable";
        } else {
            dVar.jFn = "sdk not init";
        }
        AppMethodBeat.o(215169);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(215167);
            Log.i("MicroMsg.WiFiManagerWrapper", "onReceive");
            if (intent == null || !"android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                Log.w("MicroMsg.WiFiManagerWrapper", "onReceive, action not match");
                AppMethodBeat.o(215167);
                return;
            }
            b bVar = e.mIk;
            if (bVar == null) {
                Log.i("MicroMsg.WiFiManagerWrapper", "onReceive, getWiFiListCallback is null");
                AppMethodBeat.o(215167);
                return;
            }
            bVar.a(e.bLK());
            AppMethodBeat.o(215167);
        }
    }

    public static void bLI() {
        AppMethodBeat.i(215170);
        Log.i("MicroMsg.WiFiManagerWrapper", "releaseGetWiFiListCallback");
        mIk = null;
        AppMethodBeat.o(215170);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(215171);
        Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync");
        mIh = null;
        if (!mIf || !d.isWifiEnabled()) {
            d dVar = new d();
            if (mIf) {
                dVar.jFn = "wifi is disable";
            } else {
                dVar.jFn = "sdk not init";
            }
            bVar.a(dVar);
            AppMethodBeat.o(215171);
            return;
        }
        Log.i("MicroMsg.WiFiManagerWrapper", "getWifiListAsync, startScan");
        d.startScan();
        mIk = bVar;
        AppMethodBeat.o(215171);
    }

    public static void I(String str, String str2, String str3) {
        int i2;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2;
        boolean z;
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a aVar;
        AppMethodBeat.i(144701);
        if (!(mIg == null || (aVar = mIg.get()) == null || aVar.bLM())) {
            aVar.abI("duplicated request");
        }
        com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a(mIi, mContext);
        Log.i("MicroMsg.WiFiConnector", "ssid:" + str + " bssid:" + str2);
        aVar2.mHX = str;
        aVar2.mHY = str2;
        if (aVar2.mIl.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            if (TextUtils.isEmpty(str3)) {
                i2 = 0;
            } else {
                i2 = 2;
            }
            if (str == null || str.length() <= 0) {
                wifiConfiguration = null;
            } else {
                wifiConfiguration = new WifiConfiguration();
                wifiConfiguration.allowedAuthAlgorithms.clear();
                wifiConfiguration.allowedGroupCiphers.clear();
                wifiConfiguration.allowedKeyManagement.clear();
                wifiConfiguration.allowedPairwiseCiphers.clear();
                wifiConfiguration.allowedProtocols.clear();
                wifiConfiguration.SSID = "\"" + str + "\"";
                wifiConfiguration.hiddenSSID = true;
                switch (i2) {
                    case 2:
                        if (str3.length() != 0) {
                            if (!str3.matches("[0-9A-Fa-f]{64}")) {
                                wifiConfiguration.preSharedKey = "\"" + str3 + '\"';
                                break;
                            } else {
                                wifiConfiguration.preSharedKey = str3;
                                break;
                            }
                        }
                        break;
                    default:
                        wifiConfiguration.allowedKeyManagement.set(0);
                        break;
                }
                wifiConfiguration.status = 2;
            }
            List<WifiConfiguration> configuredNetworks = d.getConfiguredNetworks();
            if (configuredNetworks != null) {
                wifiConfiguration2 = b.a(str, i2, configuredNetworks);
            } else {
                wifiConfiguration2 = null;
            }
            Log.i("MicroMsg.WiFiConnector", "connect, config exists: %b, oldConfig exists: %b", wifiConfiguration, wifiConfiguration2);
            if (wifiConfiguration != null) {
                if (wifiConfiguration2 != null) {
                    if (b.bR(str, i2)) {
                        d.saveConfiguration();
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Log.i("MicroMsg.WiFiConnector", "connect, forgotWifi fail");
                        wifiConfiguration.networkId = b.c(wifiConfiguration);
                        if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE) {
                            Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail, use oldConfig");
                            aVar2.mIs = true;
                            wifiConfiguration = wifiConfiguration2;
                        }
                    }
                }
                if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE) {
                    wifiConfiguration.networkId = b.c(wifiConfiguration);
                }
                if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.e.mIE) {
                    Log.i("MicroMsg.WiFiConnector", "connect, addConfig fail");
                } else if (aVar2.a(wifiConfiguration)) {
                    Log.i("MicroMsg.wifi_event", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING);
                    aVar2.xN(1);
                    aVar2.mIo = wifiConfiguration;
                    if (!aVar2.mHU) {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        intentFilter.setPriority(Integer.MAX_VALUE);
                        aVar2.mHV = new WiFiConnector$2(aVar2);
                        aVar2.mIl.registerReceiver(aVar2.mHV, intentFilter);
                        aVar2.mHU = true;
                        Log.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
                    }
                    aVar2.mHandler.sendEmptyMessageDelayed(1, 13000);
                } else {
                    Log.i("MicroMsg.WiFiConnector", "connect, connectWifi fail");
                }
            }
            aVar2.q(false, "fail to connect wifi:invalid network id");
            Log.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        } else {
            Log.i("MicroMsg.WiFiConnector", "connect, use WifiConnector29Impl");
            c cVar = c.mIv;
            c.a(aVar2.mIl, str, str2, str3, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.a
                public final void bLN() {
                    AppMethodBeat.i(215173);
                    Log.i("MicroMsg.WiFiConnector", "connect, onConnectSuccess");
                    a.this.q(true, "");
                    AppMethodBeat.o(215173);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.a
                public final void bLO() {
                    AppMethodBeat.i(215174);
                    Log.i("MicroMsg.WiFiConnector", "connect, onConnectFailure");
                    a.this.q(false, "");
                    AppMethodBeat.o(215174);
                }
            });
        }
        mIg = new WeakReference<>(aVar2);
        AppMethodBeat.o(144701);
    }

    public static void a(a aVar) {
        mIi = aVar;
    }
}
