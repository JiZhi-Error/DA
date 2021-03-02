package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback;
    private d rr;

    public h(String str, String str2, long j2, String str3) {
        AppMethodBeat.i(203143);
        d.a aVar = new d.a();
        aVar.iLN = new dui();
        aVar.iLO = new duj();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/send_subscription_msg";
        aVar.funcId = 2810;
        this.rr = aVar.aXF();
        dui dui = (dui) this.rr.iLK.iLR;
        dui.MVS = str;
        dui.gTk = str2;
        dui.DYn = j2;
        dui.LzN = str3;
        AppMethodBeat.o(203143);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(203144);
        int type = this.rr.getType();
        AppMethodBeat.o(203144);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(203145);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(203145);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(203146);
        Log.i("NetSceneAdSubscribe", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(203146);
    }
}
