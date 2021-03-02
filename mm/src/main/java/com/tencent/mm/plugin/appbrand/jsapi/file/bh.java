package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import org.json.JSONObject;

final class bh extends g {
    bh() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final i.a a(f fVar, String str, JSONObject jSONObject) {
        boolean z;
        o Wa;
        AppMethodBeat.i(128932);
        String optString = jSONObject.optString("targetDirectory", "");
        switch (fVar.getFileSystem().Vl(optString)) {
            case ERR_PERMISSION_DENIED:
            case ERR_IS_FILE:
            case ERR_OP_FAIL:
                i.a aVar = new i.a(String.format("fail permission denied, open \"%s\"", optString), new Object[0]);
                AppMethodBeat.o(128932);
                return aVar;
            default:
                o VY = fVar.getFileSystem().VY(str);
                if (VY == null || !VY.exists()) {
                    if (fVar.getFileSystem().Vj(str) != m.OK || (Wa = fVar.getFileSystem().Wa(URLEncoder.encode(str))) == null) {
                        z = false;
                    } else {
                        com.tencent.mm.plugin.appbrand.ac.i<ByteBuffer> iVar = new com.tencent.mm.plugin.appbrand.ac.i<>();
                        fVar.getFileSystem().b(str, iVar);
                        try {
                            Channels.newChannel(s.ap(Wa)).write(iVar.value);
                            VY = new o(aa.z(Wa.her()));
                            z = true;
                        } catch (IOException e2) {
                            Log.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", e2);
                            VY = null;
                            z = false;
                        }
                    }
                    if (VY == null) {
                        i.a aVar2 = new i.a("fail no such file \"%s\"", str);
                        AppMethodBeat.o(128932);
                        return aVar2;
                    }
                } else if (VY.isDirectory() || n.u(VY)) {
                    i.a aVar3 = new i.a("fail permission denied, open \"%s\"", str);
                    AppMethodBeat.o(128932);
                    return aVar3;
                } else {
                    z = false;
                }
                try {
                    m a2 = fVar.getFileSystem().a(optString, VY);
                    if (z) {
                        s.deleteFile(aa.z(VY.her()));
                    }
                    switch (a2) {
                        case ERR_PERMISSION_DENIED:
                            i.a aVar4 = new i.a("fail permission denied, open \"%s\"", str);
                            AppMethodBeat.o(128932);
                            return aVar4;
                        case ERR_IS_FILE:
                        case ERR_OP_FAIL:
                        default:
                            i.a aVar5 = new i.a("fail " + a2.name(), new Object[0]);
                            AppMethodBeat.o(128932);
                            return aVar5;
                        case ERR_PARENT_DIR_NOT_EXISTS:
                            i.a aVar6 = new i.a("fail no such file or directory, open \"%s\"", str);
                            AppMethodBeat.o(128932);
                            return aVar6;
                        case RET_ALREADY_EXISTS:
                            i.a aVar7 = new i.a("fail illegal operation on a filePath, open \"%s\"", str);
                            AppMethodBeat.o(128932);
                            return aVar7;
                        case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                            i.a aVar8 = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
                            AppMethodBeat.o(128932);
                            return aVar8;
                        case ERR_BAD_ZIP_FILE:
                            i.a aVar9 = new i.a("fail read zip data", new Object[0]);
                            AppMethodBeat.o(128932);
                            return aVar9;
                        case ERR_WRITE_ZIP_ENTRY:
                            i.a aVar10 = new i.a("fail write entry", new Object[0]);
                            AppMethodBeat.o(128932);
                            return aVar10;
                        case OK:
                            i.a aVar11 = new i.a("ok", new Object[0]);
                            AppMethodBeat.o(128932);
                            return aVar11;
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e3, "write zip stream", new Object[0]);
                    i.a aVar12 = new i.a("fail read zip data", new Object[0]);
                    AppMethodBeat.o(128932);
                    return aVar12;
                }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.g
    public final String V(JSONObject jSONObject) {
        AppMethodBeat.i(128933);
        String optString = jSONObject.optString("zipFilePath");
        AppMethodBeat.o(128933);
        return optString;
    }
}
