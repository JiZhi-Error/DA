package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public class d extends j<a> implements c, e {
    private static final Map<String, d> lFs = new android.support.v4.e.a();
    private static final d lFt = new d() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.appbrand.utils.j, com.tencent.mm.plugin.appbrand.jsapi.auth.d
        public final /* synthetic */ void cE(a aVar) {
            AppMethodBeat.i(46005);
            d.super.a(aVar);
            AppMethodBeat.o(46005);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.d
        public final boolean bEI() {
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.j, com.tencent.mm.plugin.appbrand.jsapi.auth.d
        public final /* bridge */ /* synthetic */ boolean bEJ() {
            return true;
        }
    };

    /* access modifiers changed from: package-private */
    public interface a {
        void bpf();
    }

    /* synthetic */ d() {
        this(null);
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(46016);
        dVar.quit();
        AppMethodBeat.o(46016);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.j
    public /* synthetic */ boolean bEJ() {
        AppMethodBeat.i(46015);
        boolean bEI = bEI();
        AppMethodBeat.o(46015);
        return bEI;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.appbrand.utils.j
    public /* synthetic */ void cE(a aVar) {
        AppMethodBeat.i(46014);
        a(aVar);
        AppMethodBeat.o(46014);
    }

    static {
        AppMethodBeat.i(46017);
        AppMethodBeat.o(46017);
    }

    public static d V(AppBrandRuntime appBrandRuntime) {
        d dVar;
        AppMethodBeat.i(46009);
        if (appBrandRuntime == null || appBrandRuntime.isDestroyed()) {
            d dVar2 = lFt;
            AppMethodBeat.o(46009);
            return dVar2;
        }
        synchronized (lFs) {
            try {
                dVar = lFs.get(appBrandRuntime.mAppId);
                if (dVar == null) {
                    dVar = new d(appBrandRuntime);
                    lFs.put(appBrandRuntime.mAppId, dVar);
                }
            } finally {
                AppMethodBeat.o(46009);
            }
        }
        return dVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private d(com.tencent.mm.plugin.appbrand.AppBrandRuntime r5) {
        /*
            r4 = this;
            r3 = 46010(0xb3ba, float:6.4474E-41)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = "MicroMsg.AppBrandAuthJsApiQueue"
            r1.<init>(r0)
            if (r5 != 0) goto L_0x0028
            java.lang.String r0 = "|DUMMY"
        L_0x0010:
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r4.<init>(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            if (r5 != 0) goto L_0x003b
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x0027:
            return
        L_0x0028:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "|"
            r0.<init>(r2)
            java.lang.String r2 = r5.mAppId
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            goto L_0x0010
        L_0x003b:
            com.tencent.mm.plugin.appbrand.a.c r0 = r5.kAH
            com.tencent.mm.plugin.appbrand.jsapi.auth.d$2 r1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.d$2
            r1.<init>()
            r0.a(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.auth.d.<init>(com.tencent.mm.plugin.appbrand.AppBrandRuntime):void");
    }

    /* access modifiers changed from: protected */
    public boolean bEI() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final void a(a aVar) {
        AppMethodBeat.i(46012);
        Log.d(getName(), "about to executeTask %s", aVar.toString());
        aVar.bpf();
        AppMethodBeat.o(46012);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.c
    public final void a(final i iVar, final com.tencent.mm.plugin.appbrand.d dVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(229890);
        Log.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", iVar.getName(), Integer.valueOf(i2), dVar.getAppId());
        super.cQ(new a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.d.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.d.a
            public final void bpf() {
                AppMethodBeat.i(46007);
                Log.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", d.this.getName());
                if (!dVar.isRunning()) {
                    Log.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", iVar.getName());
                    this.sendMessage(2);
                    AppMethodBeat.o(46007);
                    return;
                }
                iVar.a(dVar, jSONObject, i2, new a(this));
                AppMethodBeat.o(46007);
            }

            public final String toString() {
                AppMethodBeat.i(46008);
                String str = hashCode() + "|" + iVar.getName();
                AppMethodBeat.o(46008);
                return str;
            }
        });
        try {
            jSONObject.put("queueLength", this.ogP.size());
            AppMethodBeat.o(229890);
        } catch (JSONException e2) {
            AppMethodBeat.o(229890);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.e
    public final void bEE() {
        AppMethodBeat.i(46011);
        sendMessage(2);
        AppMethodBeat.o(46011);
    }
}
