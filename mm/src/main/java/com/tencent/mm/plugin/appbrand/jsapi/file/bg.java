package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import org.json.JSONObject;

final class bg extends g {
    bg() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128930);
        m VX = fVar.getFileSystem().VX(str);
        switch (VX) {
            case ERR_PERMISSION_DENIED:
                i.a aVar = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128930);
                return aVar;
            case RET_NOT_EXISTS:
                i.a aVar2 = new i.a("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(128930);
                return aVar2;
            case ERR_IS_DIRECTORY:
                i.a aVar3 = new i.a("fail operation not permitted, unlink \"%s\"", str);
                AppMethodBeat.o(128930);
                return aVar3;
            case OK:
                i.a aVar4 = new i.a("ok", new Object[0]);
                AppMethodBeat.o(128930);
                return aVar4;
            default:
                i.a aVar5 = new i.a("fail " + VX.name(), new Object[0]);
                AppMethodBeat.o(128930);
                return aVar5;
        }
    }
}
