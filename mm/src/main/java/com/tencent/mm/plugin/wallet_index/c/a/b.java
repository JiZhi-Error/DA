package com.tencent.mm.plugin.wallet_index.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dai;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private daj Irc;
    private dai Ird = ((dai) this.rr.iLK.iLR);
    private i callback;
    private final d rr;

    public b(int i2) {
        AppMethodBeat.i(214272);
        d.a aVar = new d.a();
        aVar.iLN = new dai();
        aVar.iLO = new daj();
        aVar.funcId = 2540;
        aVar.uri = "/cgi-bin/mmpay-bin/payibgquickgetoverseawallet";
        this.rr = aVar.aXF();
        this.Ird.MFC = i2;
        AppMethodBeat.o(214272);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2540;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(214273);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(214273);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(214274);
        Log.i("MicroMsg.NetScenePayIBGQuickGetOverseaWallet", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.Irc = (daj) ((d) sVar).iLL.iLR;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(214274);
    }

    public final daj fUq() {
        AppMethodBeat.i(214275);
        if (this.Irc == null) {
            daj daj = new daj();
            AppMethodBeat.o(214275);
            return daj;
        }
        daj daj2 = this.Irc;
        AppMethodBeat.o(214275);
        return daj2;
    }
}
