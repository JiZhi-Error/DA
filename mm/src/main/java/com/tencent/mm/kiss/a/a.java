package com.tencent.mm.kiss.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a {
    private static a htI = new a();
    public MMHandler mHandler = new MMHandler("InflateThread");

    private a() {
        AppMethodBeat.i(140994);
        AppMethodBeat.o(140994);
    }

    static {
        AppMethodBeat.i(140995);
        AppMethodBeat.o(140995);
    }

    public static a aBg() {
        return htI;
    }
}
