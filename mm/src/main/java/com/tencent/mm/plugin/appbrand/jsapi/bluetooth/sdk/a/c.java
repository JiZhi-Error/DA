package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public final class c {
    private final Context context;
    public Map<String, d> lMA;
    public volatile h lMB;
    public volatile g lMC;

    public interface a {
        public static final a lME = new a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.a.AnonymousClass1 */
        };
    }

    public c(Context context2) {
        this.context = context2;
    }

    public final synchronized void init() {
        AppMethodBeat.i(215148);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new Object[0]);
        if (this.lMA == null) {
            this.lMA = new ConcurrentHashMap();
        }
        this.lMA.clear();
        AppMethodBeat.o(215148);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(215149);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
        if (this.lMA != null) {
            for (d dVar : this.lMA.values()) {
                dVar.uninit();
            }
            this.lMA.clear();
            this.lMA = null;
        }
        AppMethodBeat.o(215149);
    }

    public final synchronized d ZE(String str) {
        d dVar;
        AppMethodBeat.i(215150);
        if (this.lMA == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getWorker, connectWorkers is null", new Object[0]);
            dVar = null;
            AppMethodBeat.o(215150);
        } else {
            dVar = this.lMA.get(str);
            if (dVar == null) {
                dVar = new d(this.context, str, this);
                dVar.init();
                dVar.lMC = new g() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g
                    public final void g(String str, String str2, String str3, String str4) {
                        AppMethodBeat.i(144556);
                        g gVar = c.this.lMC;
                        if (gVar != null) {
                            gVar.g(str, str2, str3, str4);
                        }
                        AppMethodBeat.o(144556);
                    }
                };
                dVar.lMB = new h() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h
                    public final void ap(String str, boolean z) {
                        AppMethodBeat.i(144557);
                        h hVar = c.this.lMB;
                        if (hVar != null) {
                            hVar.ap(str, z);
                        }
                        AppMethodBeat.o(144557);
                    }
                };
                this.lMA.put(str, dVar);
            }
            AppMethodBeat.o(215150);
        }
        return dVar;
    }

    public final List<d> bFp() {
        AppMethodBeat.i(215151);
        ArrayList arrayList = new ArrayList();
        if (this.lMA == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
            AppMethodBeat.o(215151);
            return arrayList;
        }
        for (d dVar : this.lMA.values()) {
            BluetoothGatt bluetoothGatt = dVar.lMG;
            if (bluetoothGatt != null) {
                arrayList.add(new d(Util.nullAsNil(bluetoothGatt.getDevice().getName()), dVar.dGL));
            }
        }
        AppMethodBeat.o(215151);
        return arrayList;
    }

    public final List<d> bB(List<String> list) {
        AppMethodBeat.i(215152);
        if (list == null || list.isEmpty()) {
            List<d> bFp = bFp();
            AppMethodBeat.o(215152);
            return bFp;
        }
        ArrayList arrayList = new ArrayList();
        if (this.lMA == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
            AppMethodBeat.o(215152);
            return arrayList;
        }
        for (d dVar : this.lMA.values()) {
            BluetoothGatt bluetoothGatt = dVar.lMG;
            if (bluetoothGatt != null) {
                List<e> services = dVar.getServices();
                if (services == null || services.isEmpty()) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, services is empty", new Object[0]);
                } else {
                    ArrayList arrayList2 = new ArrayList(services.size());
                    for (e eVar : services) {
                        if (eVar.lNt) {
                            arrayList2.add(eVar.uuid);
                        }
                    }
                    if (h(list, arrayList2)) {
                        arrayList.add(new d(Util.nullAsNil(bluetoothGatt.getDevice().getName()), dVar.dGL));
                    }
                }
            }
        }
        AppMethodBeat.o(215152);
        return arrayList;
    }

    private static boolean h(List<String> list, List<String> list2) {
        AppMethodBeat.i(175629);
        for (String str : list) {
            Iterator<String> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Objects.equals(str, it.next())) {
                        AppMethodBeat.o(175629);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(175629);
        return false;
    }

    public static List<d> bFq() {
        AppMethodBeat.i(215153);
        ArrayList arrayList = new ArrayList();
        BluetoothManager bFB = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFB();
        if (bFB == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevicesSysImpl, bluetoothManager is null", new Object[0]);
            AppMethodBeat.o(215153);
            return arrayList;
        }
        for (BluetoothDevice bluetoothDevice : bFB.getConnectedDevices(7)) {
            arrayList.add(new d(bluetoothDevice.getName(), bluetoothDevice.getAddress()));
        }
        AppMethodBeat.o(215153);
        return arrayList;
    }
}
