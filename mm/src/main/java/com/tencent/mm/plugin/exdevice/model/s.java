package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends q implements m {
    private i heq = null;
    private d rAy = null;
    private String rzn = null;

    public s(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(23404);
        d.a aVar = new d.a();
        aVar.iLN = new cba();
        aVar.iLO = new cbb();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/subscribestatus";
        aVar.funcId = 1090;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rAy = aVar.aXF();
        cba cba = (cba) this.rAy.iLK.iLR;
        cba.KOk = b.bfZ(str2);
        cba.KOi = b.bfZ(str3);
        cba.him = i2;
        this.rzn = str;
        AppMethodBeat.o(23404);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(23405);
        Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        ad.cKL().anJ(this.rzn);
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.exdevice.NetSceneHardDeviceStatusSubscribe", "HardDeviceStatusSubResponse: ret=" + ((cbb) this.rAy.iLL.iLR).getBaseResponse().Ret + ",msg=" + str);
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23405);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1090;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23406);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rAy, this);
        AppMethodBeat.o(23406);
        return dispatch;
    }
}
