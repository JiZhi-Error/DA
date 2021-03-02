package kotlin.d.b.a;

import java.io.Serializable;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.h;
import kotlin.d.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, hxF = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"})
public abstract class a implements Serializable, e, d<Object> {
    private final d<Object> completion;

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    public a(d<Object> dVar) {
        this.completion = dVar;
    }

    public final d<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.d.d
    public final void resumeWith(Object obj) {
        a aVar = this;
        while (true) {
            p.h(aVar, "frame");
            d<Object> dVar = aVar.completion;
            if (dVar == null) {
                p.hyc();
            }
            try {
                Object invokeSuspend = aVar.invokeSuspend(obj);
                if (invokeSuspend != kotlin.d.a.a.COROUTINE_SUSPENDED) {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m46constructorimpl(invokeSuspend);
                    aVar.releaseIntercepted();
                    if (dVar instanceof a) {
                        aVar = (a) dVar;
                    } else {
                        dVar.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m46constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public d<x> create(d<?> dVar) {
        p.h(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d<x> create(Object obj, d<?> dVar) {
        p.h(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        StackTraceElement stackTraceElement = getStackTraceElement();
        return sb.append(stackTraceElement != null ? stackTraceElement : getClass().getName()).toString();
    }

    @Override // kotlin.d.b.a.e
    public e getCallerFrame() {
        d<Object> dVar = this.completion;
        if (!(dVar instanceof e)) {
            dVar = null;
        }
        return (e) dVar;
    }

    @Override // kotlin.d.b.a.e
    public StackTraceElement getStackTraceElement() {
        int i2;
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        String str = null;
        p.h(this, "$this$getStackTraceElementImpl");
        f fVar = (f) getClass().getAnnotation(f.class);
        if (fVar == null) {
            return null;
        }
        int hxL = fVar.hxL();
        if (hxL > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + hxL + ". Please update the Kotlin standard library.").toString());
        }
        int a2 = g.a(this);
        if (a2 < 0) {
            i2 = -1;
        } else {
            i2 = fVar.hxM()[a2];
        }
        h hVar = h.SXZ;
        p.h(this, "continuation");
        h.a aVar = h.SXY;
        if (aVar == null) {
            aVar = h.b(this);
        }
        if (!(aVar == h.SXX || (method = aVar.SYa) == null || (invoke = method.invoke(getClass(), new Object[0])) == null || (method2 = aVar.SYb) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null)) {
            Method method3 = aVar.SYc;
            Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
            if (!(invoke3 instanceof String)) {
                invoke3 = null;
            }
            str = (String) invoke3;
        }
        return new StackTraceElement(str == null ? fVar.c() : str + '/' + fVar.c(), fVar.m(), fVar.f(), i2);
    }
}
