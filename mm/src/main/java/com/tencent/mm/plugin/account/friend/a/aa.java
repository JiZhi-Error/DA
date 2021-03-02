package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class aa extends q implements m {
    public static int kfh = 1;
    public static int kfi = 2;
    public static int kfj = 3;
    public static int kfk = 4;
    private i callback;
    private d rr;

    public aa(int i2) {
        AppMethodBeat.i(131093);
        d.a aVar = new d.a();
        aVar.iLN = new zu();
        aVar.iLO = new zv();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.funcId = 254;
        aVar.iLP = TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE;
        aVar.respCmdId = 1000000131;
        this.rr = aVar.aXF();
        ((zu) this.rr.iLK.iLR).Brf = i2;
        AppMethodBeat.o(131093);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131094);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131094);
        return dispatch;
    }

    public final String bok() {
        AppMethodBeat.i(131095);
        try {
            String str = ((zv) this.rr.iLL.iLR).Lld;
            Log.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
            AppMethodBeat.o(131095);
            return str;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e2, "", new Object[0]);
            AppMethodBeat.o(131095);
            return null;
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 254;
    }

    public final zv bol() {
        return (zv) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131096);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131096);
    }
}
