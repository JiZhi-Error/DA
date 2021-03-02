package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.b;
import org.json.JSONObject;

public class b extends com.tencent.mm.plugin.appbrand.jsapi.o.b {
    public static final int CTRL_INDEX = 269;
    public static final String NAME = "createDownloadTask";
    private final a mgF;

    public b(b.AbstractC0793b bVar) {
        AppMethodBeat.i(179512);
        this.mgF = a(bVar);
        AppMethodBeat.o(179512);
    }

    /* access modifiers changed from: protected */
    public a a(b.AbstractC0793b bVar) {
        AppMethodBeat.i(179513);
        a aVar = new a(bVar, this.mgb);
        AppMethodBeat.o(179513);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String bjl() {
        AppMethodBeat.i(179514);
        String bjl = this.mgF.bjl();
        AppMethodBeat.o(179514);
        return bjl;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final void a(f fVar, JSONObject jSONObject, String str) {
        AppMethodBeat.i(179515);
        this.mgF.a(fVar, jSONObject, str);
        AppMethodBeat.o(179515);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.h
    public final String auJ() {
        return "downloadTaskId";
    }
}
