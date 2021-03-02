package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;

public final class c {
    private static volatile c szP;
    public a szQ = new d();

    public static c cNY() {
        AppMethodBeat.i(121963);
        if (szP == null) {
            synchronized (c.class) {
                try {
                    if (szP == null) {
                        szP = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(121963);
                    throw th;
                }
            }
        }
        c cVar = szP;
        AppMethodBeat.o(121963);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(121964);
        if (b.isMMProcess()) {
            this.szQ.reset();
        }
        AppMethodBeat.o(121964);
    }

    public final void apj(String str) {
        AppMethodBeat.i(121965);
        this.szQ.apj(str);
        AppMethodBeat.o(121965);
    }
}
