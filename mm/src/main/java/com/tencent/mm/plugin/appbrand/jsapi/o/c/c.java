package com.tencent.mm.plugin.appbrand.jsapi.o.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.o.c {
    public static final int CTRL_INDEX = 272;
    public static final String NAME = "createUploadTaskAsync";
    private a mgQ = new a(this.mgd);

    public c() {
        AppMethodBeat.i(179546);
        AppMethodBeat.o(179546);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179547);
        String bjl = this.mgQ.bjl();
        AppMethodBeat.o(179547);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179548);
        this.mgQ.a(fVar, jSONObject, str);
        AppMethodBeat.o(179548);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "uploadTaskId";
    }
}
