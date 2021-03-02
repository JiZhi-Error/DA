package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsOnlineSDKExtensionEntry;

public final class s extends IListener<ps> {
    public s() {
        AppMethodBeat.i(161779);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161779);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        AppMethodBeat.i(150853);
        boolean bet = bet();
        AppMethodBeat.o(150853);
        return bet;
    }

    private static boolean bet() {
        boolean z;
        AppMethodBeat.i(150852);
        if (Util.secondsToNow(Util.nullAs((Long) g.aAh().azQ().get(66818, (Object) null), 0)) * 1000 > 1800000) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(66820, (Object) null), (int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE);
            if (nullAs != -99999) {
                cf.I(9, String.valueOf(nullAs));
                g.aAh().azQ().set(66820, Integer.valueOf((int) TbsOnlineSDKExtensionEntry.EXTENSION_INIT_FAILURE));
            }
            g.aAh().azQ().set(66818, Long.valueOf(Util.nowSecond()));
        }
        AppMethodBeat.o(150852);
        return false;
    }
}
