package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private volatile d QZV;
    volatile a Rag;

    public interface a {
        void em(Object obj);

        void hdE();

        void interrupt();
    }

    public f(d dVar, a aVar) {
        AppMethodBeat.i(74921);
        c(dVar);
        this.Rag = aVar;
        AppMethodBeat.o(74921);
    }

    public final synchronized void c(d dVar) {
        this.QZV = dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(final com.tencent.mm.vending.c.a r11, final java.lang.Object r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.vending.h.f.a(com.tencent.mm.vending.c.a, java.lang.Object, boolean):void");
    }
}
