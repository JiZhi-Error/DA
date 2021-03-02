package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.file.h;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public abstract class g implements i {
    p lUM;

    /* access modifiers changed from: package-private */
    public abstract i.a a(f fVar, String str, JSONObject jSONObject);

    g() {
    }

    static {
        h.a.init();
    }

    public final i.a e(f fVar, JSONObject jSONObject) {
        String V = V(jSONObject);
        if (Util.isNullOrNil(V)) {
            return new i.a("fail invalid path", new Object[0]);
        }
        if (fVar.bsV() || fVar.isRunning()) {
            return a(fVar, V, jSONObject);
        }
        return new i.a("fail:interrupted", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public String V(JSONObject jSONObject) {
        String optString = jSONObject.optString("filePath", null);
        if (Util.isNullOrNil(optString)) {
            optString = jSONObject.optString("dirPath", null);
        }
        if (Util.isNullOrNil(optString)) {
            return jSONObject.optString("path", null);
        }
        return optString;
    }
}
