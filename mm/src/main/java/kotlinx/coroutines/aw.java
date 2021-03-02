package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.internal.y;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\b\u001a.\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00100\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, hxF = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "REUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "UNDEFINED$annotations", "executeUnconfined", "", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "yieldUndispatched", "kotlinx-coroutines-core"})
public final class aw {
    private static final u TUo = new u("UNDEFINED");
    public static final u TUp = new u("REUSABLE_CLAIMED");

    static {
        AppMethodBeat.i(192384);
        AppMethodBeat.o(192384);
    }

    public static final <T> void a(d<? super T> dVar, Object obj) {
        boolean z;
        AppMethodBeat.i(192383);
        if (dVar instanceof av) {
            av avVar = (av) dVar;
            Object fQ = w.fQ(obj);
            ad adVar = avVar.TUm;
            avVar.getContext();
            if (adVar.hMH()) {
                avVar._state = fQ;
                avVar.TUq = 1;
                avVar.TUm.a(avVar.getContext(), avVar);
                AppMethodBeat.o(192383);
                return;
            }
            cp cpVar = cp.TVk;
            bg hNz = cp.hNz();
            if (hNz.hNb()) {
                avVar._state = fQ;
                avVar.TUq = 1;
                hNz.b(avVar);
                AppMethodBeat.o(192383);
                return;
            }
            av avVar2 = avVar;
            hNz.EX(true);
            try {
                bu buVar = (bu) avVar.getContext().get(bu.TUO);
                if (buVar == null || buVar.isActive()) {
                    z = false;
                } else {
                    Result.Companion companion = Result.Companion;
                    avVar.resumeWith(Result.m46constructorimpl(ResultKt.createFailure(buVar.hNj())));
                    z = true;
                }
                if (!z) {
                    f context = avVar.getContext();
                    Object a2 = y.a(context, avVar.TUk);
                    try {
                        avVar.TUn.resumeWith(obj);
                        x xVar = x.SXb;
                        y.b(context, a2);
                    } catch (Throwable th) {
                        y.b(context, a2);
                        AppMethodBeat.o(192383);
                        throw th;
                    }
                }
                do {
                } while (hNz.hNa());
            } catch (Throwable th2) {
                avVar2.c(th2, null);
            } finally {
                hNz.hNd();
                AppMethodBeat.o(192383);
            }
        } else {
            dVar.resumeWith(obj);
            AppMethodBeat.o(192383);
        }
    }
}
