package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;

public final class d {
    public int bNu = -1;
    public int endPos = -1;
    public int qSo = -1;
    public int startOffset = -1;

    public d() {
        AppMethodBeat.i(181849);
        set(-1, -1, -1, -1);
        AppMethodBeat.o(181849);
    }

    public d(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(181850);
        set(i2, i3, i4, i5);
        AppMethodBeat.o(181850);
    }

    public final void set(int i2, int i3, int i4, int i5) {
        this.bNu = i2;
        this.startOffset = i3;
        this.endPos = i4;
        this.qSo = i5;
    }

    public final int getSelectType() {
        AppMethodBeat.i(181851);
        if (this.bNu < 0 || this.startOffset < 0 || this.endPos < 0 || this.qSo < 0 || this.bNu > this.endPos || (this.bNu == this.endPos && this.startOffset > this.qSo)) {
            AppMethodBeat.o(181851);
            return 0;
        }
        a Fw = c.cDo().Fw(this.bNu);
        a Fw2 = c.cDo().Fw(this.endPos);
        if (Fw == null || Fw2 == null) {
            AppMethodBeat.o(181851);
            return 0;
        } else if (this.bNu == this.endPos && this.startOffset == this.qSo) {
            AppMethodBeat.o(181851);
            return 1;
        } else if (this.bNu == this.endPos && Fw.getType() == 1) {
            AppMethodBeat.o(181851);
            return 2;
        } else {
            AppMethodBeat.o(181851);
            return 3;
        }
    }
}
