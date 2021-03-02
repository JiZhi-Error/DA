package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.n.b;

final class h implements b {
    public static final h TQs = new h();
    private static final String description = description;

    static {
        AppMethodBeat.i(61304);
        AppMethodBeat.o(61304);
    }

    private h() {
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String i(t tVar) {
        AppMethodBeat.i(61305);
        p.h(tVar, "functionDescriptor");
        String a2 = b.a.a(this, tVar);
        AppMethodBeat.o(61305);
        return a2;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String getDescription() {
        return description;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final boolean h(t tVar) {
        boolean z;
        AppMethodBeat.i(61303);
        p.h(tVar, "functionDescriptor");
        List<av> hAw = tVar.hAw();
        p.g(hAw, "functionDescriptor.valueParameters");
        List<av> list = hAw;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (T t : list) {
                p.g(t, LocaleUtil.ITALIAN);
                if (a.b(t) || t.hBB() != null) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    AppMethodBeat.o(61303);
                    return false;
                }
            }
        }
        AppMethodBeat.o(61303);
        return true;
    }
}
