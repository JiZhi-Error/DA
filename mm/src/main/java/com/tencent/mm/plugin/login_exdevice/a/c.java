package com.tencent.mm.plugin.login_exdevice.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.backgroundfetch.a;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dge;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private i callback;
    public d hJu;

    public c(String str, byte[] bArr) {
        AppMethodBeat.i(231735);
        d.a aVar = new d.a();
        aVar.iLN = new dgd();
        aVar.iLO = new dge();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/pushloginurl";
        this.hJu = aVar.aXF();
        dgd dgd = (dgd) this.hJu.iLK.iLR;
        dgd.UserName = str;
        dgd.KKZ = z.aC(bArr);
        dgd.KQy = 3;
        dgd.MrO = g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).toString().getBytes());
        dgd.oTI = com.tencent.mm.protocal.d.DEVICE_NAME;
        byte[] uuidRandom = Util.getUuidRandom();
        dgd.KPW = z.aC(uuidRandom);
        this.hJu.setRsaInfo(ac.gtT());
        this.hJu.option = 1;
        this.hJu.getReqObj().setPassKey(uuidRandom);
        AppMethodBeat.o(231735);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(231736);
        Log.i("MicroMsg.NetScenePushLoginUrl", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(231736);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return a.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(231737);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(231737);
        return dispatch;
    }
}
