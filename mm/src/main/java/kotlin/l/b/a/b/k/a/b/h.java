package kotlin.l.b.a.b.k.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.h.s;
import kotlin.l.b.a.b.j.f;
import kotlin.l.b.a.b.j.f.d;
import kotlin.l.b.a.b.j.f.i;
import kotlin.l.b.a.b.k.a.n;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.b.k.a.x;
import kotlin.l.k;

public abstract class h extends i {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(h.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), aa.a(new y(aa.bp(h.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), aa.a(new y(aa.bp(h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;"))};
    final n TLm;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> TMt;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> TMu;
    private final Map<kotlin.l.b.a.b.f.f, byte[]> TMv;
    private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.f.f, ar> TMw;
    private final kotlin.l.b.a.b.l.f TMx;
    private final kotlin.l.b.a.b.l.f TMy;
    private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<ah>> TkA;
    private final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.f, Collection<am>> Tkz;
    private final kotlin.l.b.a.b.l.f TsH;

    /* access modifiers changed from: protected */
    public abstract void c(Collection<l> collection, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar);

    /* access modifiers changed from: protected */
    public abstract Set<kotlin.l.b.a.b.f.f> hLm();

    /* access modifiers changed from: protected */
    public abstract Set<kotlin.l.b.a.b.f.f> hLn();

    public final Set<kotlin.l.b.a.b.f.f> hLp() {
        return (Set) kotlin.l.b.a.b.l.i.a(this.TMy, cLI[2]);
    }

    /* access modifiers changed from: protected */
    public abstract kotlin.l.b.a.b.f.a z(kotlin.l.b.a.b.f.f fVar);

    static final class e extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends am>> {
        final /* synthetic */ h TMB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super(1);
            this.TMB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(60463);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, LocaleUtil.ITALIAN);
            Collection a2 = h.a(this.TMB, fVar2);
            AppMethodBeat.o(60463);
            return a2;
        }
    }

    static final class f extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, Collection<? extends ah>> {
        final /* synthetic */ h TMB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(h hVar) {
            super(1);
            this.TMB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends ah> invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(60464);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, LocaleUtil.ITALIAN);
            Collection b2 = h.b(this.TMB, fVar2);
            AppMethodBeat.o(60464);
            return b2;
        }
    }

    static final class g extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.f, ar> {
        final /* synthetic */ h TMB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(h hVar) {
            super(1);
            this.TMB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ar invoke(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(60465);
            kotlin.l.b.a.b.f.f fVar2 = fVar;
            p.h(fVar2, LocaleUtil.ITALIAN);
            ar c2 = h.c(this.TMB, fVar2);
            AppMethodBeat.o(60465);
            return c2;
        }
    }

    public static final /* synthetic */ ar c(h hVar, kotlin.l.b.a.b.f.f fVar) {
        byte[] bArr = hVar.TMv.get(fVar);
        if (bArr == null) {
            return null;
        }
        a.q e2 = a.q.e(new ByteArrayInputStream(bArr), hVar.TLm.Tvt.TKW);
        if (e2 == null) {
            return null;
        }
        return hVar.TLm.TKZ.f(e2);
    }

    protected h(n nVar, Collection<a.h> collection, Collection<a.m> collection2, Collection<a.q> collection3, kotlin.g.a.a<? extends Collection<kotlin.l.b.a.b.f.f>> aVar) {
        p.h(nVar, "c");
        p.h(collection, "functionList");
        p.h(collection2, "propertyList");
        p.h(collection3, "typeAliasList");
        p.h(aVar, "classNames");
        this.TLm = nVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : collection) {
            kotlin.l.b.a.b.f.f b2 = x.b(this.TLm.SZH, t.Tyk);
            Object obj = linkedHashMap.get(b2);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(b2, obj);
            }
            ((List) obj).add(t);
        }
        this.TMt = cA(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (T t2 : collection2) {
            kotlin.l.b.a.b.f.f b3 = x.b(this.TLm.SZH, t2.Tyk);
            Object obj2 = linkedHashMap2.get(b3);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap2.put(b3, obj2);
            }
            ((List) obj2).add(t2);
        }
        this.TMu = cA(linkedHashMap2);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (T t3 : collection3) {
            kotlin.l.b.a.b.f.f b4 = x.b(this.TLm.SZH, t3.Tyk);
            Object obj3 = linkedHashMap3.get(b4);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap3.put(b4, obj3);
            }
            ((List) obj3).add(t3);
        }
        this.TMv = cA(linkedHashMap3);
        this.Tkz = this.TLm.Tvt.TcN.U(new e(this));
        this.TkA = this.TLm.Tvt.TcN.U(new f(this));
        this.TMw = this.TLm.Tvt.TcN.V(new g(this));
        this.TsH = this.TLm.Tvt.TcN.al(new d(this));
        this.TMx = this.TLm.Tvt.TcN.al(new C2355h(this));
        this.TMy = this.TLm.Tvt.TcN.al(new a(aVar));
    }

