package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, hxF = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"})
public final class ao {
    public static final String f(d<?> dVar) {
        String r0;
        AppMethodBeat.i(192388);
        if (dVar instanceof av) {
            String obj = dVar.toString();
            AppMethodBeat.o(192388);
            return obj;
        }
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(dVar + '@' + Integer.toHexString(System.identityHashCode(dVar)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m49exceptionOrNullimpl(r0) != null) {
            r0 = dVar.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(dVar));
        }
        String str = (String) r0;
        AppMethodBeat.o(192388);
        return str;
    }
}
