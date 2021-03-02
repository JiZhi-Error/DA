package kotlin.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, hxF = {"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public final class c implements d<Object> {
    public static final c SXW = new c();

    static {
        AppMethodBeat.i(129607);
        AppMethodBeat.o(129607);
    }

    private c() {
    }

    @Override // kotlin.d.d
    public final f getContext() {
        AppMethodBeat.i(129605);
        IllegalStateException illegalStateException = new IllegalStateException("This continuation is already complete".toString());
        AppMethodBeat.o(129605);
        throw illegalStateException;
    }

    @Override // kotlin.d.d
    public final void resumeWith(Object obj) {
        AppMethodBeat.i(129606);
        IllegalStateException illegalStateException = new IllegalStateException("This continuation is already complete".toString());
        AppMethodBeat.o(129606);
        throw illegalStateException;
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
