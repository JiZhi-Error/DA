package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.h;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class bc extends g {
    bc() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        h hVar;
        m b2;
        AppMethodBeat.i(128919);
        String optString = jSONObject.optString("encoding");
        Log.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", str, optString);
        if (Util.isNullOrNil(optString)) {
            hVar = null;
        } else {
            h hVar2 = h.a.lUN.get(optString.toLowerCase());
            if (hVar2 == null) {
                i.a aVar = new i.a("fail invalid encoding", new Object[0]);
                AppMethodBeat.o(128919);
                return aVar;
            }
            hVar = hVar2;
        }
        long j2 = Long.MIN_VALUE;
        long j3 = Long.MIN_VALUE;
        if (jSONObject.has("position") || jSONObject.has("length")) {
            j2 = jSONObject.optLong("position", 0);
            j3 = jSONObject.optLong("length", MAlarmHandler.NEXT_FIRE_INTERVAL);
        }
        com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
        if (j2 == Long.MIN_VALUE || j3 == Long.MIN_VALUE) {
            b2 = fVar.getFileSystem().b(str, iVar);
        } else {
            b2 = fVar.getFileSystem().a(str, j2, j3, iVar);
        }
        if (b2 == m.OK) {
            T n = hVar == null ? iVar.value : hVar.n(iVar.value);
            if (!(n instanceof ByteBuffer)) {
                a.i(iVar.value);
            }
            i.a q = new i.a("ok", new Object[0]).q("data", n);
            AppMethodBeat.o(128919);
            return q;
        }
        switch (b2) {
            case RET_NOT_EXISTS:
                i.a aVar2 = new i.a("fail no such file \"%s\"", str);
                AppMethodBeat.o(128919);
                return aVar2;
            case ERR_PERMISSION_DENIED:
                i.a aVar3 = new i.a("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(128919);
                return aVar3;
            case ERR_SYMLINK:
                i.a aVar4 = new i.a("fail \"%s\" is not a regular file", str);
                AppMethodBeat.o(128919);
                return aVar4;
            case ERR_ILLEGAL_READ_POSITION:
                i.a aVar5 = new i.a("fail the value of \"position\" is out of range", new Object[0]);
                AppMethodBeat.o(128919);
                return aVar5;
            case ERR_ILLEGAL_READ_LENGTH:
                i.a aVar6 = new i.a("fail the value of \"length\" is out of range", new Object[0]);
                AppMethodBeat.o(128919);
                return aVar6;
            default:
                i.a aVar7 = new i.a("fail " + b2.name(), new Object[0]);
                AppMethodBeat.o(128919);
                return aVar7;
        }
    }
}
