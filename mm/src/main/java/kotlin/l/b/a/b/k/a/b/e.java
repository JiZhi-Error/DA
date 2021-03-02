package kotlin.l.b.a.b.k.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.b;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.j.b;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.b.j.f.k;
import kotlin.l.b.a.b.k.a.aa;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.x;

public final class e extends kotlin.l.b.a.b.b.c.a {
    public final a.b TKA;
    public final kotlin.l.b.a.b.e.b.a TKB;
    private final an TKC;
    private final kotlin.l.b.a.b.j.f.i TLW;
    private final b TLX;
    private final al<a> TLY;
    private final c TLZ;
    public final n TLm;
    private final kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.b.d> TMa;
    private final kotlin.l.b.a.b.l.g<kotlin.l.b.a.b.b.e> TMb;
    private final kotlin.l.b.a.b.l.f<Collection<kotlin.l.b.a.b.b.e>> TMc;
    public final z.a TMd;
    private final kotlin.l.b.a.b.f.a Tfj;
    private final kotlin.l.b.a.b.b.a.g Tih;
    private final ba TkL;
    private final l Tko;
    private final w Tkq = aa.a(kotlin.l.b.a.b.e.b.b.TAW.get(this.TKA.Txb));
    private final kotlin.l.b.a.b.b.f Tkr;
    private final kotlin.l.b.a.b.l.f<Collection<kotlin.l.b.a.b.b.d>> Tsh;

