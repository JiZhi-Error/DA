package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.cyx;
import com.tencent.mm.protocal.protobuf.cyy;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private a JXB;
    private i callback;
    private d rr;

    public interface a {
        void a(boolean z, int i2, cyx cyx);
    }

    public b(String str, cyy cyy, int i2, byte[] bArr, a aVar) {
        AppMethodBeat.i(223770);
        d.a aVar2 = new d.a();
        aVar2.iLN = new cyw();
        aVar2.iLO = new cyx();
        aVar2.uri = "/cgi-bin/micromsg-bin/parallelupload";
        aVar2.funcId = 3784;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        cyw cyw = (cyw) this.rr.iLK.iLR;
        cyw.MDU = str;
        cyw.MDV = cyy;
        cyw.MDW = i2;
        cyw.MDX = new com.tencent.mm.bw.b(bArr);
        this.JXB = aVar;
        AppMethodBeat.o(223770);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3784;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(223771);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(223771);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(223772);
        Log.d("MicroMsg.NetSceneCGIParallelUpload", "summerbig onGYNetEnd [%d, %d, %s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (4 == i3 || (i3 == 0 && i4 == 0)) {
            cyx cyx = (cyx) ((d) sVar).iLL.iLR;
            if (cyx.getBaseResponse().Ret == 0) {
                this.JXB.a(true, 0, cyx);
                AppMethodBeat.o(223772);
                return;
            }
            this.JXB.a(false, cyx.getBaseResponse().Ret, null);
            AppMethodBeat.o(223772);
            return;
        }
        Log.e("MicroMsg.NetSceneCGIParallelUpload", "onSceneEnd errType = " + i3 + ", errCode = " + i4 + ", errMsg:" + str);
        this.JXB.a(false, i4, null);
        AppMethodBeat.o(223772);
    }
}
