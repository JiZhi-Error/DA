package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.u;
import kotlin.m.h;
import kotlin.m.i;
import kotlin.m.o;

public final class at {
    public static final List<as> a(i iVar) {
        l lVar;
        kotlin.l.b.a.b.m.at hzz;
        v vVar = null;
        AppMethodBeat.i(56893);
        p.h(iVar, "$this$computeConstructorTypeParameters");
        List<as> hzO = iVar.hzO();
        p.g(hzO, "declaredTypeParameters");
        if (iVar.hzG() || (iVar.hzx() instanceof a)) {
            h<l> H = kotlin.l.b.a.b.j.d.a.H(iVar);
            a aVar = a.ThN;
            p.h(H, "$this$takeWhile");
            p.h(aVar, "predicate");
            List c2 = i.c(i.c(i.a(new o(H, aVar), b.ThO), c.ThP));
            Iterator<l> it = kotlin.l.b.a.b.j.d.a.H(iVar).iterator();
            while (true) {
                if (!it.hasNext()) {
                    lVar = null;
                    break;
                }
                lVar = it.next();
                if (lVar instanceof e) {
                    break;
                }
            }
            e eVar = (e) lVar;
            if (!(eVar == null || (hzz = eVar.hzz()) == null)) {
                vVar = hzz.getParameters();
            }
            if (vVar == null) {
                vVar = v.SXr;
            }
            if (!c2.isEmpty() || !vVar.isEmpty()) {
                List<as> b2 = j.b((Collection) c2, (Iterable) vVar);
                ArrayList arrayList = new ArrayList(j.a(b2, 10));
                for (as asVar : b2) {
                    p.g(asVar, LocaleUtil.ITALIAN);
                    arrayList.add(new c(asVar, iVar, hzO.size()));
                }
                List<as> b3 = j.b((Collection) hzO, (Iterable) arrayList);
                AppMethodBeat.o(56893);
                return b3;
            }
            List<as> hzO2 = iVar.hzO();
            p.g(hzO2, "declaredTypeParameters");
            AppMethodBeat.o(56893);
            return hzO2;
        }
        AppMethodBeat.o(56893);
        return hzO;
    }

    public static final af a(ab abVar, i iVar, int i2) {
        AppMethodBeat.i(56894);
        if (iVar == null || u.L(iVar)) {
            AppMethodBeat.o(56894);
            return null;
        }
        int size = iVar.hzO().size() + i2;
        if (!iVar.hzG()) {
            boolean z = size == abVar.hKB().size() || kotlin.l.b.a.b.j.c.m(iVar);
            if (!aa.SXc || z) {
                af afVar = new af(iVar, abVar.hKB().subList(i2, abVar.hKB().size()), null);
                AppMethodBeat.o(56894);
                return afVar;
            }
            AssertionError assertionError = new AssertionError((abVar.hKB().size() - size) + " trailing arguments were found in " + abVar + " type");
            AppMethodBeat.o(56894);
            throw assertionError;
        }
        List<av> subList = abVar.hKB().subList(i2, size);
        l hzx = iVar.hzx();
        if (!(hzx instanceof i)) {
            hzx = null;
        }
        af afVar2 = new af(iVar, subList, a(abVar, (i) hzx, size));
        AppMethodBeat.o(56894);
        return afVar2;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<l, Boolean> {
        public static final a ThN = new a();

        static {
            AppMethodBeat.i(56888);
            AppMethodBeat.o(56888);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(l lVar) {
            AppMethodBeat.i(56887);
            l lVar2 = lVar;
            p.h(lVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(lVar2 instanceof a);
            AppMethodBeat.o(56887);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.b<l, Boolean> {
        public static final b ThO = new b();

        static {
            AppMethodBeat.i(56890);
            AppMethodBeat.o(56890);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(l lVar) {
            AppMethodBeat.i(56889);
            l lVar2 = lVar;
            p.h(lVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(!(lVar2 instanceof k));
            AppMethodBeat.o(56889);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.b<l, h<? extends as>> {
        public static final c ThP = new c();

        static {
            AppMethodBeat.i(56892);
            AppMethodBeat.o(56892);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ h<? extends as> invoke(l lVar) {
            AppMethodBeat.i(56891);
            l lVar2 = lVar;
            p.h(lVar2, LocaleUtil.ITALIAN);
            List<as> hAt = ((a) lVar2).hAt();
            p.g(hAt, "(it as CallableDescriptor).typeParameters");
            h z = j.z(hAt);
            AppMethodBeat.o(56891);
            return z;
        }
    }
}
