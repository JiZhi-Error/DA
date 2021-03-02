package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    public String jGZ;
    public String jHi;
    public String jHj;
    private final d rr;

    public q(String str, String str2, int i2) {
        AppMethodBeat.i(223646);
        d.a aVar = new d.a();
        aVar.iLN = new epo();
        aVar.iLO = new epp();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
        aVar.funcId = JsApiGetRecentUsageList.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.jGZ = str;
        this.jHi = str2;
        epo epo = (epo) this.rr.iLK.iLR;
        epo.jGZ = str;
        epo.jHi = str2;
        epo.KHA = (long) i2;
        Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", str, str2);
        AppMethodBeat.o(223646);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151226);
        Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.jGZ);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151226);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return JsApiGetRecentUsageList.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151227);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151227);
        return dispatch;
    }
}
