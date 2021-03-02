package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;

public final class n extends e {
    final boolean qTj;
    public final boolean qTk;

    public n(int i2, int i3, boolean z, boolean z2) {
        super(i2, i3);
        this.qTj = z;
        this.qTk = z2;
    }

    public final boolean a(e eVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(30652);
        if (eVar == null) {
            AppMethodBeat.o(30652);
            return false;
        } else if (eVar.isEmpty()) {
            if (eVar.avh < this.avh || eVar.Pc >= this.Pc) {
                z = false;
            } else {
                z = true;
            }
            if (eVar.avh < this.avh || eVar.Pc > this.Pc) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z || (z2 && this.qTk)) {
                AppMethodBeat.o(30652);
                return true;
            }
            AppMethodBeat.o(30652);
            return false;
        } else if (Math.max(this.avh, eVar.avh) < Math.min(this.Pc, eVar.Pc)) {
            AppMethodBeat.o(30652);
            return true;
        } else {
            AppMethodBeat.o(30652);
            return false;
        }
    }

    public final int getLen() {
        AppMethodBeat.i(30653);
        int abs = Math.abs(this.Pc - this.avh);
        AppMethodBeat.o(30653);
        return abs;
    }
}
