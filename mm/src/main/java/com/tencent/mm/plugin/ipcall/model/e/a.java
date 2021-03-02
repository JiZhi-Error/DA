package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.j;
import com.tencent.mm.protocal.protobuf.dff;
import com.tencent.mm.protocal.protobuf.dfg;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback = null;
    private d rr = null;
    public dff yrn = null;
    private dfg yro = null;

    public a(int i2, long j2, String str, String str2, int i3, long j3) {
        AppMethodBeat.i(25451);
        d.a aVar = new d.a();
        aVar.iLN = new dff();
        aVar.iLO = new dfg();
        aVar.funcId = j.CTRL_INDEX;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        long currentTimeMillis = System.currentTimeMillis();
        this.yrn = (dff) this.rr.iLK.iLR;
        this.yrn.LsZ = i2;
        this.yrn.Lta = j2;
        this.yrn.xNG = str;
        this.yrn.MKf = currentTimeMillis;
        this.yrn.MKg = i3;
        this.yrn.MKh = str2;
        this.yrn.MKi = j3;
        Log.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", Integer.valueOf(i2), Long.valueOf(j2), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i3), str2, Long.valueOf(j3));
        AppMethodBeat.o(25451);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return j.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25452);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25452);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25453);
        Log.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yro = (dfg) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25453);
    }
}
