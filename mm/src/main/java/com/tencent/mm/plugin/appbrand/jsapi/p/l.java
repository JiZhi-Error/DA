package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

@Deprecated
public abstract class l<CONTEXT extends f, EXTENSION> extends ab<CONTEXT> {
    private final Class<EXTENSION> aWC;

    /* access modifiers changed from: protected */
    public abstract String a(CONTEXT context, JSONObject jSONObject, EXTENSION extension);

    protected l(Class<EXTENSION> cls) {
        this.aWC = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.tencent.mm.plugin.appbrand.jsapi.p.l<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.f, EXTENSION> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(CONTEXT context, JSONObject jSONObject) {
        ac i2 = df.i(context);
        if (i2 == null) {
            return h("fail:page don't exist", null);
        }
        if (jSONObject == null) {
            return h("fail:invalid data", null);
        }
        Object S = i2.S(this.aWC);
        if (S != null) {
            return a(context, jSONObject, S);
        }
        if (!i2.isRunning()) {
            return h("fail:interrupted", null);
        }
        if (!i2.kAU) {
            return h("fail:not supported", null);
        }
        throw new IllegalAccessError(String.format("%s Not Found", this.aWC.getName()));
    }
}
