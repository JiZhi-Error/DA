package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    final String cDW = ("MicroMsg.Ble.BleScanWorker#" + hashCode());
    private final Context context;
    final AtomicBoolean dxh = new AtomicBoolean(false);
    private BroadcastReceiver lKJ;
    private e lNP;
    public final AtomicBoolean lNQ = new AtomicBoolean(false);
    List<d> lNR;
    final Runnable lNS = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.AnonymousClass1 */

        public final void run() {
            ArrayList arrayList;
            AppMethodBeat.i(144597);
            if (!a.this.lNQ.get()) {
                AppMethodBeat.o(144597);
                return;
            }
            synchronized (a.this) {
                try {
                    arrayList = new ArrayList(a.this.lNR);
                    a.this.lNR.clear();
                } catch (Throwable th) {
                    AppMethodBeat.o(144597);
                    throw th;
                }
            }
            i iVar = a.this.lNT;
            if (iVar != null && arrayList.size() > 0) {
                iVar.bA(arrayList);
            }
            a.this.mHandler.postDelayed(a.this.lNS, (long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn);
            AppMethodBeat.o(144597);
        }
    };
    volatile i lNT;
    Map<String, d> ljN;
    final Handler mHandler = new Handler();

    public a(Context context2) {
        AppMethodBeat.i(144601);
        this.context = context2;
        AppMethodBeat.o(144601);
    }

    private static ScanSettingsCompat ZF(String str) {
        AppMethodBeat.i(175632);
        while (true) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1078030475:
                    if (str.equals(FirebaseAnalytics.b.MEDIUM)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 107348:
                    if (str.equals("low")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3202466:
                    if (str.equals("high")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ScanSettingsCompat bFy = new ScanSettingsCompat.a().wT(0).bFy();
                    AppMethodBeat.o(175632);
                    return bFy;
                case 1:
                    ScanSettingsCompat bFy2 = new ScanSettingsCompat.a().wT(1).bFy();
                    AppMethodBeat.o(175632);
                    return bFy2;
                case 2:
                    ScanSettingsCompat bFy3 = new ScanSettingsCompat.a().wT(2).bFy();
                    AppMethodBeat.o(175632);
                    return bFy3;
                default:
                    str = FirebaseAnalytics.b.MEDIUM;
            }
        }
    }

    public final synchronized void init() {
        AppMethodBeat.i(215157);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new Object[0]);
        this.dxh.set(true);
        this.ljN = new HashMap();
        this.lNR = new ArrayList();
        this.lNP = new e() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.AnonymousClass2 */

            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0092, code lost:
                if (r0 == false) goto L_0x00c7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x009a, code lost:
                if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn <= 0) goto L_0x00be;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x009c, code lost:
                r2 = r9.lNU;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
                monitor-enter(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a3, code lost:
                if (r9.lNU.lNR == null) goto L_0x00ac;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a5, code lost:
                r9.lNU.lNR.add(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
                monitor-exit(r2);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b8, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(144598);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bd, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x00be, code lost:
                r0 = r9.lNU.lNT;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
                if (r0 == null) goto L_0x00c7;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
                r0.a(r1);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
                com.tencent.matrix.trace.core.AppMethodBeat.o(144598);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                return;
             */
            @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.e
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(int r10, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat r11) {
                /*
                // Method dump skipped, instructions count: 204
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.AnonymousClass2.a(int, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat):void");
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.e
            public final void onScanFailed(int i2) {
                AppMethodBeat.i(144599);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(a.this.cDW, "[onScanResult]onScanFailed, errorCode:%d", Integer.valueOf(i2));
                AppMethodBeat.o(144599);
            }
        };
        bFu();
        AppMethodBeat.o(215157);
    }

    private synchronized void bFu() {
        AppMethodBeat.i(215158);
        if (this.context == null) {
            Log.w(this.cDW, "initBroadcaseListener, context is null");
            AppMethodBeat.o(215158);
        } else {
            if (this.lKJ == null) {
                Log.i(this.cDW, "bluetoothStateListener init");
                this.lKJ = new BroadcastReceiver() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.a.AnonymousClass3 */

                    public final void onReceive(Context context, Intent intent) {
                        AppMethodBeat.i(144600);
                        if (intent == null) {
                            Log.i(a.this.cDW, "Receive intent failed");
                            AppMethodBeat.o(144600);
                            return;
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            Log.d(a.this.cDW, "state:%d", Integer.valueOf(state));
                            if (!(state == 12 || state == 11 || (state != 10 && state != 13))) {
                                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(a.this.cDW, "bluetooth is disable, stop scan", new Object[0]);
                                a.this.lNQ.set(false);
                                a.this.bFv();
                            }
                        }
                        AppMethodBeat.o(144600);
                    }
                };
                this.context.registerReceiver(this.lKJ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
            }
            AppMethodBeat.o(215158);
        }
    }

    public final synchronized void a(b bVar, List<ScanFilterCompat> list, i iVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(144602);
        if (!this.dxh.get() || this.lNP == null) {
            bVar.a(j.lNE);
            AppMethodBeat.o(144602);
        } else if (this.lNQ.get()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "already scan", new Object[0]);
            bVar.a(j.lNu);
            AppMethodBeat.o(144602);
        } else {
            BluetoothAdapter bFC = c.bFC();
            if (bFC == null || !c.bFE()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "BluetoothAdapter is null, err", new Object[0]);
                bVar.a(j.lNx);
                AppMethodBeat.o(144602);
            } else {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (c.ZG("android.permission.ACCESS_FINE_LOCATION") || c.ZG("android.permission.ACCESS_COARSE_LOCATION")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "checkLocationPermission :%b", Boolean.valueOf(z));
                    LocationManager locationManager = (LocationManager) MMApplicationContext.getContext().getSystemService(FirebaseAnalytics.b.LOCATION);
                    if (locationManager != null) {
                        z3 = locationManager.isProviderEnabled("gps");
                        z2 = locationManager.isProviderEnabled(TencentLocation.NETWORK_PROVIDER);
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleHelper", "isGPSEnable " + z3 + ", isNetworkEnable:" + z2, new Object[0]);
                    } else {
                        z2 = false;
                        z3 = false;
                    }
                    if (!z3 || !z2) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "checkGpsEnable:%b", Boolean.valueOf(z4));
                }
                this.lNQ.set(true);
                if (list != null && list.size() == 0) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "scanFilterCompats size:%d", Integer.valueOf(list.size()));
                    list = null;
                }
                boolean a2 = b.a(bFC, list, ZF(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().lMm), this.lNP);
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "startBleScan isOk:%b", Boolean.valueOf(a2));
                if (a2) {
                    this.lNT = iVar;
                    if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn > 0) {
                        this.mHandler.postDelayed(this.lNS, (long) com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.bFm().gTn);
                    }
                    bVar.a(j.lNu);
                    AppMethodBeat.o(144602);
                } else {
                    bVar.a(j.lNE);
                    AppMethodBeat.o(144602);
                }
            }
        }
    }

    public final synchronized j bFv() {
        j jVar;
        AppMethodBeat.i(144603);
        if (!this.dxh.get() || this.lNP == null) {
            jVar = j.lNw;
            AppMethodBeat.o(144603);
        } else if (!this.lNQ.get()) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "not scan", new Object[0]);
            jVar = j.lNu;
            AppMethodBeat.o(144603);
        } else {
            BluetoothAdapter bFC = c.bFC();
            if (bFC == null || !c.bFE()) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(this.cDW, "BluetoothAdapter is null, err", new Object[0]);
                jVar = j.lNx;
                AppMethodBeat.o(144603);
            } else {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(this.cDW, "stopBleScan, stopScan", new Object[0]);
                this.lNQ.set(false);
                b.a(bFC, this.lNP);
                jVar = j.lNu;
                AppMethodBeat.o(144603);
            }
        }
        return jVar;
    }

    public final synchronized List<d> bFw() {
        ArrayList arrayList;
        AppMethodBeat.i(215159);
        if (this.ljN == null) {
            arrayList = new ArrayList();
            AppMethodBeat.o(215159);
        } else {
            arrayList = new ArrayList(this.ljN.values());
            AppMethodBeat.o(215159);
        }
        return arrayList;
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(215160);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(this.cDW, "uninit", new Object[0]);
        bFv();
        this.dxh.set(false);
        if (this.ljN != null) {
            this.ljN.clear();
        }
        if (this.lNR != null) {
            this.lNR.clear();
        }
        if (c.bFC() != null && c.bFC().isDiscovering()) {
            c.bFC().cancelDiscovery();
        }
        bFe();
        this.lNP = null;
        AppMethodBeat.o(215160);
    }

    private synchronized void bFe() {
        AppMethodBeat.i(215161);
        if (!(this.lKJ == null || this.context == null)) {
            Log.i(this.cDW, "bluetoothStateListener uninit");
            this.context.unregisterReceiver(this.lKJ);
            this.lKJ = null;
        }
        AppMethodBeat.o(215161);
    }
}
