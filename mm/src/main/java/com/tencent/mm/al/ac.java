package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac extends q implements m {
    public String brandUsername;
    private i callback;
    public d rr;

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124138);
        Log.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124138);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 672;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124139);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124139);
        return dispatch;
    }

    public final cfq bad() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (cfq) this.rr.iLL.iLR;
    }
}
