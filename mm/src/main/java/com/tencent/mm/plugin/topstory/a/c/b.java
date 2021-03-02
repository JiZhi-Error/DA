package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Iterator;

public final class b extends q implements m {
    private i callback;
    public eii eel;
    private d rr;
    private long uOV = System.currentTimeMillis();

    public b(eii eii, int i2, String str) {
        AppMethodBeat.i(91005);
        Log.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home channelId:%s, %s %s %s", Integer.valueOf(eii.channelId), Integer.valueOf(i2), eii.sGQ, eii.sessionId);
        this.eel = eii;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.iLN = new fal();
        aVar.iLO = new fam();
        this.rr = aVar.aXF();
        fal fal = (fal) this.rr.iLK.iLR;
        fal.KZk = eii.offset;
        fal.MaY = ai.aft(1);
        fal.LPT = eii.dDv;
        fal.MlQ = ai.clJ();
        fal.Scene = eii.scene;
        fal.KZj = eii.hes;
        fal.Nva.addAll(eii.IDO);
        fal.NgA = eii.channelId;
        fal.NwK = i2;
        fal.NwL = eii.NhC;
        if (fal.NgA == 110) {
            eiq fxo = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
            if (fxo != null) {
                fal.MOi = fxo.msgId;
            }
        } else if (fal.NgA == 100) {
            fal.MOi = str;
        } else {
            fal.MOi = "";
        }
        fal.NwI = eii.IDW;
        fal.NwJ = eii.NhB;
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
            Log.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", next.key, Long.valueOf(next.LmC), next.LmD);
        }
        Log.i("MicroMsg.TopStory.NetSceneTopStory", "request params offset %d h5Version %d CheckDocListSize: %d", Integer.valueOf(fal.KZk), Integer.valueOf(fal.MaY), Integer.valueOf(fal.NwJ.size()));
        AppMethodBeat.o(91005);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1943;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(91006);
        ar.kb(this.eel.scene, 2);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(91006);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(91007);
        Log.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Long.valueOf(System.currentTimeMillis() - this.uOV));
        if (i4 == -1) {
            ar.kb(this.eel.scene, 4);
        } else if (i3 == 0 && i4 == 0) {
            ar.kb(this.eel.scene, 3);
        } else {
            ar.kb(this.eel.scene, 8);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(91007);
    }

    public final fam fxZ() {
        return (fam) this.rr.iLL.iLR;
    }
}
