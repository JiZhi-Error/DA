package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.protocal.protobuf.cdi;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.cfx;
import com.tencent.mm.protocal.protobuf.cfy;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class x extends q implements m {
    private i callback;
    private final d rr;

    public x(List<cfy> list) {
        AppMethodBeat.i(78909);
        d.a aVar = new d.a();
        aVar.iLN = new cfg();
        aVar.iLO = new cfh();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        aVar.funcId = 1803;
        this.rr = aVar.aXF();
        cfg cfg = (cfg) this.rr.iLK.iLR;
        cfx cfx = new cfx();
        cfx.hid = com.tencent.mm.protocal.d.KyJ;
        cfx.hie = com.tencent.mm.protocal.d.KyI;
        cfx.hif = com.tencent.mm.protocal.d.KyL;
        cfx.hig = com.tencent.mm.protocal.d.KyM;
        cfx.hih = LocaleUtil.getApplicationLanguage();
        cfx.LOF = (int) (System.currentTimeMillis() / 1000);
        cfg.KGA = cfx;
        cfg.KGB.addAll(list);
        AppMethodBeat.o(78909);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78910);
        Log.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (i3 == 0 && i4 == 0) {
            cfh cfh = (cfh) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder sb = new StringBuilder("{ ");
            if (Util.isNullOrNil(cfh.Mlt)) {
                sb.append("{  }");
            } else {
                Iterator<cdi> it = cfh.Mlt.iterator();
                while (it.hasNext()) {
                    cdi next = it.next();
                    sb.append(String.format(" { logId(%d), interval(%d) },", Integer.valueOf(next.Mjf), Integer.valueOf(next.Mjg)));
                }
            }
            sb.append(" }");
            Log.i("MicroMsg.NetSceneJsLog", sb.toString());
            h unused = h.a.IXJ;
            h.ii(cfh.Mlt);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78910);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1803;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78911);
        this.callback = iVar;
        Log.d("MicroMsg.NetSceneJsLog", "doScene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78911);
        return dispatch;
    }
}
