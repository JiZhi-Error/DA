package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.n.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import org.json.JSONObject;

public final class ab implements g {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.g
    public final h c(f fVar, JSONObject jSONObject) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(43977);
        if (fVar instanceof ac) {
            if (jSONObject != null) {
                z = jSONObject.optInt("dest", 0) == 2;
            } else {
                z = false;
            }
            if (z) {
                a bRo = ((ac) fVar).bRo();
                AppMethodBeat.o(43977);
                return bRo;
            }
        }
        if (fVar instanceof h) {
            h hVar = (h) fVar;
            AppMethodBeat.o(43977);
            return hVar;
        } else if (fVar instanceof s) {
            if (jSONObject == null) {
                z2 = false;
            } else if (jSONObject.optInt("dest", 0) != 1) {
                z2 = false;
            }
            if (z2) {
                s sVar = (s) fVar;
                if (sVar.kEi != null) {
                    com.tencent.mm.plugin.appbrand.ad.g gVar = sVar.kEi;
                    AppMethodBeat.o(43977);
                    return gVar;
                }
                sVar.kEi = new com.tencent.mm.plugin.appbrand.ad.g(sVar);
                com.tencent.mm.plugin.appbrand.ad.g gVar2 = sVar.kEi;
                AppMethodBeat.o(43977);
                return gVar2;
            }
            ac currentPageView = ((s) fVar).getCurrentPageView();
            AppMethodBeat.o(43977);
            return currentPageView;
        } else {
            AppMethodBeat.o(43977);
            return null;
        }
    }
}
