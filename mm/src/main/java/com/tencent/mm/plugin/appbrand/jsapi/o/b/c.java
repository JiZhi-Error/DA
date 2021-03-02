package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.d;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.o.c {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTaskAsync";
    private final a mgN;

    public c(int i2, d.b bVar) {
        AppMethodBeat.i(179531);
        this.mgN = new a(i2, bVar, this.mgd);
        AppMethodBeat.o(179531);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179532);
        String bjl = this.mgN.bjl();
        AppMethodBeat.o(179532);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179533);
        this.mgN.a(fVar, jSONObject, str);
        AppMethodBeat.o(179533);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "requestTaskId";
    }
}
