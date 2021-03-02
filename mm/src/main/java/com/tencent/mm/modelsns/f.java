package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcl;
import java.util.Map;

public final class f implements j {
    public bcl jld = new bcl();

    public f() {
        AppMethodBeat.i(164142);
        AppMethodBeat.o(164142);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(164143);
        String b2 = l.b(this.jld);
        AppMethodBeat.o(164143);
        return b2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(164144);
        this.jld = l.z(str, map);
        AppMethodBeat.o(164144);
    }
}
