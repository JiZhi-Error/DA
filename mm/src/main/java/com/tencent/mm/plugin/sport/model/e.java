package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.enc;
import com.tencent.mm.protocal.protobuf.end;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private enc Fjr;
    private i callback = null;
    private d rr = null;

    public e(String str, String str2, int i2, int i3, int i4, String str3, int i5) {
        AppMethodBeat.i(149305);
        Log.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep %s, %s, %s, %s, %s", str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        d.a aVar = new d.a();
        aVar.iLN = new enc();
        aVar.iLO = new end();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/uploaddevicestep";
        aVar.funcId = 1261;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.Fjr = (enc) this.rr.iLK.iLR;
        this.Fjr.dGL = str;
        this.Fjr.dGP = str2;
        this.Fjr.NkT = i2;
        this.Fjr.NkU = i3;
        this.Fjr.cmD = i4;
        this.Fjr.NkV = String.valueOf(k.fmI());
        this.Fjr.NkX = str3;
        this.Fjr.Nla = i5;
        AppMethodBeat.o(149305);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1261;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(149306);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(149306);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(149307);
        Log.i("MicroMsg.Sport.NetSceneUploadDeviceStep", "NetSceneUploadDeviceStep end: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(149307);
    }
}
