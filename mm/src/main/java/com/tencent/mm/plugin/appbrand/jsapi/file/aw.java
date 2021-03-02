package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import org.json.JSONObject;

final class aw extends g {
    aw() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        String format;
        AppMethodBeat.i(128907);
        if (fVar.getFileSystem().Vj(str) == m.OK) {
            format = "ok";
        } else {
            format = String.format("fail no such file or directory \"%s\"", str);
        }
        i.a aVar = new i.a(format, new Object[0]);
        AppMethodBeat.o(128907);
        return aVar;
    }
}
