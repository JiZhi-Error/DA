package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tinkerboots.sdk.a;

public final class f extends IListener<d> {
    private static long dfO = 0;

    public f() {
        AppMethodBeat.i(161184);
        this.__eventId = d.class.getName().hashCode();
        AppMethodBeat.o(161184);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(d dVar) {
        AppMethodBeat.i(117436);
        boolean a2 = a(dVar);
        AppMethodBeat.o(117436);
        return a2;
    }

    private static boolean a(d dVar) {
        AppMethodBeat.i(117435);
        if (dVar.dBP.dBQ) {
            AppMethodBeat.o(117435);
        } else if (!g.aAc()) {
            AppMethodBeat.o(117435);
        } else {
            if (dfO == 0) {
                dfO = ((Long) g.aAh().azQ().get(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, (Object) 0L)).longValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - dfO >= 21600000 && a.hvX() != null) {
                a.hvX().Ey(false);
                Log.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                dfO = currentTimeMillis;
                g.aAh().azQ().set(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
            }
            AppMethodBeat.o(117435);
        }
        return false;
    }

    public static void GQ(long j2) {
        dfO = j2;
    }
}
