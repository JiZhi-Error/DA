package com.tencent.mm.plugin.record.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class t extends IListener<rc> {
    public t() {
        AppMethodBeat.i(160914);
        this.__eventId = rc.class.getName().hashCode();
        AppMethodBeat.o(160914);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(rc rcVar) {
        AppMethodBeat.i(9585);
        rc rcVar2 = rcVar;
        Log.i("MicroMsg.RecordOperationListener", "on record operation listener, %d", Integer.valueOf(rcVar2.dXF.type));
        switch (rcVar2.dXF.type) {
            case 0:
                rcVar2.dXG.dXP = p.aKY(rcVar2.dXF.dXH);
                break;
            case 1:
                Log.i("MicroMsg.RecordOperationListener", "get record paths, msg id %d", Long.valueOf(rcVar2.dXF.msgId));
                rcVar2.dXG.dXQ = p.d(rcVar2.dXF.dKT, rcVar2.dXF.msgId);
                rcVar2.dXG.dataPath = p.c(rcVar2.dXF.dKT, rcVar2.dXF.msgId);
                rcVar2.dXG.dXR = p.e(rcVar2.dXF.dKT, rcVar2.dXF.msgId);
                rcVar2.dXG.thumbPath = p.f(rcVar2.dXF.dKT, rcVar2.dXF.msgId);
                break;
            case 2:
                Log.i("MicroMsg.RecordOperationListener", "send record msg, to %s, thumbPath %s, thumbId %s", rcVar2.dXF.toUser, rcVar2.dXF.thumbPath, Integer.valueOf(rcVar2.dXF.dXJ));
                p.a(rcVar2.dXF.toUser, rcVar2.dXF.dXI, rcVar2.dXF.title, rcVar2.dXF.desc, rcVar2.dXF.thumbPath, rcVar2.dXF.dXJ, rcVar2.dXF.dXL);
                break;
            case 3:
                Log.i("MicroMsg.RecordOperationListener", "clear resouces, msg id %d", Long.valueOf(rcVar2.dXF.msgId));
                p.HV(rcVar2.dXF.msgId);
                break;
            case 4:
                Log.i("MicroMsg.RecordOperationListener", "forward record msg, to %s, msg id %d", rcVar2.dXF.toUser, Long.valueOf(rcVar2.dXF.dTX.field_msgId));
                p.a(rcVar2.dXF.toUser, rcVar2.dXF.dLs, rcVar2.dXF.dTX, rcVar2.dXF.dXN);
                break;
            case 5:
                Log.i("MicroMsg.RecordOperationListener", "summerrecord forward multi record msg, to %s(%s)", rcVar2.dXF.toUser, Util.nullAs(rcVar2.dXF.dXO, ""));
                Pair<Long, Boolean> a2 = p.a(rcVar2.dXF.context, rcVar2.dXF.toUser, rcVar2.dXF.from, rcVar2.dXF.dXK, rcVar2.dXF.dWX, rcVar2.dXF.dXM, rcVar2.dXF.dXO);
                rcVar2.dXG.msgId = ((Long) a2.first).longValue();
                rcVar2.dXG.dXS = ((Boolean) a2.second).booleanValue();
                break;
            case 6:
            case 10:
                cz czVar = new cz();
                c.a(rcVar2.dXF.context, czVar, rcVar2.dXF.from, rcVar2.dXF.dXK, rcVar2.dXF.type);
                d a3 = p.a(rcVar2.dXF.context, czVar, rcVar2.dXF.from);
                rcVar2.dXG.dWX = czVar;
                rcVar2.dXG.dXM = a3;
                break;
            case 8:
                if (!Util.isNullOrNil(rcVar2.dXF.thumbPath)) {
                    p.c(rcVar2.dXF.dKT, rcVar2.dXF.msgId, true);
                    break;
                } else {
                    p.b(rcVar2.dXF.dKT, rcVar2.dXF.msgId, true);
                    break;
                }
            case 9:
                rcVar2.dXG.dXQ = p.g(rcVar2.dXF.dKT, rcVar2.dXF.msgId);
                break;
        }
        AppMethodBeat.o(9585);
        return false;
    }
}
