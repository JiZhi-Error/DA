package com.google.android.flexbox;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class b {
    int Al = Integer.MAX_VALUE;
    int Am = Integer.MAX_VALUE;
    int An = Integer.MIN_VALUE;
    int Ao = Integer.MIN_VALUE;
    int acn;
    int auc;
    int bJa;
    int bJb;
    int bJc;
    int bJd;
    float bJe;
    float bJf;
    int bJg;
    int bJh;
    List<Integer> bJi = new ArrayList();
    int bJj;

    b() {
        AppMethodBeat.i(62214);
        AppMethodBeat.o(62214);
    }

    public final int xJ() {
        return this.auc - this.bJd;
    }

    /* access modifiers changed from: package-private */
    public final void k(View view, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(62215);
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.Al = Math.min(this.Al, (view.getLeft() - flexItem.xG()) - i2);
        this.Am = Math.min(this.Am, (view.getTop() - flexItem.xH()) - i3);
        this.An = Math.max(this.An, view.getRight() + flexItem.xI() + i4);
        this.Ao = Math.max(this.Ao, flexItem.getMarginBottom() + view.getBottom() + i5);
        AppMethodBeat.o(62215);
    }
}
