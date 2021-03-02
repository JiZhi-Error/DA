package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.EmotionPrice;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.sdk.platformtools.Log;
import java.text.DecimalFormat;

public final class b extends q implements m {
    public static int rcn = 6;
    public static int rco = 7;
    public static int rcp = 10;
    private i heq;
    private String rcq;
    private EmotionPrice rcr;
    private final d rr;

    public b(String str, EmotionPrice emotionPrice) {
        AppMethodBeat.i(108668);
        d.a aVar = new d.a();
        aVar.iLN = new hg();
        aVar.iLO = new hh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmaskforreward";
        aVar.funcId = 830;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.rcq = str;
        this.rcr = emotionPrice;
        AppMethodBeat.o(108668);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(108669);
        Log.d("MicroMsg.emoji.NetSceneAskForReward", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(108669);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 830;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(108670);
        this.heq = iVar;
        hg hgVar = (hg) this.rr.iLK.iLR;
        hgVar.ProductID = this.rcq;
        EmotionPrice emotionPrice = new EmotionPrice();
        emotionPrice.Label = this.rcr.Label;
        emotionPrice.Type = this.rcr.Type;
        emotionPrice.Number = new DecimalFormat("0.00").format(Float.valueOf(this.rcr.Number));
        hgVar.KKQ = emotionPrice;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(108670);
        return dispatch;
    }

    public final hh cGp() {
        return (hh) this.rr.iLL.iLR;
    }
}
