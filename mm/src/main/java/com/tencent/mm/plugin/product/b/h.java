package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class h extends q implements m {
    public String AZs;
    public m AZt;
    public List<n> AZu;
    private i callback;
    private d rr;

    public h(m mVar, String str) {
        AppMethodBeat.i(66894);
        d.a aVar = new d.a();
        aVar.iLN = new bsw();
        aVar.iLO = new bsx();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        aVar.funcId = 553;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bsw bsw = (bsw) this.rr.iLK.iLR;
        this.AZs = str;
        bsw.LZy = str;
        Log.d("MicroMsg.NetSceneMallGetProductDetail", "pid ".concat(String.valueOf(str)));
        bsw.Version = 0;
        this.AZt = mVar;
        AppMethodBeat.o(66894);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66895);
        bsx bsx = (bsx) ((d) sVar).iLL.iLR;
        if (!Util.isNullOrNil(bsx.LZA)) {
            Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + bsx.LZA);
            this.AZt = m.a(this.AZt, bsx.LZA);
        }
        if (i4 == 0 && bsx.KOt != 0) {
            i4 = bsx.KOt;
            str = bsx.KOu;
        }
        if (!Util.isNullOrNil(bsx.LZB)) {
            Log.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + bsx.LZB);
            this.AZu = n.parse(bsx.LZB);
        }
        Log.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i4 + ", errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66895);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 553;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(66896);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66896);
        return dispatch;
    }
}
