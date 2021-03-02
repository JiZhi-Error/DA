package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener Kbl;

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this.Kbl = null;
    }

    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(141581);
        if (this.Kbl != null) {
            this.Kbl.onScroll(absListView, i2, i3, i4);
        }
        AppMethodBeat.o(141581);
    }

    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(141582);
        if (this.Kbl != null) {
            this.Kbl.onScrollStateChanged(absListView, i2);
        }
        AppMethodBeat.o(141582);
    }
}
