package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private final s iMO = new p();

    public m() {
        AppMethodBeat.i(134154);
        AppMethodBeat.o(134154);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 381;
    }

    @Override // com.tencent.mm.ak.q
    public final boolean needCheckCallback() {
        return false;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134155);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(134155);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134156);
        Log.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(134156);
    }
}
