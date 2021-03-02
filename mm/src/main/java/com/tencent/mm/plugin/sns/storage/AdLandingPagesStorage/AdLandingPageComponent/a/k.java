package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btk;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i callback;
    private d rr;

    public k(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(203147);
        d.a aVar = new d.a();
        aVar.iLN = new btk();
        aVar.iLO = new btl();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_qywx_qrcode";
        aVar.funcId = 1022;
        this.rr = aVar.aXF();
        btk btk = (btk) this.rr.iLK.iLR;
        btk.dRy = str;
        btk.DYM = str2;
        btk.Mab = str3;
        btk.gTk = str4;
        btk.Mac = str5;
        btk.Mad = str6;
        AppMethodBeat.o(203147);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(203148);
        int type = this.rr.getType();
        AppMethodBeat.o(203148);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(203149);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(203149);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(203150);
        Log.i("NetSceneUpdateQrUrl", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(203150);
    }
}
