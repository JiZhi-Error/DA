package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public int dDN;
    private d hJu;
    public String qwn;
    private alj yRG = ((alj) this.hJu.iLK.iLR);
    private alk yRH;

    public b(String str) {
        AppMethodBeat.i(65038);
        d.a aVar = new d.a();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.iLN = new alj();
        aVar.iLO = new alk();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
        this.hJu = aVar.aXF();
        bf fQy = k.fQy();
        if (fQy != null) {
            this.yRG.latitude = fQy.latitude;
            this.yRG.longitude = fQy.longitude;
        }
        this.yRG.Lum = str;
        AppMethodBeat.o(65038);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65039);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(65039);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1971;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65040);
        Log.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.yRH = (alk) ((d) sVar).iLL.iLR;
        this.dDN = this.yRH.dDN;
        this.qwn = this.yRH.qwn;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, this.yRH.dDN, this.yRH.qwn, this);
        }
        AppMethodBeat.o(65040);
    }
}
