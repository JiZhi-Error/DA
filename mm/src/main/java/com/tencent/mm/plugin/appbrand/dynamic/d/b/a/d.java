package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import org.json.JSONObject;

public final class d extends a {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final /* synthetic */ DrawCanvasArg d(JSONObject jSONObject, String str) {
        AppMethodBeat.i(121379);
        DrawCanvasArg c2 = c(jSONObject, str);
        AppMethodBeat.o(121379);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a
    public final DrawCanvasArg c(JSONObject jSONObject, String str) {
        AppMethodBeat.i(121378);
        DrawCanvasArg c2 = super.d(jSONObject, str);
        c2.h(jSONObject.optJSONArray("actions"));
        AppMethodBeat.o(121378);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.b.a.e
    public final int bCe() {
        return 0;
    }
}
