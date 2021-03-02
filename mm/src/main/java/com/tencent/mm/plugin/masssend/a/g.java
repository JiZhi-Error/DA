package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends IListener<ps> {
    public g() {
        AppMethodBeat.i(161392);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161392);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        AppMethodBeat.i(26364);
        boolean bet = bet();
        AppMethodBeat.o(26364);
        return bet;
    }

    private static boolean bet() {
        boolean z;
        AppMethodBeat.i(26363);
        if (!bg.aAc()) {
            Log.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
            AppMethodBeat.o(26363);
        } else {
            h.ehG();
            bg.aVF();
            if (Util.milliSecondsToNow(Util.nullAs((Long) c.azQ().get(102409, (Object) null), 0)) > 900000) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Log.d("MicroMsg.PostTaskMassSendListener", "time limit");
                AppMethodBeat.o(26363);
            } else {
                h.ehG().ehB();
                h.ehG();
                c.Ha(Util.nowMilliSecond());
                AppMethodBeat.o(26363);
            }
        }
        return false;
    }
}
