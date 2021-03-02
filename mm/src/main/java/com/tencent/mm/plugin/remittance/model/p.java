package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private vs CoM = ((vs) this.hJu.iLK.iLR);
    public vt CoN;
    private i callback;
    private d hJu;

    public p(String str, String str2, int i2, String str3, String str4, int i3, int i4, String str5, String str6) {
        AppMethodBeat.i(67868);
        d.a aVar = new d.a();
        aVar.iLN = new vs();
        aVar.iLO = new vt();
        aVar.funcId = 2773;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.CoM.KHM = str;
        this.CoM.KHN = str2;
        this.CoM.yRL = i2;
        this.CoM.CpD = str3;
        this.CoM.CpC = str4;
        this.CoM.channel = i3;
        this.CoM.Coi = i4;
        this.CoM.LgK = str5;
        this.CoM.LgL = str6;
        AppMethodBeat.o(67868);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2773;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67869);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(67869);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(67870);
        Log.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.CoN = (vt) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.CoN.dDN), this.CoN.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(67870);
    }
}
