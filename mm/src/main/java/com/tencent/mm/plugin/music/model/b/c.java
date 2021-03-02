package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buz;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private buz AkX;
    public String AkY = "";
    private i callback;
    private d iUB;
    public String playUrl = "";

    public c(String str) {
        AppMethodBeat.i(63099);
        d.a aVar = new d.a();
        aVar.funcId = 769;
        aVar.uri = "/cgi-bin/micromsg-bin/getshakemusicurl";
        aVar.iLN = new buz();
        aVar.iLO = new bva();
        this.iUB = aVar.aXF();
        this.AkX = (buz) this.iUB.iLK.iLR;
        this.AkX.Mbq = str;
        this.playUrl = str;
        Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "request music url:%s", str);
        AppMethodBeat.o(63099);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 769;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63100);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(63100);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63101);
        Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            bva bva = (bva) this.iUB.iLL.iLR;
            this.callback.onSceneEnd(i3, i4, str, this);
            if (bva != null) {
                this.AkY = bva.Mbq;
                Log.i("MicroMsg.Music.NetSceneGetShakeMusicUrl", "tempPlayUrl:%s", this.AkY);
                AppMethodBeat.o(63101);
                return;
            }
            Log.e("MicroMsg.Music.NetSceneGetShakeMusicUrl", "response is null");
            AppMethodBeat.o(63101);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(63101);
    }
}
