package com.tencent.mm.appbrand.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ab extends z {
    private static final ThreadLocal<ab> dpE = new ThreadLocal<>();
    private final a drJ;

    interface a {
        void XP();
    }

    static {
        AppMethodBeat.i(216935);
        AppMethodBeat.o(216935);
    }

    public static ab a(a aVar, boolean z) {
        AppMethodBeat.i(216933);
        if (dpE.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.o(216933);
            throw runtimeException;
        }
        ab abVar = new ab(aVar, z);
        dpE.set(abVar);
        AppMethodBeat.o(216933);
        return abVar;
    }

    private ab(a aVar, boolean z) {
        super(z);
        this.drJ = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.z
    public final void XD() {
        AppMethodBeat.i(216934);
        super.XD();
        if (this.drJ != null) {
            this.drJ.XP();
        }
        AppMethodBeat.o(216934);
    }
}
