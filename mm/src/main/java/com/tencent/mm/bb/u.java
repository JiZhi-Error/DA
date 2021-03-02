package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class u extends IListener<ps> {
    private static long gmF = Util.MILLSECONDS_OF_DAY;

    public u() {
        AppMethodBeat.i(161781);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161781);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        AppMethodBeat.i(150858);
        boolean bet = bet();
        AppMethodBeat.o(150858);
        return bet;
    }

    private static boolean bet() {
        AppMethodBeat.i(150856);
        Log.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + akM());
        if (akM()) {
            c.beo().update();
        }
        AppMethodBeat.o(150856);
        return false;
    }

    private static boolean akM() {
        AppMethodBeat.i(150857);
        if (Util.secondsToNow(Util.nullAsNil((Long) g.aAh().azQ().get(81938, (Object) null))) * 1000 > gmF) {
            AppMethodBeat.o(150857);
            return true;
        }
        AppMethodBeat.o(150857);
        return false;
    }
}
