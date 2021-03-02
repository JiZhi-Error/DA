package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.udp.libmmudp.UdpNative;
import java.lang.ref.WeakReference;

public final class c {
    boolean czD = true;
    protected UdpNative czO;
    private final a czP = new a(new Runnable() {
        /* class com.tencent.luggage.sdk.b.a.a.c.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(146760);
            synchronized (c.this) {
                try {
                    if (c.this.czO != null) {
                        Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
                        c.this.czO.destoryUdp();
                        c.this.czO = null;
                    } else {
                        Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
                    }
                } finally {
                    AppMethodBeat.o(146760);
                }
            }
        }
    });

    public c() {
        AppMethodBeat.i(146762);
        AppMethodBeat.o(146762);
    }

    public final void a(final i iVar, f fVar) {
        AppMethodBeat.i(229839);
        Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
        if (iVar == null) {
            Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
            AppMethodBeat.o(229839);
            return;
        }
        com.tencent.mm.udp.libmmudp.a.loadLibraries();
        q qVar = (q) iVar.R(q.class);
        if (qVar == null) {
            Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
            AppMethodBeat.o(229839);
            return;
        }
        b bVar = (b) fVar.M(b.class);
        if (bVar != null) {
            this.czD = bVar.Oa();
            Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", Boolean.valueOf(this.czD));
        }
        final WeakReference weakReference = new WeakReference(qVar);
        final AnonymousClass1 r2 = new UdpNative.NativeCallBackInterface() {
            /* class com.tencent.luggage.sdk.b.a.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface
            public final void onCallBack(final long j2, final String str) {
                AppMethodBeat.i(146758);
                ((q) weakReference.get()).post(new Runnable() {
                    /* class com.tencent.luggage.sdk.b.a.a.c.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(146757);
                        Log.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", str, Long.valueOf(j2));
                        c.this.czO.update(j2);
                        AppMethodBeat.o(146757);
                    }
                });
                AppMethodBeat.o(146758);
            }
        };
        qVar.post(new Runnable() {
            /* class com.tencent.luggage.sdk.b.a.a.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(146759);
                Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
                if (c.this.czO != null) {
                    Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
                    AppMethodBeat.o(146759);
                    return;
                }
                v vVar = (v) iVar.R(v.class);
                if (vVar == null) {
                    Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
                    AppMethodBeat.o(146759);
                    return;
                }
                if (c.this.czD) {
                    c.this.czO = new UdpNative(vVar.getIsolatePtr(), vVar.XK(), vVar.getUVLoopPtr());
                } else {
                    c.this.czO = new UdpNative(vVar.getIsolatePtr(), vVar.XK(), 0);
                }
                Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", Integer.valueOf(c.this.czO.InitCallBack(r2)));
                AppMethodBeat.o(146759);
            }
        });
        AppMethodBeat.o(229839);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(146764);
        Log.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
        if (iVar == null) {
            Log.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
            AppMethodBeat.o(146764);
            return;
        }
        ((m) iVar.R(m.class)).a(this.czP);
        AppMethodBeat.o(146764);
    }

    class a extends l implements m.a {
        a(Runnable runnable) {
            super(runnable);
        }

        @Override // com.tencent.mm.plugin.appbrand.m.m.a
        public final void onDestroy() {
            AppMethodBeat.i(146761);
            run();
            AppMethodBeat.o(146761);
        }
    }
}
