package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cxa;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private i callback;
    private d rr;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1967;
    }

    public f(String str, String str2, String str3) {
        AppMethodBeat.i(129686);
        d.a aVar = new d.a();
        aVar.iLN = new cxa();
        aVar.iLO = new cxb();
        aVar.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        aVar.funcId = 1967;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cxa cxa = (cxa) this.rr.iLK.iLR;
        Log.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", str, str2, str3);
        cxa.MBA = str;
        cxa.signature = str2;
        cxa.HQm = str3;
        AppMethodBeat.o(129686);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(129687);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(129687);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(129688);
        Log.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(129688);
    }
}
