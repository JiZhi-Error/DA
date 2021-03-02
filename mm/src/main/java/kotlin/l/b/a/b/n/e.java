package kotlin.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.i;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.j.d.a;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.n.b;

final class e implements b {
    public static final e TQo = new e();
    private static final String description = description;

    static {
        AppMethodBeat.i(61295);
        AppMethodBeat.o(61295);
    }

    private e() {
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String i(t tVar) {
        AppMethodBeat.i(61296);
        p.h(tVar, "functionDescriptor");
        String a2 = b.a.a(this, tVar);
        AppMethodBeat.o(61296);
        return a2;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final String getDescription() {
        return description;
    }

    @Override // kotlin.l.b.a.b.n.b
    public final boolean h(t tVar) {
        aj a2;
        AppMethodBeat.i(61294);
        p.h(tVar, "functionDescriptor");
        av avVar = tVar.hAw().get(1);
        i.b bVar = i.TeS;
        p.g(avVar, "secondParameter");
        y F = a.F(avVar);
        p.h(F, "module");
        kotlin.l.b.a.b.f.a aVar = g.TcO.Ted;
        p.g(aVar, "KotlinBuiltIns.FQ_NAMES.kProperty");
        kotlin.l.b.a.b.b.e b2 = s.b(F, aVar);
        if (b2 == null) {
            a2 = null;
        } else {
            g.a aVar2 = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
            at hzz = b2.hzz();
            p.g(hzz, "kPropertyClass.typeConstructor");
            List<as> parameters = hzz.getParameters();
            p.g(parameters, "kPropertyClass.typeConstructor.parameters");
            Object kw = j.kw(parameters);
            p.g(kw, "kPropertyClass.typeConstructor.parameters.single()");
            a2 = ac.a(hBP, b2, j.listOf(new ao((as) kw)));
        }
        if (a2 != null) {
            ab hBy = avVar.hBy();
            p.g(hBy, "secondParameter.type");
            boolean c2 = kotlin.l.b.a.b.m.d.a.c(a2, kotlin.l.b.a.b.m.d.a.aD(hBy));
            AppMethodBeat.o(61294);
            return c2;
        }
        AppMethodBeat.o(61294);
        return false;
    }
}
