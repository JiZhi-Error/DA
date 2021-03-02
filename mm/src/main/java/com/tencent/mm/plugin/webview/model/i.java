package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cn;
import com.tencent.mm.protocal.protobuf.co;

public final class i extends q implements m {
    private com.tencent.mm.ak.i heq;
    public final d rr;

    public i(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(78864);
        d.a aVar = new d.a();
        aVar.iLN = new cn();
        aVar.iLO = new co();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        aVar.funcId = 2500;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cn cnVar = (cn) this.rr.iLK.iLR;
        cnVar.dNI = str;
        cnVar.nickname = str2;
        cnVar.KGH = new b(bArr);
        cnVar.KGI = 0;
        AppMethodBeat.o(78864);
    }

    public i(String str, String str2, String str3) {
        AppMethodBeat.i(78865);
        d.a aVar = new d.a();
        aVar.iLN = new cn();
        aVar.iLO = new co();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        aVar.funcId = 2500;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cn cnVar = (cn) this.rr.iLK.iLR;
        cnVar.dNI = str;
        cnVar.nickname = str2;
        cnVar.fileid = str3;
        cnVar.KGI = 1;
        AppMethodBeat.o(78865);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78866);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78866);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2500;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(78867);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78867);
        return dispatch;
    }
}
