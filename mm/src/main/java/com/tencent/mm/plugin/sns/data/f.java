package com.tencent.mm.plugin.sns.data;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    public n DDH;
    public SparseArray<n> DDI;
    public int requestType;

    public f() {
        AppMethodBeat.i(95067);
        this.DDI = new SparseArray<>();
        AppMethodBeat.o(95067);
    }

    public f(n nVar, int i2) {
        this.DDH = nVar;
        this.requestType = i2;
    }

    public f(SparseArray<n> sparseArray) {
        this.DDI = sparseArray;
        this.requestType = 9;
    }
}
