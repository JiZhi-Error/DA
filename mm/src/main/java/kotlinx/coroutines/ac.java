package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.e;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.b.c;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u000b\u001a\u00020\fH\u0000\u001a4\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0013H\b¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\b*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\b8@X\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"})
public final class ac {
    private static final boolean TTP;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if (r0.equals("") != false) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        if (r0.equals("on") != false) goto L_0x000f;
     */
    static {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ac.<clinit>():void");
    }

    public static final ad hMG() {
        return TTP ? c.TWS : t.TTK;
    }

    public static final f a(ai aiVar, f fVar) {
        f fVar2;
        AppMethodBeat.i(118185);
        f plus = aiVar.hMk().plus(fVar);
        if (an.getDEBUG()) {
            fVar2 = plus.plus(new ag(an.hMM().incrementAndGet()));
        } else {
            fVar2 = plus;
        }
        if (plus == ba.hMU() || plus.get(e.SXH) != null) {
            AppMethodBeat.o(118185);
            return fVar2;
        }
        f plus2 = fVar2.plus(ba.hMU());
        AppMethodBeat.o(118185);
        return plus2;
    }

    public static final String a(f fVar) {
        String str;
        AppMethodBeat.i(118186);
        if (!an.getDEBUG()) {
            AppMethodBeat.o(118186);
            return null;
        }
        ag agVar = (ag) fVar.get(ag.TTV);
        if (agVar == null) {
            AppMethodBeat.o(118186);
            return null;
        }
        ah ahVar = (ah) fVar.get(ah.TTW);
        if (ahVar == null || (str = ahVar.name) == null) {
            str = "coroutine";
        }
        String str2 = str + '#' + agVar.id;
        AppMethodBeat.o(118186);
        return str2;
    }
}
