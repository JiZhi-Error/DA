package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f {
    public static boolean a(p pVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppBrandRuntime appBrandRuntime;
        String str;
        AppMethodBeat.i(177123);
        if (!pVar.getName().contains("operate")) {
            AppMethodBeat.o(177123);
            return false;
        }
        String optString = jSONObject.optString("type");
        if (Util.isNullOrNil(optString)) {
            AppMethodBeat.o(177123);
            return false;
        } else if (!optString.equalsIgnoreCase("exitPictureInPicture")) {
            AppMethodBeat.o(177123);
            return false;
        } else {
            if (fVar instanceof k) {
                appBrandRuntime = ((k) fVar).getRuntime();
            } else {
                appBrandRuntime = null;
            }
            if (appBrandRuntime == null) {
                fVar.i(i2, pVar.h("fail", null));
                AppMethodBeat.o(177123);
                return true;
            }
            com.tencent.mm.plugin.appbrand.pip.f fVar2 = appBrandRuntime.kAQ;
            if (fVar2 == null) {
                fVar.i(i2, pVar.h("fail", null));
                AppMethodBeat.o(177123);
                return true;
            }
            if (fVar2.yV(jSONObject.optInt("viewId"))) {
                str = "ok";
            } else {
                str = "fail";
            }
            fVar.i(i2, pVar.h(str, null));
            AppMethodBeat.o(177123);
            return true;
        }
    }
}
