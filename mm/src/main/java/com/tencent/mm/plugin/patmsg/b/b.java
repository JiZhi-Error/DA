package com.tencent.mm.plugin.patmsg.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.hu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    public Pair<Long, Long> ARo;
    public hu ARp;
    private i callback;
    public d iUB;

    public b(Pair<Long, Long> pair, String str, String str2) {
        this(pair, str, str2, 0);
    }

    public b(Pair<Long, Long> pair, String str, String str2, int i2) {
        AppMethodBeat.i(206970);
        dty dty = new dty();
        dty.MKC = z.aTY();
        dty.MVH = str;
        dty.MVI = str2;
        dty.KIz = ((com.tencent.mm.plugin.patmsg.a.b) g.af(com.tencent.mm.plugin.patmsg.a.b.class)).d(pair);
        dty.Scene = i2;
        this.ARo = pair;
        d.a aVar = new d.a();
        aVar.iLN = dty;
        aVar.uri = "/cgi-bin/micromsg-bin/sendpat";
        aVar.funcId = getType();
        aVar.iLO = new dtz();
        this.iUB = aVar.aXF();
        AppMethodBeat.o(206970);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 849;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(206971);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(206971);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(206972);
        Log.i("MicroMsg.NetSceneSendPat", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(206972);
    }
}
