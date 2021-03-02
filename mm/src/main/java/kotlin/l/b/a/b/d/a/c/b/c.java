package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.d.a.c.e;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.c.m;
import kotlin.l.b.a.b.d.a.e.f;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.i;
import kotlin.l.b.a.b.d.a.e.j;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.d.a.e.z;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;

public final class c {
    private final h Trn;
    private final m Trw;

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<v, Boolean> {
        public static final a Ttj = new a();

        static {
            AppMethodBeat.i(57959);
            AppMethodBeat.o(57959);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(v vVar) {
            AppMethodBeat.i(57957);
            Boolean valueOf = Boolean.valueOf(a(vVar));
            AppMethodBeat.o(57957);
            return valueOf;
        }

        public static boolean a(v vVar) {
            AppMethodBeat.i(57958);
            z zVar = (z) (!(vVar instanceof z) ? null : vVar);
            if (zVar == null) {
                AppMethodBeat.o(57958);
                return false;
            } else if (zVar.hDk() == null || zVar.hDl()) {
                AppMethodBeat.o(57958);
                return false;
            } else {
                AppMethodBeat.o(57958);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.d.a.c.b.c$c  reason: collision with other inner class name */
    public static final class C2287c extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ j Ttq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2287c(j jVar) {
            super(0);
            this.Ttq = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(57962);
            aj hDU = hDU();
            AppMethodBeat.o(57962);
            return hDU;
        }

        public final aj hDU() {
            AppMethodBeat.i(57963);
            aj bun = u.bun("Unresolved java class " + this.Ttq.hCV());
            p.g(bun, "ErrorUtils.createErrorTy…vaType.presentableText}\")");
            AppMethodBeat.o(57963);
            return bun;
        }
    }

    public c(h hVar, m mVar) {
        p.h(hVar, "c");
        p.h(mVar, "typeParameterResolver");
        AppMethodBeat.i(57975);
        this.Trn = hVar;
        this.Trw = mVar;
        AppMethodBeat.o(57975);
    }

    public final ab a(v vVar, a aVar) {
        ab a2;
        aj hzq;
        AppMethodBeat.i(57964);
        p.h(aVar, "attr");
        if (vVar instanceof kotlin.l.b.a.b.d.a.e.u) {
            kotlin.l.b.a.b.a.h hDh = ((kotlin.l.b.a.b.d.a.e.u) vVar).hDh();
            if (hDh != null) {
                hzq = this.Trn.Trv.Tfp.hBh().a(hDh);
            } else {
                hzq = this.Trn.Trv.Tfp.hBh().hzq();
            }
            p.g(hzq, "if (primitiveType != nul….module.builtIns.unitType");
            aj ajVar = hzq;
            AppMethodBeat.o(57964);
            return ajVar;
        } else if (vVar instanceof j) {
            ab a3 = a((j) vVar, aVar);
            AppMethodBeat.o(57964);
            return a3;
        } else if (vVar instanceof f) {
            ab a4 = a((f) vVar, aVar, false);
            AppMethodBeat.o(57964);
            return a4;
        } else if (vVar instanceof z) {
            v hDk = ((z) vVar).hDk();
            if (hDk == null || (a2 = a(hDk, aVar)) == null) {
                aj hzk = this.Trn.Trv.Tfp.hBh().hzk();
                p.g(hzk, "c.module.builtIns.defaultBound");
                aj ajVar2 = hzk;
                AppMethodBeat.o(57964);
                return ajVar2;
            }
            AppMethodBeat.o(57964);
            return a2;
        } else if (vVar == null) {
            aj hzk2 = this.Trn.Trv.Tfp.hBh().hzk();
            p.g(hzk2, "c.module.builtIns.defaultBound");
            aj ajVar3 = hzk2;
            AppMethodBeat.o(57964);
            return ajVar3;
        } else {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unsupported type: ".concat(String.valueOf(vVar)));
            AppMethodBeat.o(57964);
            throw unsupportedOperationException;
        }
    }

    public final ab a(f fVar, a aVar, boolean z) {
        v vVar;
        AppMethodBeat.i(57965);
        p.h(fVar, "arrayType");
        p.h(aVar, "attr");
        v hCI = fVar.hCI();
        if (!(hCI instanceof kotlin.l.b.a.b.d.a.e.u)) {
            vVar = null;
        } else {
            vVar = hCI;
        }
        kotlin.l.b.a.b.d.a.e.u uVar = (kotlin.l.b.a.b.d.a.e.u) vVar;
        kotlin.l.b.a.b.a.h hDh = uVar != null ? uVar.hDh() : null;
        if (hDh != null) {
            aj b2 = this.Trn.Trv.Tfp.hBh().b(hDh);
            p.g(b2, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            if (aVar.Ttd) {
                aj ajVar = b2;
                AppMethodBeat.o(57965);
                return ajVar;
            }
            bg a2 = ac.a(b2, b2.EG(true));
            AppMethodBeat.o(57965);
            return a2;
        }
        ab a3 = a(hCI, d.a(l.Tqv, aVar.Ttd, null, 2));
        if (aVar.Ttd) {
            aj a4 = this.Trn.Trv.Tfp.hBh().a(z ? bh.OUT_VARIANCE : bh.INVARIANT, a3);
            p.g(a4, "c.module.builtIns.getArr…ctionKind, componentType)");
            aj ajVar2 = a4;
            AppMethodBeat.o(57965);
            return ajVar2;
        }
        aj a5 = this.Trn.Trv.Tfp.hBh().a(bh.INVARIANT, a3);
        p.g(a5, "c.module.builtIns.getArr…INVARIANT, componentType)");
        bg a6 = ac.a(a5, this.Trn.Trv.Tfp.hBh().a(bh.OUT_VARIANCE, a3).EG(true));
        AppMethodBeat.o(57965);
        return a6;
    }

    private final ab a(j jVar, a aVar) {
        AppMethodBeat.i(57966);
        C2287c cVar = new C2287c(jVar);
        boolean z = !aVar.Ttd && aVar.Ttb != l.SUPERTYPE;
        boolean hCW = jVar.hCW();
        if (hCW || z) {
            aj a2 = a(jVar, aVar.a(b.FLEXIBLE_LOWER_BOUND), (aj) null);
            if (a2 == null) {
                aj hDU = cVar.hDU();
                AppMethodBeat.o(57966);
                return hDU;
            }
            aj a3 = a(jVar, aVar.a(b.FLEXIBLE_UPPER_BOUND), a2);
            if (a3 == null) {
                aj hDU2 = cVar.hDU();
                AppMethodBeat.o(57966);
                return hDU2;
            } else if (hCW) {
                g gVar = new g(a2, a3);
                AppMethodBeat.o(57966);
                return gVar;
            } else {
                bg a4 = ac.a(a2, a3);
                AppMethodBeat.o(57966);
                return a4;
            }
        } else {
            aj a5 = a(jVar, aVar, (aj) null);
            if (a5 != null) {
                aj ajVar = a5;
                AppMethodBeat.o(57966);
                return ajVar;
            }
            aj hDU3 = cVar.hDU();
            AppMethodBeat.o(57966);
            return hDU3;
        }
    }

    private final aj a(j jVar, a aVar, aj ajVar) {
        e eVar;
        at atVar;
        AppMethodBeat.i(57967);
        if (ajVar == null || (eVar = ajVar.hzL()) == null) {
            eVar = new e(this.Trn, jVar);
        }
        at b2 = b(jVar, aVar);
        if (b2 == null) {
            AppMethodBeat.o(57967);
            return null;
        }
        boolean a2 = a(aVar);
        if (ajVar != null) {
            atVar = ajVar.hKE();
        } else {
            atVar = null;
        }
        if (!p.j(atVar, b2) || jVar.hCW() || !a2) {
            aj c2 = ac.c(eVar, b2, a(jVar, aVar, b2), a2);
            AppMethodBeat.o(57967);
            return c2;
        }
        aj EG = ajVar.EG(true);
        AppMethodBeat.o(57967);
        return EG;
    }

    private final at b(j jVar, a aVar) {
        at hzz;
        AppMethodBeat.i(57968);
        i hCT = jVar.hCT();
        if (hCT == null) {
            at a2 = a(jVar);
            AppMethodBeat.o(57968);
            return a2;
        } else if (hCT instanceof g) {
            kotlin.l.b.a.b.f.b hBk = ((g) hCT).hBk();
            if (hBk == null) {
                AssertionError assertionError = new AssertionError("Class type should have a FQ name: ".concat(String.valueOf(hCT)));
                AppMethodBeat.o(57968);
                throw assertionError;
            }
            kotlin.l.b.a.b.b.e a3 = a(jVar, aVar, hBk);
            if (a3 == null) {
                a3 = this.Trn.Trv.TqZ.c((g) hCT);
            }
            if (a3 == null || (hzz = a3.hzz()) == null) {
                at a4 = a(jVar);
                AppMethodBeat.o(57968);
                return a4;
            }
            AppMethodBeat.o(57968);
            return hzz;
        } else if (hCT instanceof w) {
            as a5 = this.Trw.a((w) hCT);
            if (a5 != null) {
                at hzz2 = a5.hzz();
                AppMethodBeat.o(57968);
                return hzz2;
            }
            AppMethodBeat.o(57968);
            return null;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unknown classifier kind: ".concat(String.valueOf(hCT)));
            AppMethodBeat.o(57968);
            throw illegalStateException;
        }
    }

    private final at a(j jVar) {
        AppMethodBeat.i(57969);
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(jVar.hCU()));
        p.g(p, "ClassId.topLevel(FqName(…classifierQualifiedName))");
        at hzz = this.Trn.Trv.TqS.hEh().TeR.a(p, kotlin.a.j.listOf((Object) 0)).hzz();
        p.g(hzz, "c.components.deserialize…istOf(0)).typeConstructor");
        AppMethodBeat.o(57969);
        return hzz;
    }

    private static boolean a(j jVar, kotlin.l.b.a.b.b.e eVar) {
        bh hAJ;
        AppMethodBeat.i(57971);
        a aVar = a.Ttj;
        if (!a.a((v) kotlin.a.j.kv(jVar.hCX()))) {
            AppMethodBeat.o(57971);
            return false;
        }
        kotlin.l.b.a.b.a.b.c cVar = kotlin.l.b.a.b.a.b.c.TfZ;
        at hzz = kotlin.l.b.a.b.a.b.c.k(eVar).hzz();
        p.g(hzz, "JavaToKotlinClassMap.con…         .typeConstructor");
        List<as> parameters = hzz.getParameters();
        p.g(parameters, "JavaToKotlinClassMap.con…ypeConstructor.parameters");
        as asVar = (as) kotlin.a.j.kv(parameters);
        if (asVar == null || (hAJ = asVar.hAJ()) == null) {
            AppMethodBeat.o(57971);
            return false;
        }
        p.g(hAJ, "JavaToKotlinClassMap.con….variance ?: return false");
        if (hAJ != bh.OUT_VARIANCE) {
            AppMethodBeat.o(57971);
            return true;
        }
        AppMethodBeat.o(57971);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.l.b.a.b.m.av> a(kotlin.l.b.a.b.d.a.e.j r12, kotlin.l.b.a.b.d.a.c.b.a r13, kotlin.l.b.a.b.m.at r14) {
        /*
        // Method dump skipped, instructions count: 383
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.c.b.c.a(kotlin.l.b.a.b.d.a.e.j, kotlin.l.b.a.b.d.a.c.b.a, kotlin.l.b.a.b.m.at):java.util.List");
    }

    private final av a(v vVar, a aVar, as asVar) {
        AppMethodBeat.i(57973);
        if (vVar instanceof z) {
            v hDk = ((z) vVar).hDk();
            bh bhVar = ((z) vVar).hDl() ? bh.OUT_VARIANCE : bh.IN_VARIANCE;
            if (hDk == null || a(bhVar, asVar)) {
                av a2 = d.a(asVar, aVar);
                AppMethodBeat.o(57973);
                return a2;
            }
            av a3 = kotlin.l.b.a.b.m.d.a.a(a(hDk, d.a(l.Tqv, false, null, 3)), bhVar, asVar);
            AppMethodBeat.o(57973);
            return a3;
        }
        ax axVar = new ax(bh.INVARIANT, a(vVar, aVar));
        AppMethodBeat.o(57973);
        return axVar;
    }

    private static boolean a(bh bhVar, as asVar) {
        AppMethodBeat.i(57974);
        if (asVar.hAJ() == bh.INVARIANT) {
            AppMethodBeat.o(57974);
            return false;
        } else if (bhVar != asVar.hAJ()) {
            AppMethodBeat.o(57974);
            return true;
        } else {
            AppMethodBeat.o(57974);
            return false;
        }
    }

    private static boolean a(a aVar) {
        if (aVar.Ttc == b.FLEXIBLE_LOWER_BOUND || aVar.Ttd || aVar.Ttb == l.SUPERTYPE) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<ab> {
        final /* synthetic */ as Ttk;
        final /* synthetic */ c Ttl;
        final /* synthetic */ a Ttm;
        final /* synthetic */ at Ttn;
        final /* synthetic */ boolean Tto;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(as asVar, c cVar, a aVar, at atVar, boolean z) {
            super(0);
            this.Ttk = asVar;
            this.Ttl = cVar;
            this.Ttm = aVar;
            this.Ttn = atVar;
            this.Tto = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(57961);
            as asVar = this.Ttk;
            p.g(asVar, "parameter");
            ab a2 = d.a(asVar, this.Ttm.Tte, new kotlin.g.a.a<ab>(this) {
                /* class kotlin.l.b.a.b.d.a.c.b.c.b.AnonymousClass1 */
                final /* synthetic */ b Ttp;

                {
                    this.Ttp = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ ab invoke() {
                    AppMethodBeat.i(57960);
                    kotlin.l.b.a.b.b.h hzS = this.Ttp.Ttn.hzS();
                    if (hzS == null) {
                        p.hyc();
                    }
                    p.g(hzS, "constructor.declarationDescriptor!!");
                    aj hAG = hzS.hAG();
                    p.g(hAG, "constructor.declarationDescriptor!!.defaultType");
                    ab aO = kotlin.l.b.a.b.m.d.a.aO(hAG);
                    AppMethodBeat.o(57960);
                    return aO;
                }
            });
            AppMethodBeat.o(57961);
            return a2;
        }
    }

    private final kotlin.l.b.a.b.b.e a(j jVar, a aVar, kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(57970);
        if (!aVar.Ttd || !p.j(bVar, d.hDV())) {
            kotlin.l.b.a.b.a.b.c cVar = kotlin.l.b.a.b.a.b.c.TfZ;
            kotlin.l.b.a.b.b.e a2 = kotlin.l.b.a.b.a.b.c.a(bVar, this.Trn.Trv.Tfp.hBh());
            if (a2 == null) {
                AppMethodBeat.o(57970);
                return null;
            } else if (!kotlin.l.b.a.b.a.b.c.i(a2) || !(aVar.Ttc == b.FLEXIBLE_LOWER_BOUND || aVar.Ttb == l.SUPERTYPE || a(jVar, a2))) {
                AppMethodBeat.o(57970);
                return a2;
            } else {
                kotlin.l.b.a.b.b.e k = kotlin.l.b.a.b.a.b.c.k(a2);
                AppMethodBeat.o(57970);
                return k;
            }
        } else {
            kotlin.l.b.a.b.b.e hzv = this.Trn.Trv.Trc.hzv();
            AppMethodBeat.o(57970);
            return hzv;
        }
    }
}
