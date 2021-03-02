package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.c.e;
import com.tencent.mm.game.report.c.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    private i callback;
    private final com.tencent.mm.ak.d hhm;

    public d(String str, int i2, int i3, String str2, String str3) {
        AppMethodBeat.i(175995);
        d.a aVar = new d.a();
        aVar.iLN = new e();
        aVar.iLO = new f();
        aVar.uri = "/cgi-bin/mmgame-bin/gamereport";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        e eVar = (e) this.hhm.iLK.iLR;
        eVar.hik = str;
        eVar.him = i2;
        eVar.hin = i3;
        eVar.hio = str2;
        eVar.hip = str3;
        eVar.hil = (int) (System.currentTimeMillis() / 1000);
        AppMethodBeat.o(175995);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1223;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(175996);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(175996);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(175997);
        Log.i("MicroMsg.NetSceneGetGameIndex", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(175997);
    }
}
