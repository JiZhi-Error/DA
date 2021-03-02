package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    private d rr;

    public i(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202035);
        d.a aVar = new d.a();
        aVar.iLN = new bvl();
        aVar.iLO = new bvm();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_sns_ad_metric";
        aVar.funcId = 4342;
        this.rr = aVar.aXF();
        bvl bvl = (bvl) this.rr.iLK.iLR;
        bvl.pTI = 1;
        bvl.MbA = str;
        bvl.aid = str2;
        bvl.MbB = str3;
        bvl.gTk = str4;
        AppMethodBeat.o(202035);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(202036);
        int type = this.rr.getType();
        AppMethodBeat.o(202036);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(202037);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(202037);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(202038);
        Log.i("NetSceneDynamicAdDataUpdate", "errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(202038);
    }
}
