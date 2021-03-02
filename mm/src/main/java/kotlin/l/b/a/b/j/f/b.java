package kotlin.l.b.a.b.j.f;

import com.google.android.gms.common.internal.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public final class b implements h {
    public static final a TJn = new a((byte) 0);
    private final String TJl;
    private final List<h> TJm;

    static {
        AppMethodBeat.i(60193);
        AppMethodBeat.o(60193);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends kotlin.l.b.a.b.j.f.h> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(String str, List<? extends h> list) {
        p.h(str, "debugName");
        p.h(list, Constants.KEY_SCOPES);
        AppMethodBeat.i(60192);
        this.TJl = str;
        this.TJm = list;
        AppMethodBeat.o(60192);
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60186);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        h hVar = null;
        for (h hVar2 : this.TJm) {
            h c2 = hVar2.c(fVar, aVar);
            if (c2 != null) {
                if (!(c2 instanceof i) || !((i) c2).hzJ()) {
                    AppMethodBeat.o(60186);
                    return c2;
                } else if (hVar == null) {
                    hVar = c2;
                }
            }
        }
        AppMethodBeat.o(60186);
        return hVar;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Collection<ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        x xVar;
        AppMethodBeat.i(60187);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        List<h> list = this.TJm;
        if (list.isEmpty()) {
            x xVar2 = x.SXt;
            AppMethodBeat.o(60187);
            return xVar2;
        }
        Collection<ah> collection = null;
        for (h hVar : list) {
            collection = kotlin.l.b.a.b.n.b.a.a(collection, hVar.a(fVar, aVar));
        }
        if (collection == null) {
            xVar = x.SXt;
        } else {
            xVar = collection;
        }
        AppMethodBeat.o(60187);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public final Collection<am> b(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        x xVar;
        AppMethodBeat.i(60188);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        List<h> list = this.TJm;
        if (list.isEmpty()) {
            x xVar2 = x.SXt;
            AppMethodBeat.o(60188);
            return xVar2;
        }
        Collection<am> collection = null;
        for (h hVar : list) {
            collection = kotlin.l.b.a.b.n.b.a.a(collection, hVar.b(fVar, aVar));
        }
        if (collection == null) {
            xVar = x.SXt;
        } else {
            xVar = collection;
        }
        AppMethodBeat.o(60188);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final Collection<l> a(d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        x xVar;
        AppMethodBeat.i(60189);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        List<h> list = this.TJm;
        if (list.isEmpty()) {
            x xVar2 = x.SXt;
            AppMethodBeat.o(60189);
            return xVar2;
        }
        Collection<l> collection = null;
        for (h hVar : list) {
            collection = kotlin.l.b.a.b.n.b.a.a(collection, hVar.a(dVar, bVar));
        }
        if (collection == null) {
            xVar = x.SXt;
        } else {
            xVar = collection;
        }
        AppMethodBeat.o(60189);
        return xVar;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<f> hCa() {
        AppMethodBeat.i(60190);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.TJm.iterator();
        while (it.hasNext()) {
            j.a((Collection) linkedHashSet, (Iterable) it.next().hCa());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(60190);
        return linkedHashSet2;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<f> hCb() {
        AppMethodBeat.i(60191);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = this.TJm.iterator();
        while (it.hasNext()) {
            j.a((Collection) linkedHashSet, (Iterable) it.next().hCb());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(60191);
        return linkedHashSet2;
    }

    public final String toString() {
        return this.TJl;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
