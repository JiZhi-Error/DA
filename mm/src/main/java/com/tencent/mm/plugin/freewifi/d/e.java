package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bfl;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class e extends c {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void dNu() {
        AppMethodBeat.i(24851);
        d.a aVar = new d.a();
        aVar.iLN = new bfm();
        aVar.iLO = new bfn();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24851);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1781;
    }

    public e(LinkedList<bfl> linkedList) {
        AppMethodBeat.i(24852);
        dNu();
        if (linkedList != null && linkedList.size() > 0) {
            ((bfm) this.rr.iLK.iLR).LPf = linkedList;
        }
        AppMethodBeat.o(24852);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.freewifi.d.c
    public final void a(int i2, int i3, int i4, String str) {
        AppMethodBeat.i(24853);
        Log.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (m.gB(i3, i4)) {
            j.dNr().dMZ().post(new Runnable() {
                /* class com.tencent.mm.plugin.freewifi.d.e.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(24850);
                    if (((bfn) e.this.rr.iLL.iLR) == null) {
                        AppMethodBeat.o(24850);
                    } else {
                        AppMethodBeat.o(24850);
                    }
                }
            });
        }
        AppMethodBeat.o(24853);
    }

    public final LinkedList<bfl> dNB() {
        bfn bfn = (bfn) this.rr.iLL.iLR;
        if (bfn == null) {
            return null;
        }
        return bfn.LPf;
    }
}
