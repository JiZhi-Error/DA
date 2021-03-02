package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class c extends d {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";
    private final d lRY = new d();

    public c() {
        AppMethodBeat.i(137497);
        AppMethodBeat.o(137497);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137498);
        this.lRY.a(fVar, jSONObject, i2);
        AppMethodBeat.o(137498);
    }

    public static String Ts(String str) {
        AppMethodBeat.i(137499);
        if (str == null) {
            AppMethodBeat.o(137499);
            return null;
        }
        String replaceAll = str.replaceAll("\\D", "");
        if (replaceAll.startsWith("86")) {
            replaceAll = replaceAll.substring(2);
        }
        AppMethodBeat.o(137499);
        return replaceAll;
    }
}
