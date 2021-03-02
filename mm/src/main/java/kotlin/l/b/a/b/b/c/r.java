package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public final class r extends j implements ad {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(r.class), "fragments", "getFragments()Ljava/util/List;"))};
    final kotlin.l.b.a.b.f.b TiI;
    private final f Tlx;
    private final h Tly;
    final w Tlz;

    static {
        AppMethodBeat.i(57124);
        AppMethodBeat.o(57124);
    }

    @Override // kotlin.l.b.a.b.b.ad
    public final List<ab> getFragments() {
        AppMethodBeat.i(57125);
        List<ab> list = (List) i.a(this.Tlx, cLI[0]);
        AppMethodBeat.o(57125);
        return list;
    }

    @Override // kotlin.l.b.a.b.b.ad
    public final kotlin.l.b.a.b.f.b hBk() {
        return this.TiI;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(w wVar, kotlin.l.b.a.b.f.b bVar, j jVar) {
        super(g.a.hBP(), bVar.hJh());
        p.h(wVar, "module");
        p.h(bVar, "fqName");
        p.h(jVar, "storageManager");
        g.a aVar = g.TiC;
        AppMethodBeat.i(57130);
        this.Tlz = wVar;
        this.TiI = bVar;
        this.Tlx = jVar.al(new a(this));
        this.Tly = new kotlin.l.b.a.b.j.f.g(jVar.al(new b(this)));
        AppMethodBeat.o(57130);
    }

    @Override // kotlin.l.b.a.b.b.ad
    public final h hAp() {
        return this.Tly;
    }

    public final boolean equals(Object obj) {
        Object obj2;
        AppMethodBeat.i(57127);
        if (!(obj instanceof ad)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        ad adVar = (ad) obj2;
        if (adVar == null) {
            AppMethodBeat.o(57127);
            return false;
        } else if (!p.j(this.TiI, adVar.hBk()) || !p.j(this.Tlz, adVar.hBl())) {
            AppMethodBeat.o(57127);
            return false;
        } else {
            AppMethodBeat.o(57127);
            return true;
        }
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57129);
        p.h(nVar, "visitor");
        R a2 = nVar.a(this, d2);
        AppMethodBeat.o(57129);
        return a2;
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends ab>> {
        final /* synthetic */ r TlA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(r rVar) {
            super(0);
            this.TlA = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends ab> invoke() {
            AppMethodBeat.i(57122);
            List<ab> f2 = this.TlA.Tlz.hCl().f(this.TlA.TiI);
            AppMethodBeat.o(57122);
            return f2;
        }
    }

    static final class b extends q implements kotlin.g.a.a<h> {
        final /* synthetic */ r TlA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(r rVar) {
            super(0);
            this.TlA = rVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ h invoke() {
            AppMethodBeat.i(57123);
            if (this.TlA.getFragments().isEmpty()) {
                h.b bVar = h.b.TKa;
                AppMethodBeat.o(57123);
                return bVar;
            }
            List<ab> fragments = this.TlA.getFragments();
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hAp());
            }
            kotlin.l.b.a.b.j.f.b bVar2 = new kotlin.l.b.a.b.j.f.b("package view scope for " + this.TlA.TiI + " in " + this.TlA.Tlz.hAH(), kotlin.a.j.b((Collection) arrayList, (Object) new af(this.TlA.Tlz, this.TlA.TiI)));
            AppMethodBeat.o(57123);
            return bVar2;
        }
    }

    @Override // kotlin.l.b.a.b.b.l
    public final /* synthetic */ l hzx() {
        ad e2;
        AppMethodBeat.i(57126);
        if (this.TiI.TCR.TCW.isEmpty()) {
            e2 = null;
        } else {
            w wVar = this.Tlz;
            kotlin.l.b.a.b.f.b hJf = this.TiI.hJf();
            p.g(hJf, "fqName.parent()");
            e2 = wVar.e(hJf);
        }
        ad adVar = e2;
        AppMethodBeat.o(57126);
        return adVar;
    }

    public final int hashCode() {
        AppMethodBeat.i(57128);
        int hashCode = (this.Tlz.hashCode() * 31) + this.TiI.hashCode();
        AppMethodBeat.o(57128);
        return hashCode;
    }

    @Override // kotlin.l.b.a.b.b.ad
    public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.y hBl() {
        return this.Tlz;
    }

    @Override // kotlin.l.b.a.b.b.ad
    public final boolean isEmpty() {
        AppMethodBeat.i(57131);
        boolean isEmpty = getFragments().isEmpty();
        AppMethodBeat.o(57131);
        return isEmpty;
    }
}
