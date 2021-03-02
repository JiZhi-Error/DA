package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.d.b;
import com.tencent.mm.protocal.protobuf.dfq;
import com.tencent.mm.protocal.protobuf.dfr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public final class l extends q implements m {
    private i callback;
    private d rr = null;
    private dfq yrK = null;
    private dfr yrL = null;

    public l(int i2, long j2, boolean z) {
        AppMethodBeat.i(25484);
        d.a aVar = new d.a();
        aVar.iLN = new dfq();
        aVar.iLO = new dfr();
        aVar.funcId = TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnreport";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrK = (dfq) this.rr.iLK.iLR;
        this.yrK.LsZ = i2;
        this.yrK.MKi = j2;
        this.yrK.MKB = z ? 1 : 0;
        Log.d("MicroMsg.NetSceneIPCallReport", "NetSceneIPCallReport, roomId: %d, callseq: %d, gotAnswer: %d", Integer.valueOf(this.yrK.LsZ), Long.valueOf(this.yrK.MKi), Integer.valueOf(this.yrK.MKB));
        dfq dfq = this.yrK;
        b eau = com.tencent.mm.plugin.ipcall.model.i.eau();
        String str = eau.roomId + "," + eau.ypH + "," + eau.yqW + "," + eau.kik + "," + eau.yqX + "," + eau.yqM + "," + eau.yqN + "," + eau.yqO + "," + eau.yqP + "," + eau.yqQ + "," + eau.yqR + "," + eau.yqS + "," + eau.yqT + "," + eau.yqU + "," + eau.yqV + "," + eau.yqY + "," + c.ebM() + "," + eau.yrh + "," + eau.countryCode + "," + eau.yri + "," + eau.yrj + "," + eau.yrk + eau.yrf + "," + eau.yrm;
        Log.i("MicroMsg.IPCallReportHelper", "getPstnClientReportString, result: %s", str);
        dfq.MKy = z.Su(str);
        dfq dfq2 = this.yrK;
        b eau2 = com.tencent.mm.plugin.ipcall.model.i.eau();
        String str2 = eau2.roomId + "," + eau2.ypH + "," + eau2.yqW + eau2.yre;
        Log.i("MicroMsg.IPCallReportHelper", "getPstnChannelReportString, result: %s", str2);
        dfq2.MKz = z.Su(str2);
        dfq dfq3 = this.yrK;
        b eau3 = com.tencent.mm.plugin.ipcall.model.i.eau();
        String str3 = eau3.roomId + "," + eau3.ypH + "," + eau3.yqW + eau3.yrd;
        Log.i("MicroMsg.IPCallReportHelper", "getPstnEngineReport, result: %s", str3);
        dfq3.MKA = z.Su(str3);
        AppMethodBeat.o(25484);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25485);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25485);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25486);
        Log.i("MicroMsg.NetSceneIPCallReport", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrL = (dfr) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25486);
    }
}
