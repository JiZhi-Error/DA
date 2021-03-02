package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class f extends d<com.tencent.mm.plugin.appbrand.jsapi.f> {
    public static final int CTRL_INDEX = 529;
    public static final String NAME = "operateLocalServicesScan";
    final Map<String, a> mgp = new ConcurrentHashMap();

    public f() {
        AppMethodBeat.i(144239);
        AppMethodBeat.o(144239);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144240);
        String optString = jSONObject.optString(NativeProtocol.WEB_DIALOG_ACTION);
        Log.i("MicroMsg.JsApiOperateLocalServicesScan", "action = ".concat(String.valueOf(optString)));
        if (TextUtils.equals("start", optString)) {
            final String optString2 = jSONObject.optString("serviceType");
            if (TextUtils.isEmpty(optString2)) {
                fVar.i(i2, h("fail:invalid param", (JSONObject) null));
                AppMethodBeat.o(144240);
                return;
            }
            synchronized (this.mgp) {
                try {
                    for (String str : this.mgp.keySet()) {
                        if (str.contains(fVar.getAppId())) {
                            fVar.i(i2, h("fail:scan task already exist", (JSONObject) null));
                            return;
                        }
                    }
                    final a aVar = new a(fVar);
                    aVar.mgv.set(i2);
                    this.mgp.put(h(fVar, optString2), aVar);
                    p pVar = p.INSTANCE;
                    NsdManager bPK = p.bPK();
                    p.AnonymousClass1 r5 = new NsdManager.DiscoveryListener(aVar) {
                        /* class com.tencent.mm.plugin.appbrand.s.p.AnonymousClass1 */
                        final /* synthetic */ b njf;

                        {
                            this.njf = r2;
                        }

                        public final void onStartDiscoveryFailed(String str, int i2) {
                            AppMethodBeat.i(144442);
                            this.njf.bHE();
                            Log.i("MicroMsg.LocalServiceMgr", "onStartDiscoveryFailed ".concat(String.valueOf(str)));
                            AppMethodBeat.o(144442);
                        }

                        public final void onStopDiscoveryFailed(String str, int i2) {
                            AppMethodBeat.i(144443);
                            this.njf.bHF();
                            Log.i("MicroMsg.LocalServiceMgr", "onStopDiscoveryFailed ".concat(String.valueOf(str)));
                            AppMethodBeat.o(144443);
                        }

                        public final void onDiscoveryStarted(String str) {
                            AppMethodBeat.i(144444);
                            this.njf.bHG();
                            Log.i("MicroMsg.LocalServiceMgr", "onDiscoveryStarted ".concat(String.valueOf(str)));
                            AppMethodBeat.o(144444);
                        }

                        public final void onDiscoveryStopped(String str) {
                            AppMethodBeat.i(144445);
                            this.njf.bHH();
                            Log.i("MicroMsg.LocalServiceMgr", "onDiscoveryStopped ".concat(String.valueOf(str)));
                            AppMethodBeat.o(144445);
                        }

                        public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                            AppMethodBeat.i(144446);
                            this.njf.a(new c(nsdServiceInfo));
                            Log.i("MicroMsg.LocalServiceMgr", "onServicesFound " + nsdServiceInfo.getServiceType());
                            AppMethodBeat.o(144446);
                        }

                        public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
                            AppMethodBeat.i(144447);
                            this.njf.b(new c(nsdServiceInfo));
                            Log.i("MicroMsg.LocalServiceMgr", "onServiceLost " + nsdServiceInfo.getServiceType());
                            AppMethodBeat.o(144447);
                        }
                    };
                    pVar.njd.put(aVar, r5);
                    bPK.discoverServices(optString2, 1, r5);
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.o.f.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(144229);
                            ThreadPool.post(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.o.f.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(144228);
                                    synchronized (f.this.mgp) {
                                        try {
                                            if (!f.this.mgp.containsKey(f.h(fVar, optString2))) {
                                                Log.i("MicroMsg.JsApiOperateLocalServicesScan", "scan task not exist, cancel auto stop");
                                                return;
                                            }
                                            p.INSTANCE.a(aVar);
                                            f.this.mgp.remove(f.h(fVar, optString2));
                                            AppMethodBeat.o(144228);
                                        } finally {
                                            AppMethodBeat.o(144228);
                                        }
                                    }
                                }
                            }, "stopScanServices");
                            AppMethodBeat.o(144229);
                        }
                    }, 30000);
                    AppMethodBeat.o(144240);
                } finally {
                    AppMethodBeat.o(144240);
                }
            }
        } else if (TextUtils.equals("stop", optString)) {
            synchronized (this.mgp) {
                try {
                    boolean z = true;
                    for (a aVar2 : this.mgp.values()) {
                        aVar2.mgw.set(i2);
                        p.INSTANCE.a(aVar2);
                        z = false;
                    }
                    if (z) {
                        fVar.i(i2, h("fail:task not found", (JSONObject) null));
                    }
                    this.mgp.clear();
                } finally {
                    AppMethodBeat.o(144240);
                }
            }
        } else {
            fVar.i(i2, h("fail:invalid param", (JSONObject) null));
            AppMethodBeat.o(144240);
        }
    }

    static String h(com.tencent.mm.plugin.appbrand.jsapi.f fVar, String str) {
        AppMethodBeat.i(144241);
        String str2 = fVar.getAppId() + "#" + str;
        AppMethodBeat.o(144241);
        return str2;
    }

    class a implements p.b {
        com.tencent.mm.plugin.appbrand.jsapi.f kzr;
        AtomicInteger mgv = new AtomicInteger();
        AtomicInteger mgw = new AtomicInteger();

        a(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
            AppMethodBeat.i(144232);
            this.kzr = fVar;
            AppMethodBeat.o(144232);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void bHE() {
            AppMethodBeat.i(144233);
            this.kzr.i(this.mgv.get(), f.this.h("fail", (JSONObject) null));
            Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStartDiscoveryFailed");
            AppMethodBeat.o(144233);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void bHF() {
            AppMethodBeat.i(144234);
            this.kzr.i(this.mgw.get(), f.this.h("fail", (JSONObject) null));
            Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onStopDiscoveryFailed");
            AppMethodBeat.o(144234);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void bHG() {
            AppMethodBeat.i(144235);
            this.kzr.i(this.mgv.get(), f.this.h("ok", (JSONObject) null));
            Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStarted");
            AppMethodBeat.o(144235);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void bHH() {
            AppMethodBeat.i(144236);
            Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onDiscoveryStopped");
            this.kzr.i(this.mgw.get(), f.this.h("ok", (JSONObject) null));
            a.t(this.kzr);
            AppMethodBeat.o(144236);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void a(p.c cVar) {
            AppMethodBeat.i(144237);
            Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceFound");
            h.RTc.b(new Runnable(cVar, new p.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.o.f.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.s.p.a
                public final void c(p.c cVar) {
                    AppMethodBeat.i(144230);
                    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onResolveFailed");
                    a.c(a.this.kzr, cVar);
                    AppMethodBeat.o(144230);
                }

                @Override // com.tencent.mm.plugin.appbrand.s.p.a
                public final void d(p.c cVar) {
                    AppMethodBeat.i(144231);
                    Log.i("MicroMsg.JsApiOperateLocalServicesScan", "onServiceResolved");
                    a.a(a.this.kzr, cVar);
                    AppMethodBeat.o(144231);
                }
            }) {
                /* class com.tencent.mm.plugin.appbrand.s.p.AnonymousClass2 */
                final /* synthetic */ c njh;
                final /* synthetic */ a nji;

                {
                    this.njh = r2;
                    this.nji = r3;
                }

                public final void run() {
                    AppMethodBeat.i(144450);
                    Log.i("MicroMsg.LocalServiceMgr", "start reslove " + this.njh.serviceName);
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
                    nsdServiceInfo.setServiceName(this.njh.serviceName);
                    nsdServiceInfo.setServiceType(this.njh.iBb);
                    p.bPL().resolveService(nsdServiceInfo, new NsdManager.ResolveListener() {
                        /* class com.tencent.mm.plugin.appbrand.s.p.AnonymousClass2.AnonymousClass1 */

                        public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i2) {
                            AppMethodBeat.i(144448);
                            AnonymousClass2.this.nji.c(new c(nsdServiceInfo));
                            countDownLatch.countDown();
                            AppMethodBeat.o(144448);
                        }

                        public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
                            AppMethodBeat.i(144449);
                            AnonymousClass2.this.nji.d(new c(nsdServiceInfo));
                            countDownLatch.countDown();
                            AppMethodBeat.o(144449);
                        }
                    });
                    try {
                        countDownLatch.await(1000, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("LocalServiceMgr", e2, "", new Object[0]);
                    }
                    Log.i("MicroMsg.LocalServiceMgr", "finish reslove " + this.njh.serviceName + " trhead id=" + Thread.currentThread().getId());
                    AppMethodBeat.o(144450);
                }
            }, "LocalServiceMgr#resolveService");
            AppMethodBeat.o(144237);
        }

        @Override // com.tencent.mm.plugin.appbrand.s.p.b
        public final void b(p.c cVar) {
            AppMethodBeat.i(144238);
            a.b(this.kzr, cVar);
            AppMethodBeat.o(144238);
        }
    }
}
