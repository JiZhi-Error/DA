package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dqu;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class k extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24865);
        d.a aVar = new d.a();
        aVar.iLN = new qn();
        aVar.iLO = new qo();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.funcId = 1705;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24865);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1705;
    }

    public k(String str, dqu dqu, int i2, String str2) {
        AppMethodBeat.i(24866);
        dNu();
        if (!(8 == i2 && 9 == i2)) {
            Log.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", Integer.valueOf(i2));
        }
        qn qnVar = (qn) this.rr.iLK.iLR;
        qnVar.KSV = str;
        qnVar.KXt = dqu;
        qnVar.KCx = i2;
        qnVar.KCy = str2;
        AppMethodBeat.o(24866);
    }

    public final String dNG() {
        AppMethodBeat.i(24867);
        LinkedList<ej> linkedList = ((qo) this.rr.iLL.iLR).KXu;
        if (linkedList == null || linkedList.size() != 1) {
            AppMethodBeat.o(24867);
            return null;
        }
        String str = linkedList.get(0).KIa;
        AppMethodBeat.o(24867);
        return str;
    }
}
