package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.g;

public final class c {
    public int NBC;
    g NBz;

    public static c iK(Context context) {
        AppMethodBeat.i(193776);
        c cVar = new c(context);
        AppMethodBeat.o(193776);
        return cVar;
    }

    private c(Context context) {
        AppMethodBeat.i(193777);
        this.NBz = new g.a(context, "recovery_crash_count").guE();
        this.NBC = Math.max(this.NBz.getInt("crash_count", 0), 0);
        AppMethodBeat.o(193777);
    }

    c(int i2, g gVar) {
        this.NBC = i2;
        this.NBz = gVar;
    }

    public final void save() {
        AppMethodBeat.i(193778);
        this.NBz.gL("crash_count", this.NBC).guF();
        AppMethodBeat.o(193778);
    }
}
