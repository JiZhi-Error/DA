package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.m;
import kotlin.t;

public final class y {
    public static final boolean al(ab abVar) {
        AppMethodBeat.i(60747);
        p.h(abVar, "$this$isFlexible");
        boolean z = abVar.hLF() instanceof v;
        AppMethodBeat.o(60747);
        return z;
    }

    public static final v am(ab abVar) {
        AppMethodBeat.i(60748);
        p.h(abVar, "$this$asFlexibleType");
        bg hLF = abVar.hLF();
        if (hLF == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
            AppMethodBeat.o(60748);
            throw tVar;
        }
        v vVar = (v) hLF;
        AppMethodBeat.o(60748);
        return vVar;
    }

    public static final aj an(ab abVar) {
        AppMethodBeat.i(60749);
        p.h(abVar, "$this$lowerIfFlexible");
        bg hLF = abVar.hLF();
        if (hLF instanceof v) {
            aj ajVar = ((v) hLF).TNV;
            AppMethodBeat.o(60749);
            return ajVar;
        } else if (hLF instanceof aj) {
            aj ajVar2 = (aj) hLF;
            AppMethodBeat.o(60749);
            return ajVar2;
        } else {
            m mVar = new m();
            AppMethodBeat.o(60749);
            throw mVar;
        }
    }

    public static final aj ao(ab abVar) {
        AppMethodBeat.i(60750);
        p.h(abVar, "$this$upperIfFlexible");
        bg hLF = abVar.hLF();
        if (hLF instanceof v) {
            aj ajVar = ((v) hLF).TNW;
            AppMethodBeat.o(60750);
            return ajVar;
        } else if (hLF instanceof aj) {
            aj ajVar2 = (aj) hLF;
            AppMethodBeat.o(60750);
            return ajVar2;
        } else {
            m mVar = new m();
            AppMethodBeat.o(60750);
            throw mVar;
        }
    }
}
