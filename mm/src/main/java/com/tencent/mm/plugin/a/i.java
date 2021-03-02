package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public static a f(int i2, int i3, long j2) {
        a aVar;
        AppMethodBeat.i(133870);
        if (i3 == a.blm) {
            aVar = new p(i2, j2, i3);
        } else if (i3 == a.bln) {
            aVar = new g(i2, j2, i3);
        } else if (i3 == a.blp) {
            aVar = new o(i2, j2, i3);
        } else if (i3 == a.bly) {
            aVar = new d(i2, j2, i3);
        } else {
            aVar = new a(i2, j2, i3, 0);
        }
        AppMethodBeat.o(133870);
        return aVar;
    }
}
