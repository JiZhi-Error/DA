package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "isDispatchNeeded", "", "toString", "", "kotlinx-coroutines-core"})
public final class cv extends ad {
    public static final cv TVn = new cv();

    static {
        AppMethodBeat.i(118172);
        AppMethodBeat.o(118172);
    }

    private cv() {
    }

    @Override // kotlinx.coroutines.ad
    public final boolean hMH() {
        return false;
    }

    @Override // kotlinx.coroutines.ad
    public final void a(f fVar, Runnable runnable) {
        AppMethodBeat.i(118171);
        cx cxVar = (cx) fVar.get(cx.TVp);
        if (cxVar != null) {
            cxVar.TVo = true;
            AppMethodBeat.o(118171);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        AppMethodBeat.o(118171);
        throw unsupportedOperationException;
    }

    @Override // kotlinx.coroutines.ad
    public final String toString() {
        return "Unconfined";
    }
}
