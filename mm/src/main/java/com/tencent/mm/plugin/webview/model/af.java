package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.sdk.platformtools.Log;

public final class af extends q implements m {
    private i callback;
    public final d iUB;

    public af(String str, String str2, String str3) {
        AppMethodBeat.i(78940);
        d.a aVar = new d.a();
        aVar.iLN = new epj();
        aVar.iLO = new epk();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        aVar.funcId = 1702;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        epj epj = (epj) this.iUB.iLK.iLR;
        epj.Url = str;
        epj.dNI = str2;
        epj.dHx = str3;
        AppMethodBeat.o(78940);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1702;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78941);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(78941);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78942);
        Log.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            Log.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            Log.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78942);
    }
}
