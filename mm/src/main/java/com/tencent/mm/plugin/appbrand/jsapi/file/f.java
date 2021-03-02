package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.g;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import org.json.JSONObject;

abstract class f<T extends g> extends ab {
    private final T lUI;

    public f(T t) {
        this.lUI = t;
        this.lUI.lUM = this;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject) {
        i.a e2 = this.lUI.e(fVar, jSONObject);
        return a(fVar, e2.errMsg, e2.values);
    }
}
