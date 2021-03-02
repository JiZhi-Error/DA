package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    public String dFw;
    public long gY;
    private d hJu;
    public vx qwf;
    public long qwg;
    private long qwh = System.currentTimeMillis();
    public int source;

    public i(int i2, b bVar, String str, int i3, long j2) {
        AppMethodBeat.i(63819);
        d.a aVar = new d.a();
        aVar.iLN = new vw();
        aVar.iLO = new vx();
        aVar.funcId = 1384;
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        vw vwVar = (vw) this.hJu.iLK.iLR;
        vwVar.yRL = i2;
        vwVar.Lba = 0;
        vwVar.qwM = str;
        vwVar.Lhb = null;
        vwVar.Lhc = bVar;
        this.dFw = str;
        this.source = i3;
        this.gY = j2;
        Log.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i2), str);
        AppMethodBeat.o(63819);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1384;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(63820);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63820);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63821);
        Log.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.qwf = (vx) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.qwf.dDN), this.qwf.qwn, Integer.valueOf(this.qwf.Lba));
        this.qwg = System.currentTimeMillis() - this.qwh;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63821);
    }
}
