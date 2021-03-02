package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class d {
    public int bNu = -1;
    public int endPos = -1;
    public int qSo = -1;
    public int startOffset = -1;

    public d() {
        AppMethodBeat.i(30549);
        set(-1, -1, -1, -1);
        AppMethodBeat.o(30549);
    }

    public d(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(30550);
        set(i2, i3, i4, i5);
        AppMethodBeat.o(30550);
    }

    public final void set(int i2, int i3, int i4, int i5) {
        this.bNu = i2;
        this.startOffset = i3;
        this.endPos = i4;
        this.qSo = i5;
    }

    public final int getSelectType() {
        AppMethodBeat.i(30551);
        if (this.bNu < 0 || this.startOffset < 0 || this.endPos < 0 || this.qSo < 0 || this.bNu > this.endPos || (this.bNu == this.endPos && this.startOffset > this.qSo)) {
            AppMethodBeat.o(30551);
            return 0;
        }
        c ahp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.bNu);
        c ahp2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(this.endPos);
        if (ahp == null || ahp2 == null) {
            AppMethodBeat.o(30551);
            return 0;
        } else if (this.bNu == this.endPos && this.startOffset == this.qSo) {
            AppMethodBeat.o(30551);
            return 1;
        } else if (this.bNu == this.endPos && ahp.getType() == 1) {
            AppMethodBeat.o(30551);
            return 2;
        } else {
            AppMethodBeat.o(30551);
            return 3;
        }
    }
}
