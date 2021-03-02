package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.ehg;
import com.tencent.mm.protocal.protobuf.ehh;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class j extends q implements m {
    private i callback;
    public d rr;

    public j(String str) {
        AppMethodBeat.i(127838);
        d.a aVar = new d.a();
        aVar.iLN = new ehg();
        aVar.iLO = new ehh();
        aVar.uri = "/cgi-bin/micromsg-bin/thirdappverify";
        aVar.funcId = cp.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ehg) this.rr.iLK.iLR).Luy = str;
        ((ehg) this.rr.iLK.iLR).NgU = 1;
        ((ehg) this.rr.iLK.iLR).rBI = LocaleUtil.getApplicationLanguage();
        byte[] uuidRandom = Util.getUuidRandom();
        ((ehg) this.rr.iLK.iLR).KPW = z.aC(uuidRandom);
        this.rr.setRsaInfo(ac.gtT());
        this.rr.option = 1;
        this.rr.getReqObj().setPassKey(uuidRandom);
        this.rr.getReqObj().setSceneStatus(1);
        AppMethodBeat.o(127838);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(127839);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127839);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return cp.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127840);
        Log.i("MicroMsg.NetSceneVerifyThirdApp", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127840);
    }
}
