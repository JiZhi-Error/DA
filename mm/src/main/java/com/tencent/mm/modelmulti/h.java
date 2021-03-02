package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ddm;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.protocal.protobuf.ekv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.o.a;

public final class h extends q implements m {
    private i callback;
    private int jcv = 0;
    private d rr;

    public h(int i2, String str) {
        AppMethodBeat.i(20546);
        d.a aVar = new d.a();
        aVar.iLN = new ddm();
        aVar.iLO = new ddn();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.funcId = 1804;
        this.rr = aVar.aXF();
        ddm ddm = (ddm) this.rr.iLK.iLR;
        ddm.LWR = i2;
        ddm.LWT = str;
        if ((i2 & 16) > 0) {
            a aVar2 = new a();
            ekv ekv = new ekv();
            if (aVar2.QAH == null) {
                ekv = null;
            } else if (!Util.isNullOrNil(aVar2.QAH.token)) {
                ekv.Nke = aVar2.QAH.token;
                ekv.Nkf = aVar2.QAH.Mte;
            }
            ddm.MID = ekv;
        }
        this.jcv = i2;
        AppMethodBeat.o(20546);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20547);
        Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i3 + " errCode:" + i4);
        if (i3 == 0 && i4 == 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(20547);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20547);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1804;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20548);
        Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20548);
        return dispatch;
    }
}
