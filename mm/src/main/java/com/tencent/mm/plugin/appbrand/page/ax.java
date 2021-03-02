package com.tencent.mm.plugin.appbrand.page;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class ax extends SparseIntArray {
    ax() {
    }

    /* access modifiers changed from: package-private */
    public final void u(ac acVar) {
        AppMethodBeat.i(219457);
        if (acVar == null) {
            AppMethodBeat.o(219457);
            return;
        }
        super.put(acVar.getComponentId(), acVar.getComponentId());
        AppMethodBeat.o(219457);
    }

    /* access modifiers changed from: package-private */
    public final boolean v(ac acVar) {
        AppMethodBeat.i(219458);
        if (acVar == null) {
            AppMethodBeat.o(219458);
            return false;
        }
        int indexOfKey = super.indexOfKey(acVar.getComponentId());
        if (indexOfKey >= 0) {
            super.removeAt(indexOfKey);
            AppMethodBeat.o(219458);
            return true;
        }
        AppMethodBeat.o(219458);
        return false;
    }
}
