package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class a implements com.tencent.mm.plugin.appbrand.w.a {
    private final long[] ncK = {1088};

    public a() {
        AppMethodBeat.i(47576);
        AppMethodBeat.o(47576);
    }

    @Override // com.tencent.mm.plugin.appbrand.w.a
    public final void Bl(long j2) {
        AppMethodBeat.i(47577);
        h.INSTANCE.n(807, j2, 1);
        AppMethodBeat.o(47577);
    }

    @Override // com.tencent.mm.plugin.appbrand.w.a
    public final void idkeyStat(long j2, long j3, long j4, boolean z) {
        boolean z2;
        AppMethodBeat.i(47578);
        h.INSTANCE.idkeyStat(j2, j3, j4, z);
        long[] jArr = this.ncK;
        int length = jArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = false;
                break;
            } else if (jArr[i2] == j2) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2) {
            i.a((String) null, 0, 0, j2, j3, j4);
        }
        AppMethodBeat.o(47578);
    }

    @Override // com.tencent.mm.plugin.appbrand.w.a
    public final void b(ArrayList<IDKey> arrayList, boolean z) {
        AppMethodBeat.i(47579);
        h.INSTANCE.b(arrayList, z);
        AppMethodBeat.o(47579);
    }
}
