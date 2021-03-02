package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static BroadcastReceiver lKJ;
    private static boolean lKK;
    private static a.AbstractC0652a lKL = new a.AbstractC0652a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.AbstractC0652a
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(144473);
            Log.e(str, str2, objArr);
            AppMethodBeat.o(144473);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.AbstractC0652a
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(144474);
            Log.w(str, str2, objArr);
            AppMethodBeat.o(144474);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.AbstractC0652a
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(144475);
            Log.i(str, str2, objArr);
            AppMethodBeat.o(144475);
        }
    };
    private static Map<String, b> map = new HashMap();

    static {
        AppMethodBeat.i(144483);
        AppMethodBeat.o(144483);
    }

    public static synchronized j a(String str, b.a aVar, h hVar, g gVar) {
        j jVar;
        synchronized (a.class) {
            AppMethodBeat.i(144478);
            Log.i("MicroMsg.Ble.BleManager", "open appId:%s", str);
            if (!c.bFD()) {
                Log.e("MicroMsg.Ble.BleManager", "api version is below 18");
                jVar = j.lNF;
                AppMethodBeat.o(144478);
            } else {
                if (!map.containsKey(str)) {
                    b bVar = new b(str);
                    bVar.init();
                    bVar.lKN = aVar;
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = bVar.bFg();
                    if (bFg != null) {
                        bFg.lMr.lMB = hVar;
                    }
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg2 = bVar.bFg();
                    if (bFg2 != null) {
                        bFg2.lMr.lMC = gVar;
                    }
                    map.put(str, bVar);
                    com.tencent.mm.plugin.appbrand.h.a(str, bVar);
                    bFd();
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.lOT = lKL;
                } else {
                    Log.i("MicroMsg.Ble.BleManager", "already open appId:%s", str);
                }
                if (!c.bFE()) {
                    Log.e("MicroMsg.Ble.BleManager", "bluetooth not enable, err");
                    jVar = j.lNx;
                    AppMethodBeat.o(144478);
                } else {
                    jVar = j.lNu;
                    AppMethodBeat.o(144478);
                }
            }
        }
        return jVar;
    }

    public static synchronized b ZC(String str) {
        b bVar;
        synchronized (a.class) {
            AppMethodBeat.i(144479);
            bVar = map.get(str);
            AppMethodBeat.o(144479);
        }
        return bVar;
    }

    public static synchronized j ZD(String str) {
        j jVar;
        synchronized (a.class) {
            AppMethodBeat.i(144480);
            Log.i("MicroMsg.Ble.BleManager", "close appId:%s", str);
            if (!map.containsKey(str)) {
                jVar = j.lNu;
                AppMethodBeat.o(144480);
            } else {
                b remove = map.remove(str);
                com.tencent.mm.plugin.appbrand.h.b(str, remove);
                if (remove == null) {
                    Log.i("MicroMsg.Ble.BleManager", "close, bleWorker is null");
                } else {
                    remove.uninit();
                }
                if (map.size() == 0) {
                    bFe();
                }
                jVar = j.lNu;
                AppMethodBeat.o(144480);
            }
        }
        return jVar;
    }

    private static synchronized void bFd() {
        synchronized (a.class) {
            AppMethodBeat.i(144481);
            if (lKJ == null) {
                Log.i("MicroMsg.Ble.BleManager", "bluetoothStateListener init");
                lKJ = new BroadcastReceiver() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.AnonymousClass2 */

                    public final void onReceive(Context context, Intent intent) {
                        boolean z = false;
                        AppMethodBeat.i(144477);
                        if (intent == null) {
                            Log.i("MicroMsg.Ble.BleManager", "Receive intent failed");
                            AppMethodBeat.o(144477);
                            return;
                        }
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if (defaultAdapter != null) {
                            int state = defaultAdapter.getState();
                            Log.d("MicroMsg.Ble.BleManager", "state:%d", Integer.valueOf(state));
                            if (state == 12) {
                                z = true;
                            } else if (state == 10) {
                            }
                            if ((a.lKK && !z) || (!a.lKK && z)) {
                                for (b bVar : a.map.values()) {
                                    b.a aVar = bVar.lKN;
                                    if (aVar != null) {
                                        aVar.ho(z);
                                    }
                                }
                            }
                            boolean unused = a.lKK = z;
                        }
                        AppMethodBeat.o(144477);
                    }
                };
                MMApplicationContext.getContext().registerReceiver(lKJ, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
                lKK = c.bFE();
            }
            AppMethodBeat.o(144481);
        }
    }

    private static synchronized void bFe() {
        synchronized (a.class) {
            AppMethodBeat.i(144482);
            if (lKJ != null) {
                Log.i("MicroMsg.Ble.BleManager", "bluetoothStateListener uninit");
                MMApplicationContext.getContext().unregisterReceiver(lKJ);
                lKJ = null;
            }
            AppMethodBeat.o(144482);
        }
    }
}
