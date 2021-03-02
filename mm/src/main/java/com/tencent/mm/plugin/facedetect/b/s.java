package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends q implements m, e {
    private i callback;
    private d rr;
    private boolean sPX = false;

    public s(long j2, String str, String str2) {
        AppMethodBeat.i(103626);
        d.a aVar = new d.a();
        aVar.iLN = new epl();
        aVar.iLO = new epm();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyface";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        epl epl = (epl) this.rr.iLK.iLR;
        epl.LTb = j2;
        epl.MPK = str;
        epl.MPL = str2;
        AppMethodBeat.o(103626);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 797;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103627);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103627);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(103628);
        epm epm = (epm) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            this.sPX = epm.MPN == 0;
            i4 = epm.MPN;
            Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", Boolean.valueOf(this.sPX));
        } else if (!(epm == null || epm.MPN == 0)) {
            Log.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i4 = epm.MPN;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103628);
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final boolean cSO() {
        return true;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final String cSP() {
        return null;
    }
}
