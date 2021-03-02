package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private i callback;
    String content;
    int key;
    private int scene = 0;
    int type;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2743;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(220620);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new akj();
        aVar.iLO = new akk();
        aVar.uri = "/cgi-bin/mmexptappsvr-bin/reportexptdebug";
        aVar.funcId = 2743;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        akj akj = (akj) aXF.iLK.iLR;
        akj.oUv = this.type;
        akj.Scene = this.scene == 0 ? (int) Util.nowSecond() : this.scene;
        akj.Cya = this.key;
        akj.iAc = this.content;
        int dispatch = dispatch(gVar, aXF, this);
        AppMethodBeat.o(220620);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(220621);
        Log.i("MicroMsg.NetSceneDebugReport", "send expt debug info ongynetend type[%d] errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(this.type), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(220621);
    }
}
