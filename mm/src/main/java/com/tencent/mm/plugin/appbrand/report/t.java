package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

public final class t {
    public static final t nHN = new t();

    static {
        AppMethodBeat.i(51027);
        AppMethodBeat.o(51027);
    }

    private t() {
    }

    public static /* synthetic */ String bUy() {
        AppMethodBeat.i(180651);
        String el = el(null);
        AppMethodBeat.o(180651);
        return el;
    }

    public static final String el(Context context) {
        AppMethodBeat.i(51026);
        if (context == null) {
            context = MMApplicationContext.getContext();
        }
        f.c dS = f.dS(context);
        switch (u.$EnumSwitchMapping$0[dS.ordinal()]) {
            case 1:
                AppMethodBeat.o(51026);
                return "offline";
            default:
                String str = dS.value;
                p.g(str, "type.value");
                AppMethodBeat.o(51026);
                return str;
        }
    }
}
