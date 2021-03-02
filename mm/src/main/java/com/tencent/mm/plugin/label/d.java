package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends IListener<ps> {
    public d() {
        AppMethodBeat.i(161391);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161391);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        AppMethodBeat.i(26135);
        boolean bet = bet();
        AppMethodBeat.o(26135);
        return bet;
    }

    private static boolean bet() {
        boolean z;
        AppMethodBeat.i(26134);
        bg.aVF();
        if (System.currentTimeMillis() - ((Long) c.azQ().get(209408, (Object) 0L)).longValue() > Util.MILLSECONDS_OF_DAY) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            bg.azz().a(new com.tencent.mm.plugin.label.b.c(), 0);
            bg.aVF();
            c.azQ().set(209408, Long.valueOf((System.currentTimeMillis() - Util.MILLSECONDS_OF_DAY) + 1800000));
        }
        AppMethodBeat.o(26134);
        return false;
    }
}
