package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.sdk.event.IListener;

public final class t extends IListener<ps> {
    public t() {
        AppMethodBeat.i(161780);
        this.__eventId = ps.class.getName().hashCode();
        AppMethodBeat.o(161780);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(ps psVar) {
        AppMethodBeat.i(150855);
        boolean bet = bet();
        AppMethodBeat.o(150855);
        return bet;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean bet() {
        /*
        // Method dump skipped, instructions count: 329
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bb.t.bet():boolean");
    }
}
