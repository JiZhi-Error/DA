package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class as extends q implements m {
    private String appId;
    private i callback;
    final d hhm;

    public as(String str) {
        AppMethodBeat.i(41616);
        d.a aVar = new d.a();
        aVar.iLN = new cam();
        aVar.iLO = new can();
        aVar.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.appId = str;
        this.hhm = aVar.aXF();
        cam cam = (cam) this.hhm.iLK.iLR;
        cam.xLl = LocaleUtil.getApplicationLanguage();
        cam.keh = Util.getSimCountryCode(MMApplicationContext.getContext());
        cam.jfi = str;
        Log.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", cam.xLl, cam.keh, cam.jfi);
        AppMethodBeat.o(41616);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41617);
        Log.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        if (i3 != 0 || i4 != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(41617);
        } else if (((can) ((d) sVar).iLL.iLR) == null) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(41617);
        } else {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(41617);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1369;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41618);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41618);
        return dispatch;
    }
}
