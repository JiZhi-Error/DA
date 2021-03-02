package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eiw;

public final class c {
    public eiw GjH;
    public boolean GjI;
    public boolean vtY;
    public long xeh = System.currentTimeMillis();

    public c(eiw eiw) {
        AppMethodBeat.i(91003);
        this.GjH = eiw;
        AppMethodBeat.o(91003);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91004);
        if (obj == null) {
            AppMethodBeat.o(91004);
            return false;
        }
        boolean equals = this.GjH.psI.equals(((c) obj).GjH.psI);
        AppMethodBeat.o(91004);
        return equals;
    }
}
