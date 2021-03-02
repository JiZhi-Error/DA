package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dme;
import com.tencent.mm.protocal.protobuf.dmf;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m, e {
    private i callback;
    private d rr;
    private boolean sPX = false;
    private String sQa = null;

    public n(long j2, String str, String str2) {
        AppMethodBeat.i(103610);
        d.a aVar = new d.a();
        aVar.iLN = new dme();
        aVar.iLO = new dmf();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dme dme = (dme) this.rr.iLK.iLR;
        dme.LTb = j2;
        dme.MPK = str;
        dme.MPL = str2;
        AppMethodBeat.o(103610);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 918;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103611);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103611);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103612);
        dmf dmf = (dmf) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            this.sPX = dmf.MPN == 0;
            this.sQa = dmf.MPM;
            i4 = dmf.MPN;
            Log.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", Boolean.valueOf(this.sPX));
        } else if (!(dmf == null || dmf.MPN == 0)) {
            Log.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i4 = dmf.MPN;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103612);
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final boolean cSO() {
        return true;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final String cSP() {
        return this.sQa;
    }
}
