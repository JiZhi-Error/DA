package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.d.b.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001a*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u001aB\u0015\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0001J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, hxF = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "(Lkotlin/coroutines/Continuation;)V", "initialResult", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "getOrThrow", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "Companion", "kotlin-stdlib"})
public final class h<T> implements e, d<T> {
    private static final AtomicReferenceFieldUpdater<h<?>, Object> SXM = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "result");
    @Deprecated
    public static final a SXN = new a((byte) 0);
    private final d<T> SXL;
    private volatile Object result;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.d.d<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    private h(d<? super T> dVar, Object obj) {
        p.h(dVar, "delegate");
        AppMethodBeat.i(129638);
        this.SXL = dVar;
        this.result = obj;
        AppMethodBeat.o(129638);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(d<? super T> dVar) {
        this(dVar, kotlin.d.a.a.UNDECIDED);
        p.h(dVar, "delegate");
        AppMethodBeat.i(129639);
        AppMethodBeat.o(129639);
    }

    @Override // kotlin.d.d
    public final f getContext() {
        AppMethodBeat.i(129634);
        f context = this.SXL.getContext();
        AppMethodBeat.o(129634);
        return context;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002RZ\u0010\u0003\u001aF\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001 \u0006*\"\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\b"}, hxF = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "()V", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT$annotations", "kotlin-stdlib"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(129640);
        AppMethodBeat.o(129640);
    }

    @Override // kotlin.d.d
    public final void resumeWith(Object obj) {
        AppMethodBeat.i(129635);
        while (true) {
            Object obj2 = this.result;
            if (obj2 == kotlin.d.a.a.UNDECIDED) {
                if (SXM.compareAndSet(this, kotlin.d.a.a.UNDECIDED, obj)) {
                    AppMethodBeat.o(129635);
                    return;
                }
            } else if (obj2 != kotlin.d.a.a.COROUTINE_SUSPENDED) {
                IllegalStateException illegalStateException = new IllegalStateException("Already resumed");
                AppMethodBeat.o(129635);
                throw illegalStateException;
            } else if (SXM.compareAndSet(this, kotlin.d.a.a.COROUTINE_SUSPENDED, kotlin.d.a.a.RESUMED)) {
                this.SXL.resumeWith(obj);
                AppMethodBeat.o(129635);
                return;
            }
        }
    }

    public final Object hxK() {
        AppMethodBeat.i(129636);
        Object obj = this.result;
        if (obj == kotlin.d.a.a.UNDECIDED) {
            if (SXM.compareAndSet(this, kotlin.d.a.a.UNDECIDED, kotlin.d.a.a.COROUTINE_SUSPENDED)) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                AppMethodBeat.o(129636);
                return aVar;
            }
            obj = this.result;
        }
        if (obj == kotlin.d.a.a.RESUMED) {
            kotlin.d.a.a aVar2 = kotlin.d.a.a.COROUTINE_SUSPENDED;
            AppMethodBeat.o(129636);
            return aVar2;
        } else if (obj instanceof Result.Failure) {
            Throwable th = ((Result.Failure) obj).exception;
            AppMethodBeat.o(129636);
            throw th;
        } else {
            AppMethodBeat.o(129636);
            return obj;
        }
    }

    @Override // kotlin.d.b.a.e
    public final e getCallerFrame() {
        d<T> dVar = this.SXL;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    @Override // kotlin.d.b.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public final String toString() {
        AppMethodBeat.i(129637);
        String str = "SafeContinuation for " + this.SXL;
        AppMethodBeat.o(129637);
        return str;
    }
}
