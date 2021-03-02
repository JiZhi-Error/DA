package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.EmotionDetail;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailRequest;
import com.tencent.mm.protocal.protobuf.GetEmotionDetailResponse;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class m extends q implements com.tencent.mm.network.m {
    private int cR;
    private i callback;
    private int mScene;
    public String rcD;
    private final d rr;

    public m(String str, int i2, int i3) {
        AppMethodBeat.i(108699);
        this.rcD = str;
        this.mScene = i2;
        this.cR = i3;
        d.a aVar = new d.a();
        aVar.iLN = new GetEmotionDetailRequest();
        aVar.iLO = new GetEmotionDetailResponse();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.funcId = 412;
        aVar.iLP = 211;
        aVar.respCmdId = 1000000211;
        this.rr = aVar.aXF();
        AppMethodBeat.o(108699);
    }

    public m(String str, int i2) {
        this(str, i2, -1);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 412;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108700);
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", this.rcD, Integer.valueOf(this.mScene), Integer.valueOf(this.cR));
        this.callback = iVar;
        GetEmotionDetailRequest getEmotionDetailRequest = (GetEmotionDetailRequest) this.rr.iLK.iLR;
        getEmotionDetailRequest.ProductID = this.rcD;
        getEmotionDetailRequest.Scene = this.mScene;
        getEmotionDetailRequest.Version = this.cR;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108700);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108701);
        Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i3 + "   errCode:" + i4);
        if (i3 == 0 || i4 == 0 || i4 == 5) {
            if (i3 == 0 && i4 == 0) {
                ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpR.a(this.rcD, (GetEmotionDetailResponse) this.rr.iLL.iLR, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(108701);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108701);
    }

    public final EmotionDetail cGv() {
        AppMethodBeat.i(108702);
        new EmotionDetail();
        EmotionDetail emotionDetail = ((GetEmotionDetailResponse) this.rr.iLL.iLR).EmotionDetail;
        AppMethodBeat.o(108702);
        return emotionDetail;
    }
}
