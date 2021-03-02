package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.protocal.protobuf.bkp;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ac extends q implements m {
    private i callback;
    public LinkedList<String> pQI;
    public int pQK;
    public int pQL;
    public int pQM;
    private final d rr;

    public ac(String str) {
        AppMethodBeat.i(112843);
        d.a aVar = new d.a();
        aVar.iLN = new bkp();
        aVar.iLO = new bkq();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.funcId = ah.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bkp) this.rr.iLK.iLR).eaO = str;
        AppMethodBeat.o(112843);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ah.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112844);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112844);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112845);
        Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            bkq bkq = (bkq) this.rr.iLL.iLR;
            this.pQI = bkq.pQI;
            this.pQK = bkq.pQK;
            this.pQL = bkq.pQL;
            this.pQM = bkq.pQM;
        }
        Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", Integer.valueOf(this.pQK), Integer.valueOf(this.pQL), Integer.valueOf(this.pQM));
        if (this.pQI != null) {
            Log.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.pQI.size());
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112845);
    }
}
