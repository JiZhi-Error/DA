package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class ah extends d {
    private static final int CTRL_INDEX = 117;
    private static final String NAME = "removeSavedFile";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        String str;
        AppMethodBeat.i(128891);
        String optString = jSONObject.optString("filePath", "");
        if (Util.isNullOrNil(optString)) {
            str = "fail:invalid data";
        } else if (!fVar.getFileSystem().Wb(optString)) {
            str = "fail not a store filePath";
        } else {
            str = fVar.getFileSystem().VY(optString).delete() ? "ok" : "fail";
        }
        fVar.i(i2, h(str, null));
        AppMethodBeat.o(128891);
    }
}
