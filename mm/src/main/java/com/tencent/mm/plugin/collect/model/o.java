package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.wf;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    private i callback;
    public String dFw;
    public wg qwA;
    private d rr;

    public o(int i2, b bVar, String str) {
        AppMethodBeat.i(63835);
        d.a aVar = new d.a();
        aVar.iLN = new wf();
        aVar.iLO = new wg();
        aVar.funcId = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        wf wfVar = (wf) this.rr.iLK.iLR;
        wfVar.yRL = i2;
        wfVar.Lba = 0;
        wfVar.qwM = str;
        wfVar.Lhb = null;
        wfVar.Lhc = bVar;
        this.dFw = str;
        Log.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(63835);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1317;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63836);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(63836);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63837);
        Log.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.qwA = (wg) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.qwA.dDN), this.qwA.qwn, Integer.valueOf(this.qwA.Lba));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63837);
    }
}
