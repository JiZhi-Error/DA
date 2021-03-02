package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.d.a.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.x;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.u;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000{2\b\u0012\u0004\u0012\u00028\u00000|2\u00060cj\u0002`dB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\fJ\u000f\u0010\u001d\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\n\u0018\u00010(j\u0004\u0018\u0001`)H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020\nH\u0016¢\u0006\u0004\b/\u0010\u001cJ\u001e\u00102\u001a\u00020\n2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\n00H\b¢\u0006\u0004\b2\u00103J8\u00109\u001a\u00020\n2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`7H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u000fH\u0002¢\u0006\u0004\b;\u0010\u0018J8\u0010=\u001a\u00020<2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`7H\u0002¢\u0006\u0004\b=\u0010>JB\u0010?\u001a\u00020\n2'\u00108\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04j\u0002`72\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0014¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020\u000fH\u0000¢\u0006\u0004\bG\u0010\u0018J:\u0010K\u001a\u00020\n2\u0006\u0010I\u001a\u00028\u00002!\u0010J\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n04H\u0016¢\u0006\u0004\bK\u0010LJ#\u0010N\u001a\u0004\u0018\u00010M2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010OJ \u0010R\u001a\u00020\n2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000PH\u0016ø\u0001\u0000¢\u0006\u0004\bR\u0010\fJ\u000f\u0010S\u001a\u00020\nH\u0002¢\u0006\u0004\bS\u0010\u001cJ\u0011\u0010U\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bT\u0010'J\u000f\u0010V\u001a\u00020AH\u0016¢\u0006\u0004\bV\u0010CJ\u000f\u0010W\u001a\u00020\u000fH\u0002¢\u0006\u0004\bW\u0010\u0018J#\u0010W\u001a\u0004\u0018\u00010\b2\u0006\u0010I\u001a\u00028\u00002\b\u0010X\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\bW\u0010YJ\u0019\u0010[\u001a\u0004\u0018\u00010\b2\u0006\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u000fH\u0002¢\u0006\u0004\b]\u0010\u0018J\u001b\u0010_\u001a\u00020\n*\u00020^2\u0006\u0010I\u001a\u00028\u0000H\u0016¢\u0006\u0004\b_\u0010`J\u001b\u0010a\u001a\u00020\n*\u00020^2\u0006\u0010Z\u001a\u00020\rH\u0016¢\u0006\u0004\ba\u0010bR\u001e\u0010g\u001a\n\u0018\u00010cj\u0004\u0018\u0001`d8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u001c\u0010i\u001a\u00020h8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0003\u0010m\u001a\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0018R\u0016\u0010q\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bq\u0010\u0018R\u0016\u0010r\u001a\u00020\u000f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u0018R(\u0010x\u001a\u0004\u0018\u00010s2\b\u0010I\u001a\u0004\u0018\u00010s8B@BX\u000e¢\u0006\f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\by\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006z"}, hxF = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "proposedUpdate", "", "alreadyResumedError", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "cancelLater", "state", "cancelResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelResult", "checkCompleted", "()Z", "token", "completeResume", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlin/Function0;", "block", "invokeHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "Lkotlinx/coroutines/CancelHandler;", "makeHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "", "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "resetState$kotlinx_coroutines_core", "resetState", "value", "onCancellation", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/CancelledContinuation;", "resumeImpl", "(Ljava/lang/Object;I)Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/Result;", "result", "resumeWith", "setupCancellation", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"})
public class l<T> extends ay<T> implements e, k<T> {
    private static final AtomicIntegerFieldUpdater TTC = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");
    private static final AtomicReferenceFieldUpdater TTD = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    final d<T> SXL;
    private final f TTt = this.SXL.getContext();
    private volatile int _decision = 0;
    private volatile Object _parentHandle = null;
    private volatile Object _state = b.TTv;

