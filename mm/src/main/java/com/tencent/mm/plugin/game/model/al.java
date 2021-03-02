package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bgf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class al extends q implements m {
    private i callback;
    public String dDv;
    public final d hhm;

    public al(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.i(41595);
        d.a aVar = new d.a();
        aVar.iLN = new bge();
        aVar.iLO = new bgf();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        if (str2 == null) {
            this.dDv = "";
        } else {
            this.dDv = str2.trim();
        }
        this.hhm = aVar.aXF();
        bge bge = (bge) this.hhm.iLK.iLR;
        bge.xLl = str;
        bge.LPT = str2;
        bge.LPU = linkedList;
        AppMethodBeat.o(41595);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41596);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41596);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41597);
        Log.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41597);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1329;
    }
}
