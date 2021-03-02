package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.cuj;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private i callback;
    public String jsonString;
    private d rr;

    public j(String str, String str2, String str3) {
        AppMethodBeat.i(97153);
        d.a aVar = new d.a();
        aVar.iLN = new bnu();
        aVar.iLO = new bnv();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        aVar.funcId = 1337;
        this.rr = aVar.aXF();
        bnu bnu = (bnu) this.rr.iLK.iLR;
        bnu.jfi = str;
        bnu.LWj = str2;
        bnu.LWk = str3;
        Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
        AppMethodBeat.o(97153);
    }

    public j(String str) {
        AppMethodBeat.i(97154);
        d.a aVar = new d.a();
        aVar.iLN = new cuj();
        aVar.iLO = new cuk();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
        aVar.funcId = 2721;
        this.rr = aVar.aXF();
        ((cuj) this.rr.iLK.iLR).MzD = str;
        Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(str)));
        AppMethodBeat.o(97154);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97155);
        int type = this.rr.getType();
        AppMethodBeat.o(97155);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(97156);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97156);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97157);
        Log.i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str + " sceneType: " + getType());
        if (getType() == 1337) {
            this.jsonString = ((bnv) ((d) sVar).iLL.iLR).LSg;
        } else if (getType() == 2721) {
            this.jsonString = ((cuk) ((d) sVar).iLL.iLR).MzE;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(97157);
    }
}
