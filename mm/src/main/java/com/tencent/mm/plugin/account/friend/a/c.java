package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends IListener<am> {
    public c() {
        AppMethodBeat.i(161616);
        this.__eventId = am.class.getName().hashCode();
        AppMethodBeat.o(161616);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(am amVar) {
        AppMethodBeat.i(130989);
        boolean a2 = a(amVar);
        AppMethodBeat.o(130989);
        return a2;
    }

    private static boolean a(am amVar) {
        AppMethodBeat.i(130988);
        if (amVar.dDo.dDq == 0) {
            try {
                int aUl = z.aUl() | 4096;
                g.aAh().azQ().set(34, Integer.valueOf(aUl));
                ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", aUl, "", ""));
                Log.d("MicroMsg.FriendBindQQ.EventListener", "doClearQQFriendHelper succ ");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FriendBindQQ.EventListener", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(130988);
        return false;
    }
}
