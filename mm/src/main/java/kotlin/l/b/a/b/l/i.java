package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.k;

public final class i {
    public static final <T> T a(f<? extends T> fVar, k<?> kVar) {
        AppMethodBeat.i(60556);
        p.h(fVar, "$this$getValue");
        p.h(kVar, "p");
        T t = (T) fVar.invoke();
        AppMethodBeat.o(60556);
        return t;
    }
}
