package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private i callback;
    public d rr;

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23394);
        Log.i("MicroMsg.exdevice.NetSceneGetHardDeviceHelpUrl", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23394);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1719;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23395);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23395);
        return dispatch;
    }
}
