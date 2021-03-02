package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.bw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

final class f extends IListener<sy> {
    f() {
        AppMethodBeat.i(161676);
        this.__eventId = sy.class.getName().hashCode();
        AppMethodBeat.o(161676);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(sy syVar) {
        AppMethodBeat.i(102667);
        sy syVar2 = syVar;
        if (syVar2 instanceof sy) {
            long j2 = syVar2.dZu.msgId;
            g.HP(j2);
            bw eHI = g.eHI();
            String str = "delete from " + bw.se(20) + " where reserved2 = " + j2;
            Log.d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", str);
            if (eHI.iFy.execSQL(bw.se(20), str)) {
                eHI.si(20);
                eHI.doNotify();
            }
            AppMethodBeat.o(102667);
            return true;
        }
        AppMethodBeat.o(102667);
        return false;
    }
}
