package com.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimeZone;

/* access modifiers changed from: package-private */
public final class aa {
    private static long aL(long j2) {
        AppMethodBeat.i(88041);
        long offset = ((long) TimeZone.getDefault().getOffset(j2)) + j2;
        AppMethodBeat.o(88041);
        return offset;
    }

    static long aM(long j2) {
        AppMethodBeat.i(88042);
        long aL = aL(j2) / 1000;
        AppMethodBeat.o(88042);
        return aL;
    }
}
