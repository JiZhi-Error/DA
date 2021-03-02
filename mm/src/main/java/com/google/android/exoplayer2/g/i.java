package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.r;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public final r bEF;
    public final g bEG;
    public final t[] bEH;
    public final Object info;

    public i(r rVar, g gVar, Object obj, t[] tVarArr) {
        this.bEF = rVar;
        this.bEG = gVar;
        this.info = obj;
        this.bEH = tVarArr;
    }

    public final boolean a(i iVar) {
        AppMethodBeat.i(92953);
        if (iVar == null) {
            AppMethodBeat.o(92953);
            return false;
        }
        for (int i2 = 0; i2 < this.bEG.length; i2++) {
            if (!a(iVar, i2)) {
                AppMethodBeat.o(92953);
                return false;
            }
        }
        AppMethodBeat.o(92953);
        return true;
    }

    public final boolean a(i iVar, int i2) {
        AppMethodBeat.i(92954);
        if (iVar == null) {
            AppMethodBeat.o(92954);
            return false;
        } else if (!x.j(this.bEG.bED[i2], iVar.bEG.bED[i2]) || !x.j(this.bEH[i2], iVar.bEH[i2])) {
            AppMethodBeat.o(92954);
            return false;
        } else {
            AppMethodBeat.o(92954);
            return true;
        }
    }
}
