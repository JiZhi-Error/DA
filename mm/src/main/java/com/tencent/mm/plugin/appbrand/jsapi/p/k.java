package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public abstract class k<CONTEXT extends d, Extension> extends com.tencent.mm.plugin.appbrand.jsapi.d<CONTEXT> {
    final Class<Extension> aWC;

    /* access modifiers changed from: protected */
    public abstract void a(CONTEXT context, JSONObject jSONObject, int i2, Extension extension);

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(f fVar, final JSONObject jSONObject, final int i2) {
        final d dVar = (d) fVar;
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.p.k.AnonymousClass1 */

            /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.tencent.mm.plugin.appbrand.jsapi.p.k */
            /* JADX WARN: Multi-variable type inference failed */
            public final void run() {
                AppMethodBeat.i(134883);
                ac i2 = df.i(dVar);
                if (i2 == null) {
                    dVar.i(i2, k.this.h("fail:page don't exist", null));
                    AppMethodBeat.o(134883);
                    return;
                }
                Object S = i2.S(k.this.aWC);
                if (S != null) {
                    k.this.a(dVar, jSONObject, i2, S);
                    AppMethodBeat.o(134883);
                } else if (!i2.isRunning()) {
                    dVar.i(i2, k.this.h("fail:interrupted", null));
                    AppMethodBeat.o(134883);
                } else if (i2.kAU) {
                    IllegalAccessError illegalAccessError = new IllegalAccessError(String.format("%s Not Found", k.this.aWC.getName()));
                    AppMethodBeat.o(134883);
                    throw illegalAccessError;
                } else {
                    dVar.i(i2, k.this.h("fail:not supported", null));
                    AppMethodBeat.o(134883);
                }
            }
        };
        if ((dVar instanceof ac) || !dVar.getRuntime().bry()) {
            r0.run();
        } else {
            dVar.getRuntime().O(r0);
        }
    }

    protected k(Class<Extension> cls) {
        this.aWC = cls;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }
}
