package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;
import org.json.JSONObject;

public final class b extends a {
    public b(int i2) {
        super(f.NAME, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, Bundle bundle, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121308);
        c.cP(d.G(jSONObject), "before_jsapi_invoke");
        ad.b ayQ = aVar.ayQ();
        String string = ayQ.getString("__page_view_id", null);
        String string2 = ayQ.getString("__process_name", MMApplicationContext.getProcessName());
        int i2 = ayQ.getInt("__draw_strategy", 0);
        if (com.tencent.mm.plugin.appbrand.dynamic.d.bBH().Yi(string) == null) {
            Log.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", string);
            aVar2.bt(a(false, "got 'null' when get view by the given viewId", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121308);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.d.b.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
        bVar.a(string2, string, jSONObject, this, aVar2, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH(string, i2), bundle != null ? bundle.getString("rawJsapiData") : new StringBuilder().append(System.currentTimeMillis()).toString());
        com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bH(string, i2).a(bVar);
        AppMethodBeat.o(121308);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
    }
}
