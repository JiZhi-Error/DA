package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ba.l;
import com.tencent.mm.g.a.am;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class a extends IListener<am> {
    a() {
        AppMethodBeat.i(161424);
        this.__eventId = am.class.getName().hashCode();
        AppMethodBeat.o(161424);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(am amVar) {
        AppMethodBeat.i(27711);
        boolean a2 = a(amVar);
        AppMethodBeat.o(27711);
        return a2;
    }

    private static boolean a(am amVar) {
        AppMethodBeat.i(27710);
        if (!(amVar instanceof am)) {
            Log.f("MicroMsg.QMsg.EventListener", "not bind qq event");
            AppMethodBeat.o(27710);
        } else {
            if (amVar.dDo.dDq == 0) {
                try {
                    int aUl = z.aUl() | 32;
                    bg.aVF();
                    c.azQ().set(34, Integer.valueOf(aUl));
                    bg.aVF();
                    c.aSM().d(new l("", "", "", "", "", "", "", "", aUl, "", ""));
                    g.eGb();
                    Log.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.QMsg.EventListener", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(27710);
        }
        return false;
    }
}
