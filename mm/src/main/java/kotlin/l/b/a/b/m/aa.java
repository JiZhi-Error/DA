package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.j.f.m;
import kotlin.l.b.a.b.m.a.i;

public final class aa implements at {
    public final LinkedHashSet<ab> TOe;
    private final int aHK;

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<i, aj> {
        final /* synthetic */ aa TOf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(aa aaVar) {
            super(1);
            this.TOf = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(i iVar) {
            AppMethodBeat.i(60754);
            i iVar2 = iVar;
            p.h(iVar2, "kotlinTypeRefiner");
            aa aaVar = this.TOf;
            p.h(iVar2, "kotlinTypeRefiner");
            LinkedHashSet<ab> linkedHashSet = aaVar.TOe;
            ArrayList arrayList = new ArrayList(j.a(linkedHashSet, 10));
            Iterator<T> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d(iVar2));
            }
            aj hLE = new aa(arrayList).hLE();
            AppMethodBeat.o(60754);
            return hLE;
        }
    }

    public aa(Collection<? extends ab> collection) {
        p.h(collection, "typesToIntersect");
        AppMethodBeat.i(60760);
        boolean z = !collection.isEmpty();
        if (!kotlin.aa.SXc || z) {
            this.TOe = new LinkedHashSet<>(collection);
            this.aHK = this.TOe.hashCode();
            AppMethodBeat.o(60760);
            return;
        }
        AssertionError assertionError = new AssertionError("Attempt to create an empty intersection");
        AppMethodBeat.o(60760);
        throw assertionError;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final Collection<ab> hBV() {
        return this.TOe;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final boolean hzU() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final h hzS() {
        return null;
    }

    @Override // kotlin.l.b.a.b.m.at
    public final g hBh() {
        AppMethodBeat.i(60756);
        g hBh = this.TOe.iterator().next().hKE().hBh();
        p.g(hBh, "intersectedTypes.iterato…xt().constructor.builtIns");
        AppMethodBeat.o(60756);
        return hBh;
    }

    public final String toString() {
        AppMethodBeat.i(60757);
        String a2 = j.a(j.a((Iterable) this.TOe, (Comparator) new b()), " & ", "{", "}", 0, (CharSequence) null, (kotlin.g.a.b) null, 56);
        AppMethodBeat.o(60757);
        return a2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(60758);
        if (this == obj) {
            AppMethodBeat.o(60758);
            return true;
        } else if (!(obj instanceof aa)) {
            AppMethodBeat.o(60758);
            return false;
        } else {
            boolean j2 = p.j(this.TOe, ((aa) obj).TOe);
            AppMethodBeat.o(60758);
            return j2;
        }
    }

    public final aj hLE() {
        AppMethodBeat.i(60759);
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        m.a aVar2 = m.TKi;
        aj a2 = ac.a(g.a.hBP(), this, v.SXr, false, m.a.c("member scope for intersection type ".concat(String.valueOf(this)), this.TOe), new a(this));
        AppMethodBeat.o(60759);
        return a2;
    }

    public final int hashCode() {
        return this.aHK;
    }

    public static final class b<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(60755);
            int a2 = kotlin.b.a.a(t.toString(), t2.toString());
            AppMethodBeat.o(60755);
            return a2;
        }
    }

    @Override // kotlin.l.b.a.b.m.at
    public final List<as> getParameters() {
        return v.SXr;
    }
}
