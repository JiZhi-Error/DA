package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f {
    private static f jnX = null;
    public com.tencent.mm.b.f<String, Long> jnY = new c(10);
    public String jnZ;

    public static f bgg() {
        AppMethodBeat.i(151075);
        if (jnX == null) {
            jnX = new f();
        }
        f fVar = jnX;
        AppMethodBeat.o(151075);
        return fVar;
    }

    private f() {
        AppMethodBeat.i(151076);
        AppMethodBeat.o(151076);
    }

    public final void J(String str, long j2) {
        AppMethodBeat.i(151077);
        if (this.jnY != null) {
            this.jnZ = str;
            this.jnY.put(str, Long.valueOf(j2));
        }
        AppMethodBeat.o(151077);
    }
}
