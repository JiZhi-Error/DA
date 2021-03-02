package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.protocal.protobuf.bsk;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    public String HPH = "";
    public boolean HPI = false;
    private i callback;
    private d rr;

    public j() {
        AppMethodBeat.i(69908);
        d.a aVar = new d.a();
        aVar.iLN = new bsk();
        aVar.iLO = new bsl();
        aVar.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        aVar.funcId = 2541;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(69908);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2541;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69909);
        this.callback = iVar;
        c.eBv().sC(false);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69909);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69910);
        Log.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i3 + ", errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            bsl bsl = (bsl) ((d) sVar).iLL.iLR;
            this.HPH = bsl.HPH;
            this.HPI = bsl.HPI;
            Log.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", this.HPH, Boolean.valueOf(this.HPI));
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(69910);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69910);
    }
}
