package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.vfs.o;
import java.util.Locale;
import org.json.JSONObject;

final class bd extends g {
    bd() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        AppMethodBeat.i(128921);
        q fileSystem = fVar.getFileSystem();
        if (fileSystem == null) {
            i.a aVar = new i.a("fail:internal error", new Object[0]);
            AppMethodBeat.o(128921);
            return aVar;
        }
        String optString = jSONObject.optString("newPath");
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", str, optString);
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", str, optString);
        if (!fileSystem.VZ(str)) {
            i.a aVar2 = new i.a(format2, new Object[0]);
            AppMethodBeat.o(128921);
            return aVar2;
        }
        o ag = fVar.getFileSystem().ag(str, true);
        if (ag == null || !ag.exists()) {
            i.a aVar3 = new i.a(format, new Object[0]);
            AppMethodBeat.o(128921);
            return aVar3;
        } else if (n.u(ag)) {
            i.a aVar4 = new i.a("fail \"%s\" not a regular file", str);
            AppMethodBeat.o(128921);
            return aVar4;
        } else {
            m a2 = fVar.getFileSystem().a(optString, ag, true);
            switch (a2) {
                case ERR_PERMISSION_DENIED:
                    i.a aVar5 = new i.a(format2, new Object[0]);
                    AppMethodBeat.o(128921);
                    return aVar5;
                case ERR_PARENT_DIR_NOT_EXISTS:
                    i.a aVar6 = new i.a(format, new Object[0]);
                    AppMethodBeat.o(128921);
                    return aVar6;
                case ERR_FS_NOT_MOUNTED:
                    i.a aVar7 = new i.a("fail sdcard not mounted", new Object[0]);
                    AppMethodBeat.o(128921);
                    return aVar7;
                case OK:
                    i.a aVar8 = new i.a("ok", new Object[0]);
                    AppMethodBeat.o(128921);
                    return aVar8;
                default:
                    i.a aVar9 = new i.a("fail " + a2.name(), new Object[0]);
                    AppMethodBeat.o(128921);
                    return aVar9;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final String V(JSONObject jSONObject) {
        AppMethodBeat.i(128922);
        String optString = jSONObject.optString("oldPath");
        AppMethodBeat.o(128922);
        return optString;
    }
}
