package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.internal.y;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b\u0013J\u001f\u0010\u0014\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001aJ\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelResult", "", "state", "", "cause", "", "cancelResult$kotlinx_coroutines_core", "getExceptionalResult", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"})
public abstract class ay<T> extends i {
    public int TUq;

    public abstract Object hMt();

    public abstract d<T> hMz();

    public ay(int i2) {
        this.TUq = i2;
    }

    public void a(Object obj, Throwable th) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T fP(Object obj) {
        return obj;
    }

    public static Throwable fT(Object obj) {
        v vVar = (v) (!(obj instanceof v) ? null : obj);
        if (vVar != null) {
            return vVar.cause;
        }
        return null;
    }

    public final void run() {
        Object r1;
        Object r12;
        Object r13;
        CancellationException cancellationException;
        j jVar = this.TXa;
        try {
            d<T> hMz = hMz();
            if (hMz == null) {
                throw new t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
            }
            av avVar = (av) hMz;
            d<T> dVar = avVar.TUn;
            f context = dVar.getContext();
            Object hMt = hMt();
            Object a2 = y.a(context, avVar.TUk);
            try {
                Throwable fT = fT(hMt);
                bu buVar = az.avU(this.TUq) ? (bu) context.get(bu.TUO) : null;
                if (fT == null && buVar != null && !buVar.isActive()) {
                    CancellationException hNj = buVar.hNj();
                    a(hMt, hNj);
                    Result.Companion companion = Result.Companion;
                    if (!an.hML() || !(dVar instanceof e)) {
                        cancellationException = hNj;
                    } else {
                        cancellationException = kotlinx.coroutines.internal.t.a(hNj, (e) dVar);
                    }
                    dVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(cancellationException)));
                } else if (fT != null) {
                    Result.Companion companion2 = Result.Companion;
                    dVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(fT)));
                } else {
                    T fP = fP(hMt);
                    Result.Companion companion3 = Result.Companion;
                    dVar.resumeWith(Result.m46constructorimpl(fP));
                }
                x xVar = x.SXb;
                try {
                    Result.Companion companion4 = Result.Companion;
                    jVar.hOe();
                    r13 = Result.m46constructorimpl(x.SXb);
                } catch (Throwable th) {
                    Result.Companion companion5 = Result.Companion;
                    r13 = Result.m46constructorimpl(ResultKt.createFailure(th));
                }
                c(null, Result.m49exceptionOrNullimpl(r13));
                return;
            } finally {
                y.b(context, a2);
            }
            c(null, Result.m49exceptionOrNullimpl(r1));
            throw th;
            c(th, Result.m49exceptionOrNullimpl(r12));
        } catch (Throwable th2) {
            Result.Companion companion6 = Result.Companion;
            r1 = Result.m46constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final void c(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                a.a(th, th2);
            }
            if (th != null) {
                th2 = th;
            }
            String str = "Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers";
            if (th2 == null) {
                p.hyc();
            }
            af.b(hMz().getContext(), new am(str, th2));
        }
    }
}
