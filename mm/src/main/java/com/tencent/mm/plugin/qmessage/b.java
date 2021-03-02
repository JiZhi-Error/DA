package com.tencent.mm.plugin.qmessage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class b extends IListener<qc> {
    public b() {
        AppMethodBeat.i(161423);
        this.__eventId = qc.class.getName().hashCode();
        AppMethodBeat.o(161423);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(qc qcVar) {
        AppMethodBeat.i(27709);
        qc qcVar2 = qcVar;
        switch (qcVar2.dWm.opType) {
            case 0:
                String str = qcVar2.dWm.dWo;
                String str2 = qcVar2.dWm.dWp;
                bg.aVF();
                as Kn = c.aSN().Kn(str);
                if (Kn == null || ((int) Kn.gMZ) == 0) {
                    as asVar = new as(str);
                    asVar.aqW();
                    asVar.setNickname(str2);
                    asVar.nl(4);
                    bg.aVF();
                    c.aSN().ap(asVar);
                    com.tencent.mm.aj.c.Mb(asVar.field_username);
                }
                d aKB = g.eFZ().aKB(str);
                if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
                    d dVar = new d();
                    dVar.cSx = -1;
                    dVar.Bqg = 1;
                    dVar.username = str;
                    dVar.Bqh = 0;
                    dVar.Bqi = 0;
                    if (!g.eFZ().a(dVar)) {
                        Log.e("MicroMsg.QMsgExtension", "processModQContact: insert qcontact failed");
                    }
                }
                qcVar2.dWn.dFE = true;
                break;
            case 1:
                d aKB2 = g.eFZ().aKB(qcVar2.dWm.dWq);
                if (aKB2 != null && Util.nullAsNil(aKB2.getUsername()).length() > 0) {
                    if (aKB2.Bqh != ((long) qcVar2.dWm.dWr) || aKB2.Bqi != ((long) qcVar2.dWm.dWs)) {
                        aKB2.Bqg = 1;
                        aKB2.username = qcVar2.dWm.dWq;
                        aKB2.Bqh = (long) qcVar2.dWm.dWr;
                        aKB2.Bqi = (long) qcVar2.dWm.dWs;
                        aKB2.cSx = 56;
                        if (!g.eFZ().a(aKB2.getUsername(), aKB2)) {
                            Log.e("MicroMsg.QMsgOperationListener", "processModQContact: update qcontact failed");
                        }
                        qcVar2.dWn.dFE = true;
                        break;
                    } else {
                        qcVar2.dWn.dFE = true;
                        break;
                    }
                } else {
                    d dVar2 = new d();
                    dVar2.cSx = -1;
                    dVar2.Bqg = 1;
                    dVar2.username = qcVar2.dWm.dWq;
                    dVar2.Bqh = (long) qcVar2.dWm.dWr;
                    dVar2.Bqi = (long) qcVar2.dWm.dWs;
                    if (!g.eFZ().a(dVar2)) {
                        Log.e("MicroMsg.QMsgOperationListener", "processModQContact: insert qcontact failed");
                    }
                    qcVar2.dWn.dFE = true;
                    break;
                }
                break;
            case 2:
                g.eGa();
                break;
        }
        AppMethodBeat.o(27709);
        return false;
    }
}
