package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/JobSupport;", "job", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class cj<T> extends bz<ca> {
    private final l<T> TVi;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlinx.coroutines.l<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public cj(ca caVar, l<? super T> lVar) {
        super(caVar);
        AppMethodBeat.i(192403);
        this.TVi = lVar;
        AppMethodBeat.o(192403);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118267);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118267);
        return xVar;
    }

    @Override // kotlinx.coroutines.z
    public final void y(Throwable th) {
        AppMethodBeat.i(118266);
        Object hNm = ((ca) this.TUQ).hNm();
        if (an.hMK()) {
            if (!(!(hNm instanceof bp))) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(118266);
                throw assertionError;
            }
        }
        if (hNm instanceof v) {
            Throwable th2 = ((v) hNm).cause;
            Result.Companion companion = Result.Companion;
            this.TVi.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(th2)));
            AppMethodBeat.o(118266);
            return;
        }
        Object gd = cb.gd(hNm);
        Result.Companion companion2 = Result.Companion;
        this.TVi.resumeWith(Result.m46constructorimpl(gd));
        AppMethodBeat.o(118266);
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118268);
        String str = "ResumeAwaitOnCompletion[" + this.TVi + ']';
        AppMethodBeat.o(118268);
        return str;
    }
}
