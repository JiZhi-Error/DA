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
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

public final class h extends q implements m {
    private eit GjJ;
    public eiw GjK;
    private i callback;
    private d rr;

    public h(eit eit, int i2, eiw eiw, long j2) {
        AppMethodBeat.i(91017);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "Create NetSceneTopStoryVideo %s %s %s", eit.sGQ, eit.hes, Long.valueOf(j2));
        this.GjJ = eit;
        this.GjK = eiw;
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
        Iterator<aca> it = fal.Nva.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            aca next = it.next();
            if (next.key.equals("relevant_vid")) {
                next.LmD = eiw.psI;
                break;
            }
        }
        aca aca = new aca();
        aca.key = "relevant_vid";
        aca.LmD = eiw.psI;
        fal.Nva.add(aca);
        fal.NgA = (int) eit.Nib;
        fal.MRy = i2;
        fal.oUv = 1;
        aca aca2 = new aca();
        aca2.key = "client_system_version";
        aca2.LmC = (long) Build.VERSION.SDK_INT;
        fal.Nva.add(aca2);
        aca aca3 = new aca();
        aca3.key = DownloadInfo.NETTYPE;
        aca3.LmD = ai.ait();
        fal.Nva.add(aca3);
        aca aca4 = new aca();
        aca4.key = "client_request_time";
        aca4.LmD = String.valueOf(System.currentTimeMillis());
        fal.Nva.add(aca4);
        aca aca5 = new aca();
        aca5.key = "relevant_play_time";
        aca5.LmD = String.valueOf(j2);
        aca5.LmC = j2;
        fal.Nva.add(aca5);
        Iterator<aca> it2 = fal.Nva.iterator();
        while (it2.hasNext()) {
            aca next2 = it2.next();
            Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "key: %s unit_value %s text_value %s", next2.key, Long.valueOf(next2.LmC), next2.LmD);
        }
        AppMethodBeat.o(91017);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1943;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(91018);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91018);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91019);
        Log.i("MicroMsg.TopStory.NetSceneTopStoryRelevantVideo", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91019);
    }

    public final fam fxZ() {
        return (fam) this.rr.iLL.iLR;
    }
}
