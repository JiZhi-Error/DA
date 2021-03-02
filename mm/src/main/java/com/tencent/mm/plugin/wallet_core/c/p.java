package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhp;
import com.tencent.mm.protocal.protobuf.dhq;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    public String FJm;
    private dhp HPT = ((dhp) this.hJu.iLK.iLR);
    public dhq HPU;
    private i callback;
    private d hJu;

    public p(String str, String str2) {
        AppMethodBeat.i(69923);
        d.a aVar = new d.a();
        aVar.iLN = new dhp();
        aVar.iLO = new dhq();
        aVar.funcId = 2710;
        aVar.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HPT.Iie = str;
        this.FJm = str2;
        Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", str, str2);
        AppMethodBeat.o(69923);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2710;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69924);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(69924);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69925);
        Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.HPU = (dhq) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            Log.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.HPU.pTZ), this.HPU.pUa);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69925);
    }
}
