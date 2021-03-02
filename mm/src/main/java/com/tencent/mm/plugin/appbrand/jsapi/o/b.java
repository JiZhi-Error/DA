package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class b extends ab<f> implements h {
    protected a mgb = new a();

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        if (!BuildInfo.DEBUG) {
            return a(fVar, jSONObject, fVar.getJsRuntime());
        }
        throw new RuntimeException("Should call 3 params version!");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(final f fVar, final JSONObject jSONObject, o oVar) {
        final String bjl = bjl();
        HashMap hashMap = new HashMap();
        hashMap.put(auJ(), bjl);
        this.mgb.a(bjl, oVar);
        fVar.getAsyncHandler().post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(144184);
                b.this.a(fVar, jSONObject, bjl);
                AppMethodBeat.o(144184);
            }
        });
        return n("ok", hashMap);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
