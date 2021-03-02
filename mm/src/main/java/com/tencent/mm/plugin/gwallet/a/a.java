package com.tencent.mm.plugin.gwallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends Exception {
    c yhk;

    private a(c cVar) {
        this(cVar, (Exception) null);
    }

    public a(int i2, String str) {
        this(new c(i2, str));
        AppMethodBeat.i(64585);
        AppMethodBeat.o(64585);
    }

    public a(String str, Exception exc) {
        this(new c(-1001, str), exc);
        AppMethodBeat.i(64586);
        AppMethodBeat.o(64586);
    }

    private a(c cVar, Exception exc) {
        super(cVar.mMessage, exc);
        this.yhk = cVar;
    }
}
