package com.tencent.mm.plugin.newtips.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class c extends q implements m {
    private i callback;
    private String dUb;
    private d rr;

    public c(String str) {
        AppMethodBeat.i(184028);
        d.a aVar = new d.a();
        aVar.iLN = new dgf();
        aVar.iLO = new dgg();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.funcId = 597;
        this.rr = aVar.aXF();
        ((dgf) this.rr.iLK.iLR).KSL = str;
        this.dUb = str;
        AppMethodBeat.o(184028);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(184029);
        if (i3 == 0 && i4 == 0) {
            dgg dgg = (dgg) ((d) sVar).iLL.iLR;
            String str2 = this.dUb;
            boolean z = dgg.MKT;
            Log.i("MicroMsg.NewTips.NewTipsHelper", "setLocalNewTipsState() uniqueId:%s isReject:%s", str2, Boolean.valueOf(z));
            MultiProcessMMKV.getMMKV("new_tips").edit().putBoolean(str2, z).commit();
            this.callback.onSceneEnd(i3, i4, str, this);
            Log.i("MicroMsg.NewTips.NetScenePushNewTips", "onGYNetEnd() uniqueId:%s IsReject:%s", this.dUb, Boolean.valueOf(dgg.MKT));
            AppMethodBeat.o(184029);
            return;
        }
        Log.e("MicroMsg.NewTips.NetScenePushNewTips", "errType:" + i3 + " errCode:" + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(184029);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 597;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(184030);
        Log.d("MicroMsg.NewTips.NetScenePushNewTips", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(184030);
        return dispatch;
    }
}
