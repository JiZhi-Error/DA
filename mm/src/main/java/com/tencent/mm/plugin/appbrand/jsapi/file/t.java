package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t extends d {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(128881);
        e.lUJ.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.file.t.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(128880);
                if (!fVar.isRunning()) {
                    AppMethodBeat.o(128880);
                    return;
                }
                List<? extends q.a> bxs = fVar.getFileSystem().bxs();
                JSONArray jSONArray = new JSONArray();
                if (bxs != null && bxs.size() > 0) {
                    for (q.a aVar : bxs) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("filePath", aVar.getFileName());
                            jSONObject.put("size", aVar.bxm());
                            jSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(aVar.lastModified()));
                            jSONArray.put(jSONObject);
                        } catch (Exception e2) {
                        }
                    }
                }
                HashMap hashMap = new HashMap(1);
                hashMap.put("fileList", jSONArray);
                fVar.i(i2, t.this.n("ok", hashMap));
                AppMethodBeat.o(128880);
            }
        });
        AppMethodBeat.o(128881);
    }
}
