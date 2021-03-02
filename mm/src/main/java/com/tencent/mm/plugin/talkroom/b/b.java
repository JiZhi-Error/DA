package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public final class b extends q implements m {
    private i callback;
    private final d rr;
    private int sceneType;

    public b(int i2, long j2, String str, int i3) {
        AppMethodBeat.i(29554);
        this.sceneType = i3;
        d.a aVar = new d.a();
        aVar.iLN = new ajy();
        aVar.iLO = new ajz();
        aVar.uri = "/cgi-bin/micromsg-bin/exittalkroom";
        aVar.funcId = TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL;
        aVar.iLP = 148;
        aVar.respCmdId = 1000000148;
        this.rr = aVar.aXF();
        ajy ajy = (ajy) this.rr.iLK.iLR;
        ajy.LsY = str;
        ajy.LsZ = i2;
        ajy.Lta = j2;
        ajy.Scene = i3;
        AppMethodBeat.o(29554);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29555);
        Log.d("MicroMsg.NetSceneExitTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29555);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.ERROR_ONE_ENTRY_INIT_NULL;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29556);
        Log.d("MicroMsg.NetSceneExitTalkRoom", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29556);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29556);
    }
}
