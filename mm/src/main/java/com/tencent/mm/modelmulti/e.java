package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bos;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    public String content = "";
    public int jcv = 0;
    private d rr;
    public String title = "";

    public e(int i2) {
        AppMethodBeat.i(20543);
        d.a aVar = new d.a();
        aVar.iLN = new bos();
        aVar.iLO = new bot();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.funcId = 1803;
        this.rr = aVar.aXF();
        ((bos) this.rr.iLK.iLR).LWR = i2;
        this.jcv = i2;
        AppMethodBeat.o(20543);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20544);
        Log.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            bot bot = (bot) this.rr.iLL.iLR;
            this.title = bot.LWS;
            this.content = bot.LWT;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(20544);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20544);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1803;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20545);
        Log.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20545);
        return dispatch;
    }
}
