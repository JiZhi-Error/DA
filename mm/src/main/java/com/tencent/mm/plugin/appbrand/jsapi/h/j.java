package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.luggage.h.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.d.h;
import org.json.JSONObject;

public final class j extends i {
    private static final int CTRL_INDEX = 111;
    private static final String NAME = "updateTextArea";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.h.i
    public final /* bridge */ /* synthetic */ void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136296);
        super.a(acVar, jSONObject, i2);
        AppMethodBeat.o(136296);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.widget.input.d.f, org.json.JSONObject, com.tencent.mm.plugin.appbrand.page.ac, int] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.a
    public final /* synthetic */ boolean a(h hVar, JSONObject jSONObject, ac acVar, int i2) {
        Boolean aL;
        AppMethodBeat.i(136295);
        h hVar2 = hVar;
        boolean a2 = super.a(hVar2, jSONObject, acVar, i2);
        hVar2.oya = Boolean.TRUE;
        Object opt = jSONObject.opt("confirm");
        if (opt == null) {
            aL = null;
        } else {
            aL = e.aL(opt);
        }
        hVar2.oyb = aL;
        AppMethodBeat.o(136295);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.h.i
    public final void a(ac acVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(136294);
        super.a(acVar, jSONObject, i2);
        AppMethodBeat.o(136294);
    }
}
