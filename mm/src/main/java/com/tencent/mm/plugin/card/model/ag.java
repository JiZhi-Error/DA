package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddq;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.sdk.platformtools.Log;

public final class ag extends q implements m {
    private i callback;
    public String content;
    public String dYs;
    public String lco;
    public String pUs;
    public String pUt;
    public boolean pUu;
    public String pUv;
    public String pUw;
    public String pUx;
    public String pUy;
    private final d rr;
    public int status;

    public ag(int i2, String str, String str2) {
        AppMethodBeat.i(112855);
        d.a aVar = new d.a();
        aVar.iLN = new ddq();
        aVar.iLO = new ddr();
        aVar.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        aVar.funcId = 1171;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ddq ddq = (ddq) this.rr.iLK.iLR;
        ddq.KDl = i2;
        ddq.KDm = str;
        ddq.KDn = str2;
        AppMethodBeat.o(112855);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112856);
        Log.i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            ddr ddr = (ddr) this.rr.iLL.iLR;
            this.dYs = ddr.KDq;
            this.pUs = ddr.KDr;
            this.status = ddr.status;
            this.content = ddr.content;
            this.pUt = ddr.pTK;
            this.lco = ddr.LFY;
            this.pUu = ddr.pUu;
            this.pUv = ddr.MIE;
            this.pUw = ddr.MIF;
            this.pUx = ddr.MIG;
            this.pUy = ddr.MIH;
            Log.d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", this.dYs, this.pUs, Integer.valueOf(this.status), this.content, this.pUt, this.lco, Boolean.valueOf(this.pUu));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112856);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1171;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112857);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112857);
        return dispatch;
    }
}
