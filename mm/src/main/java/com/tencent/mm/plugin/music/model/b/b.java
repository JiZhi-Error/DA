package com.tencent.mm.plugin.music.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.e;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    public a AkC;
    public bth AkU;
    public boolean AkV;
    public boolean AkW;
    private i callback;
    private d iUB;

    public b(a aVar, boolean z, boolean z2) {
        int i2;
        int i3;
        AppMethodBeat.i(219850);
        this.AkC = aVar;
        this.AkV = z;
        this.AkW = z2;
        d.a aVar2 = new d.a();
        aVar2.iLN = new btg();
        aVar2.iLO = new bth();
        aVar2.uri = "/cgi-bin/micromsg-bin/getqqmusiclyric";
        aVar2.funcId = 520;
        this.iUB = aVar2.aXF();
        btg btg = (btg) this.iUB.iLK.iLR;
        btg.jfk = aVar.field_songId;
        if (aVar.field_songWebUrl != null) {
            btg.LZR = z.aC(aVar.field_songWebUrl.getBytes());
        }
        if (aVar.field_songMId != null) {
            btg.LZU = z.aC(aVar.field_songMId.getBytes());
        }
        if (e.bem()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        btg.LZS = i2;
        if (e.bel()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        btg.LZT = i3;
        Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "songId=%d, url=%s IsOutsideGFW=%d ShakeMusicGlobalSwitch=%d", Integer.valueOf(aVar.field_songId), aVar.field_songWebUrl, Integer.valueOf(btg.LZS), Integer.valueOf(btg.LZT));
        AppMethodBeat.o(219850);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(63097);
        Log.i("MicroMsg.Music.NetSceneGetQQMusicLyric", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.AkU = (bth) this.iUB.iLL.iLR;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(63097);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(63097);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 520;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(63098);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(63098);
        return dispatch;
    }
}
