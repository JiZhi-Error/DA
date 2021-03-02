package com.tencent.mm.plugin.appbrand.jsapi.o.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.d;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.o.b {
    public static final int CTRL_INDEX = 242;
    public static final String NAME = "createRequestTask";
    private final a mgN;

    public b(int i2, d.b bVar) {
        AppMethodBeat.i(179528);
        this.mgN = new a(i2, bVar, this.mgb);
        AppMethodBeat.o(179528);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179529);
        String bjl = this.mgN.bjl();
        AppMethodBeat.o(179529);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179530);
        this.mgN.a(fVar, jSONObject, str);
        AppMethodBeat.o(179530);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "requestTaskId";
    }
}
