package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.g;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class y extends q implements m {
    private long DJc = 0;
    public i callback;
    private int dJY;
    private d rr;

    public y(long j2, String str) {
        AppMethodBeat.i(95658);
        Log.d("MicroMsg.NetSceneSnsTagOption", "opcode 3 snsTagId " + j2 + " tagName " + str);
        this.DJc = j2;
        this.dJY = 3;
        d.a aVar = new d.a();
        aVar.iLN = new ebb();
        aVar.iLO = new ebc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.funcId = g.CTRL_INDEX;
        aVar.iLP = 114;
        aVar.respCmdId = 1000000114;
        this.rr = aVar.aXF();
        ebb ebb = (ebb) this.rr.iLK.iLR;
        ebb.OpCode = 3;
        ebb.Nar = j2;
        ebb.xMo = str;
        AppMethodBeat.o(95658);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return g.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(95659);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95659);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95660);
        Log.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            eaw eaw = ((ebc) ((d) sVar).iLL.iLR).Nat;
            Log.d("MicroMsg.NetSceneSnsTagOption", eaw.toString());
            switch (this.dJY) {
                case 1:
                case 2:
                    com.tencent.mm.plugin.sns.storage.s JL = aj.faU().JL(eaw.Nar);
                    JL.field_tagId = eaw.Nar;
                    JL.field_tagName = Util.nullAs(eaw.xMo, "");
                    JL.field_count = eaw.oTz;
                    JL.gX(eaw.oTA);
                    aj.faU().a(JL);
                    break;
                case 3:
                    Log.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL ".concat(String.valueOf(aj.faU().JM(this.DJc))));
                    break;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(95660);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95660);
    }
}
