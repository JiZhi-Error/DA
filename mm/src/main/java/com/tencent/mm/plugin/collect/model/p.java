package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.protocal.protobuf.dwl;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private i callback;
    private d hJu;
    private dwk qwB = ((dwk) this.hJu.iLK.iLR);

    public p(String str) {
        AppMethodBeat.i(63838);
        d.a aVar = new d.a();
        aVar.iLN = new dwk();
        aVar.iLO = new dwl();
        aVar.funcId = 304;
        aVar.uri = "/cgi-bin/micromsg-bin/setpushsound";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.qwB.oUv = 3;
        this.qwB.MWK = str;
        Log.i("MicroMsg.NetSceneSetPushSound", "type: %d, sound: %s", 3, str);
        AppMethodBeat.o(63838);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 304;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63839);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(63839);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63840);
        Log.i("MicroMsg.NetSceneSetPushSound", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(63840);
    }
}
