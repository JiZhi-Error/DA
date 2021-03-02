package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.col;
import java.util.Map;

public final class g implements j {
    public col jlh = new col();

    public g() {
        AppMethodBeat.i(192727);
        AppMethodBeat.o(192727);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(192728);
        String a2 = l.a(this.jlh);
        AppMethodBeat.o(192728);
        return a2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(192729);
        this.jlh = l.y(str, map);
        AppMethodBeat.o(192729);
    }
}
