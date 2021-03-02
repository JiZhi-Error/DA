package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;

public final class b extends RuntimeException {
    private final int dvm = 0;

    public b() {
        super(a.aza());
        AppMethodBeat.i(132231);
        AppMethodBeat.o(132231);
    }

    public b(byte b2) {
        super(a.aza());
        AppMethodBeat.i(132232);
        AppMethodBeat.o(132232);
    }
}
