package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private d rr;

    public c(String str, String str2) {
        AppMethodBeat.i(203132);
        d.a aVar = new d.a();
        aVar.iLN = new bya();
        aVar.iLO = new byb();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_wx_user_name";
        aVar.funcId = 4353;
        this.rr = aVar.aXF();
        bya bya = (bya) this.rr.iLK.iLR;
        bya.gTk = str;
        bya.MdB = str2;
        AppMethodBeat.o(203132);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(203133);
        Log.i("NetSceneAdGetBtnPersonalUserName", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(203133);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(203134);
        int type = this.rr.getType();
        AppMethodBeat.o(203134);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(203135);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(203135);
        return dispatch;
    }
}
