package com.tinkerboots.sdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public final Map<String, String> SKH = new HashMap();

    public a() {
        AppMethodBeat.i(3440);
        AppMethodBeat.o(3440);
    }

    public final a oo(String str, String str2) {
        AppMethodBeat.i(3441);
        this.SKH.put(str, str2);
        AppMethodBeat.o(3441);
        return this;
    }
}
