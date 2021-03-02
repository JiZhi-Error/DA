package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.game.e.a.e;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private final d iUB;
    public Object tag;

    public c(String str) {
        AppMethodBeat.i(104520);
        d.a aVar = new d.a();
        aVar.iLN = new cfj();
        aVar.iLO = new cfk();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        aVar.funcId = e.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        ((cfj) this.iUB.iLK.iLR).Url = str;
        AppMethodBeat.o(104520);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return e.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(104521);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(104521);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(104522);
        Log.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(104522);
    }

    public final cfk bbD() {
        return (cfk) this.iUB.iLL.iLR;
    }
}
