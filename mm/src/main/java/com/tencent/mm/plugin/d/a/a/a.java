package com.tencent.mm.plugin.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    int[] pfK = null;

    public a(int[] iArr) {
        AppMethodBeat.i(22436);
        if (iArr.length == 0) {
            NullPointerException nullPointerException = new NullPointerException("null == aDataGroup || 0 == aDataGroup.length");
            AppMethodBeat.o(22436);
            throw nullPointerException;
        }
        this.pfK = iArr;
        AppMethodBeat.o(22436);
    }
}
