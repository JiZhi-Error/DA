package com.tencent.e.a;

import com.tencent.e.b.c;
import com.tencent.e.e.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    static /* synthetic */ boolean a(c cVar, b bVar, String str, String str2, a aVar) {
        boolean z = false;
        AppMethodBeat.i(138309);
        byte[] c2 = cVar.c(str, str2, aVar);
        if (c2 == null || c2.length == 0) {
            bVar.p(-20, new byte[0]);
        } else {
            z = bVar.p(0, c2);
        }
        AppMethodBeat.o(138309);
        return z;
    }
}
