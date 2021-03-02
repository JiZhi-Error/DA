package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.dsw;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends q implements m {
    private i callback = null;
    public d rr = null;

    public v(String str, String str2, String str3) {
        AppMethodBeat.i(23413);
        d.a aVar = new d.a();
        aVar.iLN = new dsw();
        aVar.iLO = new dsx();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchwifiharddevice";
        aVar.funcId = 1270;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dsw dsw = (dsw) this.rr.iLK.iLR;
        dsw.KPD = new cat();
        dsw.KPD.KLO = str;
        dsw.KPD.oTH = str2;
        dsw.MUY = str3;
        AppMethodBeat.o(23413);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23414);
        Log.i("MicroMsg.exdevice.NetSceneSearchWiFiHardDevice", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23414);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1270;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23415);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23415);
        return dispatch;
    }
}
