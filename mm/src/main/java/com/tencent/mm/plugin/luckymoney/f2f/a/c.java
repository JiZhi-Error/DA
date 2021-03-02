package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    public int dGe;
    public int egZ;
    public String ehh;
    private d hJu;
    public String yQE;
    private all yRI = ((all) this.hJu.iLK.iLR);
    public alm yRJ;
    public int yRK;
    public int yRL;
    public dju yRM;
    public int yRN;
    public String yRO;
    public String yRP;
    public String yRQ;
    public int yRR;
    public String yRS;
    public String yRT;

    public c(String str) {
        AppMethodBeat.i(65041);
        d.a aVar = new d.a();
        aVar.iLN = new all();
        aVar.iLO = new alm();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.hJu = aVar.aXF();
        this.yRI.rCq = str;
        bf fQy = k.fQy();
        if (fQy != null) {
            this.yRI.fuK = fQy.fuK;
            this.yRI.fuJ = fQy.fuJ;
            this.yRI.Lun = fQy.KED;
            this.yRI.Luo = fQy.KEE;
            this.yRI.Lup = fQy.KEC;
            this.yRI.Luq = fQy.latitude;
            this.yRI.Lur = fQy.longitude;
        }
        AppMethodBeat.o(65041);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65042);
        this.yRJ = (alm) ((d) sVar).iLL.iLR;
        Log.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", Integer.valueOf(i3), Integer.valueOf(this.yRJ.dDN), this.yRJ.qwn);
        this.yQE = this.yRJ.yQE;
        this.egZ = this.yRJ.egZ;
        this.yRK = this.yRJ.eha;
        this.dGe = this.yRJ.dGe;
        this.ehh = this.yRJ.yVy;
        this.yRL = this.yRJ.yRL;
        this.yRM = this.yRJ.LgT;
        this.yRN = this.yRJ.yRN;
        this.yRO = this.yRJ.yRO;
        this.yRP = this.yRJ.yRP;
        this.yRQ = this.yRJ.yRQ;
        this.yRR = this.yRJ.yRR;
        this.yRS = this.yRJ.yRS;
        this.yRT = this.yRJ.yRT;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, this.yRJ.dDN, this.yRJ.qwn, this);
        }
        AppMethodBeat.o(65042);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1997;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65043);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65043);
        return dispatch;
    }
}
