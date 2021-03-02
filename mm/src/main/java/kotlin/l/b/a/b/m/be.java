package kotlin.l.b.a.b.m;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.m;

public final class be {
    public static final ab aJ(ab abVar) {
        AppMethodBeat.i(60903);
        p.h(abVar, "$this$getEnhancement");
        if (abVar instanceof bd) {
            ab hLD = ((bd) abVar).hLD();
            AppMethodBeat.o(60903);
            return hLD;
        }
        AppMethodBeat.o(60903);
        return null;
    }

    public static final bg a(bg bgVar, ab abVar) {
        AppMethodBeat.i(60904);
        p.h(bgVar, "$this$inheritEnhancement");
        p.h(abVar, FirebaseAnalytics.b.ORIGIN);
        bg b2 = b(bgVar, aJ(abVar));
        AppMethodBeat.o(60904);
        return b2;
    }

    public static final bg b(bg bgVar, ab abVar) {
        AppMethodBeat.i(60905);
        p.h(bgVar, "$this$wrapEnhancement");
        if (abVar == null) {
            AppMethodBeat.o(60905);
            return bgVar;
        } else if (bgVar instanceof aj) {
            al alVar = new al((aj) bgVar, abVar);
            AppMethodBeat.o(60905);
            return alVar;
        } else if (bgVar instanceof v) {
            x xVar = new x((v) bgVar, abVar);
            AppMethodBeat.o(60905);
            return xVar;
        } else {
            m mVar = new m();
            AppMethodBeat.o(60905);
            throw mVar;
        }
    }
}
