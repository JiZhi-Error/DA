package com.tencent.mm.plugin.expt.hellhound.core.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static c szk;
    public e szl = new e();

    public static c cNJ() {
        AppMethodBeat.i(121867);
        if (szk == null) {
            synchronized (c.class) {
                try {
                    if (szk == null) {
                        szk = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121867);
                    throw th;
                }
            }
        }
        c cVar = szk;
        AppMethodBeat.o(121867);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(121868);
        AppMethodBeat.o(121868);
    }

    public final void GP(int i2) {
        AppMethodBeat.i(121869);
        a aVar = new a();
        aVar.msgType = i2;
        this.szl.b(aVar);
        AppMethodBeat.o(121869);
    }

    public final void m(int i2, Object obj) {
        AppMethodBeat.i(121870);
        a aVar = new a();
        aVar.msgType = i2;
        aVar.szh = obj;
        this.szl.b(aVar);
        AppMethodBeat.o(121870);
    }
}
