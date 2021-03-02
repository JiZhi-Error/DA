package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class h<CONTEXT extends f> extends a<CONTEXT> {
    private static final int CTRL_INDEX = 340;
    private static final String NAME = "enableLocationUpdate";
    protected s lXb;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.f */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final /* bridge */ /* synthetic */ void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143630);
        super.a(fVar, jSONObject, i2);
        AppMethodBeat.o(143630);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.a
    public void d(CONTEXT context, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143628);
        Log.i("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate:%s", jSONObject);
        this.lXb = (s) context.aw(s.class);
        if (this.lXb == null) {
            this.lXb = r(context);
            this.lXb.start();
            context.a(this.lXb);
        }
        this.lXb.jkf = g(context, jSONObject);
        s sVar = this.lXb;
        sVar.jvO = false;
        sVar.sendMessage(1);
        context.i(i2, h("ok", null));
        AppMethodBeat.o(143628);
    }

    /* access modifiers changed from: protected */
    public s r(CONTEXT context) {
        AppMethodBeat.i(143629);
        s sVar = new s(context);
        AppMethodBeat.o(143629);
        return sVar;
    }

    /* access modifiers changed from: protected */
    public Bundle g(CONTEXT context, JSONObject jSONObject) {
        return null;
    }
}
