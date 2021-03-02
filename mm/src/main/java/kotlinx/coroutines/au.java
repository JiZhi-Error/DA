package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.a.a;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, hxF = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "", "timeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class au {
    public static final Object a(long j2, d<? super x> dVar) {
        AppMethodBeat.i(118246);
        if (j2 <= 0) {
            x xVar = x.SXb;
            AppMethodBeat.o(118246);
            return xVar;
        }
        l lVar = new l(b.e(dVar));
        l lVar2 = lVar;
        c(lVar2.getContext()).a(j2, lVar2);
        Object result = lVar.getResult();
        if (result == a.COROUTINE_SUSPENDED) {
            p.h(dVar, "frame");
        }
        AppMethodBeat.o(118246);
        return result;
    }

    public static final at c(f fVar) {
        AppMethodBeat.i(118247);
        f.b bVar = fVar.get(e.SXH);
        if (!(bVar instanceof at)) {
            bVar = null;
        }
        at atVar = (at) bVar;
        if (atVar == null) {
            atVar = aq.hMR();
        }
        AppMethodBeat.o(118247);
        return atVar;
    }
}
