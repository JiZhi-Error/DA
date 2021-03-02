package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.protocal.protobuf.efn;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    public com.tencent.mm.ak.d rr;

    public d(String str, boolean z) {
        AppMethodBeat.i(6384);
        d.a aVar = new d.a();
        aVar.iLN = new efm();
        aVar.iLO = new efn();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        aVar.funcId = 1394;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        efm efm = (efm) this.rr.iLK.iLR;
        efm.KTt = str;
        efm.neT = z;
        AppMethodBeat.o(6384);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(6385);
        Log.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(6385);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1394;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(6386);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(6386);
        return dispatch;
    }

    public final efn eDY() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (efn) this.rr.iLL.iLR;
    }

    public final efm eDZ() {
        if (this.rr == null || this.rr.iLK.iLR == null) {
            return null;
        }
        return (efm) this.rr.iLK.iLR;
    }
}
