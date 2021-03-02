package kotlin.l.b.a.b.m.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.i.b;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.i.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.au;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;
import kotlin.m;
import kotlin.o;
import kotlin.t;
import kotlin.x;

public final class b {

    /* access modifiers changed from: package-private */
    public static final class e extends q implements kotlin.g.a.b<bh, bh> {
        final /* synthetic */ d TQc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar) {
            super(1);
            this.TQc = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bh invoke(bh bhVar) {
            AppMethodBeat.i(61268);
            bh c2 = c(bhVar);
            AppMethodBeat.o(61268);
            return c2;
        }

        public final bh c(bh bhVar) {
            AppMethodBeat.i(61269);
            p.h(bhVar, "variance");
            if (bhVar == this.TQc.TOv.hAJ()) {
                bh bhVar2 = bh.INVARIANT;
                AppMethodBeat.o(61269);
                return bhVar2;
            }
            AppMethodBeat.o(61269);
            return bhVar;
        }
    }

    private static final d b(av avVar, as asVar) {
        AppMethodBeat.i(61270);
        switch (c.$EnumSwitchMapping$0[ba.a(asVar.hAJ(), avVar).ordinal()]) {
            case 1:
                ab hBy = avVar.hBy();
                p.g(hBy, "type");
                ab hBy2 = avVar.hBy();
                p.g(hBy2, "type");
                d dVar = new d(asVar, hBy, hBy2);
                AppMethodBeat.o(61270);
                return dVar;
            case 2:
                ab hBy3 = avVar.hBy();
                p.g(hBy3, "type");
                aj hzj = kotlin.l.b.a.b.j.d.a.G(asVar).hzj();
                p.g(hzj, "typeParameter.builtIns.nullableAnyType");
                d dVar2 = new d(asVar, hBy3, hzj);
                AppMethodBeat.o(61270);
                return dVar2;
            case 3:
                aj hzh = kotlin.l.b.a.b.j.d.a.G(asVar).hzh();
                p.g(hzh, "typeParameter.builtIns.nothingType");
                ab hBy4 = avVar.hBy();
                p.g(hBy4, "type");
                d dVar3 = new d(asVar, hzh, hBy4);
                AppMethodBeat.o(61270);
                return dVar3;
            default:
                m mVar = new m();
                AppMethodBeat.o(61270);
                throw mVar;
        }
    }

    public static final av a(av avVar, boolean z) {
        AppMethodBeat.i(61271);
        if (avVar == null) {
            AppMethodBeat.o(61271);
            return null;
        } else if (avVar.hLH()) {
            AppMethodBeat.o(61271);
            return avVar;
        } else {
            ab hBy = avVar.hBy();
            p.g(hBy, "typeProjection.type");
            if (!bc.b(hBy, C2362b.TQa)) {
                AppMethodBeat.o(61271);
                return avVar;
            }
            bh hLI = avVar.hLI();
            p.g(hLI, "typeProjection.projectionKind");
            if (hLI == bh.OUT_VARIANCE) {
                ax axVar = new ax(hLI, aP(hBy).TPZ);
                AppMethodBeat.o(61271);
                return axVar;
            } else if (z) {
                ax axVar2 = new ax(hLI, aP(hBy).TPY);
                AppMethodBeat.o(61271);
                return axVar2;
            } else {
                av e2 = e(avVar);
                AppMethodBeat.o(61271);
                return e2;
            }
        }
    }

    public static final class c extends au {
        c() {
        }

        @Override // kotlin.l.b.a.b.m.au
        public final av d(at atVar) {
            at atVar2;
            AppMethodBeat.i(61265);
            p.h(atVar, "key");
            if (!(atVar instanceof kotlin.l.b.a.b.j.a.a.b)) {
                atVar2 = null;
            } else {
                atVar2 = atVar;
            }
            kotlin.l.b.a.b.j.a.a.b bVar = (kotlin.l.b.a.b.j.a.a.b) atVar2;
            if (bVar == null) {
                AppMethodBeat.o(61265);
                return null;
            } else if (bVar.hKF().hLH()) {
                ax axVar = new ax(bh.OUT_VARIANCE, bVar.hKF().hBy());
                AppMethodBeat.o(61265);
                return axVar;
            } else {
                av hKF = bVar.hKF();
                AppMethodBeat.o(61265);
                return hKF;
            }
        }
    }

