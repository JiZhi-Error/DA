package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

public final class k extends q implements m {
    public eit GjJ;
    private i callback;
    private d rr;

    public k(eit eit) {
        AppMethodBeat.i(91025);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "Create NetSceneTopStory Video contextId:%s searchId:%s", eit.sGQ, eit.hes);
        this.GjJ = eit;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.iLN = new fal();
        aVar.iLO = new fam();
        this.rr = aVar.aXF();
        fal fal = (fal) this.rr.iLK.iLR;
        fal.KZk = eit.offset;
        fal.MaY = ai.aft(1);
        fal.LPT = eit.dDv;
        fal.MlQ = ai.clJ();
        fal.Scene = eit.scene;
        fal.KZj = eit.hes;
        fal.Nva.addAll(eit.IDO);
        fal.NgA = (int) eit.Nib;
        aca aca = new aca();
        aca.key = "client_system_version";
        aca.LmC = (long) Build.VERSION.SDK_INT;
        fal.Nva.add(aca);
        aca aca2 = new aca();
        aca2.key = DownloadInfo.NETTYPE;
        aca2.LmD = ai.ait();
        fal.Nva.add(aca2);
        aca aca3 = new aca();
        aca3.key = "client_request_time";
        aca3.LmD = String.valueOf(System.currentTimeMillis());
        fal.Nva.add(aca3);
        Iterator<aca> it = fal.Nva.iterator();
        while (it.hasNext()) {
            aca next = it.next();
            Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "key: %s unit_value %s text_value %s", next.key, Long.valueOf(next.LmC), next.LmD);
        }
        AppMethodBeat.o(91025);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1943;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(91026);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91026);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91027);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryVideo", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91027);
    }

    public final fam fxZ() {
        return (fam) this.rr.iLL.iLR;
    }
}
