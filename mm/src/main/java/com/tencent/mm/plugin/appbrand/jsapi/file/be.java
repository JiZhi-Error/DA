package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import org.json.JSONObject;

final class be extends g {
    be() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128924);
        m aj = fVar.getFileSystem().aj(str, jSONObject.optBoolean("recursive", false));
        switch (aj) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                i.a aVar = new i.a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(128924);
                return aVar;
            case ERR_DIR_NOT_EMPTY:
                i.a aVar2 = new i.a("fail directory not empty", new Object[0]);
                AppMethodBeat.o(128924);
                return aVar2;
            case ERR_PERMISSION_DENIED:
                i.a aVar3 = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128924);
                return aVar3;
            case OK:
                i.a aVar4 = new i.a("ok", new Object[0]);
                AppMethodBeat.o(128924);
                return aVar4;
            default:
                i.a aVar5 = new i.a("fail " + aj.name(), new Object[0]);
                AppMethodBeat.o(128924);
                return aVar5;
        }
    }
}
