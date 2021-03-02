package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.af.h;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class b extends w {
    private i callback;
    private String dQm;
    private d rr;

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69063);
        Log.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            com.tencent.mm.plugin.wallet.a.s.fOg();
            com.tencent.mm.plugin.wallet.a.s.fOh();
            an.aVo(this.dQm);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69063);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return h.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69064);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69064);
        return dispatch;
    }
}
