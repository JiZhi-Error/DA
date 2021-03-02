package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.y;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\b\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, hxF = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "dispatch", "", "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "useMode", "resumeUnconfined", "resumeWithStackTrace", "exception", "", "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"})
public final class az {
    public static final boolean avU(int i2) {
        return i2 == 1;
    }

    private static boolean avV(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static final <T> void a(ay<? super T> ayVar, int i2) {
        AppMethodBeat.i(192330);
        d<? super T> hMz = ayVar.hMz();
        if (!avV(i2) || !(hMz instanceof av) || avU(i2) != avU(ayVar.TUq)) {
            a(ayVar, hMz, i2);
            AppMethodBeat.o(192330);
            return;
        }
        ad adVar = ((av) hMz).TUm;
        f context = hMz.getContext();
        if (adVar.hMH()) {
            adVar.a(context, ayVar);
            AppMethodBeat.o(192330);
            return;
        }
        a(ayVar);
        AppMethodBeat.o(192330);
    }

    private static <T> void a(ay<? super T> ayVar, d<? super T> dVar, int i2) {
        Object r0;
        AppMethodBeat.i(192331);
        Object hMt = ayVar.hMt();
        Throwable fT = ay.fT(hMt);
        Throwable a2 = fT != null ? (!an.hML() || !(dVar instanceof e)) ? fT : t.a(fT, (e) dVar) : null;
        if (a2 != null) {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(a2));
        } else {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(hMt);
        }
        switch (i2) {
            case 0:
                dVar.resumeWith(r0);
                AppMethodBeat.o(192331);
                return;
            case 1:
                aw.a(dVar, r0);
                AppMethodBeat.o(192331);
                return;
            case 2:
                if (dVar == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlinx.coroutines.DispatchedContinuation<T>");
                    AppMethodBeat.o(192331);
                    throw tVar;
                }
                av avVar = (av) dVar;
                f context = avVar.getContext();
                Object a3 = y.a(context, avVar.TUk);
                try {
                    avVar.TUn.resumeWith(r0);
                    x xVar = x.SXb;
                    return;
                } finally {
                    y.b(context, a3);
                    AppMethodBeat.o(192331);
                }
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid mode ".concat(String.valueOf(i2)).toString());
                AppMethodBeat.o(192331);
                throw illegalStateException;
        }
    }

    private static final void a(ay<?> ayVar) {
        AppMethodBeat.i(192332);
        cp cpVar = cp.TVk;
        bg hNz = cp.hNz();
        if (hNz.hNb()) {
            hNz.b(ayVar);
            AppMethodBeat.o(192332);
            return;
        }
        hNz.EX(true);
        try {
            a(ayVar, ayVar.hMz(), 2);
            do {
            } while (hNz.hNa());
        } catch (Throwable th) {
            ayVar.c(th, null);
        } finally {
            hNz.hNd();
            AppMethodBeat.o(192332);
        }
    }
}
