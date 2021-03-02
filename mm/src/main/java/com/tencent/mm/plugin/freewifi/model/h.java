package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {
    boolean pfT;
    a wOU;
    BroadcastReceiver wOV;

    public interface a {
        void eM(List<ScanResult> list);
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    private h() {
        AppMethodBeat.i(24809);
        this.pfT = false;
        this.wOV = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.freewifi.model.h.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                List<ScanResult> arrayList;
                int i2 = 0;
                AppMethodBeat.i(24807);
                if (context == null || intent == null) {
                    Log.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                    AppMethodBeat.o(24807);
                    return;
                }
                h.this.pfT = false;
                context.unregisterReceiver(h.this.wOV);
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
                    if (wifiManager == null) {
                        Log.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                        AppMethodBeat.o(24807);
                        return;
                    }
                    try {
                        arrayList = wifiManager.getScanResults();
                    } catch (SecurityException e2) {
                        arrayList = new ArrayList<>(0);
                        Log.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e2.getMessage());
                    }
                    h hVar = h.this;
                    if (arrayList != null && arrayList.size() > 20) {
                        Collections.sort(arrayList, new Comparator<ScanResult>() {
                            /* class com.tencent.mm.plugin.freewifi.model.h.AnonymousClass2 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // java.util.Comparator
                            public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
                                ScanResult scanResult3 = scanResult;
                                ScanResult scanResult4 = scanResult2;
                                if (scanResult3.level < scanResult4.level) {
                                    return 1;
                                }
                                return scanResult3.level == scanResult4.level ? 0 : -1;
                            }
                        });
                        arrayList = arrayList.subList(0, 20);
                    }
                    StringBuilder sb = new StringBuilder("wifiManager scanResults size = ");
                    if (arrayList != null) {
                        i2 = arrayList.size();
                    }
                    Log.i("MicroMsg.FreeWifi.WifiScanReceiver", sb.append(i2).toString());
                    if (h.this.wOU != null) {
                        h.this.wOU.eM(arrayList);
                    }
                }
                AppMethodBeat.o(24807);
            }
        };
        AppMethodBeat.o(24809);
    }

    public static class b {
        private static h wOX = new h((byte) 0);

        static {
            AppMethodBeat.i(24808);
            AppMethodBeat.o(24808);
        }
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(24810);
        if (this.pfT) {
            AppMethodBeat.o(24810);
            return false;
        }
        this.pfT = true;
        this.wOU = aVar;
        WifiManager wifiManager = (WifiManager) MMApplicationContext.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            Log.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            AppMethodBeat.o(24810);
            return false;
        }
        MMApplicationContext.getContext().registerReceiver(this.wOV, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        AppMethodBeat.o(24810);
        return true;
    }
}
