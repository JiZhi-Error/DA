package com.tencent.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k extends Exception {
    public k(String str) {
        super("the error code is 104, " + str);
        AppMethodBeat.i(214670);
        AppMethodBeat.o(214670);
    }
}
