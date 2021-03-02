package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    public zb AkT = ((zb) this.iUB.iLK.iLR);
    private i callback;
    private d iUB;

    public a(int i2, com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63093);
        d.a aVar2 = new d.a();
        aVar2.funcId = 940;
        aVar2.uri = "/cgi-bin/micromsg-bin/checkmusic";
        aVar2.iLN = new zb();
        aVar2.iLO = new zc();
        this.iUB = aVar2.aXF();
        this.AkT.Scene = i2;
        this.AkT.jfi = aVar.field_appId;
        this.AkT.Lki = aVar.field_songAlbumUrl;
        this.AkT.Lkj = aVar.field_songHAlbumUrl;
        this.AkT.Lkl = aVar.field_songWifiUrl;
        this.AkT.Lkm = aVar.field_songWapLinkUrl;
        this.AkT.Lkk = aVar.field_songWebUrl;
        this.AkT.Title = aVar.field_songName;
        this.AkT.jeV = aVar.field_musicId;
        AppMethodBeat.o(63093);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 940;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63094);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(63094);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63095);
        Log.i("MicroMsg.Music.NetSceneCheckMusic", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(63095);
    }
}
