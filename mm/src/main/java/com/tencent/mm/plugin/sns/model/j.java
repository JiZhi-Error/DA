package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.protocal.protobuf.cug;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class j extends q implements m {
    public i callback;
    private final int ixX = -1216949095;
    private d rr;

    public j() {
        AppMethodBeat.i(95561);
        d.a aVar = new d.a();
        aVar.iLN = new cuf();
        aVar.iLO = new cug();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_checkgrant";
        aVar.funcId = 2842;
        this.rr = aVar.aXF();
        cuf cuf = (cuf) this.rr.iLK.iLR;
        g.aAi();
        g.aAf();
        cuf.Mzz = a.getUin();
        cuf.Mzl = -1216949095;
        Log.i("MicroMsg.NetSceneOauthCheckGrant", "init useruin:%d, bizuin:%d", Integer.valueOf(cuf.Mzz), Integer.valueOf(cuf.Mzl));
        AppMethodBeat.o(95561);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(95562);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95562);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95563);
        Log.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            cug cug = (cug) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneOauthCheckGrant", "onGYNetEnd bizUin:%d, status:%d", Integer.valueOf(this.ixX), Integer.valueOf(cug.status));
            if (this.ixX == -1216949095) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_SNS_OPEN_UPLOAD_WEISHI_BOOLEAN_SYNC, Boolean.valueOf(cug.status == 1));
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95563);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2842;
    }
}
