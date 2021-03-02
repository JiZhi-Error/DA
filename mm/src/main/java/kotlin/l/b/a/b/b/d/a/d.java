package kotlin.l.b.a.b.b.d.a;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.d.b.u;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.d.a.j;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;
import kotlin.n.n;

public final class d implements j {
    private final ClassLoader TmI;

    public d(ClassLoader classLoader) {
        p.h(classLoader, "classLoader");
        AppMethodBeat.i(57362);
        this.TmI = classLoader;
        AppMethodBeat.o(57362);
    }

    @Override // kotlin.l.b.a.b.d.a.j
    public final t i(b bVar) {
        AppMethodBeat.i(57360);
        p.h(bVar, "fqName");
        u uVar = new u(bVar);
        AppMethodBeat.o(57360);
        return uVar;
    }

    @Override // kotlin.l.b.a.b.d.a.j
    public final Set<String> j(b bVar) {
        AppMethodBeat.i(57361);
        p.h(bVar, "packageFqName");
        AppMethodBeat.o(57361);
        return null;
    }

    @Override // kotlin.l.b.a.b.d.a.j
    public final g a(j.a aVar) {
        AppMethodBeat.i(57359);
        p.h(aVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        a aVar2 = aVar.Tfj;
        b hIY = aVar2.hIY();
        p.g(hIY, "classId.packageFqName");
        String sG = aVar2.hIZ().sG();
        p.g(sG, "classId.relativeClassName.asString()");
        String a2 = n.a(sG, '.', '$');
        if (!hIY.TCR.TCW.isEmpty()) {
            a2 = hIY.sG() + "." + a2;
        }
        Class<?> a3 = e.a(this.TmI, a2);
        if (a3 != null) {
            kotlin.l.b.a.b.b.d.b.j jVar = new kotlin.l.b.a.b.b.d.b.j(a3);
            AppMethodBeat.o(57359);
            return jVar;
        }
        AppMethodBeat.o(57359);
        return null;
    }
}
