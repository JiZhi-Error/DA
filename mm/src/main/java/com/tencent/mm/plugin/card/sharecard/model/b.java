package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bks;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class b extends q implements m {
    private i callback;
    public String pTY;
    public String pVT = "";
    private final d rr;

    public b(double d2, double d3, String str) {
        AppMethodBeat.i(112957);
        d.a aVar = new d.a();
        aVar.iLN = new bkr();
        aVar.iLO = new bks();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.funcId = 1164;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bkr bkr = (bkr) this.rr.iLK.iLR;
        bkr.latitude = d2;
        bkr.longitude = d3;
        bkr.pVT = str;
        bkr.LTC = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, "");
        Log.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + bkr.LTC);
        AppMethodBeat.o(112957);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112958);
        Log.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bks bks = (bks) this.rr.iLL.iLR;
            Log.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + bks.pTY);
            this.pTY = bks.pTY;
            this.pVT = bks.pVT;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112958);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1164;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112959);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112959);
        return dispatch;
    }
}
