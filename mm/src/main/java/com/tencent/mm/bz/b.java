package com.tencent.mm.bz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dns;
import com.tencent.mm.protocal.protobuf.dnt;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    private final d iLF;

    public b(dns dns) {
        AppMethodBeat.i(9330);
        d.a aVar = new d.a();
        aVar.iLN = new dns();
        aVar.iLO = new dnt();
        aVar.uri = "/cgi-bin/micromsg-bin/reportmediainfo";
        aVar.funcId = 809;
        this.iLF = aVar.aXF();
        dns dns2 = (dns) this.iLF.iLK.iLR;
        dns2.MQO = dns.MQO;
        dns2.MQN = dns.MQN;
        dns2.KTg = dns.KTg;
        dns2.EmotionList.addAll(dns.EmotionList);
        dns2.oUv = dns.oUv;
        AppMethodBeat.o(9330);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 809;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(9331);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iLF, this);
        AppMethodBeat.o(9331);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(9332);
        Log.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(hashCode()));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(9332);
    }
}
