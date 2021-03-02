package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.facedetect.b.j;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class o extends p implements m, e {
    private final s iMO = new f();
    private boolean sPX = false;
    private String sQb = "";

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final boolean cSO() {
        return true;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.e
    public final String cSP() {
        return this.sQb;
    }

    public o(long j2, String str, String str2) {
        AppMethodBeat.i(103613);
        j.a aVar = (j.a) this.iMO.getReqObj();
        aVar.sPJ.LSY = p.sQc;
        aVar.sPJ.LTb = j2;
        aVar.sPJ.MPK = str;
        aVar.sPJ.MPL = str2;
        AppMethodBeat.o(103613);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final int f(g gVar) {
        AppMethodBeat.i(103614);
        this.iMO.getReqObj();
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(103614);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final void setSecurityCheckError(q.a aVar) {
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 930;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final void c(int i2, int i3, String str, s sVar) {
        boolean z = true;
        AppMethodBeat.i(103615);
        Log.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        j.b bVar = (j.b) sVar.getRespObj();
        if (i2 == 0 && i3 == 0) {
            this.sPX = bVar.sPK.MPN == 0;
            this.sQb = bVar.sPK.MPM;
            i3 = bVar.sPK.MPN;
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.sPX);
            objArr[1] = Integer.valueOf(bVar.sPK.MPN);
            if (Util.isNullOrNil(this.sQb)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b", objArr);
        } else if (!(bVar == null || bVar.sPK == null || bVar.sPK.MPN == 0)) {
            Log.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i3 = bVar.sPK.MPN;
        }
        this.callback.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103615);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final void ary(String str) {
        AppMethodBeat.i(103616);
        ((j.a) this.iMO.getReqObj()).sPJ.LSY = str;
        AppMethodBeat.o(103616);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final ctc f(s sVar) {
        AppMethodBeat.i(103617);
        ctc ctc = ((j.b) sVar.getRespObj()).sPK.LTd;
        AppMethodBeat.o(103617);
        return ctc;
    }
}
