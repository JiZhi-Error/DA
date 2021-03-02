package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.facedetect.b.i;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends p implements m, b {
    private final s iMO = new h();
    private long sQh = -1;
    private float sQi = 0.5f;
    private byte[] sQj = null;
    private byte[] sQk = null;

    @Override // com.tencent.mm.plugin.facedetect.b.b
    public final long cSK() {
        return this.sQh;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.b
    public final byte[] cSL() {
        return this.sQj;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.b
    public final float cSM() {
        if (this.sQi <= 0.0f || this.sQi > 1.0f) {
            this.sQi = 0.5f;
        }
        return this.sQi;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.b
    public final byte[] cSN() {
        return this.sQk;
    }

    public v(int i2, int i3) {
        AppMethodBeat.i(103637);
        i.a aVar = (i.a) this.iMO.getReqObj();
        aVar.sPH.LSY = p.sQc;
        aVar.sPH.oUv = 1;
        aVar.sPH.Scene = i2;
        aVar.sPH.LSZ = i3;
        AppMethodBeat.o(103637);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final int f(g gVar) {
        AppMethodBeat.i(103638);
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(103638);
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
        return 733;
    }

    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final void c(int i2, int i3, String str, s sVar) {
        byte[] bArr;
        byte[] bArr2;
        AppMethodBeat.i(103639);
        Log.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            i.b bVar = (i.b) sVar.getRespObj();
            this.sQh = bVar.sPI.LTb;
            this.sQi = bVar.sPI.LTf;
            if (bVar.sPI.LTc != null) {
                this.sQj = bVar.sPI.LTc.zy;
            }
            if (bVar.sPI.LTa != null) {
                this.sQk = bVar.sPI.LTa.zy;
            }
            if (bVar.sPI.LTe != null) {
                if (bVar.sPI.LTe.KQN == null || bVar.sPI.LTe.KQN.getILen() <= 0) {
                    bArr = null;
                } else {
                    Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(bVar.sPI.LTe.KQN.getILen()));
                    bArr = z.a(bVar.sPI.LTe.KQN);
                }
                if (bVar.sPI.LTe.KQO == null || bVar.sPI.LTe.KQO.getILen() <= 0) {
                    bArr2 = null;
                } else {
                    Log.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(bVar.sPI.LTe.KQO.getILen()));
                    bArr2 = z.a(bVar.sPI.LTe.KQO);
                }
                f.baR().a(bVar.sPI.LTe.KQK, bVar.sPI.LTe.KQL, bVar.sPI.LTe.KQM, bArr, bArr2, bVar.sPI.LTe.KQP);
            }
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf(this.sQh);
            objArr[1] = Integer.valueOf(this.sQj == null ? 0 : this.sQj.length);
            objArr[2] = Float.valueOf(this.sQi);
            Log.i("MicroMsg.NetSceneGetBioConfigRsa", "hy: get bio config: bioId: %s, bioConfigSize: %d ratio:%s", objArr);
        }
        this.callback.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(103639);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final void ary(String str) {
        AppMethodBeat.i(103640);
        ((i.a) this.iMO.getReqObj()).sPH.LSY = str;
        AppMethodBeat.o(103640);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.facedetect.b.p
    public final ctc f(s sVar) {
        AppMethodBeat.i(103641);
        ctc ctc = ((i.b) sVar.getRespObj()).sPI.LTd;
        AppMethodBeat.o(103641);
        return ctc;
    }
}
