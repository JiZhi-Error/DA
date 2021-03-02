package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.internal.y;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, hxF = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "afterResume", "", "state", "", "kotlinx-coroutines-core"})
public final class cw<T> extends s<T> {
    public cw(f fVar, d<? super T> dVar) {
        super(fVar, dVar);
    }

    @Override // kotlinx.coroutines.internal.s, kotlinx.coroutines.a
    public final void fM(Object obj) {
        AppMethodBeat.i(192322);
        Object a2 = w.a(obj, this.TWf);
        f context = this.TWf.getContext();
        Object a3 = y.a(context, null);
        try {
            this.TWf.resumeWith(a2);
            x xVar = x.SXb;
        } finally {
            y.b(context, a3);
            AppMethodBeat.o(192322);
        }
    }
}
