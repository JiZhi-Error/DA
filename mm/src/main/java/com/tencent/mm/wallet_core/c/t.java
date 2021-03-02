package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.das;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.wxmm.v2helper;

public final class t extends w {
    private i callback;
    private d rr;

    public t(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public t(String str, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(72794);
        d.a aVar = new d.a();
        aVar.iLN = new das();
        aVar.iLO = new dat();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.funcId = v2helper.EMethodSetPlayerPreCorrectCofOff;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.routeInfo = f.bpA(str2);
        this.rr = aVar.aXF();
        das das = (das) this.rr.iLK.iLR;
        das.MFU = str;
        das.Lcc = k.fQy();
        das.MFV = str3;
        if (!Util.isNullOrNil(str2)) {
            das.MFW = new b(str2.getBytes());
        }
        if (i2 >= 0) {
            das.LbX = i2;
        }
        if (i3 >= 0) {
            das.KCx = i3;
        }
        if (i4 >= 0) {
            das.MFX = i4;
        }
        AppMethodBeat.o(72794);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72795);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72795);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72796);
        Log.d("MicroMsg.NetScenePaySubscribe", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72796);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetPlayerPreCorrectCofOff;
    }
}
