package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class s extends d {
    private static final int CTRL_INDEX = 116;
    private static final String NAME = "getSavedFileInfo";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(128879);
        final String optString = jSONObject.optString("filePath", "");
        if (Util.isNullOrNil(optString)) {
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(128879);
            return;
        }
        e.lUJ.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.s.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(128878);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(128878);
                    return;
                }
                o VY = fVar.getFileSystem().VY(optString);
                if (VY == null) {
                    fVar.i(i2, s.this.h(String.format(Locale.US, "fail no such file \"%s\"", optString), null));
                    AppMethodBeat.o(128878);
                    return;
                }
                HashMap hashMap = new HashMap(3);
                hashMap.put("size", Long.valueOf(VY.length()));
                hashMap.put("createTime", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(VY.lastModified())));
                fVar.i(i2, s.this.n("ok", hashMap));
                AppMethodBeat.o(128878);
            }
        });
        AppMethodBeat.o(128879);
    }
}
