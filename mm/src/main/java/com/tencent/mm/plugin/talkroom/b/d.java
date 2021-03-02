package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.ego;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;

public final class d extends f {
    public int FQw;
    public int actionType;
    private i callback;
    private final com.tencent.mm.ak.d rr;
    private int sceneType = 0;
    private final String yJB;

    public d(int i2, long j2, int i3, String str, int i4) {
        AppMethodBeat.i(29561);
        this.sceneType = i4;
        d.a aVar = new d.a();
        aVar.iLN = new egn();
        aVar.iLO = new ego();
        aVar.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        aVar.funcId = TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL;
        aVar.iLP = 146;
        aVar.respCmdId = 1000000146;
        this.rr = aVar.aXF();
        egn egn = (egn) this.rr.iLK.iLR;
        egn.LsZ = i2;
        egn.Lta = j2;
        egn.KWb = i3;
        egn.KHb = (int) Util.nowSecond();
        this.actionType = i3;
        this.yJB = str;
        egn.Scene = i4;
        AppMethodBeat.o(29561);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29562);
        Log.d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29562);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final String fui() {
        return this.yJB;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29563);
        Log.d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            this.FQw = ((ego) this.rr.iLL.iLR).Ltb;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29563);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29563);
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final int fuj() {
        return this.sceneType;
    }
}
