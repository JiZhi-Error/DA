package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.emd;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private i callback;
    public String dGL;
    public String dGP;
    public String deviceName;
    private d rr;

    public c(String str, String str2, String str3) {
        AppMethodBeat.i(125516);
        d.a aVar = new d.a();
        aVar.iLN = new emd();
        aVar.iLO = new eme();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        aVar.funcId = 361;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.dGL = str;
        this.deviceName = str2;
        this.dGP = str3;
        emd emd = (emd) this.rr.iLK.iLR;
        emd.Lke = str;
        emd.Name = str2;
        emd.KLO = str3;
        AppMethodBeat.o(125516);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125517);
        Log.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125517);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 361;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125518);
        if (Util.isNullOrNil(this.dGL) || Util.isNullOrNil(this.deviceName) || Util.isNullOrNil(this.dGP)) {
            Log.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            AppMethodBeat.o(125518);
            return -1;
        }
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125518);
        return dispatch;
    }
}
