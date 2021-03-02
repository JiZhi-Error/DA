package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcf;
import java.util.Map;

public final class c implements j {
    public bcf jle = new bcf();

    public c() {
        AppMethodBeat.i(192724);
        AppMethodBeat.o(192724);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(192725);
        String a2 = l.a(this.jle);
        AppMethodBeat.o(192725);
        return a2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(192726);
        this.jle = l.A(str, map);
        AppMethodBeat.o(192726);
    }
}
