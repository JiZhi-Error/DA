package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.protocal.protobuf.czy;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private d rr;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(69967);
        d.a aVar = new d.a();
        aVar.iLN = new czx();
        aVar.iLO = new czy();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        aVar.funcId = 1767;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        czx czx = (czx) this.rr.iLK.iLR;
        czx.jfi = str;
        czx.Lkq = str4;
        czx.Lkp = str2;
        czx.Lkr = str5;
        czx.Lks = str6;
        czx.KPJ = str3;
        czx.Ljk = str7;
        AppMethodBeat.o(69967);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69968);
        Log.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        czy czy = (czy) ((d) sVar).iLL.iLR;
        if (i4 == 0 && i3 == 0) {
            i4 = czy.rBL;
            str = czy.rBM;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69968);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1767;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69969);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69969);
        return dispatch;
    }
}
