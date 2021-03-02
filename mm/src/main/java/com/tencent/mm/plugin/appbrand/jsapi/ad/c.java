package com.tencent.mm.plugin.appbrand.jsapi.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;

public final class c extends p.a {
    public static final c mFz = new c("ok", new Object[0]);

    static {
        AppMethodBeat.i(137894);
        AppMethodBeat.o(137894);
    }

    public c(String str, Object... objArr) {
        super(str, objArr);
    }

    public final String toString() {
        AppMethodBeat.i(137893);
        String str = "VoiceCallResult{errMsg='" + this.errMsg + '\'' + '}';
        AppMethodBeat.o(137893);
        return str;
    }
}
