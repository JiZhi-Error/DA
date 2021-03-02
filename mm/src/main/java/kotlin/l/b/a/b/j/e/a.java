package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.e;
import kotlin.l.b.a.b.m.ab;

public final class a {
    private static boolean af(ab abVar) {
        boolean z;
        AppMethodBeat.i(60160);
        p.h(abVar, "$this$isInlineClassThatRequiresMangling");
        h hzS = abVar.hKE().hzS();
        if (hzS != null) {
            h hVar = hzS;
            p.h(hVar, "$this$isInlineClassThatRequiresMangling");
            if (!e.D(hVar) || p.j(kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.e) hVar), c.THA)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(60160);
                return true;
            }
        }
        AppMethodBeat.o(60160);
        return false;
    }

    public static final boolean ag(ab abVar) {
        AppMethodBeat.i(60161);
        if (af(abVar) || ah(abVar)) {
            AppMethodBeat.o(60161);
            return true;
        }
        AppMethodBeat.o(60161);
        return false;
    }

    private static final boolean ah(ab abVar) {
        AppMethodBeat.i(60162);
        h hzS = abVar.hKE().hzS();
        if (!(hzS instanceof as)) {
            hzS = null;
        }
        as asVar = (as) hzS;
        if (asVar == null) {
            AppMethodBeat.o(60162);
            return false;
        }
        boolean ag = ag(kotlin.l.b.a.b.m.d.a.e(asVar));
        AppMethodBeat.o(60162);
        return ag;
    }
}
