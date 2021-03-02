package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.v;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.bh;
import kotlin.s;

public final class f {
    private static final kotlin.l.b.a.b.f.f TiA;
    private static final kotlin.l.b.a.b.f.f Tiw;
    private static final kotlin.l.b.a.b.f.f Tix;
    private static final kotlin.l.b.a.b.f.f Tiy;
    private static final kotlin.l.b.a.b.f.f Tiz;

    public static /* synthetic */ c b(g gVar, String str) {
        AppMethodBeat.i(56940);
        p.h(gVar, "$this$createDeprecatedAnnotation");
        p.h(str, "message");
        p.h("", "replaceWith");
        p.h("WARNING", "level");
        b bVar = g.TcO.Tdr;
        p.g(bVar, "KotlinBuiltIns.FQ_NAMES.replaceWith");
        j jVar = new j(gVar, bVar, ae.e(s.U(Tiz, new v("")), s.U(TiA, new kotlin.l.b.a.b.j.b.b(kotlin.a.v.SXr, new a(gVar)))));
        b bVar2 = g.TcO.Tdp;
        p.g(bVar2, "KotlinBuiltIns.FQ_NAMES.deprecated");
        kotlin.l.b.a.b.f.f fVar = Tiy;
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(g.TcO.Tdq);
        p.g(p, "ClassId.topLevel(KotlinB…Q_NAMES.deprecationLevel)");
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY("WARNING");
        p.g(btY, "Name.identifier(level)");
        j jVar2 = new j(gVar, bVar2, ae.e(s.U(Tiw, new v(str)), s.U(Tix, new kotlin.l.b.a.b.j.b.a(jVar)), s.U(fVar, new j(p, btY))));
        AppMethodBeat.o(56940);
        return jVar2;
    }

    static {
        AppMethodBeat.i(56941);
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY("message");
        p.g(btY, "Name.identifier(\"message\")");
        Tiw = btY;
        kotlin.l.b.a.b.f.f btY2 = kotlin.l.b.a.b.f.f.btY("replaceWith");
        p.g(btY2, "Name.identifier(\"replaceWith\")");
        Tix = btY2;
        kotlin.l.b.a.b.f.f btY3 = kotlin.l.b.a.b.f.f.btY("level");
        p.g(btY3, "Name.identifier(\"level\")");
        Tiy = btY3;
        kotlin.l.b.a.b.f.f btY4 = kotlin.l.b.a.b.f.f.btY("expression");
        p.g(btY4, "Name.identifier(\"expression\")");
        Tiz = btY4;
        kotlin.l.b.a.b.f.f btY5 = kotlin.l.b.a.b.f.f.btY("imports");
        p.g(btY5, "Name.identifier(\"imports\")");
        TiA = btY5;
        AppMethodBeat.o(56941);
    }

    public static final class a extends q implements kotlin.g.a.b<y, aj> {
        final /* synthetic */ g TiB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(1);
            this.TiB = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(y yVar) {
            AppMethodBeat.i(56939);
            y yVar2 = yVar;
            p.h(yVar2, "module");
            aj a2 = yVar2.hBh().a(bh.INVARIANT, this.TiB.hzr());
            p.g(a2, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            AppMethodBeat.o(56939);
            return a2;
        }
    }
}
