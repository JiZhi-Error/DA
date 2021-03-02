package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.b.c;
import kotlin.l.b.a.b.b.a.k;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.c.b.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.v;
import kotlin.m;
import kotlin.t;

public final class s {
    private static final b TuT;
    private static final b TuU;

    public static final ab a(ab abVar, b<? super Integer, d> bVar) {
        AppMethodBeat.i(58131);
        p.h(abVar, "$this$enhance");
        p.h(bVar, "qualifiers");
        k a2 = a(abVar.hLF(), bVar, 0);
        ab hBy = a2.hBy();
        if (a2.Tuq) {
            AppMethodBeat.o(58131);
            return hBy;
        }
        AppMethodBeat.o(58131);
        return null;
    }

    public static final boolean T(ab abVar) {
        AppMethodBeat.i(58132);
        p.h(abVar, "$this$hasEnhancedNullability");
        boolean a2 = a(kotlin.l.b.a.b.m.a.s.TPv, abVar);
        AppMethodBeat.o(58132);
        return a2;
    }

    public static final boolean a(bb bbVar, h hVar) {
        AppMethodBeat.i(58133);
        p.h(bbVar, "$this$hasEnhancedNullability");
        p.h(hVar, "type");
        kotlin.l.b.a.b.f.b bVar = kotlin.l.b.a.b.d.a.p.Tpt;
        p.g(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        boolean a2 = bbVar.a(hVar, bVar);
        AppMethodBeat.o(58133);
        return a2;
    }

    private static final k a(bg bgVar, b<? super Integer, d> bVar, int i2) {
        boolean z;
        ab abVar;
        g a2;
        bg b2;
        boolean z2 = false;
        AppMethodBeat.i(58134);
        if (ad.ap(bgVar)) {
            k kVar = new k(bgVar, 1, false);
            AppMethodBeat.o(58134);
            return kVar;
        } else if (bgVar instanceof v) {
            o a3 = a(((v) bgVar).TNV, bVar, i2, q.FLEXIBLE_LOWER);
            o a4 = a(((v) bgVar).TNW, bVar, i2, q.FLEXIBLE_UPPER);
            if (a3.Tup == a4.Tup) {
                z = true;
            } else {
                z = false;
            }
            if (!aa.SXc || z) {
                if (a3.Tuq || a4.Tuq) {
                    z2 = true;
                }
                ab aJ = be.aJ(a3.TuN);
                if (aJ == null) {
                    abVar = be.aJ(a4.TuN);
                } else {
                    abVar = aJ;
                }
                if (!z2) {
                    b2 = bgVar;
                } else {
                    if (bgVar instanceof g) {
                        a2 = new g(a3.TuN, a4.TuN);
                    } else {
                        a2 = ac.a(a3.TuN, a4.TuN);
                    }
                    b2 = be.b(a2, abVar);
                }
                k kVar2 = new k(b2, a3.Tup, z2);
                AppMethodBeat.o(58134);
                return kVar2;
            }
            AssertionError assertionError = new AssertionError("Different tree sizes of bounds: lower = (" + ((v) bgVar).TNV + ", " + a3.Tup + "), upper = (" + ((v) bgVar).TNW + ", " + a4.Tup + ')');
            AppMethodBeat.o(58134);
            throw assertionError;
        } else if (bgVar instanceof aj) {
            o a5 = a((aj) bgVar, bVar, i2, q.INFLEXIBLE);
            AppMethodBeat.o(58134);
            return a5;
        } else {
            m mVar = new m();
            AppMethodBeat.o(58134);
            throw mVar;
        }
    }

    private static final o a(aj ajVar, b<? super Integer, d> bVar, int i2, q qVar) {
        f fVar;
        int i3;
        av a2;
        AppMethodBeat.i(58135);
        if (a(qVar) || !ajVar.hKB().isEmpty()) {
            kotlin.l.b.a.b.b.h hzS = ajVar.hKE().hzS();
            if (hzS == null) {
                o oVar = new o(ajVar, 1, false);
                AppMethodBeat.o(58135);
                return oVar;
            }
            p.g(hzS, "constructor.declarationD…pleResult(this, 1, false)");
            d invoke = bVar.invoke(Integer.valueOf(i2));
            c<kotlin.l.b.a.b.b.h> a3 = a(hzS, invoke, qVar);
            T t = a3.result;
            kotlin.l.b.a.b.b.a.g gVar = a3.TtI;
            at hzz = t.hzz();
            p.g(hzz, "enhancedClassifier.typeConstructor");
            int i4 = i2 + 1;
            boolean z = gVar != null;
            List<av> hKB = ajVar.hKB();
            ArrayList arrayList = new ArrayList(j.a(hKB, 10));
            int i5 = 0;
            int i6 = i4;
            for (T t2 : hKB) {
                int i7 = i5 + 1;
                if (i5 < 0) {
                    j.hxH();
                }
                T t3 = t2;
                if (t3.hLH()) {
                    i3 = i6 + 1;
                    at hzz2 = t.hzz();
                    p.g(hzz2, "enhancedClassifier.typeConstructor");
                    a2 = bc.d(hzz2.getParameters().get(i5));
                } else {
                    k a4 = a(t3.hBy().hLF(), bVar, i6);
                    if (z || a4.Tuq) {
                        z = true;
                    } else {
                        z = false;
                    }
                    i3 = a4.Tup + i6;
                    ab hBy = a4.hBy();
                    bh hLI = t3.hLI();
                    p.g(hLI, "arg.projectionKind");
                    a2 = a.a(hBy, hLI, hzz.getParameters().get(i5));
                }
                arrayList.add(a2);
                i5 = i7;
                i6 = i3;
            }
            ArrayList arrayList2 = arrayList;
            c<Boolean> a5 = a(ajVar, invoke, qVar);
            boolean booleanValue = a5.result.booleanValue();
            kotlin.l.b.a.b.b.a.g gVar2 = a5.TtI;
            boolean z2 = z || gVar2 != null;
            int i8 = i6 - i2;
            if (!z2) {
                o oVar2 = new o(ajVar, i8, false);
                AppMethodBeat.o(58135);
                return oVar2;
            }
            aj c2 = ac.c(kF(j.ad(ajVar.hzL(), gVar, gVar2)), hzz, arrayList2, booleanValue);
            if (invoke.TtL) {
                fVar = new f(c2);
            } else {
                fVar = c2;
            }
            bg b2 = gVar2 != null && invoke.TtM ? be.b(ajVar, fVar) : fVar;
            if (b2 == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
                AppMethodBeat.o(58135);
                throw tVar;
            }
            o oVar3 = new o((aj) b2, i8, true);
            AppMethodBeat.o(58135);
            return oVar3;
        }
        o oVar4 = new o(ajVar, 1, false);
        AppMethodBeat.o(58135);
        return oVar4;
    }

    private static final kotlin.l.b.a.b.b.a.g kF(List<? extends kotlin.l.b.a.b.b.a.g> list) {
        AppMethodBeat.i(58136);
        switch (list.size()) {
            case 0:
                IllegalStateException illegalStateException = new IllegalStateException("At least one Annotations object expected".toString());
                AppMethodBeat.o(58136);
                throw illegalStateException;
            case 1:
                kotlin.l.b.a.b.b.a.g gVar = (kotlin.l.b.a.b.b.a.g) j.kw(list);
                AppMethodBeat.o(58136);
                return gVar;
            default:
                k kVar = new k(j.p(list));
                AppMethodBeat.o(58136);
                return kVar;
        }
    }

    private static boolean a(q qVar) {
        AppMethodBeat.i(58137);
        p.h(qVar, "$this$shouldEnhance");
        if (qVar != q.INFLEXIBLE) {
            AppMethodBeat.o(58137);
            return true;
        }
        AppMethodBeat.o(58137);
        return false;
    }

    private static final <T> c<T> fn(T t) {
        AppMethodBeat.i(58138);
        c<T> cVar = new c<>(t, null);
        AppMethodBeat.o(58138);
        return cVar;
    }

    private static final <T> c<T> fo(T t) {
        AppMethodBeat.i(58139);
        c<T> cVar = new c<>(t, TuT);
        AppMethodBeat.o(58139);
        return cVar;
    }

    private static final <T> c<T> fp(T t) {
        AppMethodBeat.i(58140);
        c<T> cVar = new c<>(t, TuU);
        AppMethodBeat.o(58140);
        return cVar;
    }

    private static final c<kotlin.l.b.a.b.b.h> a(kotlin.l.b.a.b.b.h hVar, d dVar, q qVar) {
        AppMethodBeat.i(58141);
        if (!a(qVar)) {
            c<kotlin.l.b.a.b.b.h> fn = fn(hVar);
            AppMethodBeat.o(58141);
            return fn;
        } else if (!(hVar instanceof e)) {
            c<kotlin.l.b.a.b.b.h> fn2 = fn(hVar);
            AppMethodBeat.o(58141);
            return fn2;
        } else {
            c cVar = c.TfZ;
            e eVar = dVar.TtK;
            if (eVar != null) {
                switch (t.$EnumSwitchMapping$0[eVar.ordinal()]) {
                    case 1:
                        if (qVar == q.FLEXIBLE_LOWER && c.h((e) hVar)) {
                            c<kotlin.l.b.a.b.b.h> fp = fp(c.j((e) hVar));
                            AppMethodBeat.o(58141);
                            return fp;
                        }
                    case 2:
                        if (qVar == q.FLEXIBLE_UPPER && c.i((e) hVar)) {
                            c<kotlin.l.b.a.b.b.h> fp2 = fp(c.k((e) hVar));
                            AppMethodBeat.o(58141);
                            return fp2;
                        }
                }
            }
            c<kotlin.l.b.a.b.b.h> fn3 = fn(hVar);
            AppMethodBeat.o(58141);
            return fn3;
        }
    }

    private static final c<Boolean> a(ab abVar, d dVar, q qVar) {
        AppMethodBeat.i(58142);
        if (!a(qVar)) {
            c<Boolean> fn = fn(Boolean.valueOf(abVar.hEa()));
            AppMethodBeat.o(58142);
            return fn;
        }
        g gVar = dVar.TtJ;
        if (gVar != null) {
            switch (t.haE[gVar.ordinal()]) {
                case 1:
                    c<Boolean> fo = fo(Boolean.TRUE);
                    AppMethodBeat.o(58142);
                    return fo;
                case 2:
                    c<Boolean> fo2 = fo(Boolean.FALSE);
                    AppMethodBeat.o(58142);
                    return fo2;
            }
        }
        c<Boolean> fn2 = fn(Boolean.valueOf(abVar.hEa()));
        AppMethodBeat.o(58142);
        return fn2;
    }

    static {
        AppMethodBeat.i(58143);
        kotlin.l.b.a.b.f.b bVar = kotlin.l.b.a.b.d.a.p.Tpt;
        p.g(bVar, "JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION");
        TuT = new b(bVar);
        kotlin.l.b.a.b.f.b bVar2 = kotlin.l.b.a.b.d.a.p.Tpu;
        p.g(bVar2, "JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION");
        TuU = new b(bVar2);
        AppMethodBeat.o(58143);
    }
}
