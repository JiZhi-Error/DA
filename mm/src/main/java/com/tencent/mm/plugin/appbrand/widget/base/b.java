package com.tencent.mm.plugin.appbrand.widget.base;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class b implements Iterator<View> {
    private int cBY = 0;
    private final ViewGroup parent;

    public b(ViewGroup viewGroup) {
        this.parent = viewGroup;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(131470);
        if (this.cBY < this.parent.getChildCount()) {
            AppMethodBeat.o(131470);
            return true;
        }
        AppMethodBeat.o(131470);
        return false;
    }

    public final void remove() {
        AppMethodBeat.i(131471);
        this.parent.removeViewAt(this.cBY - 1);
        AppMethodBeat.o(131471);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ View next() {
        AppMethodBeat.i(131472);
        ViewGroup viewGroup = this.parent;
        int i2 = this.cBY;
        this.cBY = i2 + 1;
        View childAt = viewGroup.getChildAt(i2);
        AppMethodBeat.o(131472);
        return childAt;
    }
}
