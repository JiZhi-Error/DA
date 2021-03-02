package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.m.h;
import kotlin.m.i;

public final class k implements g {
    private final List<g> TiL;

    static final class a extends q implements kotlin.g.a.b<g, c> {
        final /* synthetic */ kotlin.l.b.a.b.f.b TiM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.l.b.a.b.f.b bVar) {
            super(1);
            this.TiM = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ c invoke(g gVar) {
            AppMethodBeat.i(56961);
            g gVar2 = gVar;
            p.h(gVar2, LocaleUtil.ITALIAN);
            c g2 = gVar2.g(this.TiM);
            AppMethodBeat.o(56961);
            return g2;
        }
    }

    static final class b extends q implements kotlin.g.a.b<g, h<? extends c>> {
        public static final b TiN = new b();

        static {
            AppMethodBeat.i(56963);
            AppMethodBeat.o(56963);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ h<? extends c> invoke(g gVar) {
            AppMethodBeat.i(56962);
            g gVar2 = gVar;
            p.h(gVar2, LocaleUtil.ITALIAN);
            h z = j.z(gVar2);
            AppMethodBeat.o(56962);
            return z;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.b.a.g> */
    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        p.h(list, "delegates");
        AppMethodBeat.i(56968);
        this.TiL = list;
        AppMethodBeat.o(56968);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public k(g... gVarArr) {
        this(e.W(gVarArr));
        p.h(gVarArr, "delegates");
        AppMethodBeat.i(56969);
        AppMethodBeat.o(56969);
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean isEmpty() {
        AppMethodBeat.i(56964);
        List<g> list = this.TiL;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().isEmpty()) {
                    AppMethodBeat.o(56964);
                    return false;
                }
            }
        }
        AppMethodBeat.o(56964);
        return true;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final boolean h(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56965);
        p.h(bVar, "fqName");
        for (g gVar : j.z(this.TiL)) {
            if (gVar.h(bVar)) {
                AppMethodBeat.o(56965);
                return true;
            }
        }
        AppMethodBeat.o(56965);
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a.g
    public final c g(kotlin.l.b.a.b.f.b bVar) {
        Object next;
        AppMethodBeat.i(56966);
        p.h(bVar, "fqName");
        h e2 = i.e(j.z(this.TiL), new a(bVar));
        p.h(e2, "$this$firstOrNull");
        Iterator it = e2.iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
        }
        c cVar = (c) next;
        AppMethodBeat.o(56966);
        return cVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<c> iterator() {
        AppMethodBeat.i(56967);
        Iterator<c> it = i.c(j.z(this.TiL), b.TiN).iterator();
        AppMethodBeat.o(56967);
        return it;
    }
}
