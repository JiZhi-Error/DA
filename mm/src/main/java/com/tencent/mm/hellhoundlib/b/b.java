package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private List<Object> hlM = new ArrayList();

    public b() {
        AppMethodBeat.i(168726);
        AppMethodBeat.o(168726);
    }

    public final void pH(int i2) {
        AppMethodBeat.i(168727);
        bm(Integer.valueOf(i2));
        AppMethodBeat.o(168727);
    }

    public final void en(boolean z) {
        AppMethodBeat.i(168728);
        bm(Boolean.valueOf(z));
        AppMethodBeat.o(168728);
    }

    public final void zo(long j2) {
        AppMethodBeat.i(186285);
        bm(Long.valueOf(j2));
        AppMethodBeat.o(186285);
    }

    public final void bm(Object obj) {
        AppMethodBeat.i(168729);
        this.hlM.add(obj);
        AppMethodBeat.o(168729);
    }

    public final Object[] axR() {
        AppMethodBeat.i(168730);
        Object[] array = this.hlM.toArray();
        this.hlM.clear();
        AppMethodBeat.o(168730);
        return array;
    }
}
