package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

/* access modifiers changed from: package-private */
public final class aa implements g {
    aa() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.g
    public final h c(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(134624);
        if (fVar instanceof h) {
            h hVar = (h) fVar;
            AppMethodBeat.o(134624);
            return hVar;
        } else if (fVar instanceof s) {
            ac currentPageView = ((s) fVar).getCurrentPageView();
            AppMethodBeat.o(134624);
            return currentPageView;
        } else {
            AppMethodBeat.o(134624);
            return null;
        }
    }
}
