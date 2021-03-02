package kotlin.l.b.a.b.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

public final class e {
    public static final Class<?> a(ClassLoader classLoader, String str) {
        Class<?> cls;
        AppMethodBeat.i(57363);
        p.h(classLoader, "$this$tryLoadClass");
        p.h(str, "fqName");
        try {
            cls = Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException e2) {
            cls = null;
        }
        AppMethodBeat.o(57363);
        return cls;
    }
}
