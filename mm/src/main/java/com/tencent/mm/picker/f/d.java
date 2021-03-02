package com.tencent.mm.picker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.b;
import java.util.List;

public final class d<T> {
    b jKU;
    boolean jKW;
    private int jKu;
    WheelView jLL;
    public WheelView jLM;
    List<T> jLN;
    boolean jLO = true;
    float jLu;
    WheelView.b jLw;

    @Deprecated
    private void blj() {
        AppMethodBeat.i(175361);
        this.jLM.setDividerColor(this.jKu);
        AppMethodBeat.o(175361);
    }

    public final int[] blk() {
        AppMethodBeat.i(175362);
        int[] iArr = new int[3];
        iArr[0] = this.jLM.getCurrentItem();
        AppMethodBeat.o(175362);
        return iArr;
    }

    public final void uQ(int i2) {
        AppMethodBeat.i(175363);
        if (this.jLO) {
            uR(i2);
            AppMethodBeat.o(175363);
            return;
        }
        this.jLM.setCurrentItem(i2);
        AppMethodBeat.o(175363);
    }

    private void uR(int i2) {
        AppMethodBeat.i(175364);
        if (this.jLN != null) {
            this.jLM.setCurrentItem(i2);
        }
        AppMethodBeat.o(175364);
    }

    public final void setDividerColor(int i2) {
        AppMethodBeat.i(175365);
        this.jKu = i2;
        blj();
        AppMethodBeat.o(175365);
    }

    public final void dE(int i2, int i3) {
        AppMethodBeat.i(175366);
        this.jLM.setPadding(0, i2, 0, i3);
        AppMethodBeat.o(175366);
    }
}
