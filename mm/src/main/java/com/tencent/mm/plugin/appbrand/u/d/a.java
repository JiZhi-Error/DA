package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.permission.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.u.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public final class a extends e {
    private t.b nkm;

    public a(e.a aVar, s sVar) {
        super(aVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void bPV() {
        AppMethodBeat.i(147405);
        this.nkm = new t.b() {
            /* class com.tencent.mm.plugin.appbrand.u.d.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.t.b
            public final void btg() {
                AppMethodBeat.i(147404);
                Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| onRuntimeReady %s", a.this.cAJ.getAppId());
                final AppBrandRuntime runtime = a.this.cAJ.getRuntime();
                if (runtime == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("onRuntimeReady runtime null");
                    AppMethodBeat.o(147404);
                    throw illegalStateException;
                }
                q qVar = (q) a.this.cAJ.getJsRuntime().R(q.class);
                AnonymousClass1 r2 = new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.u.d.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(169499);
                        if (runtime.isDestroyed()) {
                            AppMethodBeat.o(169499);
                            return;
                        }
                        Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "AppBrandRuntimeProfile| start prepareDataForNode %s", a.this.cAJ.getAppId());
                        HashMap hashMap = new HashMap();
                        d dVar = ((com.tencent.luggage.sdk.d.d) runtime).cCn;
                        if (dVar == null) {
                            Log.w("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes controller null");
                        } else {
                            Vector<byte[]> bSW = dVar.bSW();
                            if (bSW == null) {
                                Log.i("MicroMsg.ProxyAppBrandServiceOnRuntimeReadyListener", "fillPermissionBytes getPermissionBytes null");
                            } else {
                                hashMap.put("fg", bSW.elementAt(0));
                                hashMap.put("bg", bSW.elementAt(1));
                            }
                        }
                        hashMap.put("state", b.kQH);
                        hashMap.put("wxaData", com.tencent.mm.plugin.appbrand.u.b.b.ac(runtime));
                        a.this.aa(hashMap);
                        AppMethodBeat.o(169499);
                    }
                };
                if (qVar.LO()) {
                    r2.run();
                    AppMethodBeat.o(147404);
                    return;
                }
                qVar.post(r2);
                AppMethodBeat.o(147404);
            }
        };
        t tVar = t.a.kEr;
        s sVar = this.cAJ;
        t.b bVar = this.nkm;
        int componentId = sVar.getComponentId();
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", Integer.valueOf(componentId));
        synchronized (tVar) {
            try {
                List<t.b> list = tVar.kEp.get(componentId);
                if (list == null) {
                    list = new ArrayList<>();
                    tVar.kEp.put(componentId, list);
                }
                list.add(bVar);
                tVar.e(componentId, list);
            } finally {
                AppMethodBeat.o(147405);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final int getType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void removeListener() {
        AppMethodBeat.i(147406);
        t tVar = t.a.kEr;
        s sVar = this.cAJ;
        t.b bVar = this.nkm;
        int componentId = sVar.getComponentId();
        Log.i("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", Integer.valueOf(componentId));
        synchronized (tVar) {
            try {
                List<t.b> list = tVar.kEp.get(componentId);
                if (list != null) {
                    list.remove(bVar);
                    if (list.isEmpty()) {
                        tVar.kEp.remove(componentId);
                    }
                    AppMethodBeat.o(147406);
                }
            } finally {
                AppMethodBeat.o(147406);
            }
        }
    }
}
