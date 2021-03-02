package com.tencent.mm.chatroom.d;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.emw;
import com.tencent.mm.protocal.protobuf.emx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;

public final class x extends q implements m {
    private i callback = null;
    public String chatroomName = null;
    public String gsv = null;
    public int gsw = 0;
    public int maxCount = 0;
    public String resultMsg = null;
    private final d rr;

    public x(String str) {
        AppMethodBeat.i(12498);
        d.a aVar = new d.a();
        aVar.iLN = new emw();
        aVar.iLO = new emx();
        aVar.uri = "/cgi-bin/micromsg-bin/upgradechatroom";
        aVar.funcId = b.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.chatroomName = str;
        ((emw) this.rr.iLK.iLR).KGO = str;
        AppMethodBeat.o(12498);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12499);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12499);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return b.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(GoogleSignInStatusCodes.SIGN_IN_FAILED);
        emx emx = (emx) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneUpgradeChatroom", "NetSceneUpgradeChatroom onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.gsv = emx.Mvl;
        if (!Util.isNullOrNil(this.gsv)) {
            ah Kd = ((c) com.tencent.mm.kernel.g.af(c.class)).aSX().Kd(this.chatroomName);
            if (Kd == null) {
                Kd = new ah();
            }
            Kd.mQ(z.aTY(), this.gsv);
            v.a(Kd);
        }
        this.resultMsg = emx.LUf;
        this.maxCount = emx.LUe;
        this.gsw = emx.LUg;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(GoogleSignInStatusCodes.SIGN_IN_FAILED);
    }
}
