package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.b;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.o.c {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTaskAsync";
    private final a mgF;

    public c(b.AbstractC0793b bVar) {
        AppMethodBeat.i(179516);
        this.mgF = new a(bVar, this.mgd);
        AppMethodBeat.o(179516);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179517);
        String bjl = this.mgF.bjl();
        AppMethodBeat.o(179517);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179518);
        this.mgF.a(fVar, jSONObject, str);
        AppMethodBeat.o(179518);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "downloadTaskId";
    }
}
