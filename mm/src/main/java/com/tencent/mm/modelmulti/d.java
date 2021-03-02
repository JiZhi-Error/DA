package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class d extends q implements m {
    private i callback;
    public final com.tencent.mm.ak.d iUB;

    public d(List<ccm> list, long j2, cco cco) {
        AppMethodBeat.i(20540);
        d.a aVar = new d.a();
        aVar.iLN = new bjf();
        aVar.iLO = new bjg();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        aVar.funcId = 1708;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        bjf bjf = (bjf) this.iUB.iLK.iLR;
        bjf.LSR.addAll(list);
        bjf.LSU = j2;
        bjf.LST = cco;
        Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(bjf.LSR.size()));
        AppMethodBeat.o(20540);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20541);
        Log.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        bjf bjf = (bjf) this.iUB.iLK.iLR;
        LinkedList<ccm> linkedList = bjf.LSR;
        ccm ccm = linkedList.get(0);
        cco cco = bjf.LST;
        bjg bjg = (bjg) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            if (bjg.result != 0) {
                h.INSTANCE.a(12659, 1, Integer.valueOf(linkedList.size()), ccm.uuid, Integer.valueOf(ccm.major), Integer.valueOf(ccm.minor), String.valueOf(cco.latitude), String.valueOf(cco.longitude), 2, Integer.valueOf(bjg.result));
            }
            Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            AppMethodBeat.o(20541);
            return;
        }
        h.INSTANCE.a(12659, 1, Integer.valueOf(linkedList.size()), ccm.uuid, Integer.valueOf(ccm.major), Integer.valueOf(ccm.minor), String.valueOf(cco.latitude), String.valueOf(cco.longitude), 1, Integer.valueOf(bjg.result));
        Log.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
        AppMethodBeat.o(20541);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1708;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20542);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(20542);
        return dispatch;
    }
}
