package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public class j extends f {
    public int iwA = 0;

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(20239);
        j jVar = new j();
        AppMethodBeat.o(20239);
        return jVar;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(20240);
        if (bVar.type == 2000) {
            this.iwA = 0;
            Log.i("MicroMsg.AppContentTransferMsgPiece", "hasTransferAddress: %s", Integer.valueOf(this.iwA));
        }
        AppMethodBeat.o(20240);
    }
}
