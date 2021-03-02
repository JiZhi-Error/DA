package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.ccm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class n extends q implements m {
    private i callback;
    public final d iUB;

    public n(List<ccm> list, String str) {
        AppMethodBeat.i(78879);
        d.a aVar = new d.a();
        aVar.iLN = new bjd();
        aVar.iLO = new bje();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        aVar.funcId = 1704;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        bjd bjd = (bjd) this.iUB.iLK.iLR;
        bjd.LSR.addAll(list);
        bjd.dNI = str;
        Log.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", Integer.valueOf(bjd.LSR.size()));
        AppMethodBeat.o(78879);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1704;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78880);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(78880);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78881);
        Log.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            Log.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78881);
    }
}
