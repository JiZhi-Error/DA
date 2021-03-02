package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"})
public final class o {
    static final Map<Integer, n> lLS = new ConcurrentHashMap();
    private static h.c lLT;
    private static volatile boolean lLU;
    public static final o lLV = new o();

    static {
        AppMethodBeat.i(144787);
        AppMethodBeat.o(144787);
    }

    private o() {
    }

    public static boolean bFk() {
        AppMethodBeat.i(144783);
        if (lLS.size() + 1 > 10) {
            AppMethodBeat.o(144783);
            return true;
        }
        AppMethodBeat.o(144783);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFA();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        if (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLS.containsKey(java.lang.Integer.valueOf(r0)) != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n();
        r1.c(r6, r0);
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLS.put(java.lang.Integer.valueOf(r0), r1);
        com.tencent.matrix.trace.core.AppMethodBeat.o(144784);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int n(com.tencent.mm.plugin.appbrand.jsapi.f r6) {
        /*
            r5 = this;
            r4 = 144784(0x23590, float:2.02886E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r0 = "component"
            kotlin.g.b.p.h(r6, r0)
            monitor-enter(r5)
            com.tencent.mm.plugin.appbrand.h$c r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLT     // Catch:{ all -> 0x0055 }
            if (r0 != 0) goto L_0x0023
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o$a r0 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o$a     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            com.tencent.mm.plugin.appbrand.h$c r0 = (com.tencent.mm.plugin.appbrand.h.c) r0     // Catch:{ all -> 0x0055 }
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLT = r0     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r6.getAppId()     // Catch:{ all -> 0x0055 }
            com.tencent.mm.plugin.appbrand.h$c r1 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLT     // Catch:{ all -> 0x0055 }
            com.tencent.mm.plugin.appbrand.h.a(r0, r1)     // Catch:{ all -> 0x0055 }
        L_0x0023:
            boolean r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLU     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x002d
            monitor-exit(r5)
            r0 = -1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
        L_0x002c:
            return r0
        L_0x002d:
            kotlin.x r0 = kotlin.x.SXb
            monitor-exit(r5)
        L_0x0030:
            int r0 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.b.bFA()
            java.util.Map<java.lang.Integer, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n> r1 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLS
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0030
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n r1 = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n
            r1.<init>()
            r1.c(r6, r0)
            java.util.Map<java.lang.Integer, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.n> r2 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.lLS
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r2.put(r3, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            goto L_0x002c
        L_0x0055:
            r0 = move-exception
            monitor-exit(r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.o.n(com.tencent.mm.plugin.appbrand.jsapi.f):int");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager$newPeripheralServer$1$1", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "onDestroy", "", "luggage-commons-jsapi-connectivity-ext_release"})
    public static final class a extends h.c {
        a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.h.c
        public final void onDestroy() {
            AppMethodBeat.i(144782);
            super.onDestroy();
            Log.i("MicroMsg.BLE.PeripheralBleServerManager", "onDestroy: ");
            o oVar = o.lLV;
            o.lLU = true;
            synchronized (o.lLV) {
                try {
                    Map<Integer, n> map = o.lLS;
                    ArrayList<n> arrayList = new ArrayList(map.size());
                    for (Map.Entry<Integer, n> entry : map.entrySet()) {
                        arrayList.add(entry.getValue());
                    }
                    for (n nVar : arrayList) {
                        Log.i("MicroMsg.BLE.PeripheralBleServerManager", "destroy server #" + nVar.ktp);
                        nVar.onDestroy();
                    }
                    o.lLS.clear();
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(144782);
                    throw th;
                }
            }
            o oVar2 = o.lLV;
            o.lLT = null;
            o oVar3 = o.lLV;
            o.lLU = false;
            AppMethodBeat.o(144782);
        }
    }

    public static boolean wP(int i2) {
        AppMethodBeat.i(144785);
        if (lLU) {
            AppMethodBeat.o(144785);
            return false;
        }
        n nVar = lLS.get(Integer.valueOf(i2));
        if (nVar == null) {
            AppMethodBeat.o(144785);
            return false;
        }
        nVar.onDestroy();
        if (lLS.remove(Integer.valueOf(i2)) != null) {
            AppMethodBeat.o(144785);
            return true;
        }
        AppMethodBeat.o(144785);
        return false;
    }

    public static n wQ(int i2) {
        AppMethodBeat.i(144786);
        if (lLU) {
            AppMethodBeat.o(144786);
            return null;
        }
        n nVar = lLS.get(Integer.valueOf(i2));
        AppMethodBeat.o(144786);
        return nVar;
    }
}
