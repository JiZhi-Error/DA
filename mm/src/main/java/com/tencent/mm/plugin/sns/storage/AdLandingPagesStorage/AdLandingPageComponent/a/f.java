package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwj;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends q implements m {
    private i callback;
    private d rr;

    public f(String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(203136);
        d.a aVar = new d.a();
        aVar.iLN = new bwj();
        aVar.iLO = new bwk();
        aVar.uri = "/cgi-bin/mmoc-bin/adplayinfo/get_twist_adcard";
        aVar.funcId = 4729;
        this.rr = aVar.aXF();
        bwj bwj = (bwj) this.rr.iLK.iLR;
        bwj.uxInfo = str;
        bwj.KFZ = str2;
        bwj.scene = i2;
        bwj.LYB = str3;
        bwj.extInfo = str4;
        Log.i("NetSceneAdGetTwistCard", "snsId=" + str2 + ", scene=" + i2 + ", canvasId=" + str3 + ", uxInfo=" + str + ", extra=" + str4);
        AppMethodBeat.o(203136);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(203137);
        Log.i("NetSceneAdGetTwistCard", "errType=" + i3 + ", errCode=" + i4 + ", errMsg=" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(203137);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(203138);
        int type = this.rr.getType();
        AppMethodBeat.o(203138);
        return type;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(203139);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(203139);
        return dispatch;
    }

    public static String i(int i2, int i3, Object obj) {
        AppMethodBeat.i(203140);
        Log.i("NetSceneAdGetTwistCard", "parseTwistCardId, errType=" + i2 + ", errNo=" + i3);
        if (i2 == 0 && i3 == 0 && obj != null) {
            bwk bwk = new bwk();
            try {
                bwk.parseFrom((byte[]) obj);
                Log.i("NetSceneAdGetTwistCard", "parseTwistCardId, cardId=" + bwk.eaO + ", snsId=" + bwk.KFZ);
                String nullAsNil = Util.nullAsNil(bwk.eaO);
                AppMethodBeat.o(203140);
                return nullAsNil;
            } catch (Throwable th) {
                Log.e("NetSceneAdGetTwistCard", "parseTwistCardId exp=" + th.toString());
            }
        }
        AppMethodBeat.o(203140);
        return "";
    }
}
