package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.l.f;
import kotlin.x;

public abstract class h implements at {
    private final f<a> TNy;

    /* access modifiers changed from: protected */
    public abstract Collection<ab> hzR();

    /* access modifiers changed from: protected */
    public abstract aq hzV();

    static final class d extends q implements kotlin.g.a.b<a, x> {
        final /* synthetic */ h TNB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(1);
            this.TNB = hVar;
        }

        static final class a extends q implements kotlin.g.a.b<at, Collection<? extends ab>> {
            final /* synthetic */ d TND;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(1);
                this.TND = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Collection<? extends ab> invoke(at atVar) {
                AppMethodBeat.i(60608);
                at atVar2 = atVar;
                p.h(atVar2, LocaleUtil.ITALIAN);
                Collection a2 = h.a(atVar2, false);
                AppMethodBeat.o(60608);
                return a2;
            }
        }

        static final class b extends q implements kotlin.g.a.b<ab, x> {
            final /* synthetic */ d TND;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(d dVar) {
                super(1);
                this.TND = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(ab abVar) {
                AppMethodBeat.i(60609);
                ab abVar2 = abVar;
                p.h(abVar2, LocaleUtil.ITALIAN);
                this.TND.TNB.H(abVar2);
                x xVar = x.SXb;
                AppMethodBeat.o(60609);
                return xVar;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(a aVar) {
            Collection<ab> collection;
            v vVar;
            AppMethodBeat.i(60610);
            a aVar2 = aVar;
            p.h(aVar2, "supertypes");
            Collection<ab> a2 = this.TNB.hzV().a(this.TNB, aVar2.TNA, new a(this), new b(this));
            if (a2.isEmpty()) {
                ab hBX = this.TNB.hBX();
                if (hBX != null) {
                    vVar = j.listOf(hBX);
                } else {
                    vVar = null;
                }
                if (vVar == null) {
                    vVar = v.SXr;
                }
                a2 = vVar;
            }
            this.TNB.hzV().a(this.TNB, a2, new kotlin.g.a.b<at, Collection<? extends ab>>(this) {
                /* class kotlin.l.b.a.b.m.h.d.AnonymousClass1 */
                final /* synthetic */ d TND;

                {
                    this.TND = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ Collection<? extends ab> invoke(at atVar) {
                    AppMethodBeat.i(60606);
                    at atVar2 = atVar;
                    p.h(atVar2, LocaleUtil.ITALIAN);
                    Collection a2 = h.a(atVar2, true);
                    AppMethodBeat.o(60606);
                    return a2;
                }
            }, new kotlin.g.a.b<ab, x>(this) {
                /* class kotlin.l.b.a.b.m.h.d.AnonymousClass2 */
                final /* synthetic */ d TND;

                {
                    this.TND = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(ab abVar) {
                    AppMethodBeat.i(60607);
                    ab abVar2 = abVar;
                    p.h(abVar2, LocaleUtil.ITALIAN);
                    p.h(abVar2, "type");
                    x xVar = x.SXb;
                    AppMethodBeat.o(60607);
                    return xVar;
                }
            });
            if (!(a2 instanceof List)) {
                collection = null;
            } else {
                collection = a2;
            }
            List<? extends ab> list = (List) collection;
            if (list == null) {
                list = j.p(a2);
            }
            p.h(list, "<set-?>");
            aVar2.TNz = list;
            x xVar = x.SXb;
            AppMethodBeat.o(60610);
            return xVar;
        }
    }

    static final class c extends q implements kotlin.g.a.b<Boolean, a> {
        public static final c TNC = new c();

        static {
            AppMethodBeat.i(60605);
            AppMethodBeat.o(60605);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ a invoke(Boolean bool) {
            AppMethodBeat.i(60604);
            bool.booleanValue();
            a aVar = new a(j.listOf(u.TNN));
            AppMethodBeat.o(60604);
            return aVar;
        }
    }

    public h(kotlin.l.b.a.b.l.j jVar) {
        p.h(jVar, "storageManager");
        this.TNy = jVar.a(new b(this), c.TNC, new d(this));
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.List<? extends kotlin.l.b.a.b.m.ab>, java.util.List<kotlin.l.b.a.b.m.ab> */
    /* renamed from: hLx */
    public final List<ab> hBV() {
        return ((a) this.TNy.invoke()).TNz;
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final Collection<ab> TNA;
        List<? extends ab> TNz = j.listOf(u.TNN);

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.l.b.a.b.m.ab> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Collection<? extends ab> collection) {
            p.h(collection, "allSupertypes");
            AppMethodBeat.i(60602);
            this.TNA = collection;
            AppMethodBeat.o(60602);
        }
    }

    /* access modifiers changed from: protected */
    public void H(ab abVar) {
        p.h(abVar, "type");
    }

    /* access modifiers changed from: protected */
    public ab hBX() {
        return null;
    }

    static final class b extends q implements kotlin.g.a.a<a> {
        final /* synthetic */ h TNB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar) {
            super(0);
            this.TNB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ a invoke() {
            AppMethodBeat.i(60603);
            a aVar = new a(this.TNB.hzR());
            AppMethodBeat.o(60603);
            return aVar;
        }
    }

    /* access modifiers changed from: protected */
    public Collection<ab> EU(boolean z) {
        return v.SXr;
    }

    public static final /* synthetic */ Collection a(at atVar, boolean z) {
        at atVar2;
        if (!(atVar instanceof h)) {
            atVar2 = null;
        } else {
            atVar2 = atVar;
        }
        h hVar = (h) atVar2;
        if (hVar != null) {
            return j.b((Collection) ((a) hVar.TNy.invoke()).TNA, (Iterable) hVar.EU(z));
        }
        Collection<ab> hBV = atVar.hBV();
        p.g(hBV, "supertypes");
        return hBV;
    }
}
