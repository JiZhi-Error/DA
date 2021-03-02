package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcj;
import java.util.Map;

public final class e implements j {
    public bcj jlg = new bcj();

    public e() {
        AppMethodBeat.i(164139);
        AppMethodBeat.o(164139);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(164140);
        String b2 = l.b(this.jlg);
        AppMethodBeat.o(164140);
        return b2;
    }

    public final void j(String str, Map<String, String> map) {
        AppMethodBeat.i(164141);
        this.jlg = l.x(str, map);
        AppMethodBeat.o(164141);
    }
}
