package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

public final class b extends h.c {
    private final String appId;
    private com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b lKM;
    volatile a lKN;

    public interface a {
        void ho(boolean z);
    }

    public b(String str) {
        this.appId = str;
    }

    public final synchronized void init() {
        AppMethodBeat.i(215142);
        this.lKM = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b(MMApplicationContext.getContext());
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.lKM;
        bVar.lMr.init();
        bVar.lMs.init();
        AppMethodBeat.o(215142);
    }

    public final List<d> hn(boolean z) {
        AppMethodBeat.i(215143);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = bFg();
        if (bFg != null) {
            c cVar = bFg.lMr;
            if (z) {
                List<d> bFp = cVar.bFp();
                AppMethodBeat.o(215143);
                return bFp;
            }
            c.a aVar = c.a.lME;
            List<d> bFq = c.bFq();
            AppMethodBeat.o(215143);
            return bFq;
        }
        AppMethodBeat.o(215143);
        return null;
    }

    public final List<d> b(List<String> list, boolean z) {
        AppMethodBeat.i(215144);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = bFg();
        if (bFg != null) {
            c cVar = bFg.lMr;
            if (z) {
                List<d> bB = cVar.bB(list);
                AppMethodBeat.o(215144);
                return bB;
            } else if (list == null || list.isEmpty()) {
                c.a aVar = c.a.lME;
                List<d> bFq = c.bFq();
                AppMethodBeat.o(215144);
                return bFq;
            } else {
                List<d> bB2 = cVar.bB(list);
                AppMethodBeat.o(215144);
                return bB2;
            }
        } else {
            AppMethodBeat.o(215144);
            return null;
        }
    }

    public final void a(String str, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a aVar, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b bVar) {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d ZE;
        AppMethodBeat.i(144485);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = bFg();
        if (!(bFg == null || (ZE = bFg.lMr.ZE(str)) == null)) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(ZE.cDW, "deviceId:%s aciton:%s", ZE.dGL, aVar);
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b bVar2 = ZE.lMF;
            if (bVar2 == null) {
                AppMethodBeat.o(144485);
                return;
            }
            aVar.lNb = ZE;
            aVar.a(bVar2);
            aVar.lNd = bVar;
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", aVar);
            if (aVar.lMj) {
                Queue<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.a> queue = bVar2.lMu;
                if (queue == null) {
                    AppMethodBeat.o(144485);
                    return;
                }
                queue.add(aVar);
                bVar2.bFo();
                AppMethodBeat.o(144485);
                return;
            } else if (aVar.lMh) {
                bVar2.aDv.postDelayed(new Runnable(aVar) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.b.AnonymousClass1 */
                    final /* synthetic */ a lMx;

                    {
                        this.lMx = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(144542);
                        this.lMx.doAction();
                        AppMethodBeat.o(144542);
                    }
                }, aVar.lNg);
                AppMethodBeat.o(144485);
                return;
            } else {
                aVar.doAction();
            }
        }
        AppMethodBeat.o(144485);
    }

    public final List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> dn(String str, String str2) {
        AppMethodBeat.i(144487);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg = bFg();
        if (bFg != null) {
            c cVar = bFg.lMr;
            if (cVar.lMA == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
                AppMethodBeat.o(144487);
                return null;
            }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.d dVar = cVar.lMA.get(str);
            if (dVar == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
                AppMethodBeat.o(144487);
                return null;
            }
            BluetoothGatt bluetoothGatt = dVar.lMG;
            if (bluetoothGatt == null) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(dVar.cDW, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
                AppMethodBeat.o(144487);
                return null;
            } else if (Util.isNullOrNil(str2)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(dVar.cDW, "[getCharacteristics] serviceId is null, err", new Object[0]);
                AppMethodBeat.o(144487);
                return null;
            } else if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.ZH(str2)) {
                com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(dVar.cDW, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
                AppMethodBeat.o(144487);
                return null;
            } else {
                Map<String, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c>> map = dVar.lMI;
                if (map == null) {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.e(dVar.cDW, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
                    AppMethodBeat.o(144487);
                    return null;
                }
                List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c> list = map.get(str2);
                if (list == null) {
                    BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str2));
                    if (service == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(dVar.cDW, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
                        AppMethodBeat.o(144487);
                        return null;
                    }
                    List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                    if (characteristics == null) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w(dVar.cDW, "[getCharacteristics] characteristics is null, err", new Object[0]);
                        AppMethodBeat.o(144487);
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c cVar2 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.c();
                        cVar2.uuid = bluetoothGattCharacteristic.getUuid().toString().toUpperCase();
                        int properties = bluetoothGattCharacteristic.getProperties();
                        cVar2.lNl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wU(properties);
                        cVar2.lNm = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wV(properties);
                        cVar2.lNn = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wW(properties);
                        cVar2.iDl = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wX(properties);
                        cVar2.lNo = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.wY(properties);
                        arrayList.add(cVar2);
                    }
                    map.put(str2, arrayList);
                    list = arrayList;
                } else {
                    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i(dVar.cDW, "[getCharacteristics] use cache", new Object[0]);
                }
                if (dVar.lMG == null) {
                    AppMethodBeat.o(144487);
                    return null;
                }
                AppMethodBeat.o(144487);
                return list;
            }
        } else {
            AppMethodBeat.o(144487);
            return null;
        }
    }

    public static boolean bFf() {
        AppMethodBeat.i(144488);
        boolean bFE = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE();
        AppMethodBeat.o(144488);
        return bFE;
    }

    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final void onDestroy() {
        AppMethodBeat.i(144489);
        a.ZD(this.appId);
        AppMethodBeat.o(144489);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(144490);
        if (this.lKM != null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar = this.lKM;
            bVar.lMr.uninit();
            bVar.lMs.uninit();
            this.lKM = null;
        }
        AppMethodBeat.o(144490);
    }

    public final synchronized com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bFg() {
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b bVar;
        AppMethodBeat.i(215145);
        bVar = this.lKM;
        if (bVar == null) {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.w("MicroMsg.ble.BleWorker", "getBleManager, bleManager is null", new Object[0]);
        }
        AppMethodBeat.o(215145);
        return bVar;
    }
}
