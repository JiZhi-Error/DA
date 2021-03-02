package com.tencent.luggage.xweb_ext.extendplugin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements d {
    private static b cKc;

    private b() {
    }

    public static b QL() {
        AppMethodBeat.i(215749);
        if (cKc == null) {
            cKc = new b();
        }
        b bVar = cKc;
        AppMethodBeat.o(215749);
        return bVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b.d
    public final c QM() {
        AppMethodBeat.i(139361);
        a aVar = new a();
        AppMethodBeat.o(139361);
        return aVar;
    }
}
