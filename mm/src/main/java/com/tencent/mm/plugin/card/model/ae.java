package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ae extends q implements m {
    private i callback;
    public dgv pUr;
    private final d rr;

    public ae(LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(112849);
        d.a aVar = new d.a();
        aVar.iLN = new bmn();
        aVar.iLO = new bmo();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        aVar.funcId = 1382;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bmn bmn = (bmn) this.rr.iLK.iLR;
        bmn.LVo = linkedList;
        bmn.scene = i2;
        AppMethodBeat.o(112849);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112850);
        Log.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            this.pUr = ((bmo) this.rr.iLL.iLR).LVp;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112850);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1382;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112851);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112851);
        return dispatch;
    }
}
