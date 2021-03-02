package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;

public final class l extends g {
    final boolean qTj;
    public final boolean qTk;

    public l(int i2, int i3, boolean z, boolean z2) {
        super(i2, i3);
        this.qTj = z;
        this.qTk = z2;
    }

    public final boolean a(g gVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(181946);
        if (gVar == null) {
            AppMethodBeat.o(181946);
            return false;
        } else if (gVar.isEmpty()) {
            if (gVar.avh < this.avh || gVar.Pc >= this.Pc) {
                z = false;
            } else {
                z = true;
            }
            if (gVar.avh < this.avh || gVar.Pc > this.Pc) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (z2 && this.qTk)) {
                AppMethodBeat.o(181946);
                return true;
            }
            AppMethodBeat.o(181946);
            return false;
        } else if (Math.max(this.avh, gVar.avh) < Math.min(this.Pc, gVar.Pc)) {
            AppMethodBeat.o(181946);
            return true;
        } else {
            AppMethodBeat.o(181946);
            return false;
        }
    }

    public final int getLen() {
        AppMethodBeat.i(181947);
        int abs = Math.abs(this.Pc - this.avh);
        AppMethodBeat.o(181947);
        return abs;
    }
}