    static final /* synthetic */ class g extends kotlin.g.b.n implements kotlin.g.a.b<kotlin.l.b.a.b.m.a.i, a> {
        g(e eVar) {
            super(1, eVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(60434);
            kotlin.l.b bp = kotlin.g.b.aa.bp(a.class);
            AppMethodBeat.o(60434);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ a invoke(kotlin.l.b.a.b.m.a.i iVar) {
            AppMethodBeat.i(60433);
            kotlin.l.b.a.b.m.a.i iVar2 = iVar;
            p.h(iVar2, "p1");
            a aVar = new a((e) this.SYl, iVar2);
            AppMethodBeat.o(60433);
            return aVar;
        }
    }

    public final a hLl() {
        AppMethodBeat.i(60437);
        a b2 = this.TLY.b(this.TLm.Tvt.Trh.hLM());
        AppMethodBeat.o(60437);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final kotlin.l.b.a.b.b.a.g hzL() {
        return this.Tih;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public final l hzx() {
        return this.Tko;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        return this.TLX;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.f hzB() {
        return this.Tkr;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        return this.Tkq;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        return this.TkL;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        AppMethodBeat.i(60438);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TAZ.avk(this.TKA.Txb);
        p.g(avk, "Flags.IS_INNER.get(classProto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60438);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        AppMethodBeat.i(60439);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBa.avk(this.TKA.Txb);
        p.g(avk, "Flags.IS_DATA.get(classProto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60439);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        AppMethodBeat.i(60440);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBd.avk(this.TKA.Txb);
        p.g(avk, "Flags.IS_INLINE_CLASS.get(classProto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60440);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        AppMethodBeat.i(60441);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBc.avk(this.TKA.Txb);
        p.g(avk, "Flags.IS_EXPECT_CLASS.get(classProto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60441);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean isExternal() {
        AppMethodBeat.i(60442);
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBb.avk(this.TKA.Txb);
        p.g(avk, "Flags.IS_EXTERNAL_CLASS.get(classProto.flags)");
        boolean booleanValue = avk.booleanValue();
        AppMethodBeat.o(60442);
        return booleanValue;
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final kotlin.l.b.a.b.j.f.h a(kotlin.l.b.a.b.m.a.i iVar) {
        AppMethodBeat.i(60443);
        p.h(iVar, "kotlinTypeRefiner");
        a b2 = this.TLY.b(iVar);
        AppMethodBeat.o(60443);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        AppMethodBeat.i(60444);
        if (kotlin.l.b.a.b.e.b.b.TAY.get(this.TKA.Txb) == a.b.EnumC2306b.COMPANION_OBJECT) {
            AppMethodBeat.o(60444);
            return true;
        }
        AppMethodBeat.o(60444);
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.d hzD() {
        AppMethodBeat.i(60445);
        kotlin.l.b.a.b.b.d dVar = (kotlin.l.b.a.b.b.d) this.TMa.invoke();
        AppMethodBeat.o(60445);
        return dVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<kotlin.l.b.a.b.b.d> hxW() {
        AppMethodBeat.i(60446);
        Collection<kotlin.l.b.a.b.b.d> collection = (Collection) this.Tsh.invoke();
        AppMethodBeat.o(60446);
        return collection;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.e hzA() {
        AppMethodBeat.i(60447);
        kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) this.TMb.invoke();
        AppMethodBeat.o(60447);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<kotlin.l.b.a.b.b.e> hzN() {
        AppMethodBeat.i(60448);
        Collection<kotlin.l.b.a.b.b.e> collection = (Collection) this.TMc.invoke();
        AppMethodBeat.o(60448);
        return collection;
    }

    public final String toString() {
        AppMethodBeat.i(60449);
        String str = "deserialized " + (hzJ() ? "expect" : "") + " class " + hAH();
        AppMethodBeat.o(60449);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        return this.TKC;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(60450);
        List<as> hLg = this.TLm.TKY.hLg();
        AppMethodBeat.o(60450);
        return hLg;
    }

    /* access modifiers changed from: package-private */
    public final class b extends kotlin.l.b.a.b.m.b {
        private final kotlin.l.b.a.b.l.f<List<as>> Tse;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            super(e.this.TLm.Tvt.TcN);
            AppMethodBeat.i(60424);
            this.Tse = e.this.TLm.Tvt.TcN.al(new a(this));
            AppMethodBeat.o(60424);
        }

        @Override // kotlin.l.b.a.b.m.h
        public final Collection<ab> hzR() {
            String str;
            kotlin.l.b.a.b.f.b hJd;
            String sG;
            AppMethodBeat.i(60421);
            a.b bVar = e.this.TKA;
            kotlin.l.b.a.b.e.b.h hVar = e.this.TLm.SZI;
            p.h(bVar, "$this$supertypes");
            p.h(hVar, "typeTable");
            List<a.p> list = bVar.Txv;
            ArrayList arrayList = !list.isEmpty() ? list : null;
            if (arrayList == null) {
                List<Integer> list2 = bVar.Txw;
                p.g(list2, "supertypeIdList");
                List<Integer> list3 = list2;
                ArrayList arrayList2 = new ArrayList(j.a(list3, 10));
                for (T t : list3) {
                    p.g(t, LocaleUtil.ITALIAN);
                    arrayList2.add(hVar.avo(t.intValue()));
                }
                arrayList = arrayList2;
            }
            ArrayList<T> arrayList3 = arrayList;
            ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
            for (T t2 : arrayList3) {
                arrayList4.add(e.this.TLm.TKY.r(t2));
            }
            List<ab> b2 = j.b((Collection) arrayList4, (Iterable) e.this.TLm.Tvt.TKU.l(e.this));
            ArrayList arrayList5 = new ArrayList();
            for (ab abVar : b2) {
                kotlin.l.b.a.b.b.h hzS = abVar.hKE().hzS();
                if (!(hzS instanceof aa.b)) {
                    hzS = null;
                }
                aa.b bVar2 = (aa.b) hzS;
                if (bVar2 != null) {
                    arrayList5.add(bVar2);
                }
            }
            ArrayList arrayList6 = arrayList5;
            if (!arrayList6.isEmpty()) {
                r rVar = e.this.TLm.Tvt.TqU;
                e eVar = e.this;
                ArrayList<aa.b> arrayList7 = arrayList6;
                ArrayList arrayList8 = new ArrayList(j.a(arrayList7, 10));
                for (aa.b bVar3 : arrayList7) {
                    kotlin.l.b.a.b.f.a c2 = kotlin.l.b.a.b.j.d.a.c(bVar3);
                    if (c2 == null || (hJd = c2.hJd()) == null || (sG = hJd.sG()) == null) {
                        str = bVar3.hAH().sG();
                    } else {
                        str = sG;
                    }
                    arrayList8.add(str);
                }
                rVar.a(eVar, arrayList8);
            }
            List p = j.p(b2);
            AppMethodBeat.o(60421);
            return p;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(60422);
            List<as> list = (List) this.Tse.invoke();
            AppMethodBeat.o(60422);
            return list;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(60423);
            String fVar = e.this.hAH().toString();
            p.g(fVar, "name.toString()");
            AppMethodBeat.o(60423);
            return fVar;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final aq hzV() {
            return aq.a.ThM;
        }

        static final class a extends q implements kotlin.g.a.a<List<? extends as>> {
            final /* synthetic */ b TMi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.TMi = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends as> invoke() {
                AppMethodBeat.i(60420);
                List<as> a2 = kotlin.l.b.a.b.b.at.a(e.this);
                AppMethodBeat.o(60420);
                return a2;
            }
        }

        @Override // kotlin.l.b.a.b.m.at, kotlin.l.b.a.b.m.b
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.h hzS() {
            return e.this;
        }

        @Override // kotlin.l.b.a.b.m.b
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.e hzT() {
            return e.this;
        }
    }

    public final class a extends h {
        private final kotlin.l.b.a.b.m.a.i THR;
        private final kotlin.l.b.a.b.l.f<Collection<ab>> TMe;
        final /* synthetic */ e TMf;
        private final kotlin.l.b.a.b.l.f<Collection<l>> TkB;

        static final class c extends q implements kotlin.g.a.b<am, Boolean> {
            final /* synthetic */ a TMg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar) {
                super(1);
                this.TMg = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(am amVar) {
                AppMethodBeat.i(60403);
                am amVar2 = amVar;
                p.h(amVar2, LocaleUtil.ITALIAN);
                Boolean valueOf = Boolean.valueOf(this.TMg.TLm.Tvt.TKV.a(this.TMg.TMf, amVar2));
                AppMethodBeat.o(60403);
                return valueOf;
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(kotlin.l.b.a.b.k.a.b.e r9, kotlin.l.b.a.b.m.a.i r10) {
            /*
            // Method dump skipped, instructions count: 164
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.b.e.a.<init>(kotlin.l.b.a.b.k.a.b.e, kotlin.l.b.a.b.m.a.i):void");
        }

        @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
        public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
            AppMethodBeat.i(60407);
            p.h(dVar, "kindFilter");
            p.h(bVar, "nameFilter");
            Collection<l> collection = (Collection) this.TkB.invoke();
            AppMethodBeat.o(60407);
            return collection;
        }

        @Override // kotlin.l.b.a.b.k.a.b.h, kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60408);
            p.h(fVar, "name");
            p.h(aVar, FirebaseAnalytics.b.LOCATION);
            d(fVar, aVar);
            Collection<am> b2 = super.b(fVar, aVar);
            AppMethodBeat.o(60408);
            return b2;
        }

        @Override // kotlin.l.b.a.b.k.a.b.h, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
        public final Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60409);
            p.h(fVar, "name");
            p.h(aVar, FirebaseAnalytics.b.LOCATION);
            d(fVar, aVar);
            Collection<ah> a2 = super.a(fVar, aVar);
            AppMethodBeat.o(60409);
            return a2;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final void c(kotlin.l.b.a.b.f.f fVar, Collection<am> collection) {
            AppMethodBeat.i(60410);
            p.h(fVar, "name");
            p.h(collection, "functions");
            ArrayList arrayList = new ArrayList();
            for (ab abVar : (Collection) this.TMe.invoke()) {
                arrayList.addAll(abVar.hAp().b(fVar, kotlin.l.b.a.b.c.a.c.FOR_ALREADY_TRACKED));
            }
            j.b((Iterable) collection, (kotlin.g.a.b) new c(this));
            collection.addAll(this.TLm.Tvt.TKU.a(fVar, this.TMf));
            a(fVar, arrayList, collection);
            AppMethodBeat.o(60410);
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final void b(kotlin.l.b.a.b.f.f fVar, Collection<ah> collection) {
            AppMethodBeat.i(60411);
            p.h(fVar, "name");
            p.h(collection, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (ab abVar : (Collection) this.TMe.invoke()) {
                arrayList.addAll(abVar.hAp().a(fVar, kotlin.l.b.a.b.c.a.c.FOR_ALREADY_TRACKED));
            }
            a(fVar, arrayList, collection);
            AppMethodBeat.o(60411);
        }

        private final <D extends kotlin.l.b.a.b.b.b> void a(kotlin.l.b.a.b.f.f fVar, Collection<? extends D> collection, Collection<D> collection2) {
            AppMethodBeat.i(60412);
            this.TLm.Tvt.Trh.hLN().a(fVar, collection, new ArrayList(collection2), this.TMf, new d(collection2));
            AppMethodBeat.o(60412);
        }

        public static final class d extends kotlin.l.b.a.b.j.g {
            final /* synthetic */ Collection TMh;

            d(Collection collection) {
                this.TMh = collection;
            }

            @Override // kotlin.l.b.a.b.j.h
            public final void e(kotlin.l.b.a.b.b.b bVar) {
                AppMethodBeat.i(60404);
                p.h(bVar, "fakeOverride");
                kotlin.l.b.a.b.j.i.a(bVar, (kotlin.g.a.b<kotlin.l.b.a.b.b.b, x>) null);
                this.TMh.add(bVar);
                AppMethodBeat.o(60404);
            }

            @Override // kotlin.l.b.a.b.j.g
            public final void a(kotlin.l.b.a.b.b.b bVar, kotlin.l.b.a.b.b.b bVar2) {
                AppMethodBeat.i(60405);
                p.h(bVar, "fromSuper");
                p.h(bVar2, "fromCurrent");
                AppMethodBeat.o(60405);
            }
        }

        @Override // kotlin.l.b.a.b.k.a.b.h, kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
        public final kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            kotlin.l.b.a.b.b.e A;
            AppMethodBeat.i(60415);
            p.h(fVar, "name");
            p.h(aVar, FirebaseAnalytics.b.LOCATION);
            d(fVar, aVar);
            c cVar = this.TMf.TLZ;
            if (cVar == null || (A = cVar.A(fVar)) == null) {
                kotlin.l.b.a.b.b.h c2 = super.c(fVar, aVar);
                AppMethodBeat.o(60415);
                return c2;
            }
            kotlin.l.b.a.b.b.e eVar = A;
            AppMethodBeat.o(60415);
            return eVar;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final kotlin.l.b.a.b.f.a z(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(60416);
            p.h(fVar, "name");
            kotlin.l.b.a.b.f.a o = this.TMf.Tfj.o(fVar);
            p.g(o, "classId.createNestedClassId(name)");
            AppMethodBeat.o(60416);
            return o;
        }

        /* renamed from: kotlin.l.b.a.b.k.a.b.e$a$a  reason: collision with other inner class name */
        static final class C2351a extends q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.f>> {
            final /* synthetic */ List oaN;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2351a(List list) {
                super(0);
                this.oaN = list;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* bridge */ /* synthetic */ List<? extends kotlin.l.b.a.b.f.f> invoke() {
                return this.oaN;
            }
        }

        static final class b extends q implements kotlin.g.a.a<Collection<? extends l>> {
            final /* synthetic */ a TMg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(0);
                this.TMg = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends l> invoke() {
                AppMethodBeat.i(60402);
                a aVar = this.TMg;
                kotlin.l.b.a.b.j.f.d dVar = kotlin.l.b.a.b.j.f.d.TJE;
                h.a aVar2 = kotlin.l.b.a.b.j.f.h.TJW;
                Collection<l> a2 = aVar.a(dVar, h.a.hKZ(), kotlin.l.b.a.b.c.a.c.WHEN_GET_ALL_DESCRIPTORS);
                AppMethodBeat.o(60402);
                return a2;
            }
        }

        /* renamed from: kotlin.l.b.a.b.k.a.b.e$a$e  reason: collision with other inner class name */
        static final class C2352e extends q implements kotlin.g.a.a<Collection<? extends ab>> {
            final /* synthetic */ a TMg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2352e(a aVar) {
                super(0);
                this.TMg = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Collection<? extends ab> invoke() {
                AppMethodBeat.i(60406);
                Collection<ab> D = this.TMg.THR.D(this.TMg.TMf);
                AppMethodBeat.o(60406);
                return D;
            }
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final Set<kotlin.l.b.a.b.f.f> hLm() {
            AppMethodBeat.i(60413);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = this.TMf.TLX.hBV().iterator();
            while (it.hasNext()) {
                j.a((Collection) linkedHashSet, (Iterable) it.next().hAp().hCa());
            }
            linkedHashSet.addAll(this.TLm.Tvt.TKU.m(this.TMf));
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(60413);
            return linkedHashSet2;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final Set<kotlin.l.b.a.b.f.f> hLn() {
            AppMethodBeat.i(60414);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = this.TMf.TLX.hBV().iterator();
            while (it.hasNext()) {
                j.a((Collection) linkedHashSet, (Iterable) it.next().hAp().hCb());
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(60414);
            return linkedHashSet2;
        }

        /* access modifiers changed from: protected */
        @Override // kotlin.l.b.a.b.k.a.b.h
        public final void c(Collection<l> collection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
            v vVar;
            AppMethodBeat.i(60417);
            p.h(collection, "result");
            p.h(bVar, "nameFilter");
            c cVar = this.TMf.TLZ;
            if (cVar != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = cVar.TMj.keySet().iterator();
                while (it.hasNext()) {
                    kotlin.l.b.a.b.b.e A = cVar.A(it.next());
                    if (A != null) {
                        arrayList.add(A);
                    }
                }
                vVar = arrayList;
            } else {
                vVar = null;
            }
            if (vVar == null) {
                vVar = v.SXr;
            }
            collection.addAll(vVar);
            AppMethodBeat.o(60417);
        }

        @Override // kotlin.l.b.a.b.j.f.i
        public final void d(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
            AppMethodBeat.i(60418);
            p.h(fVar, "name");
            p.h(aVar, FirebaseAnalytics.b.LOCATION);
            kotlin.l.b.a.b.c.a.a(this.TLm.Tvt.Trb, aVar, this.TMf, fVar);
            AppMethodBeat.o(60418);
        }
    }

    /* access modifiers changed from: package-private */
    public final class c {
        final Map<kotlin.l.b.a.b.f.f, a.f> TMj;
        private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.e> TMk;
        final kotlin.l.b.a.b.l.f<Set<kotlin.l.b.a.b.f.f>> Tky;

        static final class a extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.c.n> {
            final /* synthetic */ c TMl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(1);
                this.TMl = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ kotlin.l.b.a.b.b.c.n invoke(kotlin.l.b.a.b.f.f fVar) {
                AppMethodBeat.i(60426);
                kotlin.l.b.a.b.f.f fVar2 = fVar;
                p.h(fVar2, "name");
                a.f fVar3 = this.TMl.TMj.get(fVar2);
                if (fVar3 != null) {
                    kotlin.l.b.a.b.b.c.n a2 = kotlin.l.b.a.b.b.c.n.a(e.this.TLm.Tvt.TcN, e.this, fVar2, this.TMl.Tky, new b(e.this.TLm.Tvt.TcN, new C2353a(fVar3, this, fVar2)), an.ThK);
                    AppMethodBeat.o(60426);
                    return a2;
                }
                AppMethodBeat.o(60426);
                return null;
            }

            /* renamed from: kotlin.l.b.a.b.k.a.b.e$c$a$a  reason: collision with other inner class name */
            static final class C2353a extends q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
                final /* synthetic */ a.f TMm;
                final /* synthetic */ a TMn;
                final /* synthetic */ kotlin.l.b.a.b.f.f TMo;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C2353a(a.f fVar, a aVar, kotlin.l.b.a.b.f.f fVar2) {
                    super(0);
                    this.TMm = fVar;
                    this.TMn = aVar;
                    this.TMo = fVar2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
                    AppMethodBeat.i(60425);
                    List p = j.p(e.this.TLm.Tvt.TKO.a(e.this.TMd, this.TMm));
                    AppMethodBeat.o(60425);
                    return p;
                }
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
            AppMethodBeat.i(60429);
            List<a.f> list = e.this.TKA.TxE;
            p.g(list, "classProto.enumEntryList");
            List<a.f> list2 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(j.a(list2, 10)), 16));
            for (T t : list2) {
                T t2 = t;
                kotlin.l.b.a.b.e.b.c cVar = e.this.TLm.SZH;
                p.g(t2, LocaleUtil.ITALIAN);
                linkedHashMap.put(kotlin.l.b.a.b.k.a.x.b(cVar, t2.Tyk), t);
            }
            this.TMj = linkedHashMap;
            this.TMk = e.this.TLm.Tvt.TcN.V(new a(this));
            this.Tky = e.this.TLm.Tvt.TcN.al(new b(this));
            AppMethodBeat.o(60429);
        }

        public final kotlin.l.b.a.b.b.e A(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(60428);
            p.h(fVar, "name");
            kotlin.l.b.a.b.b.e invoke = this.TMk.invoke(fVar);
            AppMethodBeat.o(60428);
            return invoke;
        }

        static final class b extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
            final /* synthetic */ c TMl;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(c cVar) {
                super(0);
                this.TMl = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
                AppMethodBeat.i(60427);
                c cVar = this.TMl;
                HashSet hashSet = new HashSet();
                for (ab abVar : e.this.hzz().hBV()) {
                    for (l lVar : j.a.a(abVar.hAp(), null, null, 3)) {
                        if ((lVar instanceof am) || (lVar instanceof ah)) {
                            hashSet.add(lVar.hAH());
                        }
                    }
                }
                List<a.h> list = e.this.TKA.TxB;
                p.g(list, "classProto.functionList");
                for (T t : list) {
                    kotlin.l.b.a.b.e.b.c cVar2 = e.this.TLm.SZH;
                    p.g(t, LocaleUtil.ITALIAN);
                    hashSet.add(kotlin.l.b.a.b.k.a.x.b(cVar2, t.Tyk));
                }
                HashSet hashSet2 = hashSet;
                List<a.m> list2 = e.this.TKA.TxC;
                p.g(list2, "classProto.propertyList");
                for (T t2 : list2) {
                    kotlin.l.b.a.b.e.b.c cVar3 = e.this.TLm.SZH;
                    p.g(t2, LocaleUtil.ITALIAN);
                    hashSet.add(kotlin.l.b.a.b.k.a.x.b(cVar3, t2.Tyk));
                }
                Set b2 = ak.b(hashSet2, hashSet);
                AppMethodBeat.o(60427);
                return b2;
            }
        }
    }

    static final class h extends q implements kotlin.g.a.a<kotlin.l.b.a.b.b.d> {
        final /* synthetic */ e TMf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(e eVar) {
            super(0);
            this.TMf = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.b.d invoke() {
            AppMethodBeat.i(60435);
            kotlin.l.b.a.b.b.d d2 = e.d(this.TMf);
            AppMethodBeat.o(60435);
            return d2;
        }
    }

    static final class f extends q implements kotlin.g.a.a<Collection<? extends kotlin.l.b.a.b.b.d>> {
        final /* synthetic */ e TMf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar) {
            super(0);
            this.TMf = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Collection<? extends kotlin.l.b.a.b.b.d> invoke() {
            AppMethodBeat.i(60432);
            Collection e2 = e.e(this.TMf);
            AppMethodBeat.o(60432);
            return e2;
        }
    }

    /* renamed from: kotlin.l.b.a.b.k.a.b.e$e  reason: collision with other inner class name */
    static final class C2354e extends q implements kotlin.g.a.a<kotlin.l.b.a.b.b.e> {
        final /* synthetic */ e TMf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2354e(e eVar) {
            super(0);
            this.TMf = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.b.e invoke() {
            AppMethodBeat.i(60431);
            kotlin.l.b.a.b.b.e f2 = e.f(this.TMf);
            AppMethodBeat.o(60431);
            return f2;
        }
    }

    static final class i extends q implements kotlin.g.a.a<Collection<? extends kotlin.l.b.a.b.b.e>> {
        final /* synthetic */ e TMf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(e eVar) {
            super(0);
            this.TMf = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Collection<? extends kotlin.l.b.a.b.b.e> invoke() {
            AppMethodBeat.i(60436);
            Collection g2 = e.g(this.TMf);
            AppMethodBeat.o(60436);
            return g2;
        }
    }

    static final class d extends q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>> {
        final /* synthetic */ e TMf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar) {
            super(0);
            this.TMf = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends kotlin.l.b.a.b.b.a.c> invoke() {
            AppMethodBeat.i(60430);
            List p = kotlin.a.j.p(this.TMf.TLm.Tvt.TKO.b(this.TMf.TMd));
            AppMethodBeat.o(60430);
            return p;
        }
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.j.f.h hzy() {
        return this.TLW;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(n nVar, a.b bVar, kotlin.l.b.a.b.e.b.c cVar, kotlin.l.b.a.b.e.b.a aVar, an anVar) {
        super(nVar.Tvt.TcN, kotlin.l.b.a.b.k.a.x.a(cVar, bVar.Txs).hJa());
        c cVar2;
        z.a aVar2;
        n nVar2;
        p.h(nVar, "outerContext");
        p.h(bVar, "classProto");
        p.h(cVar, "nameResolver");
        p.h(aVar, "metadataVersion");
        p.h(anVar, "sourceElement");
        AppMethodBeat.i(60451);
        this.TKA = bVar;
        this.TKB = aVar;
        this.TKC = anVar;
        this.Tfj = kotlin.l.b.a.b.k.a.x.a(cVar, this.TKA.Txs);
        kotlin.l.b.a.b.k.a.aa aaVar = kotlin.l.b.a.b.k.a.aa.TLC;
        kotlin.l.b.a.b.k.a.aa aaVar2 = kotlin.l.b.a.b.k.a.aa.TLC;
        this.TkL = kotlin.l.b.a.b.k.a.aa.a(kotlin.l.b.a.b.e.b.b.TAV.get(this.TKA.Txb));
        kotlin.l.b.a.b.k.a.aa aaVar3 = kotlin.l.b.a.b.k.a.aa.TLC;
        this.Tkr = kotlin.l.b.a.b.k.a.aa.a(kotlin.l.b.a.b.e.b.b.TAY.get(this.TKA.Txb));
        List<a.r> list = this.TKA.Txu;
        p.g(list, "classProto.typeParameterList");
        a.s sVar = this.TKA.TxH;
        p.g(sVar, "classProto.typeTable");
        kotlin.l.b.a.b.e.b.h hVar = new kotlin.l.b.a.b.e.b.h(sVar);
        i.a aVar3 = kotlin.l.b.a.b.e.b.i.TBK;
        a.v vVar = this.TKA.TxJ;
        p.g(vVar, "classProto.versionRequirementTable");
        this.TLm = nVar.a(this, list, cVar, hVar, i.a.g(vVar), this.TKB);
        this.TLW = this.Tkr == kotlin.l.b.a.b.b.f.ENUM_CLASS ? new k(this.TLm.Tvt.TcN, this) : h.b.TKa;
        this.TLX = new b();
        al.a aVar4 = al.ThI;
        this.TLY = al.a.a(this, this.TLm.Tvt.TcN, this.TLm.Tvt.Trh.hLM(), new g(this));
        if (this.Tkr == kotlin.l.b.a.b.b.f.ENUM_CLASS) {
            cVar2 = new c();
        } else {
            cVar2 = null;
        }
        this.TLZ = cVar2;
        this.Tko = nVar.Tko;
        this.TMa = this.TLm.Tvt.TcN.am(new h(this));
        this.Tsh = this.TLm.Tvt.TcN.al(new f(this));
        this.TMb = this.TLm.Tvt.TcN.am(new C2354e(this));
        this.TMc = this.TLm.Tvt.TcN.al(new i(this));
        a.b bVar2 = this.TKA;
        kotlin.l.b.a.b.e.b.c cVar3 = this.TLm.SZH;
        kotlin.l.b.a.b.e.b.h hVar2 = this.TLm.SZI;
        an anVar2 = this.TKC;
        l lVar = this.Tko;
        e eVar = (e) (!(lVar instanceof e) ? null : lVar);
        if (eVar != null) {
            aVar2 = eVar.TMd;
        } else {
            aVar2 = null;
        }
        this.TMd = new z.a(bVar2, cVar3, hVar2, anVar2, aVar2);
        if (!kotlin.l.b.a.b.e.b.b.TAU.avk(this.TKA.Txb).booleanValue()) {
            g.a aVar5 = kotlin.l.b.a.b.b.a.g.TiC;
            nVar2 = g.a.hBP();
        } else {
            nVar2 = new n(this.TLm.Tvt.TcN, new d(this));
        }
        this.Tih = nVar2;
        AppMethodBeat.o(60451);
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.d d(e eVar) {
        T t;
        boolean z;
        AppMethodBeat.i(60452);
        if (eVar.Tkr.hAQ()) {
            e eVar2 = eVar;
            an anVar = an.ThK;
            if (anVar == null) {
                kotlin.l.b.a.b.j.b.atM(21);
            }
            b.a aVar = new b.a(eVar2, anVar);
            aVar.I(eVar.hAG());
            b.a aVar2 = aVar;
            AppMethodBeat.o(60452);
            return aVar2;
        }
        List<a.c> list = eVar.TKA.TxA;
        p.g(list, "classProto.constructorList");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            T t2 = next;
            b.a aVar3 = kotlin.l.b.a.b.e.b.b.TBe;
            p.g(t2, LocaleUtil.ITALIAN);
            if (!aVar3.avk(t2.Txb).booleanValue()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t3 = t;
        if (t3 != null) {
            kotlin.l.b.a.b.b.d a2 = eVar.TLm.TKZ.a((a.c) t3, true);
            AppMethodBeat.o(60452);
            return a2;
        }
        AppMethodBeat.o(60452);
        return null;
    }

    public static final /* synthetic */ Collection e(e eVar) {
        AppMethodBeat.i(60453);
        List<a.c> list = eVar.TKA.TxA;
        p.g(list, "classProto.constructorList");
        ArrayList arrayList = new ArrayList();
        for (T t : list) {
            T t2 = t;
            b.a aVar = kotlin.l.b.a.b.e.b.b.TBe;
            p.g(t2, LocaleUtil.ITALIAN);
            Boolean avk = aVar.avk(t2.Txb);
            p.g(avk, "Flags.IS_SECONDARY.get(it.flags)");
            if (avk.booleanValue()) {
                arrayList.add(t);
            }
        }
        ArrayList<a.c> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
        for (a.c cVar : arrayList2) {
            kotlin.l.b.a.b.k.a.w wVar = eVar.TLm.TKZ;
            p.g(cVar, LocaleUtil.ITALIAN);
            arrayList3.add(wVar.a(cVar, false));
        }
        List b2 = kotlin.a.j.b((Collection) kotlin.a.j.b((Collection) arrayList3, (Iterable) kotlin.a.j.eR(eVar.hzD())), (Iterable) eVar.TLm.Tvt.TKU.o(eVar));
        AppMethodBeat.o(60453);
        return b2;
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.e f(e eVar) {
        AppMethodBeat.i(60454);
        if (!eVar.TKA.hFa()) {
            AppMethodBeat.o(60454);
            return null;
        }
        kotlin.l.b.a.b.b.h c2 = eVar.hLl().c(kotlin.l.b.a.b.k.a.x.b(eVar.TLm.SZH, eVar.TKA.Txt), kotlin.l.b.a.b.c.a.c.FROM_DESERIALIZATION);
        if (!(c2 instanceof kotlin.l.b.a.b.b.e)) {
            c2 = null;
        }
        kotlin.l.b.a.b.b.e eVar2 = (kotlin.l.b.a.b.b.e) c2;
        AppMethodBeat.o(60454);
        return eVar2;
    }

    public static final /* synthetic */ Collection g(e eVar) {
        AppMethodBeat.i(60455);
        if (eVar.Tkq != w.SEALED) {
            v vVar = v.SXr;
            AppMethodBeat.o(60455);
            return vVar;
        }
        List<Integer> list = eVar.TKA.TxF;
        p.g(list, "fqNames");
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                kotlin.l.b.a.b.k.a.l lVar = eVar.TLm.Tvt;
                kotlin.l.b.a.b.e.b.c cVar = eVar.TLm.SZH;
                p.g(t, FirebaseAnalytics.b.INDEX);
                kotlin.l.b.a.b.b.e g2 = lVar.g(kotlin.l.b.a.b.k.a.x.a(cVar, t.intValue()));
                if (g2 != null) {
                    arrayList.add(g2);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(60455);
            return arrayList2;
        }
        Collection<kotlin.l.b.a.b.b.e> C = kotlin.l.b.a.b.j.d.a.C(eVar);
        AppMethodBeat.o(60455);
        return C;
    }
}