    private final Set<kotlin.l.b.a.b.f.f> hLo() {
        return this.TMv.keySet();
    }

    /* access modifiers changed from: protected */
    public void c(kotlin.l.b.a.b.f.f fVar, Collection<am> collection) {
        p.h(fVar, "name");
        p.h(collection, "functions");
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        if (!hCa().contains(fVar)) {
            return v.SXr;
        }
        return this.Tkz.invoke(fVar);
    }

    /* access modifiers changed from: protected */
    public void b(kotlin.l.b.a.b.f.f fVar, Collection<ah> collection) {
        p.h(fVar, "name");
        p.h(collection, "descriptors");
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        if (!hCb().contains(fVar)) {
            return v.SXr;
        }
        return this.TkA.invoke(fVar);
    }

    /* access modifiers changed from: protected */
    public final Collection<l> a(kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        ArrayList arrayList = new ArrayList(0);
        d.a aVar2 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJv)) {
            c(arrayList, bVar);
        }
        a(arrayList, dVar, bVar, aVar);
        d.a aVar3 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJB)) {
            for (kotlin.l.b.a.b.f.f fVar : hLp()) {
                if (bVar.invoke(fVar).booleanValue()) {
                    kotlin.l.b.a.b.o.a.c(arrayList, B(fVar));
                }
            }
        }
        d.a aVar4 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJw)) {
            for (kotlin.l.b.a.b.f.f fVar2 : hLo()) {
                if (bVar.invoke(fVar2).booleanValue()) {
                    kotlin.l.b.a.b.o.a.c(arrayList, this.TMw.invoke(fVar2));
                }
            }
        }
        return kotlin.l.b.a.b.o.a.bC(arrayList);
    }

    private final void a(Collection<l> collection, kotlin.l.b.a.b.j.f.d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar, kotlin.l.b.a.b.c.a.a aVar) {
        d.a aVar2 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJz)) {
            ArrayList arrayList = new ArrayList();
            for (kotlin.l.b.a.b.f.f fVar : hCb()) {
                if (bVar.invoke(fVar).booleanValue()) {
                    arrayList.addAll(a(fVar, aVar));
                }
            }
            f.a aVar3 = f.a.THN;
            p.g(aVar3, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            j.a((List) arrayList, (Comparator) aVar3);
            collection.addAll(arrayList);
        }
        d.a aVar4 = kotlin.l.b.a.b.j.f.d.TJQ;
        if (dVar.avF(kotlin.l.b.a.b.j.f.d.TJy)) {
            ArrayList arrayList2 = new ArrayList();
            for (kotlin.l.b.a.b.f.f fVar2 : hCa()) {
                if (bVar.invoke(fVar2).booleanValue()) {
                    arrayList2.addAll(b(fVar2, aVar));
                }
            }
            f.a aVar5 = f.a.THN;
            p.g(aVar5, "MemberComparator.NameAnd…MemberComparator.INSTANCE");
            j.a((List) arrayList2, (Comparator) aVar5);
            collection.addAll(arrayList2);
        }
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public kotlin.l.b.a.b.b.h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        if (C(fVar)) {
            return B(fVar);
        }
        if (hLo().contains(fVar)) {
            return this.TMw.invoke(fVar);
        }
        return null;
    }

    private final kotlin.l.b.a.b.b.e B(kotlin.l.b.a.b.f.f fVar) {
        return this.TLm.Tvt.g(z(fVar));
    }

    /* access modifiers changed from: protected */
    public boolean C(kotlin.l.b.a.b.f.f fVar) {
        p.h(fVar, "name");
        return hLp().contains(fVar);
    }

    private static Map<kotlin.l.b.a.b.f.f, byte[]> cA(Map<kotlin.l.b.a.b.f.f, ? extends Collection<? extends kotlin.l.b.a.b.h.a>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(map.size()));
        for (T t : map.entrySet()) {
            Object key = t.getKey();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Iterable<kotlin.l.b.a.b.h.a> iterable = (Iterable) t.getValue();
            ArrayList arrayList = new ArrayList(j.a(iterable, 10));
            for (kotlin.l.b.a.b.h.a aVar : iterable) {
                aVar.d(byteArrayOutputStream);
                arrayList.add(kotlin.x.SXb);
            }
            linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
        }
        return linkedHashMap;
    }

    static final class d extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ h TMB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar) {
            super(0);
            this.TMB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(60462);
            Set b2 = ak.b(this.TMB.TMt.keySet(), this.TMB.hLm());
            AppMethodBeat.o(60462);
            return b2;
        }
    }

    /* renamed from: kotlin.l.b.a.b.k.a.b.h$h  reason: collision with other inner class name */
    static final class C2355h extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ h TMB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2355h(h hVar) {
            super(0);
            this.TMB = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(60466);
            Set b2 = ak.b(this.TMB.TMu.keySet(), this.TMB.hLn());
            AppMethodBeat.o(60466);
            return b2;
        }
    }

    static final class a extends q implements kotlin.g.a.a<Set<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ kotlin.g.a.a TMz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.g.a.a aVar) {
            super(0);
            this.TMz = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Set<? extends kotlin.l.b.a.b.f.f> invoke() {
            AppMethodBeat.i(60459);
            Set r = j.r((Iterable) this.TMz.invoke());
            AppMethodBeat.o(60459);
            return r;
        }
    }

    public static final class b extends q implements kotlin.g.a.a<M> {
        final /* synthetic */ ByteArrayInputStream TMA;
        final /* synthetic */ h TMB;
        final /* synthetic */ s TMC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ByteArrayInputStream byteArrayInputStream, h hVar, s sVar) {
            super(0);
            this.TMA = byteArrayInputStream;
            this.TMB = hVar;
            this.TMC = sVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(60460);
            kotlin.l.b.a.b.h.q qVar = (kotlin.l.b.a.b.h.q) this.TMC.i(this.TMA, this.TMB.TLm.Tvt.TKW);
            AppMethodBeat.o(60460);
            return qVar;
        }
    }

    public static final class c extends q implements kotlin.g.a.a<M> {
        final /* synthetic */ ByteArrayInputStream TMA;
        final /* synthetic */ h TMB;
        final /* synthetic */ s TMC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ByteArrayInputStream byteArrayInputStream, h hVar, s sVar) {
            super(0);
            this.TMA = byteArrayInputStream;
            this.TMB = hVar;
            this.TMC = sVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(60461);
            kotlin.l.b.a.b.h.q qVar = (kotlin.l.b.a.b.h.q) this.TMC.i(this.TMA, this.TMB.TLm.Tvt.TKW);
            AppMethodBeat.o(60461);
            return qVar;
        }
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCa() {
        return (Set) kotlin.l.b.a.b.l.i.a(this.TsH, cLI[0]);
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCb() {
        return (Set) kotlin.l.b.a.b.l.i.a(this.TMx, cLI[1]);
    }

    public static final /* synthetic */ Collection a(h hVar, kotlin.l.b.a.b.f.f fVar) {
        Iterable<a.h> iterable;
        List c2;
        Map<kotlin.l.b.a.b.f.f, byte[]> map = hVar.TMt;
        s<a.h> sVar = a.h.TwL;
        p.g(sVar, "ProtoBuf.Function.PARSER");
        byte[] bArr = map.get(fVar);
        if (bArr == null || (c2 = kotlin.m.i.c(kotlin.m.i.ao(new b(new ByteArrayInputStream(bArr), hVar, sVar)))) == null) {
            iterable = v.SXr;
        } else {
            iterable = c2;
        }
        ArrayList arrayList = new ArrayList();
        for (a.h hVar2 : iterable) {
            w wVar = hVar.TLm.TKZ;
            p.g(hVar2, LocaleUtil.ITALIAN);
            arrayList.add(wVar.g(hVar2));
        }
        ArrayList arrayList2 = arrayList;
        hVar.c(fVar, arrayList2);
        return kotlin.l.b.a.b.o.a.bC(arrayList2);
    }

    public static final /* synthetic */ Collection b(h hVar, kotlin.l.b.a.b.f.f fVar) {
        Iterable<a.m> iterable;
        List c2;
        Map<kotlin.l.b.a.b.f.f, byte[]> map = hVar.TMu;
        s<a.m> sVar = a.m.TwL;
        p.g(sVar, "ProtoBuf.Property.PARSER");
        byte[] bArr = map.get(fVar);
        if (bArr == null || (c2 = kotlin.m.i.c(kotlin.m.i.ao(new c(new ByteArrayInputStream(bArr), hVar, sVar)))) == null) {
            iterable = v.SXr;
        } else {
            iterable = c2;
        }
        ArrayList arrayList = new ArrayList();
        for (a.m mVar : iterable) {
            w wVar = hVar.TLm.TKZ;
            p.g(mVar, LocaleUtil.ITALIAN);
            arrayList.add(wVar.g(mVar));
        }
        ArrayList arrayList2 = arrayList;
        hVar.b(fVar, arrayList2);
        return kotlin.l.b.a.b.o.a.bC(arrayList2);
    }
}
