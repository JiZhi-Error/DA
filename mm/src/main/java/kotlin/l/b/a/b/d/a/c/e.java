package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.l.d;
import kotlin.m.f;
import kotlin.m.h;
import kotlin.m.i;
import kotlin.m.l;

public final class e implements g {
    private final d<kotlin.l.b.a.b.d.a.e.a, c> Trm = this.Trn.Trv.TcN.V(new a(this));
    private final h Trn;
    private final kotlin.l.b.a.b.d.a.e.d Tro;

    static final class a extends q implements b<kotlin.l.b.a.b.d.a.e.a, c> {
        final /* synthetic */ e Trp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(1);
            this.Trp = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ c invoke(kotlin.l.b.a.b.d.a.e.a aVar) {
            AppMethodBeat.i(57747);
            kotlin.l.b.a.b.d.a.e.a aVar2 = aVar;
            p.h(aVar2, "annotation");
            kotlin.l.b.a.b.d.a.a.c cVar = kotlin.l.b.a.b.d.a.a.c.Tqe;
            c a2 = kotlin.l.b.a.b.d.a.a.c.a(aVar2, this.Trp.Trn);
            AppMethodBeat.o(57747);
            return a2;
        }
    }

    public e(h hVar, kotlin.l.b.a.b.d.a.e.d dVar) {
        p.h(hVar, "c");
        p.h(dVar, "annotationOwner");
        AppMethodBeat.i(57751);
        this.Trn = hVar;
        this.Tro = dVar;
        AppMethodBeat.o(57751);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(57752);
        p.h(bVar, "fqName");
        boolean b2 = g.b.b(this, bVar);
        AppMethodBeat.o(57752);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final c g(kotlin.l.b.a.b.f.b bVar) {
        c cVar;
        AppMethodBeat.i(57748);
        p.h(bVar, "fqName");
        kotlin.l.b.a.b.d.a.e.a l = this.Tro.l(bVar);
        if (l == null || (cVar = this.Trm.invoke(l)) == null) {
            kotlin.l.b.a.b.d.a.a.c cVar2 = kotlin.l.b.a.b.d.a.a.c.Tqe;
            cVar = kotlin.l.b.a.b.d.a.a.c.a(bVar, this.Tro, this.Trn);
        }
        AppMethodBeat.o(57748);
        return cVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<c> iterator() {
        f fVar;
        AppMethodBeat.i(57749);
        h d2 = i.d(j.z(this.Tro.hCP()), this.Trm);
        kotlin.l.b.a.b.d.a.a.c cVar = kotlin.l.b.a.b.d.a.a.c.Tqe;
        kotlin.l.b.a.b.f.b bVar = kotlin.l.b.a.b.a.g.TcO.Tdp;
        p.g(bVar, "KotlinBuiltIns.FQ_NAMES.deprecated");
        c a2 = kotlin.l.b.a.b.d.a.a.c.a(bVar, this.Tro, this.Trn);
        p.h(d2, "$this$plus");
        h aj = i.aj(d2, i.aj(a2));
        p.h(aj, "$this$flatten");
        l.b bVar2 = l.b.TSJ;
        if (aj instanceof kotlin.m.p) {
            kotlin.m.p pVar = (kotlin.m.p) aj;
            p.h(bVar2, "iterator");
            fVar = new f(pVar.TSt, pVar.TSB, bVar2);
        } else {
            fVar = new f(aj, l.c.TSK, bVar2);
        }
        Iterator<c> it = i.b(fVar).iterator();
        AppMethodBeat.o(57749);
        return it;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean isEmpty() {
        AppMethodBeat.i(57750);
        if (this.Tro.hCP().isEmpty()) {
            AppMethodBeat.o(57750);
            return true;
        }
        AppMethodBeat.o(57750);
        return false;
    }
}
