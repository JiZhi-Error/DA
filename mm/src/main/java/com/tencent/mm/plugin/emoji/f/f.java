package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class f extends q implements m {
    private i callback;
    public final d rr;

    public f(LinkedList<String> linkedList) {
        AppMethodBeat.i(199782);
        d.a aVar = new d.a();
        ka kaVar = new ka();
        kaVar.KOo = linkedList;
        kaVar.ReqType = e.rcw;
        aVar.iLN = kaVar;
        aVar.iLO = new kb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojidownload";
        aVar.funcId = 697;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(199782);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 697;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(199783);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(199783);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(199784);
        Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            kb kbVar = (kb) this.rr.iLL.iLR;
            if (kbVar.KOp == null || kbVar.KOp.size() <= 0) {
                Log.i("MicroMsg.emoji.NetSceneCheckEmoijExistByp", "Change MD5 to URL failed.");
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(199784);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(199784);
    }
}
