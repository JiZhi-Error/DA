package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class c {
    public static final boolean u(Throwable th) {
        AppMethodBeat.i(61356);
        p.h(th, "$this$isProcessCanceledException");
        Class<?> cls = th.getClass();
        while (!p.j(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                AppMethodBeat.o(61356);
                return false;
            }
        }
        AppMethodBeat.o(61356);
        return true;
    }
}
