package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

final class ax extends bi {
    ax() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.bi, com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128908);
        try {
            jSONObject.put("append", true);
            i.a a2 = super.a(fVar, str, jSONObject);
            AppMethodBeat.o(128908);
            return a2;
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.UnitAppendFile", "call with path(%s), put append fail ex = %s", str, e2);
            i.a aVar = new i.a("fail " + m.ERR_OP_FAIL.name(), new Object[0]);
            AppMethodBeat.o(128908);
            return aVar;
        }
    }
}
