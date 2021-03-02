package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import org.json.JSONObject;

final class az extends g {
    az() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(128913);
        m Vl = fVar.getFileSystem().Vl(str);
        switch (Vl) {
            case RET_NOT_EXISTS:
                i.a aVar = new i.a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(128913);
                return aVar;
            case OK:
            case ERR_IS_FILE:
                i.a aVar2 = new i.a("ok", new Object[0]);
                if (Vl != m.OK) {
                    z = false;
                }
                i.a q = aVar2.q("result", Boolean.valueOf(z));
                AppMethodBeat.o(128913);
                return q;
            default:
                i.a aVar3 = new i.a("fail " + Vl.name(), new Object[0]);
                AppMethodBeat.o(128913);
                return aVar3;
        }
    }
}
