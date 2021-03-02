package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.List;

public final class h extends q implements m {
    public i callback;
    public List<cfy> nZr;
    private d rr;

    public h(List<cfy> list) {
        AppMethodBeat.i(94982);
        d.a aVar = new d.a();
        this.nZr = list;
        aVar.iLN = new ch();
        aVar.iLO = new ci();
        aVar.uri = "/cgi-bin/mmux-bin/adlog";
        aVar.funcId = 1802;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ch chVar = (ch) this.rr.iLK.iLR;
        cfx cfx = new cfx();
        cfx.hid = com.tencent.mm.protocal.d.KyJ;
        cfx.hie = com.tencent.mm.protocal.d.KyI;
        cfx.hif = com.tencent.mm.protocal.d.KyL;
        cfx.hig = com.tencent.mm.protocal.d.KyM;
        cfx.hih = LocaleUtil.getApplicationLanguage();
        cfx.LOF = (int) (System.currentTimeMillis() / 1000);
        chVar.KGA = cfx;
        for (int i2 = 0; i2 < list.size(); i2++) {
            chVar.KGB.add(list.get(i2));
        }
        Log.i("MicroMsg.NetSceneAdLog", "report count: " + chVar.KGB.size());
        AppMethodBeat.o(94982);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(94983);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(94983);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1802;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(94984);
        Log.d("MicroMsg.NetSceneAdLog", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            int i5 = ((ci) ((d) sVar).iLL.iLR).KGC;
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.BUSINESS_SNS_ADLOG_FREQUENCY_INT, Integer.valueOf(i5));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(94984);
    }
}
