package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.l;
import kotlinx.coroutines.internal.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, hxF = {"recoverResult", "Lkotlin/Result;", "T", "state", "", "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
public final class w {
    public static final <T> Object fQ(Object obj) {
        AppMethodBeat.i(118154);
        Throwable r0 = Result.m49exceptionOrNullimpl(obj);
        if (r0 == null) {
            AppMethodBeat.o(118154);
            return obj;
        }
        v vVar = new v(r0);
        AppMethodBeat.o(118154);
        return vVar;
    }

    public static final <T> Object a(Object obj, d<? super T> dVar) {
        AppMethodBeat.i(192498);
        if (obj instanceof v) {
            Result.Companion companion = Result.Companion;
            Throwable th = ((v) obj).cause;
            if (an.hML() && (dVar instanceof e)) {
                th = t.a(th, (e) dVar);
            }
            Object r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
            AppMethodBeat.o(192498);
            return r0;
        }
        Result.Companion companion2 = Result.Companion;
        Object r02 = Result.m46constructorimpl(obj);
        AppMethodBeat.o(192498);
        return r02;
    }
}
