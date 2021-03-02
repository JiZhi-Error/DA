package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.o;
import kotlin.t;

public final class m extends a {
    public static final a TKi = new a((byte) 0);
    private final b TKh;

    static {
        AppMethodBeat.i(60247);
        AppMethodBeat.o(60247);
    }

    public static final h c(String str, Collection<? extends ab> collection) {
        AppMethodBeat.i(60248);
        h c2 = a.c(str, collection);
        AppMethodBeat.o(60248);
        return c2;
    }

    static final class b extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.a> {
        public static final b TKj = new b();

        static {
            AppMethodBeat.i(60239);
            AppMethodBeat.o(60239);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.l.b.a.b.b.a invoke(kotlin.l.b.a.b.b.a aVar) {
            AppMethodBeat.i(60238);
            kotlin.l.b.a.b.b.a aVar2 = aVar;
            p.h(aVar2, "$receiver");
            AppMethodBeat.o(60238);
            return aVar2;
        }
    }

    static final class c extends q implements kotlin.g.a.b<am, am> {
        public static final c TKk = new c();

        static {
            AppMethodBeat.i(60241);
            AppMethodBeat.o(60241);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ am invoke(am amVar) {
            AppMethodBeat.i(60240);
            am amVar2 = amVar;
            p.h(amVar2, "$receiver");
            AppMethodBeat.o(60240);
            return amVar2;
        }
    }

    static final class d extends q implements kotlin.g.a.b<ah, ah> {
        public static final d TKl = new d();

        static {
            AppMethodBeat.i(60243);
            AppMethodBeat.o(60243);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ah invoke(ah ahVar) {
            AppMethodBeat.i(60242);
            ah ahVar2 = ahVar;
            p.h(ahVar2, "$receiver");
            AppMethodBeat.o(60242);
            return ahVar2;
        }
    }

    private m(b bVar) {
        this.TKh = bVar;
    }

    public /* synthetic */ m(b bVar, byte b2) {
        this(bVar);
    }

    @Override // kotlin.l.b.a.b.j.f.a, kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public final Collection<am> b(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60244);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        Collection<am> b2 = j.b(super.b(fVar, aVar), c.TKk);
        AppMethodBeat.o(60244);
        return b2;
    }

    @Override // kotlin.l.b.a.b.j.f.a, kotlin.l.b.a.b.j.f.h
    public final Collection<ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60245);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        Collection<ah> b2 = j.b(super.a(fVar, aVar), d.TKl);
        AppMethodBeat.o(60245);
        return b2;
    }

    @Override // kotlin.l.b.a.b.j.f.a, kotlin.l.b.a.b.j.f.j
    public final Collection<l> a(d dVar, kotlin.g.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(60246);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : super.a(dVar, bVar)) {
            if (t instanceof kotlin.l.b.a.b.b.a) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        o oVar = new o(arrayList, arrayList2);
        A a2 = oVar.first;
        B b2 = oVar.second;
        if (a2 == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
            AppMethodBeat.o(60246);
            throw tVar;
        }
        List b3 = kotlin.a.j.b(j.b(a2, b.TKj), (Iterable) b2);
        AppMethodBeat.o(60246);
        return b3;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h c(String str, Collection<? extends ab> collection) {
            AppMethodBeat.i(60237);
            p.h(str, "message");
            p.h(collection, "types");
            Collection<? extends ab> collection2 = collection;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(collection2, 10));
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().hAp());
            }
            b bVar = new b(str, arrayList);
            if (collection.size() <= 1) {
                b bVar2 = bVar;
                AppMethodBeat.o(60237);
                return bVar2;
            }
            m mVar = new m(bVar, (byte) 0);
            AppMethodBeat.o(60237);
            return mVar;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.a
    public final /* bridge */ /* synthetic */ h hKM() {
        return this.TKh;
    }
}