    private static final av e(av avVar) {
        AppMethodBeat.i(61272);
        ba d2 = ba.d(new c());
        p.g(d2, "TypeSubstitutor.create(o…ojection\n        }\n    })");
        av d3 = d2.d(avVar);
        AppMethodBeat.o(61272);
        return d3;
    }

    public static final a<ab> aP(ab abVar) {
        boolean z;
        aj a2;
        boolean z2;
        AppMethodBeat.i(61273);
        p.h(abVar, "type");
        if (y.al(abVar)) {
            a<ab> aP = aP(y.an(abVar));
            a<ab> aP2 = aP(y.ao(abVar));
            a<ab> aVar = new a<>(be.a(ac.a(y.an(aP.TPY), y.ao(aP2.TPY)), abVar), be.a(ac.a(y.an(aP.TPZ), y.ao(aP2.TPZ)), abVar));
            AppMethodBeat.o(61273);
            return aVar;
        }
        at hKE = abVar.hKE();
        if (kotlin.l.b.a.b.j.a.a.d.ad(abVar)) {
            if (hKE == null) {
                t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
                AppMethodBeat.o(61273);
                throw tVar;
            }
            av hKF = ((kotlin.l.b.a.b.j.a.a.b) hKE).hKF();
            a aVar2 = new a(abVar);
            ab hBy = hKF.hBy();
            p.g(hBy, "typeProjection.type");
            ab aQ = aVar2.aQ(hBy);
            switch (c.haE[hKF.hLI().ordinal()]) {
                case 1:
                    aj hzj = kotlin.l.b.a.b.m.d.a.aM(abVar).hzj();
                    p.g(hzj, "type.builtIns.nullableAnyType");
                    a<ab> aVar3 = new a<>(aQ, hzj);
                    AppMethodBeat.o(61273);
                    return aVar3;
                case 2:
                    aj hzh = kotlin.l.b.a.b.m.d.a.aM(abVar).hzh();
                    p.g(hzh, "type.builtIns.nothingType");
                    a<ab> aVar4 = new a<>(aVar2.aQ(hzh), aQ);
                    AppMethodBeat.o(61273);
                    return aVar4;
                default:
                    AssertionError assertionError = new AssertionError("Only nontrivial projections should have been captured, not: ".concat(String.valueOf(hKF)));
                    AppMethodBeat.o(61273);
                    throw assertionError;
            }
        } else if (abVar.hKB().isEmpty() || abVar.hKB().size() != hKE.getParameters().size()) {
            a<ab> aVar5 = new a<>(abVar, abVar);
            AppMethodBeat.o(61273);
            return aVar5;
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            List<as> parameters = hKE.getParameters();
            p.g(parameters, "typeConstructor.parameters");
            for (o oVar : j.c((Iterable) abVar.hKB(), (Iterable) parameters)) {
                A a3 = oVar.first;
                B b2 = oVar.second;
                p.g(b2, "typeParameter");
                d b3 = b(a3, b2);
                if (a3.hLH()) {
                    arrayList.add(b3);
                    arrayList2.add(b3);
                } else {
                    a<d> a4 = a(b3);
                    arrayList.add(a4.TPY);
                    arrayList2.add(a4.TPZ);
                }
            }
            ArrayList arrayList3 = arrayList;
            if (!arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (!((d) it.next()).hLP()) {
                        z2 = true;
                        continue;
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                aj hzh2 = kotlin.l.b.a.b.m.d.a.aM(abVar).hzh();
                p.g(hzh2, "type.builtIns.nothingType");
                a2 = hzh2;
            } else {
                a2 = a(abVar, arrayList);
            }
            a<ab> aVar6 = new a<>(a2, a(abVar, arrayList2));
            AppMethodBeat.o(61273);
            return aVar6;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<ab, ab> {
        final /* synthetic */ ab TIv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ab abVar) {
            super(1);
            this.TIv = abVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ ab invoke(ab abVar) {
            AppMethodBeat.i(61261);
            ab aQ = aQ(abVar);
            AppMethodBeat.o(61261);
            return aQ;
        }

        public final ab aQ(ab abVar) {
            AppMethodBeat.i(61262);
            p.h(abVar, "$this$makeNullableIfNeeded");
            ab c2 = bc.c(abVar, this.TIv.hEa());
            p.g(c2, "TypeUtils.makeNullableIf…s, type.isMarkedNullable)");
            AppMethodBeat.o(61262);
            return c2;
        }
    }

    private static final ab a(ab abVar, List<d> list) {
        ax axVar;
        AppMethodBeat.i(61274);
        boolean z = abVar.hKB().size() == list.size();
        if (!aa.SXc || z) {
            List<d> list2 = list;
            ArrayList arrayList = new ArrayList(j.a(list2, 10));
            for (T t : list2) {
                boolean hLP = t.hLP();
                if (!aa.SXc || hLP) {
                    e eVar = new e(t);
                    if (p.j(t.TQd, t.TQe)) {
                        axVar = new ax(t.TQd);
                    } else if (g.x(t.TQd) && t.TOv.hAJ() != bh.IN_VARIANCE) {
                        axVar = new ax(eVar.c(bh.OUT_VARIANCE), t.TQe);
                    } else if (g.A(t.TQe)) {
                        axVar = new ax(eVar.c(bh.IN_VARIANCE), t.TQd);
                    } else {
                        axVar = new ax(eVar.c(bh.OUT_VARIANCE), t.TQe);
                    }
                    arrayList.add(axVar);
                } else {
                    c.a aVar = kotlin.l.b.a.b.i.c.TFl;
                    kotlin.l.b.a.b.i.c T = c.a.T(d.TQb);
                    AssertionError assertionError = new AssertionError("Only consistent enhanced type projection can be converted to type projection, but [" + T.k(t.TOv) + ": <" + T.b(t.TQd) + ", " + T.b(t.TQe) + ">] was found");
                    AppMethodBeat.o(61274);
                    throw assertionError;
                }
            }
            ab a2 = az.a(abVar, arrayList, abVar.hzL());
            AppMethodBeat.o(61274);
            return a2;
        }
        AssertionError assertionError2 = new AssertionError("Incorrect type arguments ".concat(String.valueOf(list)));
        AppMethodBeat.o(61274);
        throw assertionError2;
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.b<i, x> {
        public static final d TQb = new d();

        static {
            AppMethodBeat.i(61267);
            AppMethodBeat.o(61267);
        }

        d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(i iVar) {
            AppMethodBeat.i(61266);
            i iVar2 = iVar;
            p.h(iVar2, "$receiver");
            iVar2.a(b.a.TEY);
            x xVar = x.SXb;
            AppMethodBeat.o(61266);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.m.e.b$b  reason: collision with other inner class name */
    public static final class C2362b extends q implements kotlin.g.a.b<bg, Boolean> {
        public static final C2362b TQa = new C2362b();

        static {
            AppMethodBeat.i(61264);
            AppMethodBeat.o(61264);
        }

        C2362b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bg bgVar) {
            AppMethodBeat.i(61263);
            bg bgVar2 = bgVar;
            p.g(bgVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(kotlin.l.b.a.b.j.a.a.d.ad(bgVar2));
            AppMethodBeat.o(61263);
            return valueOf;
        }
    }

    private static final a<d> a(d dVar) {
        AppMethodBeat.i(61275);
        a<ab> aP = aP(dVar.TQd);
        a<ab> aP2 = aP(dVar.TQe);
        a<d> aVar = new a<>(new d(dVar.TOv, aP.TPZ, aP2.TPY), new d(dVar.TOv, aP.TPY, aP2.TPZ));
        AppMethodBeat.o(61275);
        return aVar;
    }
}
