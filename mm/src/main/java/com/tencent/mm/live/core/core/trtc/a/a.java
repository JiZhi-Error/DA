package com.tencent.mm.live.core.core.trtc.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.trtc.a.a.b;
import com.tencent.mm.live.core.core.trtc.a.a.c;
import com.tencent.mm.live.core.core.trtc.a.a.d;

public final class a {
    private d hAR;
    private com.tencent.mm.live.core.core.trtc.a.a.a hAS;
    private c hAT;
    private b hAU;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
    }

    public static a aDC() {
        AppMethodBeat.i(196239);
        a aVar = C0385a.hAV;
        AppMethodBeat.o(196239);
        return aVar;
    }

    public final d aDD() {
        AppMethodBeat.i(196240);
        if (this.hAR == null) {
            this.hAR = new d();
        }
        d dVar = this.hAR;
        AppMethodBeat.o(196240);
        return dVar;
    }

    public final com.tencent.mm.live.core.core.trtc.a.a.a aDE() {
        AppMethodBeat.i(196241);
        if (this.hAS == null) {
            this.hAS = new com.tencent.mm.live.core.core.trtc.a.a.a();
        }
        com.tencent.mm.live.core.core.trtc.a.a.a aVar = this.hAS;
        AppMethodBeat.o(196241);
        return aVar;
    }

    public final c aDF() {
        AppMethodBeat.i(196242);
        if (this.hAT == null) {
            this.hAT = new c();
        }
        c cVar = this.hAT;
        AppMethodBeat.o(196242);
        return cVar;
    }

    public final b aDG() {
        AppMethodBeat.i(196243);
        if (this.hAU == null) {
            this.hAU = new b();
        }
        b bVar = this.hAU;
        AppMethodBeat.o(196243);
        return bVar;
    }

    /* renamed from: com.tencent.mm.live.core.core.trtc.a.a$a  reason: collision with other inner class name */
    public static class C0385a {
        private static a hAV = new a((byte) 0);

        static {
            AppMethodBeat.i(196238);
            AppMethodBeat.o(196238);
        }
    }
}
