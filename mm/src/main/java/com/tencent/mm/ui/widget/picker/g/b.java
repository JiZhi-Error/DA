package com.tencent.mm.ui.widget.picker.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.List;

public final class b<T> {
    WheelView.b QTM;
    d QUC;
    WheelView QUG;
    public WheelView QUH;
    boolean jKW;
    private int jKu;
    public List<T> jLN;
    public boolean jLO = true;
    float jLu;

    @Deprecated
    private void blj() {
        AppMethodBeat.i(198532);
        this.QUH.setDividerColor(this.jKu);
        AppMethodBeat.o(198532);
    }

    public final int[] blk() {
        AppMethodBeat.i(198533);
        int[] iArr = new int[3];
        iArr[0] = this.QUH.getCurrentItem();
        AppMethodBeat.o(198533);
        return iArr;
    }

    public final void uQ(int i2) {
        AppMethodBeat.i(198534);
        if (this.jLO) {
            uR(i2);
            AppMethodBeat.o(198534);
            return;
        }
        this.QUH.setCurrentItem(i2);
        AppMethodBeat.o(198534);
    }

    private void uR(int i2) {
        AppMethodBeat.i(198535);
        if (this.jLN != null) {
            this.QUH.setCurrentItem(i2);
        }
        AppMethodBeat.o(198535);
    }

    public final void setDividerColor(int i2) {
        AppMethodBeat.i(198536);
        this.jKu = i2;
        blj();
        AppMethodBeat.o(198536);
    }

    public final void dE(int i2, int i3) {
        AppMethodBeat.i(198537);
        this.QUH.setPadding(0, i2, 0, i3);
        AppMethodBeat.o(198537);
    }
}