    static {
        AppMethodBeat.i(192427);
        AppMethodBeat.o(192427);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.d.d<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public l(d<? super T> dVar) {
        super(1);
        AppMethodBeat.i(118213);
        this.SXL = dVar;
        AppMethodBeat.o(118213);
    }

    @Override // kotlinx.coroutines.ay
    public final d<T> hMz() {
        return this.SXL;
    }

    @Override // kotlin.d.d
    public f getContext() {
        return this.TTt;
    }

    private final boolean hMr() {
        boolean z;
        if (this.SXL instanceof av) {
            if (((av) this.SXL)._reusableCancellableContinuation != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.d.b.a.e
    public e getCallerFrame() {
        d<T> dVar = this.SXL;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    @Override // kotlin.d.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.ay
    public final void a(Object obj, Throwable th) {
        AppMethodBeat.i(192410);
        if (obj instanceof y) {
            try {
                ((y) obj).TTO.invoke(th);
                AppMethodBeat.o(192410);
                return;
            } catch (Throwable th2) {
                af.b(getContext(), new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
            }
        }
        AppMethodBeat.o(192410);
    }

    public Throwable a(bu buVar) {
        AppMethodBeat.i(192412);
        CancellationException hNj = buVar.hNj();
        AppMethodBeat.o(192412);
        return hNj;
    }

    public final Object getResult() {
        bu buVar;
        CancellationException a2;
        AppMethodBeat.i(192415);
        hMs();
        if (hMu()) {
            a aVar = a.COROUTINE_SUSPENDED;
            AppMethodBeat.o(192415);
            return aVar;
        }
        Object obj = this._state;
        if (obj instanceof v) {
            Throwable th = ((v) obj).cause;
            l<T> lVar = this;
            if (an.hML()) {
                th = t.a(th, lVar);
            }
            AppMethodBeat.o(192415);
            throw th;
        } else if (this.TUq != 1 || (buVar = (bu) getContext().get(bu.TUO)) == null || buVar.isActive()) {
            T fP = fP(obj);
            AppMethodBeat.o(192415);
            return fP;
        } else {
            CancellationException hNj = buVar.hNj();
            a(obj, hNj);
            l<T> lVar2 = this;
            if (!an.hML()) {
                a2 = hNj;
            } else {
                a2 = t.a(hNj, lVar2);
            }
            AppMethodBeat.o(192415);
            throw a2;
        }
    }

    @Override // kotlin.d.d
    public void resumeWith(Object obj) {
        Throwable a2;
        AppMethodBeat.i(192416);
        l<T> lVar = this;
        Throwable r1 = Result.m49exceptionOrNullimpl(obj);
        if (r1 != null) {
            l<T> lVar2 = lVar;
            if (!an.hML()) {
                a2 = r1;
            } else {
                a2 = t.a(r1, lVar2);
            }
            obj = new v(a2);
        }
        s(obj, this.TUq);
        AppMethodBeat.o(192416);
    }

    private static void a(b<? super Throwable, x> bVar, Object obj) {
        AppMethodBeat.i(192418);
        IllegalStateException illegalStateException = new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + bVar + ", already has " + obj).toString());
        AppMethodBeat.o(192418);
        throw illegalStateException;
    }

    private final void avT(int i2) {
        AppMethodBeat.i(192419);
        if (hMv()) {
            AppMethodBeat.o(192419);
            return;
        }
        az.a(this, i2);
        AppMethodBeat.o(192419);
    }

    private static void fO(Object obj) {
        AppMethodBeat.i(192421);
        IllegalStateException illegalStateException = new IllegalStateException("Already resumed, but proposed with update ".concat(String.valueOf(obj)).toString());
        AppMethodBeat.o(192421);
        throw illegalStateException;
    }

    /* access modifiers changed from: package-private */
    public final void hMw() {
        AppMethodBeat.i(192422);
        if (!hMr()) {
            hMx();
        }
        AppMethodBeat.o(192422);
    }

    @Override // kotlinx.coroutines.k
    public final void fN(Object obj) {
        AppMethodBeat.i(192425);
        if (an.hMK()) {
            if (!(obj == m.TTE)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192425);
                throw assertionError;
            }
        }
        avT(this.TUq);
        AppMethodBeat.o(192425);
    }

    @Override // kotlinx.coroutines.k
    public final void a(ad adVar, T t) {
        ad adVar2 = null;
        AppMethodBeat.i(118211);
        d<T> dVar = this.SXL;
        if (!(dVar instanceof av)) {
            dVar = null;
        }
        av avVar = (av) dVar;
        if (avVar != null) {
            adVar2 = avVar.TUm;
        }
        s(t, adVar2 == adVar ? 2 : this.TUq);
        AppMethodBeat.o(118211);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ay
    public final <T> T fP(Object obj) {
        return obj instanceof x ? (T) ((x) obj).result : obj instanceof y ? (T) ((y) obj).result : obj;
    }

    public String toString() {
        AppMethodBeat.i(192426);
        String str = hMy() + '(' + ao.f(this.SXL) + "){" + this._state + "}@" + Integer.toHexString(System.identityHashCode(this));
        AppMethodBeat.o(192426);
        return str;
    }

    /* access modifiers changed from: protected */
    public String hMy() {
        AppMethodBeat.i(118212);
        AppMethodBeat.o(118212);
        return "CancellableContinuation";
    }

    public final boolean A(Throwable th) {
        Object obj;
        AppMethodBeat.i(192411);
        do {
            obj = this._state;
            if (!(obj instanceof ch)) {
                AppMethodBeat.o(192411);
                return false;
            }
        } while (!TTD.compareAndSet(this, obj, new o(this, th, obj instanceof i)));
        if (obj instanceof i) {
            try {
                ((i) obj).y(th);
            } catch (Throwable th2) {
                af.b(getContext(), new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
            }
        }
        hMw();
        avT(0);
        AppMethodBeat.o(192411);
        return true;
    }

    private final boolean hMu() {
        AppMethodBeat.i(192413);
        do {
            switch (this._decision) {
                case 0:
                    break;
                case 1:
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
                    AppMethodBeat.o(192413);
                    throw illegalStateException;
                case 2:
                    AppMethodBeat.o(192413);
                    return false;
            }
        } while (!TTC.compareAndSet(this, 0, 1));
        AppMethodBeat.o(192413);
        return true;
    }

    private final boolean hMv() {
        AppMethodBeat.i(192414);
        do {
            switch (this._decision) {
                case 0:
                    break;
                case 1:
                    AppMethodBeat.o(192414);
                    return false;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Already resumed".toString());
                    AppMethodBeat.o(192414);
                    throw illegalStateException;
            }
        } while (!TTC.compareAndSet(this, 0, 2));
        AppMethodBeat.o(192414);
        return true;
    }

    @Override // kotlinx.coroutines.k
    public final void W(b<? super Throwable, x> bVar) {
        Object obj;
        Object obj2;
        Object obj3;
        br brVar;
        Throwable th = null;
        AppMethodBeat.i(192417);
        Object obj4 = null;
        while (true) {
            Object obj5 = this._state;
            if (obj5 instanceof b) {
                if (obj4 == null) {
                    if (bVar instanceof i) {
                        brVar = (i) bVar;
                    } else {
                        brVar = new br(bVar);
                    }
                    obj2 = brVar;
                    obj3 = brVar;
                } else {
                    obj2 = obj4;
                    obj3 = obj4;
                }
                if (TTD.compareAndSet(this, obj5, obj2)) {
                    AppMethodBeat.o(192417);
                    return;
                }
                obj4 = obj3;
            } else if (obj5 instanceof i) {
                a(bVar, obj5);
            } else if (obj5 instanceof o) {
                if (!((o) obj5).hME()) {
                    a(bVar, obj5);
                }
                try {
                    if (!(obj5 instanceof v)) {
                        obj = null;
                    } else {
                        obj = obj5;
                    }
                    v vVar = (v) obj;
                    if (vVar != null) {
                        th = vVar.cause;
                    }
                    bVar.invoke(th);
                    AppMethodBeat.o(192417);
                    return;
                } catch (Throwable th2) {
                    af.b(getContext(), new aa("Exception in cancellation handler for ".concat(String.valueOf(this)), th2));
                    AppMethodBeat.o(192417);
                    return;
                }
            } else {
                AppMethodBeat.o(192417);
                return;
            }
        }
    }

    private final o s(Object obj, int i2) {
        AppMethodBeat.i(192420);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof ch) {
                if (TTD.compareAndSet(this, obj2, obj)) {
                    hMw();
                    avT(i2);
                    AppMethodBeat.o(192420);
                    return null;
                }
            } else if (!(obj2 instanceof o) || !((o) obj2).hMA()) {
                fO(obj);
            } else {
                o oVar = (o) obj2;
                AppMethodBeat.o(192420);
                return oVar;
            }
        }
    }

    @Override // kotlinx.coroutines.k
    public final Object z(Throwable th) {
        Object obj;
        AppMethodBeat.i(192424);
        do {
            obj = this._state;
            if (obj instanceof ch) {
            } else {
                AppMethodBeat.o(192424);
                return null;
            }
        } while (!TTD.compareAndSet(this, obj, new v(th)));
        hMw();
        u uVar = m.TTE;
        AppMethodBeat.o(192424);
        return uVar;
    }

    @Override // kotlinx.coroutines.k
    public final boolean isCompleted() {
        return !(this._state instanceof ch);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    private final void hMs() {
        boolean z;
        Throwable th = null;
        AppMethodBeat.i(192409);
        boolean isCompleted = isCompleted();
        if (this.TUq != 0) {
            z = isCompleted;
        } else {
            d<T> dVar = this.SXL;
            if (!(dVar instanceof av)) {
                dVar = null;
            }
            av avVar = (av) dVar;
            if (avVar == null) {
                z = isCompleted;
            } else {
                l<T> lVar = this;
                while (true) {
                    Object obj = avVar._reusableCancellableContinuation;
                    if (obj == aw.TUp) {
                        if (av.TUl.compareAndSet(avVar, aw.TUp, lVar)) {
                            break;
                        }
                    } else if (obj != null) {
                        if (!(obj instanceof Throwable)) {
                            IllegalStateException illegalStateException = new IllegalStateException("Inconsistent state ".concat(String.valueOf(obj)).toString());
                            AppMethodBeat.o(192409);
                            throw illegalStateException;
                        } else if (!av.TUl.compareAndSet(avVar, obj, null)) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
                            AppMethodBeat.o(192409);
                            throw illegalArgumentException;
                        } else {
                            th = (Throwable) obj;
                        }
                    }
                }
                if (th == null) {
                    z = isCompleted;
                } else {
                    if (!isCompleted) {
                        A(th);
                    }
                    z = true;
                }
            }
        }
        if (z) {
            AppMethodBeat.o(192409);
        } else if (((bc) this._parentHandle) != null) {
            AppMethodBeat.o(192409);
        } else {
            bu buVar = (bu) this.SXL.getContext().get(bu.TUO);
            if (buVar == null) {
                AppMethodBeat.o(192409);
                return;
            }
            buVar.start();
            bc a2 = bu.a.a(buVar, true, false, new p(buVar, this), 2);
            this._parentHandle = a2;
            if (isCompleted() && !hMr()) {
                a2.dispose();
                this._parentHandle = cg.TVh;
            }
            AppMethodBeat.o(192409);
        }
    }

    @Override // kotlinx.coroutines.ay
    public final Object hMt() {
        return this._state;
    }

    public final void hMx() {
        AppMethodBeat.i(192423);
        bc bcVar = (bc) this._parentHandle;
        if (bcVar != null) {
            bcVar.dispose();
        }
        this._parentHandle = cg.TVh;
        AppMethodBeat.o(192423);
    }
}
