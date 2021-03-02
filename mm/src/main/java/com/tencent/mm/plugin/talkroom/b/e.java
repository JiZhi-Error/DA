package com.tencent.mm.plugin.talkroom.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.protocal.protobuf.egq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends f {
    private i callback;
    private final d rr;
    private int sceneType = 0;
    private final String yJB;

    public e(String str, int i2, long j2, int i3) {
        AppMethodBeat.i(29564);
        this.sceneType = i3;
        d.a aVar = new d.a();
        aVar.iLN = new egp();
        aVar.iLO = new egq();
        aVar.uri = "/cgi-bin/micromsg-bin/talknoop";
        aVar.funcId = 335;
        aVar.iLP = 149;
        aVar.respCmdId = 1000000149;
        this.rr = aVar.aXF();
        egp egp = (egp) this.rr.iLK.iLR;
        egp.LsZ = i2;
        egp.Lta = j2;
        egp.KHb = (int) Util.nowSecond();
        this.yJB = str;
        egp.Scene = i3;
        AppMethodBeat.o(29564);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29565);
        Log.d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29565);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 335;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29566);
        Log.d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29566);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29566);
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final String fui() {
        return this.yJB;
    }

    @Override // com.tencent.mm.plugin.talkroom.b.f
    public final int fuj() {
        return this.sceneType;
    }
}
