package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class am extends d {
    public static final int CTRL_INDEX = 51;
    public static final String NAME = "saveFile";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(128898);
        e.lUJ.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.am.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(128896);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(128896);
                    return;
                }
                p.a f2 = am.f(fVar, jSONObject);
                fVar.i(i2, am.this.n(f2.errMsg, f2.values));
                AppMethodBeat.o(128896);
            }
        });
        AppMethodBeat.o(128898);
    }

    static p.a f(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(128899);
        String optString = jSONObject.optString("tempFilePath");
        String optString2 = jSONObject.optString("filePath");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
            p.a aVar = new p.a("fail", new Object[0]);
            AppMethodBeat.o(128899);
            return aVar;
        }
        o VY = fVar.getFileSystem().VY(optString);
        if (VY == null || !VY.exists()) {
            p.a aVar2 = new p.a("fail tempFilePath file not exist", new Object[0]);
            AppMethodBeat.o(128899);
            return aVar2;
        }
        i iVar = new i();
        String a2 = a(fVar, VY, optString2, iVar);
        HashMap hashMap = new HashMap();
        if ("ok".equals(a2)) {
            hashMap.put("savedFilePath", iVar.value);
        }
        p.a I = new p.a(a2, new Object[0]).I(hashMap);
        AppMethodBeat.o(128899);
        return I;
    }

    public static String a(f fVar, o oVar, String str, i<String> iVar) {
        AppMethodBeat.i(170099);
        if (oVar == null || !oVar.exists()) {
            AppMethodBeat.o(170099);
            return "fail:file not exists";
        }
        m Vl = fVar.getFileSystem().Vl(str);
        if (Vl != m.OK) {
            try {
                i<String> iVar2 = new i<>();
                Vl = fVar.getFileSystem().a(oVar, str, iVar2);
                if (iVar != null) {
                    iVar.value = iVar2.value;
                }
            } catch (Exception e2) {
                String str2 = "fail:writeFile exception: " + e2.toString();
                AppMethodBeat.o(170099);
                return str2;
            }
        }
        switch (Vl) {
            case ERR_PERMISSION_DENIED:
                String format = String.format("fail permission denied, open \"%s\"", str);
                AppMethodBeat.o(170099);
                return format;
            case ERR_PARENT_DIR_NOT_EXISTS:
                String format2 = String.format("fail no such file or directory \"%s\"", str);
                AppMethodBeat.o(170099);
                return format2;
            case ERR_IS_DIRECTORY:
                String format3 = String.format("fail illegal operation on a directory, open \"%s\"", str);
                AppMethodBeat.o(170099);
                return format3;
            case ERR_EXCEED_DIRECTORY_MAX_SIZE:
                AppMethodBeat.o(170099);
                return "fail the maximum size of the file storage limit is exceeded";
            case OK:
                AppMethodBeat.o(170099);
                return "ok";
            default:
                String str3 = "fail " + Vl.name();
                AppMethodBeat.o(170099);
                return str3;
        }
    }
}
