package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.facedetect.b.k;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t extends p implements m, e {
    private final s iMO = new g();
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

    public t(long j2, String str, String str2) {
        AppMethodBeat.i(103629);
        k.a aVar = (k.a) this.iMO.getReqObj();
        aVar.sPL.LSY = p.sQc;
        aVar.sPL.LTb = j2;
        aVar.sPL.MPL = str2;
        aVar.sPL.MPK = str;
        AppMethodBeat.o(103629);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final int f(g gVar) {
        AppMethodBeat.i(103630);
        this.iMO.getReqObj();
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(103630);
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
        AppMethodBeat.i(103631);
        Log.d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        k.b bVar = (k.b) sVar.getRespObj();
        if (i2 == 0 && i3 == 0) {
            this.sPX = bVar.sPM.MPN == 0;
            this.sQb = bVar.sPM.MPM;
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.sPX);
            objArr[1] = Integer.valueOf(bVar.sPM.MPN);
            if (Util.isNullOrNil(this.sQb)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b", objArr);
            i3 = bVar.sPM.MPN;
        } else if (!(bVar == null || bVar.sPM == null || bVar.sPM.MPN == 0)) {
            Log.i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i3 = bVar.sPM.MPN;
        }
        this.callback.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103631);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final void ary(String str) {
        AppMethodBeat.i(103632);
        ((k.a) this.iMO.getReqObj()).sPL.LSY = str;
        AppMethodBeat.o(103632);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final ctc f(s sVar) {
        AppMethodBeat.i(103633);
        ctc ctc = ((k.b) sVar.getRespObj()).sPM.LTd;
        AppMethodBeat.o(103633);
        return ctc;
    }
}
