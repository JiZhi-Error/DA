package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.n;
import kotlin.l.b.a.b.d.a.e.p;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.f.f;
import kotlin.m.h;
import kotlin.m.i;

public final class a implements b {
    private final b<q, Boolean> TrG = new C2283a(this);
    private final Map<f, List<q>> TrH;
    private final g TrI;
    final b<p, Boolean> TrJ;
    private final Map<f, n> bZN;

    /* renamed from: kotlin.l.b.a.b.d.a.c.a.a$a  reason: collision with other inner class name */
    static final class C2283a extends kotlin.g.b.q implements b<q, Boolean> {
        final /* synthetic */ a TrK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2283a(a aVar) {
            super(1);
            this.TrK = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(kotlin.l.b.a.b.d.a.e.q r6) {
            /*
            // Method dump skipped, instructions count: 195
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.a.a.C2283a.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.d.a.e.p, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(g gVar, b<? super p, Boolean> bVar) {
        kotlin.g.b.p.h(gVar, "jClass");
        kotlin.g.b.p.h(bVar, "memberFilter");
        AppMethodBeat.i(57777);
        this.TrI = gVar;
        this.TrJ = bVar;
        h a2 = i.a(j.z(this.TrI.hCM()), this.TrG);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : a2) {
            f hAH = ((q) obj).hAH();
            Object obj2 = linkedHashMap.get(hAH);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(hAH, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.TrH = linkedHashMap;
        h a3 = i.a(j.z(this.TrI.hCN()), this.TrJ);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : a3) {
            linkedHashMap2.put(((n) obj3).hAH(), obj3);
        }
        this.bZN = linkedHashMap2;
        AppMethodBeat.o(57777);
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.b
    public final Collection<q> j(f fVar) {
        AppMethodBeat.i(57773);
        kotlin.g.b.p.h(fVar, "name");
        List<q> list = this.TrH.get(fVar);
        if (list != null) {
            List<q> list2 = list;
            AppMethodBeat.o(57773);
            return list2;
        }
        v vVar = v.SXr;
        AppMethodBeat.o(57773);
        return vVar;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.b
    public final Set<f> hDK() {
        AppMethodBeat.i(57774);
        h<q> a2 = i.a(j.z(this.TrI.hCM()), this.TrG);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (q qVar : a2) {
            linkedHashSet.add(qVar.hAH());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57774);
        return linkedHashSet2;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.b
    public final n k(f fVar) {
        AppMethodBeat.i(57775);
        kotlin.g.b.p.h(fVar, "name");
        n nVar = this.bZN.get(fVar);
        AppMethodBeat.o(57775);
        return nVar;
    }

    @Override // kotlin.l.b.a.b.d.a.c.a.b
    public final Set<f> hDL() {
        AppMethodBeat.i(57776);
        h<n> a2 = i.a(j.z(this.TrI.hCN()), this.TrJ);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar : a2) {
            linkedHashSet.add(nVar.hAH());
        }
        LinkedHashSet linkedHashSet2 = linkedHashSet;
        AppMethodBeat.o(57776);
        return linkedHashSet2;
    }
}
