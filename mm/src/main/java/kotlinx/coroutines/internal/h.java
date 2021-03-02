package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"})
public final class h {
    private static final boolean TVL;

    static {
        Object r0;
        AppMethodBeat.i(192448);
        try {
            Result.Companion companion = Result.Companion;
            r0 = Result.m46constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            r0 = Result.m46constructorimpl(ResultKt.createFailure(th));
        }
        TVL = Result.m53isSuccessimpl(r0);
        AppMethodBeat.o(192448);
    }

    public static final boolean hNG() {
        return TVL;
    }
}
