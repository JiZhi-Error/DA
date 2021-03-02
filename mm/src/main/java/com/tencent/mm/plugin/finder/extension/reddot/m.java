package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.g.b.p;

public final class m {
    static boolean tLv;
    public static final m tLw = new m();
    static f toy;

    static {
        AppMethodBeat.i(243660);
        AppMethodBeat.o(243660);
    }

    private m() {
    }

    private static boolean asT() {
        AppMethodBeat.i(243654);
        c cVar = c.vCb;
        if (!(c.duI().value().intValue() == 1)) {
            reset(0);
            AppMethodBeat.o(243654);
            return false;
        }
        AppMethodBeat.o(243654);
        return true;
    }

    public static void dbU() {
        AppMethodBeat.i(243655);
        f fVar = toy;
        boolean z = (fVar != null ? fVar.asX("FinderEntrance") : null) != null;
        Log.i("Finder.ThreeDayTwoDay", "beforeRevokeRedDot hasRed=".concat(String.valueOf(z)));
        tLv = z;
        AppMethodBeat.o(243655);
    }

    public final boolean dbV() {
        boolean z;
        AppMethodBeat.i(243656);
        if (!asT()) {
            AppMethodBeat.o(243656);
            return false;
        }
        dbW();
        f fVar = toy;
        if ((fVar != null ? fVar.asX("FinderEntrance") : null) != null) {
            z = true;
        } else {
            z = false;
        }
        c cVar = c.vCb;
        int intValue = c.duJ().value().intValue();
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC, 0);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        long a3 = aAh2.azQ().a(ar.a.USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC, 0);
        long aWA = cl.aWA() - a2;
        Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] hasRed=" + z + " threadDayBegin=" + a2 + " threeDayThreshold=" + intValue + " hitThreeDayTime=" + a3 + " diffThreeDay=" + aWA);
        if (z && a2 > 0 && a3 == 0 && aWA >= ((long) intValue)) {
            Log.i("Finder.ThreeDayTwoDay", "[checkOverThreeDay] USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC=" + cl.aWA());
            e aAh3 = g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC, Long.valueOf(cl.aWA()));
            AppMethodBeat.o(243656);
            return true;
        } else if (aWA >= ((long) intValue)) {
            AppMethodBeat.o(243656);
            return true;
        } else {
            AppMethodBeat.o(243656);
            return false;
        }
    }

    public final void dbW() {
        AppMethodBeat.i(243657);
        boolean asT = asT();
        if (!asT) {
            AppMethodBeat.o(243657);
            return;
        }
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        long a2 = aAh.azQ().a(ar.a.USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC, 0);
        f fVar = toy;
        boolean z = (fVar != null ? fVar.asX("FinderEntrance") : null) != null;
        Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayTwoDay] isEnable=" + asT + " begin=" + a2 + " hasRed=" + z);
        if (asT && a2 == 0 && z) {
            Log.i("Finder.ThreeDayTwoDay", "[checkThreeDayBegin] USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC=" + cl.aWA());
            e aAh2 = g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC, Long.valueOf(cl.aWA()));
        }
        AppMethodBeat.o(243657);
    }

    static /* synthetic */ void dbX() {
        AppMethodBeat.i(243659);
        reset(0);
        AppMethodBeat.o(243659);
    }

    static void reset(long j2) {
        AppMethodBeat.i(243658);
        Log.i("Finder.ThreeDayTwoDay", "[reset] begin=".concat(String.valueOf(j2)));
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_THREE_DAY_HIT_TIME_LONG_SYNC, (Object) 0L);
        e aAh2 = g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_THREE_DAY_BEGIN_TIME_LONG_SYNC, Long.valueOf(j2));
        AppMethodBeat.o(243658);
    }
}
