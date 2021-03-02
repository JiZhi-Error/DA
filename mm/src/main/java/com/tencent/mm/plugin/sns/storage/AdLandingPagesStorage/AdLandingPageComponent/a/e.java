package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bow;
import com.tencent.mm.protocal.protobuf.box;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private d rr;

    public e(long j2, int i2, String str, String str2, int i3) {
        AppMethodBeat.i(97137);
        d.a aVar = new d.a();
        aVar.iLN = new bow();
        aVar.iLO = new box();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_landpage_smartphone";
        aVar.funcId = 2605;
        this.rr = aVar.aXF();
        bow bow = (bow) this.rr.iLK.iLR;
        bow.DYn = j2;
        bow.LWW = i2;
        bow.gTl = str;
        bow.gTk = str2;
        bow.DYl = i3;
        AppMethodBeat.o(97137);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(97138);
        Log.i("NetSceneAdGetSmartPhoneNumber", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(97138);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(97139);
        int type = this.rr.getType();
        AppMethodBeat.o(97139);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(97140);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(97140);
        return dispatch;
    }
}
