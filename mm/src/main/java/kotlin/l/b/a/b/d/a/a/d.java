package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a.m;
import kotlin.l.b.a.b.b.a.n;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.u;
import kotlin.s;

public final class d {
    private static final Map<String, EnumSet<n>> Tqf = ae.e(s.U("PACKAGE", EnumSet.noneOf(n.class)), s.U("TYPE", EnumSet.of(n.CLASS, n.FILE)), s.U("ANNOTATION_TYPE", EnumSet.of(n.ANNOTATION_CLASS)), s.U("TYPE_PARAMETER", EnumSet.of(n.TYPE_PARAMETER)), s.U("FIELD", EnumSet.of(n.FIELD)), s.U("LOCAL_VARIABLE", EnumSet.of(n.LOCAL_VARIABLE)), s.U("PARAMETER", EnumSet.of(n.VALUE_PARAMETER)), s.U("CONSTRUCTOR", EnumSet.of(n.CONSTRUCTOR)), s.U("METHOD", EnumSet.of(n.FUNCTION, n.PROPERTY_GETTER, n.PROPERTY_SETTER)), s.U("TYPE_USE", EnumSet.of(n.TYPE)));
    private static final Map<String, m> Tqg = ae.e(s.U("RUNTIME", m.RUNTIME), s.U("CLASS", m.BINARY), s.U("SOURCE", m.SOURCE));
    public static final d Tqh = new d();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements b<y, ab> {
        public static final a Tqi = new a();

        static {
            AppMethodBeat.i(57662);
            AppMethodBeat.o(57662);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ab invoke(y yVar) {
            aj ajVar;
            AppMethodBeat.i(57661);
            y yVar2 = yVar;
            p.h(yVar2, "module");
            c cVar = c.Tqe;
            av b2 = a.b(c.hDH(), yVar2.hBh().a(g.TcO.Tdv));
            if (b2 == null || (ajVar = b2.hBy()) == null) {
                aj bun = u.bun("Error: AnnotationTarget[]");
                p.g(bun, "ErrorUtils.createErrorTy…ror: AnnotationTarget[]\")");
                ajVar = bun;
            }
            AppMethodBeat.o(57661);
            return ajVar;
        }
    }

    static {
        AppMethodBeat.i(57665);
        AppMethodBeat.o(57665);
    }

    private d() {
    }

    public static kotlin.l.b.a.b.j.b.g<?> kE(List<? extends kotlin.l.b.a.b.d.a.e.b> list) {
        String str;
        AppMethodBeat.i(57663);
        p.h(list, "arguments");
        ArrayList<kotlin.l.b.a.b.d.a.e.m> arrayList = new ArrayList();
        for (T t : list) {
            if (t instanceof kotlin.l.b.a.b.d.a.e.m) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (kotlin.l.b.a.b.d.a.e.m mVar : arrayList) {
            f hCZ = mVar.hCZ();
            if (hCZ != null) {
                str = hCZ.sG();
            } else {
                str = null;
            }
            EnumSet<n> enumSet = Tqf.get(str);
            if (enumSet == null) {
                enumSet = x.SXt;
            }
            j.a((Collection) arrayList2, (Iterable) enumSet);
        }
        ArrayList<n> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (n nVar : arrayList3) {
            kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(g.TcO.Tdw);
            p.g(p, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
            f btY = f.btY(nVar.name());
            p.g(btY, "Name.identifier(kotlinTarget.name)");
            arrayList4.add(new kotlin.l.b.a.b.j.b.j(p, btY));
        }
        kotlin.l.b.a.b.j.b.b bVar = new kotlin.l.b.a.b.j.b.b(arrayList4, a.Tqi);
        AppMethodBeat.o(57663);
        return bVar;
    }

    public static kotlin.l.b.a.b.j.b.g<?> a(kotlin.l.b.a.b.d.a.e.b bVar) {
        kotlin.l.b.a.b.j.b.j jVar;
        String str;
        AppMethodBeat.i(57664);
        kotlin.l.b.a.b.d.a.e.m mVar = (kotlin.l.b.a.b.d.a.e.m) (!(bVar instanceof kotlin.l.b.a.b.d.a.e.m) ? null : bVar);
        if (mVar != null) {
            Map<String, m> map = Tqg;
            f hCZ = mVar.hCZ();
            if (hCZ != null) {
                str = hCZ.sG();
            } else {
                str = null;
            }
            m mVar2 = map.get(str);
            if (mVar2 != null) {
                kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(g.TcO.Tdx);
                p.g(p, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
                f btY = f.btY(mVar2.name());
                p.g(btY, "Name.identifier(retention.name)");
                jVar = new kotlin.l.b.a.b.j.b.j(p, btY);
            } else {
                jVar = null;
            }
        } else {
            jVar = null;
        }
        kotlin.l.b.a.b.j.b.j jVar2 = jVar;
        AppMethodBeat.o(57664);
        return jVar2;
    }
}
