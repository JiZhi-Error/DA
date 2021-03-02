package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.m.c.d;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.l.b.a.b.m.c.m;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.c.t;
import kotlin.l.b.a.b.m.g;

public final class e {
    public static boolean TNk;
    public static final e TNl = new e();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.q<j, j, Boolean, Boolean> {
        final /* synthetic */ g TNm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar) {
            super(3);
            this.TNm = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ Boolean d(j jVar, j jVar2, Boolean bool) {
            AppMethodBeat.i(186267);
            Boolean valueOf = Boolean.valueOf(a(jVar, jVar2, bool.booleanValue()));
            AppMethodBeat.o(186267);
            return valueOf;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
            if (kotlin.l.b.a.b.m.e.a(r7.TNm, (kotlin.l.b.a.b.m.c.h) r9, (kotlin.l.b.a.b.m.c.h) r0) != false) goto L_0x005a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(kotlin.l.b.a.b.m.c.j r8, kotlin.l.b.a.b.m.c.j r9, boolean r10) {
            /*
            // Method dump skipped, instructions count: 105
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.e.a.a(kotlin.l.b.a.b.m.c.j, kotlin.l.b.a.b.m.c.j, boolean):boolean");
        }
    }

    static {
        AppMethodBeat.i(60589);
        AppMethodBeat.o(60589);
    }

    private e() {
    }

    public static boolean a(g gVar, h hVar, h hVar2) {
        Boolean bool;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(60579);
        p.h(gVar, "context");
        p.h(hVar, "subType");
        p.h(hVar2, "superType");
        if (hVar == hVar2) {
            AppMethodBeat.o(60579);
            return true;
        }
        e eVar = TNl;
        h a2 = gVar.a(gVar.b(hVar));
        h a3 = gVar.a(gVar.b(hVar2));
        j e2 = gVar.e(a2);
        j f2 = gVar.f(a3);
        if (gVar.n(e2) || gVar.n(f2)) {
            if (gVar.hLv()) {
                bool = Boolean.TRUE;
            } else if (!gVar.h(e2) || gVar.h(f2)) {
                bool = Boolean.valueOf(d.TNj.a((kotlin.l.b.a.b.m.c.q) gVar, (h) gVar.a(e2, false), (h) gVar.a(f2, false)));
            } else {
                bool = Boolean.FALSE;
            }
        } else if (gVar.e(e2) || gVar.e(f2)) {
            bool = Boolean.valueOf(gVar.hLw());
        } else {
            d f3 = gVar.f(f2);
            h a4 = f3 != null ? gVar.a(f3) : null;
            if (!(f3 == null || a4 == null)) {
                p.h(e2, "subType");
                p.h(f3, "superType");
                switch (f.haE[g.a.CHECK_SUBTYPE_AND_LOWER.ordinal()]) {
                    case 1:
                        bool = Boolean.valueOf(a(gVar, e2, a4));
                        break;
                    case 2:
                        if (a(gVar, e2, a4)) {
                            bool = Boolean.TRUE;
                            break;
                        }
                        break;
                }
            }
            n i2 = gVar.i(f2);
            if (gVar.i(i2)) {
                if (!gVar.h(f2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!aa.SXc || z) {
                    Collection<h> k = gVar.k(i2);
                    if (!(k instanceof Collection) || !k.isEmpty()) {
                        Iterator<T> it = k.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (!a(gVar, (h) e2, (h) it.next())) {
                                }
                            }
                        }
                    }
                    z2 = true;
                    bool = Boolean.valueOf(z2);
                } else {
                    AssertionError assertionError = new AssertionError("Intersection type should not be marked nullable!: ".concat(String.valueOf(f2)));
                    AppMethodBeat.o(60579);
                    throw assertionError;
                }
            } else {
                bool = null;
            }
        }
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            g.a(a2, a3);
            AppMethodBeat.o(60579);
            return booleanValue;
        }
        g.a(a2, a3);
        boolean b2 = eVar.b(gVar, gVar.e(a2), gVar.f(a3));
        AppMethodBeat.o(60579);
        return b2;
    }

    public static boolean b(g gVar, h hVar, h hVar2) {
        AppMethodBeat.i(60580);
        p.h(gVar, "context");
        p.h(hVar, "a");
        p.h(hVar2, "b");
        if (hVar == hVar2) {
            AppMethodBeat.o(60580);
            return true;
        }
        if (a(gVar, hVar) && a(gVar, hVar2)) {
            h b2 = gVar.b(hVar);
            h b3 = gVar.b(hVar2);
            j e2 = gVar.e(b2);
            if (!gVar.a(gVar.d(b2), gVar.d(b3))) {
                AppMethodBeat.o(60580);
                return false;
            } else if (gVar.q(e2) == 0) {
                if (gVar.i(b2) || gVar.i(b3)) {
                    AppMethodBeat.o(60580);
                    return true;
                } else if (gVar.h(e2) == gVar.h(gVar.e(b3))) {
                    AppMethodBeat.o(60580);
                    return true;
                } else {
                    AppMethodBeat.o(60580);
                    return false;
                }
            }
        }
        if (!a(gVar, hVar, hVar2) || !a(gVar, hVar2, hVar)) {
            AppMethodBeat.o(60580);
            return false;
        }
        AppMethodBeat.o(60580);
        return true;
    }

    private static Boolean a(g gVar, j jVar, j jVar2) {
        AppMethodBeat.i(60581);
        if (gVar.c(jVar) || gVar.c(jVar2)) {
            a aVar = new a(gVar);
            if (!gVar.c(jVar) || !gVar.c(jVar2)) {
                if (gVar.c(jVar)) {
                    if (aVar.a(jVar, jVar2, false)) {
                        Boolean bool = Boolean.TRUE;
                        AppMethodBeat.o(60581);
                        return bool;
                    }
                } else if (gVar.c(jVar2) && aVar.a(jVar2, jVar, true)) {
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(60581);
                    return bool2;
                }
                AppMethodBeat.o(60581);
                return null;
            }
            Boolean bool3 = Boolean.TRUE;
            AppMethodBeat.o(60581);
            return bool3;
        }
        AppMethodBeat.o(60581);
        return null;
    }

    private static boolean a(g gVar, j jVar) {
        g.b.C2363b bVar;
        AppMethodBeat.i(60582);
        n i2 = gVar.i(jVar);
        if (gVar.l(i2)) {
            boolean o = gVar.o(i2);
            AppMethodBeat.o(60582);
            return o;
        } else if (gVar.o(gVar.i(jVar))) {
            AppMethodBeat.o(60582);
            return true;
        } else {
            gVar.initialize();
            ArrayDeque<j> arrayDeque = gVar.TNp;
            if (arrayDeque == null) {
                p.hyc();
            }
            Set<j> set = gVar.TNq;
            if (set == null) {
                p.hyc();
            }
            arrayDeque.push(jVar);
            while (true) {
                if (!(!arrayDeque.isEmpty())) {
                    gVar.clear();
                    AppMethodBeat.o(60582);
                    return false;
                } else if (set.size() > 1000) {
                    IllegalStateException illegalStateException = new IllegalStateException(("Too many supertypes for type: " + jVar + ". Supertypes = " + kotlin.a.j.a(set, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63)).toString());
                    AppMethodBeat.o(60582);
                    throw illegalStateException;
                } else {
                    j pop = arrayDeque.pop();
                    p.g(pop, "current");
                    if (set.add(pop)) {
                        if (gVar.b(pop)) {
                            bVar = g.b.c.TNw;
                        } else {
                            bVar = g.b.C2363b.TNv;
                        }
                        g.b bVar2 = p.j(bVar, g.b.c.TNw) ^ true ? bVar : null;
                        if (bVar2 != null) {
                            for (h hVar : gVar.k(gVar.i(pop))) {
                                j b2 = bVar2.b(gVar, hVar);
                                if (gVar.o(gVar.i(b2))) {
                                    gVar.clear();
                                    AppMethodBeat.o(60582);
                                    return true;
                                }
                                arrayDeque.add(b2);
                            }
                            continue;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private final boolean b(g gVar, j jVar, j jVar2) {
        boolean a2;
        h c2;
        AppMethodBeat.i(60583);
        if (TNk) {
            boolean z = gVar.k(jVar) || gVar.i(gVar.i(jVar)) || gVar.c(jVar);
            if (!aa.SXc || z) {
                boolean z2 = gVar.k(jVar2) || gVar.c(jVar2);
                if (aa.SXc && !z2) {
                    AssertionError assertionError = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(jVar2)));
                    AppMethodBeat.o(60583);
                    throw assertionError;
                }
            } else {
                AssertionError assertionError2 = new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(jVar)));
                AppMethodBeat.o(60583);
                throw assertionError2;
            }
        }
        c cVar = c.TNi;
        p.h(gVar, "context");
        p.h(jVar, "subType");
        p.h(jVar2, "superType");
        if (TNk) {
            boolean z3 = gVar.k(jVar) || gVar.i(gVar.i(jVar)) || gVar.c(jVar);
            if (!aa.SXc || z3) {
                boolean z4 = gVar.k(jVar2) || gVar.c(jVar2);
                if (aa.SXc && !z4) {
                    AssertionError assertionError3 = new AssertionError("Not singleClassifierType superType: ".concat(String.valueOf(jVar2)));
                    AppMethodBeat.o(60583);
                    throw assertionError3;
                }
            } else {
                AssertionError assertionError4 = new AssertionError("Not singleClassifierType and not intersection subType: ".concat(String.valueOf(jVar)));
                AppMethodBeat.o(60583);
                throw assertionError4;
            }
        }
        if (gVar.h(jVar2)) {
            a2 = true;
        } else if (gVar.h((h) jVar)) {
            a2 = true;
        } else if (c.a(gVar, jVar, g.b.C2363b.TNv)) {
            a2 = true;
        } else if (gVar.h((h) jVar2)) {
            a2 = false;
        } else {
            a2 = c.a(gVar, jVar2, g.b.d.TNx) ? false : gVar.b(jVar) ? false : c.a(gVar, jVar, gVar.i(jVar2));
        }
        if (!a2) {
            AppMethodBeat.o(60583);
            return false;
        }
        Boolean a3 = a(gVar, gVar.e((h) jVar), gVar.f((h) jVar2));
        if (a3 != null) {
            boolean booleanValue = a3.booleanValue();
            g.a((h) jVar, (h) jVar2);
            AppMethodBeat.o(60583);
            return booleanValue;
        }
        n i2 = gVar.i(jVar2);
        if (gVar.b(gVar.i(jVar), i2) && gVar.j(i2) == 0) {
            AppMethodBeat.o(60583);
            return true;
        } else if (gVar.n(gVar.i(jVar2))) {
            AppMethodBeat.o(60583);
            return true;
        } else {
            List<j> e2 = e(gVar, jVar, i2);
            switch (e2.size()) {
                case 0:
                    boolean a4 = a(gVar, jVar);
                    AppMethodBeat.o(60583);
                    return a4;
                case 1:
                    boolean a5 = a(gVar, gVar.j((j) kotlin.a.j.ks(e2)), jVar2);
                    AppMethodBeat.o(60583);
                    return a5;
                default:
                    kotlin.l.b.a.b.m.c.a aVar = new kotlin.l.b.a.b.m.c.a(gVar.j(i2));
                    boolean z5 = false;
                    int j2 = gVar.j(i2);
                    for (int i3 = 0; i3 < j2; i3++) {
                        z5 = z5 || gVar.b(gVar.a(i2, i3)) != t.OUT;
                        if (!z5) {
                            List<j> list = e2;
                            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                            for (T t : list) {
                                m a6 = gVar.a((j) t, i3);
                                if (a6 != null) {
                                    if (!(gVar.b(a6) == t.INV)) {
                                        a6 = null;
                                    }
                                    if (!(a6 == null || (c2 = gVar.c(a6)) == null)) {
                                        arrayList.add(c2);
                                    }
                                }
                                IllegalStateException illegalStateException = new IllegalStateException(("Incorrect type: " + ((Object) t) + ", subType: " + jVar + ", superType: " + jVar2).toString());
                                AppMethodBeat.o(60583);
                                throw illegalStateException;
                            }
                            aVar.add(gVar.r(gVar.kJ(arrayList)));
                        }
                    }
                    if (z5 || !a(gVar, aVar, jVar2)) {
                        List<j> list2 = e2;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it = list2.iterator();
                            while (it.hasNext()) {
                                if (a(gVar, gVar.j((j) it.next()), jVar2)) {
                                    AppMethodBeat.o(60583);
                                    return true;
                                }
                            }
                        }
                        AppMethodBeat.o(60583);
                        return false;
                    }
                    AppMethodBeat.o(60583);
                    return true;
            }
        }
    }

    private static boolean a(g gVar, l lVar, j jVar) {
        boolean a2;
        AppMethodBeat.i(60584);
        p.h(gVar, "$this$isSubtypeForSameConstructor");
        p.h(lVar, "capturedSubArguments");
        p.h(jVar, "superType");
        n i2 = gVar.i(jVar);
        int j2 = gVar.j(i2);
        for (int i3 = 0; i3 < j2; i3++) {
            m a3 = gVar.a((h) jVar, i3);
            if (!gVar.a(a3)) {
                h c2 = gVar.c(a3);
                m a4 = gVar.a(lVar, i3);
                boolean z = gVar.b(a4) == t.INV;
                if (!aa.SXc || z) {
                    h c3 = gVar.c(a4);
                    t b2 = gVar.b(gVar.a(i2, i3));
                    t b3 = gVar.b(a3);
                    p.h(b2, "declared");
                    p.h(b3, "useSite");
                    if (b2 != t.INV) {
                        if (b3 == t.INV) {
                            b3 = b2;
                        } else if (b2 == b3) {
                            b3 = b2;
                        } else {
                            b3 = null;
                        }
                    }
                    if (b3 == null) {
                        boolean hLv = gVar.hLv();
                        AppMethodBeat.o(60584);
                        return hLv;
                    } else if (gVar.TNn > 100) {
                        IllegalStateException illegalStateException = new IllegalStateException("Arguments depth is too high. Some related argument: ".concat(String.valueOf(c3)).toString());
                        AppMethodBeat.o(60584);
                        throw illegalStateException;
                    } else {
                        gVar.TNn++;
                        switch (f.$EnumSwitchMapping$0[b3.ordinal()]) {
                            case 1:
                                a2 = b(gVar, c3, c2);
                                break;
                            case 2:
                                a2 = a(gVar, c3, c2);
                                break;
                            case 3:
                                a2 = a(gVar, c2, c3);
                                break;
                            default:
                                kotlin.m mVar = new kotlin.m();
                                AppMethodBeat.o(60584);
                                throw mVar;
                        }
                        gVar.TNn--;
                        if (!a2) {
                            AppMethodBeat.o(60584);
                            return false;
                        }
                    }
                } else {
                    AssertionError assertionError = new AssertionError("Incorrect sub argument: ".concat(String.valueOf(a4)));
                    AppMethodBeat.o(60584);
                    throw assertionError;
                }
            }
        }
        AppMethodBeat.o(60584);
        return true;
    }

    private static boolean a(g gVar, h hVar) {
        AppMethodBeat.i(60585);
        if (!gVar.g(gVar.d(hVar)) || gVar.g(hVar) || gVar.h(hVar) || !p.j(gVar.i(gVar.e(hVar)), gVar.i(gVar.f(hVar)))) {
            AppMethodBeat.o(60585);
            return false;
        }
        AppMethodBeat.o(60585);
        return true;
    }

    private static List<j> c(g gVar, j jVar, n nVar) {
        g.b.C2363b a2;
        AppMethodBeat.i(60586);
        List<j> a3 = gVar.a(jVar, nVar);
        if (a3 != null) {
            AppMethodBeat.o(60586);
            return a3;
        } else if (!gVar.l(nVar) && gVar.b(jVar)) {
            v vVar = v.SXr;
            AppMethodBeat.o(60586);
            return vVar;
        } else if (!gVar.m(nVar)) {
            kotlin.l.b.a.b.o.h hVar = new kotlin.l.b.a.b.o.h();
            gVar.initialize();
            ArrayDeque<j> arrayDeque = gVar.TNp;
            if (arrayDeque == null) {
                p.hyc();
            }
            Set<j> set = gVar.TNq;
            if (set == null) {
                p.hyc();
            }
            arrayDeque.push(jVar);
            while (true) {
                if (!(!arrayDeque.isEmpty())) {
                    gVar.clear();
                    AppMethodBeat.o(60586);
                    return hVar;
                } else if (set.size() > 1000) {
                    IllegalStateException illegalStateException = new IllegalStateException(("Too many supertypes for type: " + jVar + ". Supertypes = " + kotlin.a.j.a(set, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63)).toString());
                    AppMethodBeat.o(60586);
                    throw illegalStateException;
                } else {
                    j pop = arrayDeque.pop();
                    p.g(pop, "current");
                    if (set.add(pop)) {
                        j a4 = gVar.a(pop, kotlin.l.b.a.b.m.c.b.FOR_SUBTYPING);
                        if (a4 == null) {
                            a4 = pop;
                        }
                        if (gVar.a(gVar.i(a4), nVar)) {
                            hVar.add(a4);
                            a2 = g.b.c.TNw;
                        } else if (gVar.q(a4) == 0) {
                            a2 = g.b.C2363b.TNv;
                        } else {
                            a2 = gVar.a(a4);
                        }
                        if (!(!p.j(a2, g.b.c.TNw))) {
                            a2 = null;
                        }
                        if (a2 != null) {
                            for (h hVar2 : gVar.k(gVar.i(pop))) {
                                arrayDeque.add(a2.b(gVar, hVar2));
                            }
                        }
                    }
                }
            }
        } else if (gVar.a(gVar.i(jVar), nVar)) {
            j a5 = gVar.a(jVar, kotlin.l.b.a.b.m.c.b.FOR_SUBTYPING);
            if (a5 != null) {
                jVar = a5;
            }
            List<j> listOf = kotlin.a.j.listOf(jVar);
            AppMethodBeat.o(60586);
            return listOf;
        } else {
            v vVar2 = v.SXr;
            AppMethodBeat.o(60586);
            return vVar2;
        }
    }

    private static List<j> d(g gVar, j jVar, n nVar) {
        boolean z;
        AppMethodBeat.i(60587);
        List<j> c2 = c(gVar, jVar, nVar);
        if (c2.size() >= 2) {
            ArrayList arrayList = new ArrayList();
            for (T t : c2) {
                l j2 = gVar.j((j) t);
                g gVar2 = gVar;
                int a2 = gVar2.a(j2);
                int i2 = 0;
                while (true) {
                    if (i2 >= a2) {
                        z = true;
                        break;
                    }
                    if (!(gVar.p(gVar.c(gVar2.a(j2, i2))) == null)) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                AppMethodBeat.o(60587);
                return arrayList2;
            }
        }
        AppMethodBeat.o(60587);
        return c2;
    }

    private static List<j> e(g gVar, j jVar, n nVar) {
        g.b.C2363b bVar;
        AppMethodBeat.i(60588);
        p.h(gVar, "$this$findCorrespondingSupertypes");
        p.h(jVar, "subType");
        p.h(nVar, "superConstructor");
        if (gVar.b(jVar)) {
            List<j> d2 = d(gVar, jVar, nVar);
            AppMethodBeat.o(60588);
            return d2;
        } else if (gVar.l(nVar) || gVar.h(nVar)) {
            kotlin.l.b.a.b.o.h<j> hVar = new kotlin.l.b.a.b.o.h();
            gVar.initialize();
            ArrayDeque<j> arrayDeque = gVar.TNp;
            if (arrayDeque == null) {
                p.hyc();
            }
            Set<j> set = gVar.TNq;
            if (set == null) {
                p.hyc();
            }
            arrayDeque.push(jVar);
            while (true) {
                if (!(!arrayDeque.isEmpty())) {
                    gVar.clear();
                    ArrayList arrayList = new ArrayList();
                    for (j jVar2 : hVar) {
                        p.g(jVar2, LocaleUtil.ITALIAN);
                        kotlin.a.j.a((Collection) arrayList, (Iterable) d(gVar, jVar2, nVar));
                    }
                    ArrayList arrayList2 = arrayList;
                    AppMethodBeat.o(60588);
                    return arrayList2;
                } else if (set.size() > 1000) {
                    IllegalStateException illegalStateException = new IllegalStateException(("Too many supertypes for type: " + jVar + ". Supertypes = " + kotlin.a.j.a(set, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63)).toString());
                    AppMethodBeat.o(60588);
                    throw illegalStateException;
                } else {
                    j pop = arrayDeque.pop();
                    p.g(pop, "current");
                    if (set.add(pop)) {
                        if (gVar.b(pop)) {
                            hVar.add(pop);
                            bVar = g.b.c.TNw;
                        } else {
                            bVar = g.b.C2363b.TNv;
                        }
                        if (!(!p.j(bVar, g.b.c.TNw))) {
                            bVar = null;
                        }
                        if (bVar != null) {
                            for (h hVar2 : gVar.k(gVar.i(pop))) {
                                arrayDeque.add(bVar.b(gVar, hVar2));
                            }
                        }
                    }
                }
            }
        } else {
            List<j> c2 = c(gVar, jVar, nVar);
            AppMethodBeat.o(60588);
            return c2;
        }
    }
}
