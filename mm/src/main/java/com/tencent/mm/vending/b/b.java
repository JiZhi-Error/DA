package com.tencent.mm.vending.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    private a QZF;
    public _Callback QZG;
    private int QZH;
    private int mPriority = -1;
    public d mScheduler;

    public b(_Callback _callback, a aVar) {
        AppMethodBeat.i(74905);
        Assert.assertNotNull("Callback should not be null!", _callback);
        this.QZH = _callback.hashCode();
        this.QZG = _callback;
        this.QZF = aVar;
        AppMethodBeat.o(74905);
    }

    public final int hashCode() {
        return this.QZH;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(74906);
        if (obj == null || obj.hashCode() != this.QZH) {
            AppMethodBeat.o(74906);
            return false;
        }
        AppMethodBeat.o(74906);
        return true;
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(74907);
        Assert.assertNotNull(this.QZF);
        this.QZF.remove(this);
        AppMethodBeat.o(74907);
    }
}
