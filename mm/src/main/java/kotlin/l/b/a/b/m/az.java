package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.m;

public final class az {
    public static final ab a(ab abVar, List<? extends av> list, g gVar) {
        AppMethodBeat.i(60843);
        p.h(abVar, "$this$replace");
        p.h(list, "newArguments");
        p.h(gVar, "newAnnotations");
        if ((list.isEmpty() || list == abVar.hKB()) && gVar == abVar.hzL()) {
            AppMethodBeat.o(60843);
            return abVar;
        }
        bg hLF = abVar.hLF();
        if (hLF instanceof v) {
            bg a2 = ac.a(a(((v) hLF).TNV, list, gVar), a(((v) hLF).TNW, list, gVar));
            AppMethodBeat.o(60843);
            return a2;
        } else if (hLF instanceof aj) {
            aj a3 = a((aj) hLF, list, gVar);
            AppMethodBeat.o(60843);
            return a3;
        } else {
            m mVar = new m();
            AppMethodBeat.o(60843);
            throw mVar;
        }
    }

    public static /* synthetic */ aj a(aj ajVar, List list, g gVar, int i2) {
        AppMethodBeat.i(186272);
        aj a2 = a(ajVar, (List<? extends av>) list, ajVar.hzL());
        AppMethodBeat.o(186272);
        return a2;
    }

    private static aj a(aj ajVar, List<? extends av> list, g gVar) {
        AppMethodBeat.i(60844);
        p.h(ajVar, "$this$replace");
        p.h(list, "newArguments");
        p.h(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == ajVar.hzL()) {
            AppMethodBeat.o(60844);
            return ajVar;
        } else if (list.isEmpty()) {
            aj d2 = ajVar.d(gVar);
            AppMethodBeat.o(60844);
            return d2;
        } else {
            aj c2 = ac.c(gVar, ajVar.hKE(), list, ajVar.hEa());
            AppMethodBeat.o(60844);
            return c2;
        }
    }

    public static final aj ay(ab abVar) {
        AppMethodBeat.i(60846);
        p.h(abVar, "$this$asSimpleType");
        bg hLF = abVar.hLF();
        if (!(hLF instanceof aj)) {
            hLF = null;
        }
        aj ajVar = (aj) hLF;
        if (ajVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException("This is should be simple type: ".concat(String.valueOf(abVar)).toString());
            AppMethodBeat.o(60846);
            throw illegalStateException;
        }
        AppMethodBeat.o(60846);
        return ajVar;
    }
}
