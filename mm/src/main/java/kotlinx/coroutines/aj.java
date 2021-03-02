package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlin.l;
import kotlinx.coroutines.internal.e;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0006\u0010\t\u001a\u00020\u0002\u001a@\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u001c\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0010\b\u0002\u0010\u0016\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019\u001a\n\u0010\u001a\u001a\u00020\u0013*\u00020\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, hxF = {"isActive", "", "Lkotlinx/coroutines/CoroutineScope;", "isActive$annotations", "(Lkotlinx/coroutines/CoroutineScope;)V", "(Lkotlinx/coroutines/CoroutineScope;)Z", "CoroutineScope", "context", "Lkotlin/coroutines/CoroutineContext;", "MainScope", "coroutineScope", "R", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "", "message", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "ensureActive", "plus", "kotlinx-coroutines-core"})
public final class aj {
    public static final ai hMI() {
        AppMethodBeat.i(192511);
        e eVar = new e(cn.hNy().plus(ba.hMV()));
        AppMethodBeat.o(192511);
        return eVar;
    }

    public static final boolean a(ai aiVar) {
        AppMethodBeat.i(192512);
        bu buVar = (bu) aiVar.hMk().get(bu.TUO);
        if (buVar != null) {
            boolean isActive = buVar.isActive();
            AppMethodBeat.o(192512);
            return isActive;
        }
        AppMethodBeat.o(192512);
        return true;
    }

    public static final void b(ai aiVar) {
        AppMethodBeat.i(192513);
        bu buVar = (bu) aiVar.hMk().get(bu.TUO);
        if (buVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Scope cannot be cancelled because it does not have a job: ".concat(String.valueOf(aiVar)).toString());
            AppMethodBeat.o(192513);
            throw illegalStateException;
        }
        buVar.a((CancellationException) null);
        AppMethodBeat.o(192513);
    }
}
