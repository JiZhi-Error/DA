package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.protocal.protobuf.evi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

@Deprecated
public final class s extends c implements j {
    private m cBt;
    private o cvW;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final i Oo() {
        AppMethodBeat.i(44952);
        this.cvW = new o();
        o oVar = this.cvW;
        AppMethodBeat.o(44952);
        return oVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.luggage.sdk.b.a.c.d
    public final void i(int i2, String str) {
        AppMethodBeat.i(44953);
        if (Util.isNullOrNil(str)) {
            str = "{}";
        }
        this.cvW.ad(i2, str);
        AppMethodBeat.o(44953);
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.service.c
    public final void MC() {
        AppMethodBeat.i(44954);
        bta();
        AppMethodBeat.o(44954);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.f, com.tencent.luggage.sdk.b.a.c.d
    public final boolean dt(String str) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.service.c
    public final void d(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(44955);
        super.d(appBrandRuntime);
        bEb();
        if (v.liX != null) {
            this.cBt = v.liX;
            v.liX = null;
        } else {
            this.cBt = new m();
        }
        this.cBt.a(this, getRuntime().bsC().extInfo);
        this.cvW.a(this.cBt);
        AppMethodBeat.o(44955);
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final String Mh() {
        AppMethodBeat.i(44957);
        JSONObject Or = Or();
        String format = String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", Or.toString(), getRuntime().getAppConfig().lcc);
        AppMethodBeat.o(44957);
        return format;
    }

    @Override // com.tencent.mm.plugin.appbrand.debugger.j
    public final void ds(String str) {
        AppMethodBeat.i(44958);
        Log.d("MicroMsg.RemoteDebugService", "RemoteDebugInfo");
        evi evi = new evi();
        evi.Ntn = getRuntime().bsD().getCurrentPage().getCurrentPageView().getComponentId();
        evi.Ntm = str;
        this.cvW.a(v.a(evi, this.cBt, "domEvent"));
        AppMethodBeat.o(44958);
    }
}
