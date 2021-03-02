package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i heq;
    public String rcT;
    private String rcU;
    public final d rr;

    public k(String str, String str2) {
        AppMethodBeat.i(108692);
        d.a aVar = new d.a();
        aVar.iLN = new bmp();
        aVar.iLO = new bmq();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        aVar.funcId = 368;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcT = str;
        this.rcU = str2;
        AppMethodBeat.o(108692);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108693);
        this.heq = iVar;
        bmp bmp = (bmp) this.rr.iLK.iLR;
        bmp.LVq = this.rcT;
        bmp.Md5 = this.rcU;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108693);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108694);
        Log.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108694);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 368;
    }
}
