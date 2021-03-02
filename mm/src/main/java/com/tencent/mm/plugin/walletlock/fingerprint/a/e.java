package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejb;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    boolean Ivf = false;
    private i callback;
    private d rr;
    String wFE;

    public e(String str, String str2) {
        AppMethodBeat.i(129683);
        d.a aVar = new d.a();
        aVar.iLN = new ejb();
        aVar.iLO = new ejc();
        aVar.uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
        aVar.funcId = 1548;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ejb ejb = (ejb) this.rr.iLK.iLR;
        ejb.scene = 1548;
        ejb.FhU = str;
        ejb.hFF = str2;
        AppMethodBeat.o(129683);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1548;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(129684);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(129684);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(129685);
        Log.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        ejc ejc = (ejc) ((d) sVar).iLL.iLR;
        this.wFE = ejc.wFE;
        Log.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", this.wFE);
        if (ejc.Nbt == 1) {
            this.Ivf = true;
        } else {
            this.Ivf = false;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(129685);
    }
}
