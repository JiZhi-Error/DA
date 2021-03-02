package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.d.a.c.a.e;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.d;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.s;

public final class c {
    private static final b TpU = new b(Target.class.getCanonicalName());
    private static final b TpV = new b(Retention.class.getCanonicalName());
    private static final b TpW = new b(Deprecated.class.getCanonicalName());
    private static final b TpX = new b(Documented.class.getCanonicalName());
    private static final b TpY = new b("java.lang.annotation.Repeatable");
    private static final f TpZ;
    private static final f Tqa;
    private static final f Tqb;
    private static final Map<b, b> Tqc = ae.e(s.U(g.TcO.Tdv, TpU), s.U(g.TcO.Tdy, TpV), s.U(g.TcO.Tdz, TpY), s.U(g.TcO.TdA, TpX));
    private static final Map<b, b> Tqd = ae.e(s.U(TpU, g.TcO.Tdv), s.U(TpV, g.TcO.Tdy), s.U(TpW, g.TcO.Tdp), s.U(TpY, g.TcO.Tdz), s.U(TpX, g.TcO.TdA));
    public static final c Tqe = new c();

    static {
        AppMethodBeat.i(57660);
        f btY = f.btY("message");
        p.g(btY, "Name.identifier(\"message\")");
        TpZ = btY;
        f btY2 = f.btY("allowedTargets");
        p.g(btY2, "Name.identifier(\"allowedTargets\")");
        Tqa = btY2;
        f btY3 = f.btY("value");
        p.g(btY3, "Name.identifier(\"value\")");
        Tqb = btY3;
        AppMethodBeat.o(57660);
    }

    private c() {
    }

    public static f hDG() {
        return TpZ;
    }

    public static f hDH() {
        return Tqa;
    }

    public static f hDI() {
        return Tqb;
    }

    public static kotlin.l.b.a.b.b.a.c a(a aVar, h hVar) {
        AppMethodBeat.i(57658);
        p.h(aVar, "annotation");
        p.h(hVar, "c");
        kotlin.l.b.a.b.f.a hyy = aVar.hyy();
        if (p.j(hyy, kotlin.l.b.a.b.f.a.p(TpU))) {
            i iVar = new i(aVar, hVar);
            AppMethodBeat.o(57658);
            return iVar;
        } else if (p.j(hyy, kotlin.l.b.a.b.f.a.p(TpV))) {
            h hVar2 = new h(aVar, hVar);
            AppMethodBeat.o(57658);
            return hVar2;
        } else if (p.j(hyy, kotlin.l.b.a.b.f.a.p(TpY))) {
            b bVar = g.TcO.Tdz;
            p.g(bVar, "KotlinBuiltIns.FQ_NAMES.repeatable");
            b bVar2 = new b(hVar, aVar, bVar);
            AppMethodBeat.o(57658);
            return bVar2;
        } else if (p.j(hyy, kotlin.l.b.a.b.f.a.p(TpX))) {
            b bVar3 = g.TcO.TdA;
            p.g(bVar3, "KotlinBuiltIns.FQ_NAMES.mustBeDocumented");
            b bVar4 = new b(hVar, aVar, bVar3);
            AppMethodBeat.o(57658);
            return bVar4;
        } else if (p.j(hyy, kotlin.l.b.a.b.f.a.p(TpW))) {
            AppMethodBeat.o(57658);
            return null;
        } else {
            e eVar = new e(hVar, aVar);
            AppMethodBeat.o(57658);
            return eVar;
        }
    }

    public static kotlin.l.b.a.b.b.a.c a(b bVar, d dVar, h hVar) {
        a l;
        AppMethodBeat.i(57659);
        p.h(bVar, "kotlinName");
        p.h(dVar, "annotationOwner");
        p.h(hVar, "c");
        if (!p.j(bVar, g.TcO.Tdp) || (l = dVar.l(TpW)) == null) {
            b bVar2 = Tqc.get(bVar);
            if (bVar2 != null) {
                a l2 = dVar.l(bVar2);
                if (l2 != null) {
                    kotlin.l.b.a.b.b.a.c a2 = a(l2, hVar);
                    AppMethodBeat.o(57659);
                    return a2;
                }
                AppMethodBeat.o(57659);
                return null;
            }
            AppMethodBeat.o(57659);
            return null;
        }
        e eVar = new e(l, hVar);
        AppMethodBeat.o(57659);
        return eVar;
    }
}
