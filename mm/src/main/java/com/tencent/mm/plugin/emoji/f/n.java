package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.af.h;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private i callback;
    public byte[] rcY = null;
    private String rcZ;
    private final d rr;

    public n(String str, byte[] bArr) {
        AppMethodBeat.i(108703);
        d.a aVar = new d.a();
        aVar.iLN = new bmt();
        aVar.iLO = new bmu();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.funcId = h.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcY = bArr;
        this.rcZ = str;
        AppMethodBeat.o(108703);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108704);
        Log.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i3 + "   errCode:" + i4);
        bmu bmu = (bmu) ((d) sVar).iLL.iLR;
        if (bmu.KIk != null) {
            this.rcY = z.a(bmu.KIk);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108704);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return h.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108705);
        this.callback = iVar;
        bmt bmt = (bmt) this.rr.iLK.iLR;
        if (this.rcY != null) {
            bmt.ReqBuf = z.aC(this.rcY);
        } else {
            bmt.ReqBuf = new SKBuiltinBuffer_t();
        }
        bmt.ProductID = this.rcZ;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108705);
        return dispatch;
    }

    public final bmu cGw() {
        return (bmu) this.rr.iLL.iLR;
    }
}
