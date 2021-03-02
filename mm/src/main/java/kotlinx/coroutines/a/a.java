package kotlinx.coroutines.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.aw;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\b\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0000\u001a>\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\b*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aR\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\b*\u001e\b\u0001\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u000e\u001a\u0002H\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, hxF = {"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", "fatalCompletion", "T", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"})
public final class a {
    public static final <R, T> void b(m<? super R, ? super d<? super T>, ? extends Object> mVar, R r, d<? super T> dVar) {
        AppMethodBeat.i(118134);
        try {
            d e2 = b.e(b.a(mVar, r, dVar));
            Result.Companion companion = Result.Companion;
            aw.a(e2, Result.m46constructorimpl(x.SXb));
            AppMethodBeat.o(118134);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            dVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(th)));
            AppMethodBeat.o(118134);
        }
    }

    public static final void a(d<? super x> dVar, d<?> dVar2) {
        AppMethodBeat.i(192392);
        try {
            d e2 = b.e(dVar);
            Result.Companion companion = Result.Companion;
            aw.a(e2, Result.m46constructorimpl(x.SXb));
            AppMethodBeat.o(192392);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            dVar2.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(th)));
            AppMethodBeat.o(192392);
        }
    }
}
