package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ay extends g {
    ay() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        m mVar;
        AppMethodBeat.i(128910);
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", str, optString);
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", str, optString);
        o VY = fVar.getFileSystem().VY(str);
        boolean VW = fVar.getFileSystem().VW(str);
        if (VY == null || !VY.exists() || !VY.isFile()) {
            if (!VW) {
                i.a aVar = new i.a(format2, new Object[0]);
                AppMethodBeat.o(128910);
                return aVar;
            }
            com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
            fVar.getFileSystem().b(str, iVar);
            if (iVar.value == null) {
                i.a aVar2 = new i.a(format, new Object[0]);
                AppMethodBeat.o(128910);
                return aVar2;
            }
            a aVar3 = new a(iVar.value);
            mVar = fVar.getFileSystem().a(optString, (InputStream) aVar3, false);
            Util.qualityClose(aVar3);
        } else if (n.u(VY)) {
            i.a aVar4 = new i.a("fail \"%s\" not a regular file", str);
            AppMethodBeat.o(128910);
            return aVar4;
        } else {
            mVar = fVar.getFileSystem().a(optString, VY, false);
        }
        switch (mVar) {
            case ERR_PERMISSION_DENIED:
                i.a aVar5 = new i.a(format2, new Object[0]);
                AppMethodBeat.o(128910);
                return aVar5;
            case ERR_PARENT_DIR_NOT_EXISTS:
                i.a aVar6 = new i.a(format, new Object[0]);
                AppMethodBeat.o(128910);
                return aVar6;
            case ERR_FS_NOT_MOUNTED:
                i.a aVar7 = new i.a("fail sdcard not mounted", new Object[0]);
                AppMethodBeat.o(128910);
                return aVar7;
            case RET_ALREADY_EXISTS:
                i.a aVar8 = new i.a("fail illegal operation on a directory, open \"%s\"", optString);
                AppMethodBeat.o(128910);
                return aVar8;
            case ERR_SYMLINK:
                i.a aVar9 = new i.a("fail \"%s\" is not a regular file", optString);
                AppMethodBeat.o(128910);
                return aVar9;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                i.a aVar10 = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                AppMethodBeat.o(128910);
                return aVar10;
            case OK:
                i.a aVar11 = new i.a("ok", new Object[0]);
                AppMethodBeat.o(128910);
                return aVar11;
            default:
                i.a aVar12 = new i.a("fail " + mVar.name(), new Object[0]);
                AppMethodBeat.o(128910);
                return aVar12;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final String V(JSONObject jSONObject) {
        AppMethodBeat.i(128911);
        String optString = jSONObject.optString("srcPath");
        AppMethodBeat.o(128911);
        return optString;
    }
}
