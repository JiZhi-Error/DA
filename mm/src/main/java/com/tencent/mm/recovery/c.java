package com.tencent.mm.recovery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.f;

public final class c implements android.support.v4.e.c<Integer> {
    private final int[] NBg;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // android.support.v4.e.c
    public final /* synthetic */ void accept(Integer num) {
        AppMethodBeat.i(193906);
        Integer num2 = num;
        f.i("MicroMsg.recovery.service", "#fetchTinkerPatch callback, status = ".concat(String.valueOf(num2)));
        this.NBg[0] = num2.intValue();
        AppMethodBeat.o(193906);
    }

    public c(int[] iArr) {
        this.NBg = iArr;
    }
}
