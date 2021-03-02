package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.protocal.protobuf.css;
import java.util.Map;

public final class i implements j {
    public css jlj = new css();

    public i() {
        AppMethodBeat.i(192735);
        AppMethodBeat.o(192735);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(192736);
        String a2 = ak.a(this.jlj);
        AppMethodBeat.o(192736);
        return a2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(192737);
        this.jlj = ak.C(str, map);
        AppMethodBeat.o(192737);
    }
}
