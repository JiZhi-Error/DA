package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccz;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k extends q implements m {
    private i callback;
    LinkedList<dqi> iLb = null;
    LinkedList<ccz> iLc = null;

    public k(LinkedList<dqi> linkedList) {
        this.iLb = linkedList;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150294);
        if (this.iLb == null || this.iLb.size() <= 0) {
            Log.e("MicroMsg.NetSceneBatchGetHeadImg", f.apq() + "doScene ReqSize==0");
            AppMethodBeat.o(150294);
            return -1;
        }
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new kq();
        aVar.iLO = new kr();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetheadimg";
        aVar.funcId = 123;
        aVar.iLP = 15;
        aVar.respCmdId = 1000000015;
        d aXF = aVar.aXF();
        kq kqVar = (kq) aXF.iLK.iLR;
        kqVar.KGP = this.iLb;
        kqVar.oTz = this.iLb.size();
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(150294);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 20;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150295);
        Log.d("MicroMsg.NetSceneBatchGetHeadImg", "errType:" + i3 + " errCode:" + i4);
        this.iLc = ((kr) ((d) sVar).iLL.iLR).KOI;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150295);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 123;
    }
}
