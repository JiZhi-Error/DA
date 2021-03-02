package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wm;
import com.tencent.mm.protocal.protobuf.wn;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private wn qwl;
    private wm qwm = ((wm) this.rr.iLK.iLR);
    private final d rr;

    public m(int i2, int i3, String str, String str2, b bVar) {
        AppMethodBeat.i(213150);
        d.a aVar = new d.a();
        aVar.iLN = new wm();
        aVar.iLO = new wn();
        aVar.funcId = 3781;
        aVar.uri = "/cgi-bin/mmpay-bin/qrcodesavenotify";
        this.rr = aVar.aXF();
        this.qwm.LhC = i2;
        this.qwm.yRL = i3;
        this.qwm.LhD = str;
        this.qwm.url = str2;
        this.qwm.LhE = (int) (System.currentTimeMillis() / 1000);
        this.qwm.Lha = bVar;
        AppMethodBeat.o(213150);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3781;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(213151);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(213151);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(213152);
        Log.i("MicroMsg.NetSceneF2fQrcodeSaveNotify", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.qwl = (wn) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(213152);
    }
}
