package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.o.b {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTask";
    private a mgQ = new a(this.mgb);

    public b() {
        AppMethodBeat.i(179543);
        AppMethodBeat.o(179543);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179544);
        String bjl = this.mgQ.bjl();
        AppMethodBeat.o(179544);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179545);
        this.mgQ.a(fVar, jSONObject, str);
        AppMethodBeat.o(179545);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "uploadTaskId";
    }
}
