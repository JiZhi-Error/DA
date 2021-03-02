package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cpq;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class r extends q implements m {
    private i heq;
    public String rcD;
    private int rdj;
    private final d rr;

    public r(String str, int i2) {
        AppMethodBeat.i(108719);
        this.rcD = str;
        if (!Util.isNullOrNil(str) && str.equals(String.valueOf(EmojiGroupInfo.VkN))) {
            this.rcD = "com.tencent.xin.emoticon.tusiji";
        }
        this.rdj = i2;
        d.a aVar = new d.a();
        aVar.iLN = new cpq();
        aVar.iLO = new cpr();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.funcId = 413;
        aVar.iLP = 212;
        aVar.respCmdId = 1000000212;
        this.rr = aVar.aXF();
        Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "NetSceneModEmotionPack: %s, %s", str, Integer.valueOf(i2));
        AppMethodBeat.o(108719);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 413;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108720);
        this.heq = iVar;
        cpq cpq = (cpq) this.rr.iLK.iLR;
        cpq.ProductID = this.rcD;
        cpq.OpCode = this.rdj;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108720);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108721);
        Log.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            if (this.rdj == 1) {
                h.INSTANCE.idkeyStat(165, 2, 1, false);
            } else {
                h.INSTANCE.idkeyStat(165, 4, 1, false);
            }
            this.heq.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(108721);
            return;
        }
        this.heq.onSceneEnd(i3, i4, str, this);
        if (this.rdj == 1) {
            h.INSTANCE.idkeyStat(165, 3, 1, false);
            Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            AppMethodBeat.o(108721);
            return;
        }
        h.INSTANCE.idkeyStat(165, 5, 1, false);
        Log.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", this.rcD);
        AppMethodBeat.o(108721);
    }
}
