package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import java.util.Map;
import org.json.JSONObject;

public abstract class r {
    protected s kGT;
    private int lqe;
    private p lqf;
    protected ac lxR;
    protected JSONObject lxS;

    public r(p pVar, s sVar, ac acVar, JSONObject jSONObject, int i2) {
        if (pVar == null || sVar == null || jSONObject == null) {
            throw new IllegalArgumentException("JsApiAsyncRequest");
        }
        this.lqf = pVar;
        this.kGT = sVar;
        this.lxR = acVar;
        this.lqe = i2;
        this.lxS = jSONObject;
    }

    public final s NY() {
        return this.kGT;
    }

    public final JSONObject bEj() {
        return this.lxS;
    }

    /* access modifiers changed from: protected */
    public final void J(Map<String, ? extends Object> map) {
        this.kGT.i(this.lqe, this.lqf.n("ok", map));
    }

    /* access modifiers changed from: protected */
    public final void o(String str, Map<String, ? extends Object> map) {
        this.kGT.i(this.lqe, this.lqf.n(str, map));
    }
}
