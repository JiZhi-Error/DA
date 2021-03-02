package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class h extends d {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "openFinderProfile";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163962);
        if (!(fVar.getContext() instanceof Activity)) {
            fVar.i(i2, "fail");
            AppMethodBeat.o(163962);
        } else if (jSONObject == null) {
            fVar.i(i2, "fail:data is null");
            AppMethodBeat.o(163962);
        } else {
            String optString = jSONObject.optString(ch.COL_USERNAME, "");
            if (Util.isNullOrNil(optString)) {
                fVar.i(i2, "fail:username is null");
                AppMethodBeat.o(163962);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("finder_username", optString);
            a aVar = a.vUU;
            a.enterFinderProfileUI(fVar.getContext(), intent);
            AppMethodBeat.o(163962);
        }
    }
}
