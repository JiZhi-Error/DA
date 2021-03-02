package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;
import kotlin.l.e;
import kotlin.l.g;
import kotlin.l.h;
import kotlin.l.l;
import kotlin.l.m;

public final class aa {
    private static final ab SYH;
    private static final b[] SYI = new b[0];

    static {
        ab abVar;
        AppMethodBeat.i(128951);
        try {
            abVar = (ab) Class.forName("kotlin.l.b.a.z").newInstance();
        } catch (ClassCastException e2) {
            abVar = null;
        } catch (ClassNotFoundException e3) {
            abVar = null;
        } catch (InstantiationException e4) {
            abVar = null;
        } catch (IllegalAccessException e5) {
            abVar = null;
        }
        if (abVar == null) {
            abVar = new ab();
        }
        SYH = abVar;
        AppMethodBeat.o(128951);
    }

    public static b bp(Class cls) {
        AppMethodBeat.i(128944);
        b bp = SYH.bp(cls);
        AppMethodBeat.o(128944);
        return bp;
    }

    public static String a(q qVar) {
        AppMethodBeat.i(128945);
        String a2 = SYH.a(qVar);
        AppMethodBeat.o(128945);
        return a2;
    }

    public static String a(m mVar) {
        AppMethodBeat.i(128946);
        String a2 = SYH.a(mVar);
        AppMethodBeat.o(128946);
        return a2;
    }

    public static e a(n nVar) {
        AppMethodBeat.i(128947);
        e a2 = SYH.a(nVar);
        AppMethodBeat.o(128947);
        return a2;
    }

    public static l a(ag agVar) {
        AppMethodBeat.i(128948);
        l a2 = SYH.a(agVar);
        AppMethodBeat.o(128948);
        return a2;
    }

    public static g a(t tVar) {
        AppMethodBeat.i(206187);
        g a2 = SYH.a(tVar);
        AppMethodBeat.o(206187);
        return a2;
    }

    public static m a(x xVar) {
        AppMethodBeat.i(128949);
        m a2 = SYH.a(xVar);
        AppMethodBeat.o(128949);
        return a2;
    }

    public static h a(u uVar) {
        AppMethodBeat.i(128950);
        h a2 = SYH.a(uVar);
        AppMethodBeat.o(128950);
        return a2;
    }
}
