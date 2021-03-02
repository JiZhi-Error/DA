package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.y;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000C2\u000601j\u0002`22\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u0004\u0018\u00010\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0018\u001a\n\u0018\u00010\u0016j\u0004\u0018\u0001`\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001bH\b¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\bø\u0001\u0000¢\u0006\u0004\b$\u0010!J \u0010%\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010!J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u001e\u0010-\u001a\u0004\u0018\u00010&8\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b-\u0010.\u0012\u0004\b/\u00100R$\u00103\u001a\n\u0018\u000101j\u0004\u0018\u0001`28\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0016\u0010\u0010\u001a\u00020\u000f8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u00109R\u0016\u0010:\u001a\u00020&8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b:\u0010.R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048P@\u0010X\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010>R\u0013\u0010?\u001a\u00020\u001b8F@\u0006¢\u0006\u0006\u001a\u0004\b?\u0010#R\u0019\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, hxF = {"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"})
public final class av<T> extends ay<T> implements e, d<T> {
    static final AtomicReferenceFieldUpdater TUl = AtomicReferenceFieldUpdater.newUpdater(av.class, Object.class, "_reusableCancellableContinuation");
    private final e TUj;
    public final Object TUk;
    public final ad TUm;
    public final d<T> TUn;
    volatile Object _reusableCancellableContinuation;
    public Object _state = aw.TUo;

    static {
        AppMethodBeat.i(192405);
        AppMethodBeat.o(192405);
    }

    @Override // kotlin.d.d
    public final f getContext() {
        AppMethodBeat.i(118201);
        f context = this.TUn.getContext();
        AppMethodBeat.o(118201);
        return context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.d.d<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public av(ad adVar, d<? super T> dVar) {
        super(0);
        AppMethodBeat.i(118200);
        this.TUm = adVar;
        this.TUn = dVar;
        d<T> dVar2 = this.TUn;
        this.TUj = (e) (!(dVar2 instanceof e) ? null : dVar2);
        this.TUk = y.d(getContext());
        this._reusableCancellableContinuation = null;
        AppMethodBeat.o(118200);
    }

    @Override // kotlin.d.b.a.e
    public final e getCallerFrame() {
        return this.TUj;
    }

    @Override // kotlin.d.b.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.ay
    public final Object hMt() {
        AppMethodBeat.i(192404);
        Object obj = this._state;
        if (an.hMK()) {
            if (!(obj != aw.TUo)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192404);
                throw assertionError;
            }
        }
        this._state = aw.TUo;
        AppMethodBeat.o(192404);
        return obj;
    }

    @Override // kotlinx.coroutines.ay
    public final d<T> hMz() {
        return this;
    }

    @Override // kotlin.d.d
    public final void resumeWith(Object obj) {
        AppMethodBeat.i(118198);
        f context = this.TUn.getContext();
        Object fQ = w.fQ(obj);
        if (this.TUm.hMH()) {
            this._state = fQ;
            this.TUq = 0;
            this.TUm.a(context, this);
            AppMethodBeat.o(118198);
            return;
        }
        cp cpVar = cp.TVk;
        bg hNz = cp.hNz();
        if (hNz.hNb()) {
            this._state = fQ;
            this.TUq = 0;
            hNz.b(this);
            AppMethodBeat.o(118198);
            return;
        }
        av<T> avVar = this;
        hNz.EX(true);
        try {
            f context2 = getContext();
            Object a2 = y.a(context2, this.TUk);
            try {
                this.TUn.resumeWith(obj);
                x xVar = x.SXb;
                y.b(context2, a2);
                do {
                } while (hNz.hNa());
            } catch (Throwable th) {
                y.b(context2, a2);
                AppMethodBeat.o(118198);
                throw th;
            }
        } catch (Throwable th2) {
            avVar.c(th2, null);
        } finally {
            hNz.hNd();
            AppMethodBeat.o(118198);
        }
    }

    public final String toString() {
        AppMethodBeat.i(118199);
        String str = "DispatchedContinuation[" + this.TUm + ", " + ao.f(this.TUn) + ']';
        AppMethodBeat.o(118199);
        return str;
    }
}
