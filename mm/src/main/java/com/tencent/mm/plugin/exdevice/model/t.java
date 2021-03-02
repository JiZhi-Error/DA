package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drl;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.sdk.platformtools.Log;

public final class t extends q implements m {
    private i callback = null;
    private d rr = null;

    public t(String str, String str2, String str3) {
        AppMethodBeat.i(23407);
        d.a aVar = new d.a();
        aVar.iLN = new drl();
        aVar.iLO = new drm();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.funcId = 1706;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        drl drl = (drl) this.rr.iLK.iLR;
        drl.mac = str;
        drl.userName = str2 == null ? "" : str2;
        drl.category = str3 == null ? "" : str3;
        AppMethodBeat.o(23407);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23408);
        Log.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i2 + " errType = " + i3 + " errCode = " + i4 + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23408);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1706;
    }

    public final drm cKH() {
        return (drm) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23409);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23409);
        return dispatch;
    }
}
