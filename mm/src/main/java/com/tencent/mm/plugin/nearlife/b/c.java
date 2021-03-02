package com.tencent.mm.plugin.nearlife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.b;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.aem;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c extends q implements m {
    private i AAQ;
    public String AAR;
    private d iLF;

    public c(String str, String str2, String str3, chk chk, int i2, LinkedList<dqi> linkedList, String str4) {
        AppMethodBeat.i(26548);
        d.a aVar = new d.a();
        aVar.iLN = new ael();
        aVar.iLO = new aem();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        aVar.funcId = b.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iLF = aVar.aXF();
        String nullAs = Util.nullAs(str4, "");
        String nullAs2 = Util.nullAs((String) null, "");
        ael ael = (ael) this.iLF.iLK.iLR;
        ael.Name = str;
        ael.LpJ = str2;
        ael.LpL = chk;
        ael.oTz = i2;
        if (linkedList != null) {
            ael.LpM = linkedList;
        }
        ael.LpN = nullAs;
        ael.LpO = nullAs2;
        ael.LpK = str3;
        Log.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", str, str2, str3, Float.valueOf(chk.LbD), Float.valueOf(chk.LbC), Integer.valueOf(i2), nullAs, nullAs2);
        AppMethodBeat.o(26548);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return b.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26549);
        this.AAQ = iVar;
        int dispatch = dispatch(gVar, this.iLF, this);
        AppMethodBeat.o(26549);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26550);
        Log.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        aem aem = (aem) this.iLF.iLL.iLR;
        if (this.iLF.iLL.getRetCode() != 0) {
            this.AAQ.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(26550);
            return;
        }
        this.AAR = aem.LpP;
        Log.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.AAR);
        this.AAQ.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26550);
    }
}
