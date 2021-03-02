package com.tencent.mm.plugin.appbrand.g.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public b lll = new b();
    public String value;

    public a() {
        AppMethodBeat.i(159022);
        AppMethodBeat.o(159022);
    }

    public final String getValue() {
        return this.value;
    }

    public final String Yh(String str) {
        AppMethodBeat.i(159023);
        String str2 = this.lll.get(str);
        AppMethodBeat.o(159023);
        return str2;
    }

    public final String toString() {
        AppMethodBeat.i(159024);
        String str = this.value + ", attrs:" + this.lll.toString() + "\n";
        AppMethodBeat.o(159024);
        return str;
    }
}
