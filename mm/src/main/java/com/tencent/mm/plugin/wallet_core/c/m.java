package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bin;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private bin HPN = ((bin) this.hJu.iLK.iLR);
    public bio HPO;
    private i callback;
    public long crw;
    private d hJu;

    public m(String str, long j2) {
        AppMethodBeat.i(69914);
        d.a aVar = new d.a();
        aVar.iLN = new bin();
        aVar.iLO = new bio();
        aVar.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        aVar.funcId = 2948;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HPN.LSE = str;
        this.crw = j2;
        Log.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", str, Long.valueOf(j2));
        AppMethodBeat.o(69914);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2948;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69915);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(69915);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69916);
        Log.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.HPO = (bio) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            Log.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", Integer.valueOf(this.HPO.pTZ), this.HPO.pUa, Integer.valueOf(this.HPO.LSF), this.HPO.LSG, this.HPO.LSH);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69916);
    }
}
