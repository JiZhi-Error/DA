package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.j.b.n;
import kotlin.l.b.a.b.m.a.n;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.am;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.l;

public final class y {
    public static final y TPF = new y();

    /* access modifiers changed from: package-private */
    public static final /* synthetic */ class c extends n implements m<ab, ab, Boolean> {
        c(y yVar) {
            super(2, yVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(61182);
            kotlin.l.b bp = aa.bp(y.class);
            AppMethodBeat.o(61182);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(ab abVar, ab abVar2) {
            AppMethodBeat.i(61181);
            ab abVar3 = abVar;
            ab abVar4 = abVar2;
            p.h(abVar3, "p1");
            p.h(abVar4, "p2");
            Boolean valueOf = Boolean.valueOf(y.j(abVar3, abVar4));
            AppMethodBeat.o(61181);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    public static final /* synthetic */ class d extends n implements m<ab, ab, Boolean> {
        d(o oVar) {
            super(2, oVar);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(61184);
            kotlin.l.b bp = aa.bp(o.class);
            AppMethodBeat.o(61184);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "equalTypes";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(ab abVar, ab abVar2) {
            AppMethodBeat.i(61183);
            ab abVar3 = abVar;
            ab abVar4 = abVar2;
            p.h(abVar3, "p1");
            p.h(abVar4, "p2");
            Boolean valueOf = Boolean.valueOf(((o) this.SYl).d(abVar3, abVar4));
            AppMethodBeat.o(61183);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(61187);
        AppMethodBeat.o(61187);
    }

    private y() {
    }

    public final aj kM(List<? extends aj> list) {
        l lVar;
        boolean z = true;
        AppMethodBeat.i(61185);
        p.h(list, "types");
        boolean z2 = list.size() > 1;
        if (!kotlin.aa.SXc || z2) {
            ArrayList<bg> arrayList = new ArrayList();
            for (aj ajVar : list) {
                if (ajVar.hKE() instanceof kotlin.l.b.a.b.m.aa) {
                    Collection<ab> hBV = ajVar.hKE().hBV();
                    p.g(hBV, "type.constructor.supertypes");
                    Collection<ab> collection = hBV;
                    ArrayList arrayList2 = new ArrayList(j.a(collection, 10));
                    for (T t : collection) {
                        p.g(t, LocaleUtil.ITALIAN);
                        aj ao = kotlin.l.b.a.b.m.y.ao(t);
                        if (ajVar.hEa()) {
                            ao = ao.EG(true);
                        }
                        arrayList2.add(ao);
                    }
                    arrayList.addAll(arrayList2);
                } else {
                    arrayList.add(ajVar);
                }
            }
            a aVar = a.TPG;
            a aVar2 = aVar;
            for (bg bgVar : arrayList) {
                aVar2 = aVar2.e(bgVar);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aj ajVar2 = (aj) it.next();
                if (aVar2 == a.TPJ) {
                    p.h(ajVar2, "$this$makeSimpleTypeDefinitelyNotNullOrNotNull");
                    l.a aVar3 = l.TNF;
                    l a2 = l.a.a(ajVar2);
                    if (a2 != null) {
                        lVar = a2;
                    } else {
                        lVar = am.as(ajVar2);
                    }
                    if (lVar == null) {
                        lVar = ajVar2.EG(false);
                    }
                } else {
                    lVar = ajVar2;
                }
                linkedHashSet.add(lVar);
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            if (linkedHashSet2.size() == 1) {
                aj ajVar3 = (aj) j.i(linkedHashSet2);
                AppMethodBeat.o(61185);
                return ajVar3;
            }
            b bVar = new b(linkedHashSet2);
            Collection<aj> a3 = a(linkedHashSet2, new c(this));
            boolean z3 = !a3.isEmpty();
            if (!kotlin.aa.SXc || z3) {
                n.a aVar4 = kotlin.l.b.a.b.j.b.n.TIC;
                aj A = n.a.A(a3);
                if (A != null) {
                    AppMethodBeat.o(61185);
                    return A;
                }
                n.a aVar5 = n.TPq;
                Collection<aj> a4 = a(a3, new d(n.a.hLO()));
                if (a4.isEmpty()) {
                    z = false;
                }
                if (kotlin.aa.SXc && !z) {
                    AssertionError assertionError = new AssertionError(bVar.invoke());
                    AppMethodBeat.o(61185);
                    throw assertionError;
                } else if (a4.size() < 2) {
                    aj ajVar4 = (aj) j.i(a4);
                    AppMethodBeat.o(61185);
                    return ajVar4;
                } else {
                    aj hLE = new kotlin.l.b.a.b.m.aa(linkedHashSet2).hLE();
                    AppMethodBeat.o(61185);
                    return hLE;
                }
            } else {
                AssertionError assertionError2 = new AssertionError(bVar.invoke());
                AppMethodBeat.o(61185);
                throw assertionError2;
            }
        } else {
            AssertionError assertionError3 = new AssertionError("Size should be at least 2, but it is " + list.size());
            AppMethodBeat.o(61185);
            throw assertionError3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0017 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Collection<kotlin.l.b.a.b.m.aj> a(java.util.Collection<? extends kotlin.l.b.a.b.m.aj> r9, kotlin.g.a.m<? super kotlin.l.b.a.b.m.aj, ? super kotlin.l.b.a.b.m.aj, java.lang.Boolean> r10) {
        /*
        // Method dump skipped, instructions count: 109
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.m.a.y.a(java.util.Collection, kotlin.g.a.m):java.util.Collection");
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    public static final class a extends Enum<a> {
        public static final a TPG;
        public static final a TPH;
        public static final a TPI;
        public static final a TPJ;
        private static final /* synthetic */ a[] TPK;

        static {
            c cVar = new c("START");
            TPG = cVar;
            C2360a aVar = new C2360a("ACCEPT_NULL");
            TPH = aVar;
            d dVar = new d("UNKNOWN");
            TPI = dVar;
            b bVar = new b("NOT_NULL");
            TPJ = bVar;
            TPK = new a[]{cVar, aVar, dVar, bVar};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) TPK.clone();
        }

        public abstract a e(bg bgVar);

        static final class c extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(String str) {
                super(str, 0, (byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.a.y.a
            public final a e(bg bgVar) {
                AppMethodBeat.i(61178);
                p.h(bgVar, "nextType");
                a f2 = f(bgVar);
                AppMethodBeat.o(61178);
                return f2;
            }
        }

        private a(String str, int i2) {
        }

        public /* synthetic */ a(String str, int i2, byte b2) {
            this(str, i2);
        }

        /* renamed from: kotlin.l.b.a.b.m.a.y$a$a  reason: collision with other inner class name */
        static final class C2360a extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            C2360a(String str) {
                super(str, 1, (byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.a.y.a
            public final a e(bg bgVar) {
                AppMethodBeat.i(61176);
                p.h(bgVar, "nextType");
                a f2 = f(bgVar);
                AppMethodBeat.o(61176);
                return f2;
            }
        }

        static final class d extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            d(String str) {
                super(str, 2, (byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.a.y.a
            public final a e(bg bgVar) {
                AppMethodBeat.i(61179);
                p.h(bgVar, "nextType");
                a f2 = f(bgVar);
                if (f2 == a.TPH) {
                    d dVar = this;
                    AppMethodBeat.o(61179);
                    return dVar;
                }
                AppMethodBeat.o(61179);
                return f2;
            }
        }

        static final class b extends a {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(String str) {
                super(str, 3, (byte) 0);
            }

            @Override // kotlin.l.b.a.b.m.a.y.a
            public final /* synthetic */ a e(bg bgVar) {
                AppMethodBeat.i(61177);
                p.h(bgVar, "nextType");
                b bVar = this;
                AppMethodBeat.o(61177);
                return bVar;
            }
        }

        protected static a f(bg bgVar) {
            p.h(bgVar, "$this$resultNullability");
            if (bgVar.hEa()) {
                return TPH;
            }
            q qVar = q.TPu;
            if (q.d(bgVar)) {
                return TPJ;
            }
            return TPI;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ Set TPL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Set set) {
            super(0);
            this.TPL = set;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(61180);
            String str = "This collections cannot be empty! input types: " + j.a(this.TPL, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 63);
            AppMethodBeat.o(61180);
            return str;
        }
    }

    public static final /* synthetic */ boolean j(ab abVar, ab abVar2) {
        AppMethodBeat.i(61188);
        n.a aVar = n.TPq;
        o hLO = n.a.hLO();
        if (!hLO.c(abVar, abVar2) || hLO.c(abVar2, abVar)) {
            AppMethodBeat.o(61188);
            return false;
        }
        AppMethodBeat.o(61188);
        return true;
    }
}
