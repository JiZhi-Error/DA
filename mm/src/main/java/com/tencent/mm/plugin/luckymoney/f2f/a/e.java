package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private d hJu;
    public String rCq;
    public String yQE;
    private aln yRX = ((aln) this.hJu.iLK.iLR);
    private alo yRY;
    public String yRZ;
    public String ySa;
    public int ySb;

    public e() {
        AppMethodBeat.i(65047);
        d.a aVar = new d.a();
        aVar.iLN = new aln();
        aVar.iLO = new alo();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.hJu = aVar.aXF();
        this.yRX.timestamp = System.currentTimeMillis() / 1000;
        bf fQy = k.fQy();
        if (fQy != null) {
            this.yRX.latitude = fQy.latitude;
            this.yRX.longitude = fQy.longitude;
        }
        AppMethodBeat.o(65047);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65048);
        Log.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.yRY = (alo) ((d) sVar).iLL.iLR;
        this.yQE = this.yRY.yQE;
        this.rCq = this.yRY.rCq;
        this.ySb = this.yRY.Lut;
        this.yRZ = this.yRY.yRZ;
        this.ySa = this.yRY.ySa;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, this.yRY.dDN, this.yRY.qwn, this);
        }
        AppMethodBeat.o(65048);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1990;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65049);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65049);
        return dispatch;
    }
}
