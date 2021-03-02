package com.tencent.mm.plugin.location.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.ejg;
import com.tencent.mm.protocal.protobuf.eox;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends q implements m {
    private i callback;
    private Runnable jkz;
    public String qwG;
    public final d rr;
    public int yHb;
    public ejg yHc = null;
    public List<eox> yHd = null;
    public dmb yHe;
    public int yHf;
    private String yHg;

    public c(String str, int i2, eox eox, int i3, ejg ejg) {
        AppMethodBeat.i(55791);
        d.a aVar = new d.a();
        aVar.iLN = new dma();
        aVar.iLO = new dmb();
        aVar.uri = "/cgi-bin/micromsg-bin/refreshtrackroom";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.k.i.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dma dma = (dma) this.rr.iLK.iLR;
        dma.Ltk = str;
        dma.oUv = i2;
        dma.MPD = eox;
        dma.hil = i3;
        dma.MPE = ejg;
        this.yHg = str;
        this.yHf = dma.oUv;
        Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPosiItem " + eox.Username + " " + eox.NmV.KUu + " " + eox.NmV.KUt + " heading:" + eox.NmV.MIv);
        Log.d("MicroMsg.NetSceneRefreshTrackRoom", "userPoi " + ejg.KUu + " " + ejg.KUt + " " + ejg.Name);
        Log.d("MicroMsg.NetSceneRefreshTrackRoom", "trackRoomId:" + str + " uploadStatus:" + i2);
        AppMethodBeat.o(55791);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.k.i.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(55792);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55792);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(55793);
        this.yHe = (dmb) ((d) sVar).iLL.iLR;
        if (this.yHe != null) {
            this.qwG = this.yHe.KOu;
        }
        if (i3 == 0 && i4 == 0) {
            this.yHb = this.yHe.MlI;
            this.yHc = this.yHe.MPG;
            this.yHd = this.yHe.MPF;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format("[ resp count %d ] ", Integer.valueOf(this.yHe.oTz)));
            if (this.yHc != null) {
                stringBuffer.append(String.format("[ roomPoi  %f %f %s] ", Double.valueOf(this.yHc.KUu), Double.valueOf(this.yHc.KUt), this.yHc.Name));
            }
            Log.d("MicroMsg.NetSceneRefreshTrackRoom", "onGynetEnd " + stringBuffer.toString());
            LinkedList linkedList = new LinkedList();
            Iterator<eox> it = this.yHe.MPF.iterator();
            while (it.hasNext()) {
                eox next = it.next();
                if (next == null) {
                    linkedList.add(next);
                } else {
                    if (next.NmV == null) {
                        linkedList.add(next);
                    }
                    if (Math.abs(next.NmV.KUt) > 180.0d || Math.abs(next.NmV.KUu) > 90.0d) {
                        Log.w("MicroMsg.NetSceneRefreshTrackRoom", "server lat lng invalid %s %f %f %f", next.Username, Double.valueOf(next.NmV.KUu), Double.valueOf(next.NmV.KUt), Double.valueOf(next.NmV.MIv));
                        linkedList.add(next);
                    }
                }
            }
            this.yHe.oTz = this.yHe.MPF.size();
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (this.jkz != null) {
            this.jkz.run();
        }
        AppMethodBeat.o(55793);
    }
}
