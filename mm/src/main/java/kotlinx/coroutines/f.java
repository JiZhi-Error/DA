package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;

public final class f {
    public static /* synthetic */ ar a(ai aiVar, kotlin.d.f fVar, m mVar, int i2) {
        AppMethodBeat.i(192431);
        ar b2 = g.b(aiVar, fVar, null, mVar, i2);
        AppMethodBeat.o(192431);
        return b2;
    }

    public static /* synthetic */ bu b(ai aiVar, kotlin.d.f fVar, m mVar, int i2) {
        AppMethodBeat.i(117964);
        bu a2 = g.a(aiVar, fVar, null, mVar, i2);
        AppMethodBeat.o(117964);
        return a2;
    }

    public static final <T> ar<T> a(ai aiVar, kotlin.d.f fVar, ak akVar, m<? super ai, ? super d<? super T>, ? extends Object> mVar) {
        cc asVar;
        AppMethodBeat.i(117962);
        kotlin.d.f a2 = ac.a(aiVar, fVar);
        if (akVar.hMJ()) {
            asVar = new cc(a2, mVar);
        } else {
            asVar = new as(a2, true);
        }
        asVar.a(akVar, asVar, mVar);
        as asVar2 = asVar;
        AppMethodBeat.o(117962);
        return asVar2;
    }

    public static final bu b(ai aiVar, kotlin.d.f fVar, ak akVar, m<? super ai, ? super d<? super x>, ? extends Object> mVar) {
        cd clVar;
        AppMethodBeat.i(117963);
        kotlin.d.f a2 = ac.a(aiVar, fVar);
        if (akVar.hMJ()) {
            clVar = new cd(a2, mVar);
        } else {
            clVar = new cl(a2, true);
        }
        clVar.a(akVar, clVar, mVar);
        cl clVar2 = clVar;
        AppMethodBeat.o(117963);
        return clVar2;
    }
}
