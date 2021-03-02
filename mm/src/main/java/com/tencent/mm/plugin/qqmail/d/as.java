package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class as extends l {
    public as() {
    }

    public as(l lVar) {
        AppMethodBeat.i(198637);
        if (lVar != null) {
            this.yFq = lVar.yFq;
            this.name = lVar.name;
            this.Bry = lVar.Bry;
            this.bNi = lVar.bNi;
            this.pinyin = lVar.pinyin;
        }
        AppMethodBeat.o(198637);
    }

    public final boolean equals(Object obj) {
        if (obj != null && this.bNi == ((as) obj).bNi) {
            return true;
        }
        return false;
    }
}
