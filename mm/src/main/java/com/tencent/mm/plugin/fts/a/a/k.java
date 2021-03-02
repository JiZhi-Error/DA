package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class k {
    public int resultCode;
    public j wTn;
    public h wWd;
    public a wXa;
    public List<m> wXb = new ArrayList();

    public k(j jVar) {
        AppMethodBeat.i(131708);
        this.wTn = jVar;
        AppMethodBeat.o(131708);
    }

    public final String toString() {
        int i2 = 0;
        AppMethodBeat.i(131709);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.resultCode);
        if (this.wXb != null) {
            i2 = this.wXb.size();
        }
        objArr[1] = Integer.valueOf(i2);
        String format = String.format("{resultCode: %d, resultSize: %d}", objArr);
        AppMethodBeat.o(131709);
        return format;
    }
}
