package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.f.j;
import kotlin.l.b.a.b.j.g;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.k;
import kotlin.x;

public abstract class e extends i {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final f TJR;
    protected final kotlin.l.b.a.b.b.e TJS;

    private final List<l> hKY() {
        return (List) i.a(this.TJR, cLI[0]);
    }

    /* access modifiers changed from: protected */
    public abstract List<t> hzW();

    public e(j jVar, kotlin.l.b.a.b.b.e eVar) {
        p.h(jVar, "storageManager");
        p.h(eVar, "containingClass");
        this.TJS = eVar;
        this.TJR = jVar.al(new a(this));
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final Collection<l> a(d dVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        if (!dVar.avF(d.TJF.TJr)) {
            return v.SXr;
        }
        return hKY();
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Collection<am> b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        ArrayList arrayList = new ArrayList();
        for (T t : hKY()) {
            if (t instanceof am) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (p.j(((am) obj).hAH(), fVar)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Collection<ah> a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        ArrayList arrayList = new ArrayList();
        for (T t : hKY()) {
            if (t instanceof ah) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (p.j(((ah) obj).hAH(), fVar)) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final class b extends g {
        final /* synthetic */ e TJT;
        final /* synthetic */ ArrayList hTI;

        b(e eVar, ArrayList arrayList) {
            this.TJT = eVar;
            this.hTI = arrayList;
        }

        @Override // kotlin.l.b.a.b.j.h
        public final void e(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(60203);
            p.h(bVar, "fakeOverride");
            kotlin.l.b.a.b.j.i.a(bVar, (kotlin.g.a.b<kotlin.l.b.a.b.b.b, x>) null);
            this.hTI.add(bVar);
            AppMethodBeat.o(60203);
        }

        @Override // kotlin.l.b.a.b.j.g
        public final void a(kotlin.l.b.a.b.b.b bVar, kotlin.l.b.a.b.b.b bVar2) {
            AppMethodBeat.i(60204);
            p.h(bVar, "fromSuper");
            p.h(bVar2, "fromCurrent");
            IllegalStateException illegalStateException = new IllegalStateException(("Conflict in scope of " + this.TJT.TJS + ": " + bVar + " vs " + bVar2).toString());
            AppMethodBeat.o(60204);
            throw illegalStateException;
        }
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends l>> {
        final /* synthetic */ e TJT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(0);
            this.TJT = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends l> invoke() {
            AppMethodBeat.i(60202);
            List<t> hzW = this.TJT.hzW();
            List b2 = kotlin.a.j.b((Collection) hzW, (Iterable) e.a(this.TJT, hzW));
            AppMethodBeat.o(60202);
            return b2;
        }
    }

    public static final /* synthetic */ List a(e eVar, List list) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList(3);
        at hzz = eVar.TJS.hzz();
        p.g(hzz, "containingClass.typeConstructor");
        Collection<ab> hBV = hzz.hBV();
        p.g(hBV, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = hBV.iterator();
        while (it.hasNext()) {
            kotlin.a.j.a((Collection) arrayList3, (Iterable) j.a.a(it.next().hAp(), null, null, 3));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList3) {
            if (obj instanceof kotlin.l.b.a.b.b.b) {
                arrayList4.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList4) {
            kotlin.l.b.a.b.f.f hAH = ((kotlin.l.b.a.b.b.b) obj2).hAH();
            Object obj3 = linkedHashMap.get(hAH);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(hAH, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.l.b.a.b.f.f fVar = (kotlin.l.b.a.b.f.f) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((kotlin.l.b.a.b.b.b) obj4) instanceof t);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                kotlin.l.b.a.b.j.i iVar = kotlin.l.b.a.b.j.i.THP;
                List list2 = (List) entry2.getValue();
                if (booleanValue) {
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj6 : list) {
                        if (p.j(((t) obj6).hAH(), fVar)) {
                            arrayList5.add(obj6);
                        }
                    }
                    arrayList = arrayList5;
                } else {
                    arrayList = v.SXr;
                }
                iVar.a(fVar, list2, (List) arrayList, eVar.TJS, new b(eVar, arrayList2));
            }
        }
        return kotlin.l.b.a.b.o.a.bC(arrayList2);
    }
}
