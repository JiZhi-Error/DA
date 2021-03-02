package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.y;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u0015\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0019H\u0010¢\u0006\u0002\b!J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\tH\u0014J\u0015\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010'J\u0012\u0010(\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0004J\b\u0010)\u001a\u00020\u0015H\u0014J\r\u0010*\u001a\u00020\u0015H\u0000¢\u0006\u0002\b+J\u001c\u0010,\u001a\u00020\u00152\f\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000.ø\u0001\u0000¢\u0006\u0002\u0010'JM\u0010/\u001a\u00020\u0015\"\u0004\b\u0001\u001002\u0006\u0010/\u001a\u0002012\u0006\u00102\u001a\u0002H02'\u00103\u001a#\b\u0001\u0012\u0004\u0012\u0002H0\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001704¢\u0006\u0002\b5ø\u0001\u0000¢\u0006\u0002\u00106J4\u0010/\u001a\u00020\u00152\u0006\u0010/\u001a\u0002012\u001c\u00103\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001707ø\u0001\u0000¢\u0006\u0002\u00108R\u0017\u0010\u000b\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, hxF = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T> extends ca implements d<T>, ai, bu {
    private final f TTt = this.TTu.plus(this);
    protected final f TTu;

    public a(f fVar, boolean z) {
        super(z);
        this.TTu = fVar;
    }

    @Override // kotlin.d.d
    public final f getContext() {
        return this.TTt;
    }

    @Override // kotlinx.coroutines.ai
    public final f hMk() {
        return this.TTt;
    }

    @Override // kotlinx.coroutines.ca, kotlinx.coroutines.bu
    public final boolean isActive() {
        return super.isActive();
    }

    public final void hMl() {
        b((bu) this.TTu.get(bu.TUO));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
    }

    @Override // kotlinx.coroutines.ca
    public final void hMm() {
        onStart();
    }

    /* access modifiers changed from: protected */
    @Override // kotlinx.coroutines.ca
    public final String hMn() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // kotlin.d.d
    public final void resumeWith(Object obj) {
        Object fZ = fZ(w.fQ(obj));
        if (fZ != cb.TVb) {
            fM(fZ);
        }
    }

    /* access modifiers changed from: protected */
    public void fM(Object obj) {
        fS(obj);
    }

    @Override // kotlinx.coroutines.ca
    public final void x(Throwable th) {
        af.b(this.TTt, th);
    }

    @Override // kotlinx.coroutines.ca
    public String hMo() {
        String a2 = ac.a(this.TTt);
        if (a2 == null) {
            return super.hMo();
        }
        return "\"" + a2 + "\":" + super.hMo();
    }

    public final <R> void a(ak akVar, R r, m<? super R, ? super d<? super T>, ? extends Object> mVar) {
        hMl();
        a<T> aVar = this;
        switch (al.haE[akVar.ordinal()]) {
            case 1:
                kotlinx.coroutines.a.a.b(mVar, r, aVar);
                return;
            case 2:
                p.h(mVar, "$this$startCoroutine");
                p.h(aVar, "completion");
                d e2 = b.e(b.a(mVar, r, aVar));
                x xVar = x.SXb;
                Result.Companion companion = Result.Companion;
                e2.resumeWith(Result.m46constructorimpl(xVar));
                return;
            case 3:
                p.h(aVar, "completion");
                try {
                    f context = aVar.getContext();
                    Object a2 = y.a(context, null);
                    if (mVar == null) {
                        try {
                            throw new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        } catch (Throwable th) {
                            y.b(context, a2);
                            throw th;
                        }
                    } else {
                        Object invoke = ((m) af.r(mVar, 2)).invoke(r, aVar);
                        y.b(context, a2);
                        if (invoke != kotlin.d.a.a.COROUTINE_SUSPENDED) {
                            Result.Companion companion2 = Result.Companion;
                            aVar.resumeWith(Result.m46constructorimpl(invoke));
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.Companion;
                    aVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(th2)));
                    return;
                }
            case 4:
                return;
            default:
                throw new kotlin.m();
        }
    }
}
