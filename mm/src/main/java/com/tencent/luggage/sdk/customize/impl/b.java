package com.tencent.luggage.sdk.customize.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p;

public class b implements p.a {
    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public String Nv() {
        return " Luggage/";
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.p.a
    public final String version() {
        AppMethodBeat.i(139820);
        AppMethodBeat.o(139820);
        return "unknown";
    }
}
