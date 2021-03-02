package com.tencent.mm.plugin.messenger.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    public int action;
    private i callback;
    private final d rr;
    public ctv zqw;

    public a(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(194478);
        Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "NetSceneNotAutoSucceed action:%s originTpusername:%s op:%s heirTpusername%s", Integer.valueOf(i2), Util.nullAs(str, ""), Util.nullAs(str, ""), Util.secPrint(str3));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/notautosucceed";
        aVar.funcId = getType();
        aVar.iLN = new ctu();
        aVar.iLO = new ctv();
        this.rr = aVar.aXF();
        this.action = i2;
        ctu ctu = (ctu) this.rr.iLK.iLR;
        ctu.Mzd = Util.nullAs(str, "");
        ctu.Mze = Util.nullAs(str2, "");
        ctu.Mzf = Util.nullAs(str3, "");
        ctu.action = i2;
        AppMethodBeat.o(194478);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3713;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(194479);
        this.callback = iVar;
        this.zqw = (ctv) this.rr.iLL.iLR;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(194479);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(194480);
        Log.i("MicroMsg.openim.NetSceneOpenImNotAutoSucceed", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(194480);
    }
}
