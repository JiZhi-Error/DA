package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class c extends d<f> implements h {
    protected a mgd = new a();

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        if (BuildInfo.DEBUG) {
            throw new RuntimeException("Should call 3 params version!");
        }
        a(fVar, jSONObject, i2, fVar.getJsRuntime());
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2, o oVar) {
        String bjl = bjl();
        HashMap hashMap = new HashMap();
        hashMap.put(auJ(), bjl);
        this.mgd.a(bjl, oVar);
        fVar.i(i2, n("ok", hashMap));
        a(fVar, jSONObject, bjl);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final boolean bEi() {
        return true;
    }
}
