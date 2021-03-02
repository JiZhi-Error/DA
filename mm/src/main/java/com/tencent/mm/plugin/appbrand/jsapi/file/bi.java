package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.h;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

class bi extends g {
    bi() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public i.a a(f fVar, String str, JSONObject jSONObject) {
        InputStream byteArrayInputStream;
        h hVar;
        AppMethodBeat.i(128935);
        boolean optBoolean = jSONObject.optBoolean("append", false);
        String optString = jSONObject.optString("encoding");
        x.a(fVar.getJsRuntime(), null, jSONObject, (x.a) fVar.av(x.a.class));
        Object opt = jSONObject.opt("data");
        if (opt instanceof String) {
            if (Util.isNullOrNil(optString)) {
                hVar = h.a.lUN.get("utf8");
            } else {
                h hVar2 = h.a.lUN.get(optString.toLowerCase());
                if (hVar2 == null) {
                    i.a aVar = new i.a("fail invalid encoding", new Object[0]);
                    AppMethodBeat.o(128935);
                    return aVar;
                }
                hVar = hVar2;
            }
            try {
                byteArrayInputStream = new a(hVar.ZL((String) opt));
            } catch (Exception e2) {
                i.a aVar2 = new i.a("fail " + e2.getMessage(), new Object[0]);
                AppMethodBeat.o(128935);
                return aVar2;
            }
        } else if (opt instanceof ByteBuffer) {
            byteArrayInputStream = new a((ByteBuffer) opt);
        } else if (opt != null) {
            i.a aVar3 = new i.a("fail invalid data", new Object[0]);
            AppMethodBeat.o(128935);
            return aVar3;
        } else if (optBoolean) {
            i.a aVar4 = new i.a("ok", new Object[0]);
            AppMethodBeat.o(128935);
            return aVar4;
        } else {
            byteArrayInputStream = new ByteArrayInputStream(new byte[0]);
        }
        m a2 = fVar.getFileSystem().a(str, byteArrayInputStream, optBoolean);
        switch (a2) {
            case ERR_PARENT_DIR_NOT_EXISTS:
                i.a aVar5 = new i.a("fail no such file or directory, open \"%s\"", str);
                AppMethodBeat.o(128935);
                return aVar5;
            case RET_NOT_EXISTS:
                i.a aVar6 = new i.a("fail no such file \"%s\"", str);
                AppMethodBeat.o(128935);
                return aVar6;
            case RET_ALREADY_EXISTS:
                i.a aVar7 = new i.a("fail illegal operation on a directory, open \"%s\"", str);
                AppMethodBeat.o(128935);
                return aVar7;
            case ERR_PERMISSION_DENIED:
                i.a aVar8 = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128935);
                return aVar8;
            case ERR_SYMLINK:
                i.a aVar9 = new i.a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(128935);
                return aVar9;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                i.a aVar10 = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.o(128935);
                return aVar10;
            case OK:
                i.a aVar11 = new i.a("ok", new Object[0]);
                AppMethodBeat.o(128935);
                return aVar11;
            default:
                i.a aVar12 = new i.a("fail " + a2.name(), new Object[0]);
                AppMethodBeat.o(128935);
                return aVar12;
        }
    }
}
