package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjh;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class u extends q implements m, b {
    private i callback;
    private d rr;
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

    public u(int i2, int i3, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(186361);
        d.a aVar = new d.a();
        aVar.iLN = new bjh();
        aVar.iLO = new bji();
        aVar.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bjh bjh = (bjh) this.rr.iLK.iLR;
        bjh.oUv = 1;
        bjh.Scene = i2;
        bjh.LSZ = i3;
        bjh.dNI = str;
        bjh.KRB = str2;
        bjh.LTa = b.cD(bArr);
        AppMethodBeat.o(186361);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(103635);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(103635);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(103636);
        bji bji = (bji) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            this.sQh = bji.LTb;
            if (bji.LTc != null) {
                this.sQj = bji.LTc.zy;
            }
            this.sQi = bji.LTf;
            if (bji.LTa != null) {
                this.sQk = bji.LTa.zy;
            }
            Log.i("MicroMsg.NetSceneGetBioConfig", "carson logic bioId:%s Config is:%s ratio:%s", Long.valueOf(this.sQh), this.sQj, Float.valueOf(this.sQi));
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(103636);
    }
}
