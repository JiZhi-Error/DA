package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cl;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i heq;
    public final d rr;
    public String tjJ;

    public k(String str, String str2, String str3) {
        AppMethodBeat.i(78870);
        this.tjJ = str3;
        d.a aVar = new d.a();
        aVar.iLN = new cl();
        aVar.iLO = new cm();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
        aVar.funcId = 2667;
        aVar.iLP = 2667;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cl clVar = (cl) this.rr.iLK.iLR;
        clVar.KGG = str;
        clVar.dNI = str2;
        AppMethodBeat.o(78870);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2667;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78871);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78871);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78872);
        Log.i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.heq != null) {
            this.heq.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(78872);
    }
}
