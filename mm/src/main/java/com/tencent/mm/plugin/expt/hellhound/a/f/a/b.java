package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.stack.d;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.c;

public final class b {
    public static c<cbm, Integer> cPT() {
        AppMethodBeat.i(122090);
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPX()) {
            Log.w("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getCurPageFlowItem, doNotNeedSessionMonitor: TRUE");
            AppMethodBeat.o(122090);
            return null;
        }
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession is NULL");
            AppMethodBeat.o(122090);
            return null;
        }
        Log.i("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curSession: %s", cQo.sessionId);
        d.cNM();
        bn cNR = e.cNR();
        if (cNR == null) {
            Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, curAR is NULL");
            AppMethodBeat.o(122090);
            return null;
        }
        c<cbm, Integer> gw = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.gw(cQo.sessionId, cNR.KFh.activityName);
        if (gw == null) {
            Log.e("HABBYGE-MALI.BaseBizCollector", "BaseBizCollector, getPageFlowItemOfCurSession is NULL");
            AppMethodBeat.o(122090);
            return null;
        }
        ((Integer) gw.get(1)).intValue();
        AppMethodBeat.o(122090);
        return gw;
    }
}
