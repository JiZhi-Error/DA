package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class g extends q implements m {
    public LinkedList<akg> AZk;
    public String AZs;
    private i callback;
    private d rr;

    public g(String str, String str2, dr drVar) {
        AppMethodBeat.i(66891);
        d.a aVar = new d.a();
        aVar.iLN = new boy();
        aVar.iLO = new boz();
        aVar.uri = "/cgi-bin/micromsg-bin/getlastestexpressinfo";
        aVar.funcId = 578;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        boy boy = (boy) this.rr.iLK.iLR;
        this.AZs = str;
        boy.KZu = str;
        Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "pid ".concat(String.valueOf(str)));
        boy.Lca = str2;
        boy.LWZ = drVar;
        AppMethodBeat.o(66891);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66892);
        boz boz = (boz) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0 && boz.KOt == 0) {
            Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "resp.ExpressCount " + boz.LXb);
            this.AZk = boz.LXa;
        }
        if (i4 == 0 && boz.KOt != 0) {
            i4 = boz.KOt;
            str = boz.KOu;
        }
        Log.d("MicroMsg.NetSceneMallGetLastestExpressInfo", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66892);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 578;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(66893);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66893);
        return dispatch;
    }
}
