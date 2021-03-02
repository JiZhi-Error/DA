package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.al;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.j;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.n;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.t;

public final class f extends g implements kotlin.l.b.a.b.d.a.b.d {
    private static final Set<String> Tsc = ak.setOf((Object[]) new String[]{"equals", "hashCode", "getClass", "wait", "notify", "notifyAll", "toString"});
    public static final a Tsd = new a((byte) 0);
    private final boolean Thz;
    private final kotlin.l.b.a.b.b.a.g Tih;
    private final ba TkL;
    private final w Tkq;
    private final kotlin.l.b.a.b.b.f Tkr;
    public final kotlin.l.b.a.b.d.a.e.g TrI;
    final b TrU;
    private final g TrV;
    private final al<g> TrW;
    private final kotlin.l.b.a.b.j.f.f TrX;
    private final l TrY;
    private final kotlin.l.b.a.b.l.f<List<as>> TrZ;
    public final h Trn;
    private final h Tsa;
    private final e Tsb;

    static final class d extends q implements kotlin.g.a.b<i, g> {
        final /* synthetic */ f Tsf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar) {
            super(1);
            this.Tsf = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ g invoke(i iVar) {
            AppMethodBeat.i(57814);
            p.h(iVar, "kotlinTypeRefiner");
            g gVar = new g(this.Tsf.Trn, this.Tsf, this.Tsf.TrI, this.Tsf.Tsb != null, this.Tsf.TrV);
            AppMethodBeat.o(57814);
            return gVar;
        }
    }

    @Override // kotlin.l.b.a.b.b.c.t
    public final /* synthetic */ kotlin.l.b.a.b.j.f.h a(i iVar) {
        AppMethodBeat.i(57816);
        p.h(iVar, "kotlinTypeRefiner");
        g b2 = this.TrW.b(iVar);
        AppMethodBeat.o(57816);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.c.a
    public final /* synthetic */ kotlin.l.b.a.b.j.f.h hAM() {
        AppMethodBeat.i(57818);
        g hDO = hDO();
        AppMethodBeat.o(57818);
        return hDO;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* synthetic */ Collection hxW() {
        AppMethodBeat.i(57820);
        List<kotlin.l.b.a.b.b.d> hDP = hDP();
        AppMethodBeat.o(57820);
        return hDP;
    }

    public /* synthetic */ f(h hVar, l lVar, kotlin.l.b.a.b.d.a.e.g gVar) {
        this(hVar, lVar, gVar, null);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(57824);
        AppMethodBeat.o(57824);
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
        AppMethodBeat.i(57815);
        ba baVar = (!p.j(this.TkL, az.ThQ) || this.TrI.hCL() != null) ? this.TkL : n.Tpe;
        p.g(baVar, "if (visibility == Visibi…ISIBILITY else visibility");
        AppMethodBeat.o(57815);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        return this.Thz;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzI() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        return this.TrU;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.c.a
    public final kotlin.l.b.a.b.j.f.h hAN() {
        return this.TrX;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.j.f.h hzy() {
        return this.TrY;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.d hzD() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final e hzA() {
        return null;
    }

    public final g hDO() {
        AppMethodBeat.i(57817);
        kotlin.l.b.a.b.j.f.h hAM = super.hAM();
        if (hAM == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.lazy.descriptors.LazyJavaClassMemberScope");
            AppMethodBeat.o(57817);
            throw tVar;
        }
        g gVar = (g) hAM;
        AppMethodBeat.o(57817);
        return gVar;
    }

    public final List<kotlin.l.b.a.b.b.d> hDP() {
        AppMethodBeat.i(57819);
        List<kotlin.l.b.a.b.b.d> list = (List) this.TrV.Tsh.invoke();
        AppMethodBeat.o(57819);
        return list;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final kotlin.l.b.a.b.b.a.g hzL() {
        return this.Tih;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        AppMethodBeat.i(57821);
        List<as> list = (List) this.TrZ.invoke();
        AppMethodBeat.o(57821);
        return list;
    }

    public final String toString() {
        AppMethodBeat.i(57822);
        String str = "Lazy Java class " + kotlin.l.b.a.b.j.d.a.q(this);
        AppMethodBeat.o(57822);
        return str;
    }

    final class b extends kotlin.l.b.a.b.m.b {
        private final kotlin.l.b.a.b.l.f<List<as>> Tse;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            super(f.this.Trn.Trv.TcN);
            AppMethodBeat.i(57812);
            this.Tse = f.this.Trn.Trv.TcN.al(new a(this));
            AppMethodBeat.o(57812);
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(57807);
            List<as> list = (List) this.Tse.invoke();
            AppMethodBeat.o(57807);
            return list;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final Collection<ab> hzR() {
            ab abVar = null;
            AppMethodBeat.i(57808);
            Collection<j> hBV = f.this.TrI.hBV();
            ArrayList arrayList = new ArrayList(hBV.size());
            ArrayList arrayList2 = new ArrayList(0);
            ab hDQ = hDQ();
            for (j jVar : hBV) {
                ab a2 = f.this.Trn.Tru.a((v) jVar, kotlin.l.b.a.b.d.a.c.b.d.a(kotlin.l.b.a.b.d.a.a.l.SUPERTYPE, false, null, 3));
                if (a2.hKE().hzS() instanceof aa.b) {
                    arrayList2.add(jVar);
                }
                if (!p.j(a2.hKE(), hDQ != null ? hDQ.hKE() : null) && !kotlin.l.b.a.b.a.g.z(a2)) {
                    arrayList.add(a2);
                }
            }
            ArrayList arrayList3 = arrayList;
            e eVar = f.this.Tsb;
            if (eVar != null) {
                abVar = kotlin.l.b.a.b.a.b.j.a(eVar, f.this).hLJ().c(eVar.hAG(), bh.INVARIANT);
            }
            kotlin.l.b.a.b.o.a.c(arrayList3, abVar);
            kotlin.l.b.a.b.o.a.c(arrayList, hDQ);
            if (!arrayList2.isEmpty()) {
                r rVar = f.this.Trn.Trv.TqU;
                f fVar = f.this;
                ArrayList<v> arrayList4 = arrayList2;
                ArrayList arrayList5 = new ArrayList(kotlin.a.j.a(arrayList4, 10));
                for (v vVar : arrayList4) {
                    if (vVar == null) {
                        t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                        AppMethodBeat.o(57808);
                        throw tVar;
                    }
                    arrayList5.add(((j) vVar).hCV());
                }
                rVar.a(fVar, arrayList5);
            }
            if (!arrayList.isEmpty()) {
                List p = kotlin.a.j.p(arrayList);
                AppMethodBeat.o(57808);
                return p;
            }
            List listOf = kotlin.a.j.listOf(f.this.Trn.Trv.Tfp.hBh().hzi());
            AppMethodBeat.o(57808);
            return listOf;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final aq hzV() {
            AppMethodBeat.i(57810);
            aq aqVar = f.this.Trn.Trv.Tkm;
            AppMethodBeat.o(57810);
            return aqVar;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            return true;
        }

        @Override // kotlin.l.b.a.b.m.b
        public final e hzT() {
            return f.this;
        }

        public final String toString() {
            AppMethodBeat.i(57811);
            String sG = f.this.hAH().sG();
            p.g(sG, "name.asString()");
            AppMethodBeat.o(57811);
            return sG;
        }

        static final class a extends q implements kotlin.g.a.a<List<? extends as>> {
            final /* synthetic */ b Tsg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar) {
                super(0);
                this.Tsg = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ List<? extends as> invoke() {
                AppMethodBeat.i(57806);
                List<as> a2 = kotlin.l.b.a.b.b.at.a(f.this);
                AppMethodBeat.o(57806);
                return a2;
            }
        }

        private final ab hDQ() {
            kotlin.l.b.a.b.f.b bVar;
            String str;
            boolean z;
            kotlin.l.b.a.b.f.b bVar2;
            ArrayList arrayList;
            AppMethodBeat.i(57809);
            kotlin.l.b.a.b.b.a.g hzL = f.this.hzL();
            kotlin.l.b.a.b.f.b bVar3 = kotlin.l.b.a.b.d.a.p.Tps;
            p.g(bVar3, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            kotlin.l.b.a.b.b.a.c g2 = hzL.g(bVar3);
            if (g2 == null) {
                bVar = null;
            } else {
                Object j2 = kotlin.a.j.j(g2.hBO().values());
                if (!(j2 instanceof kotlin.l.b.a.b.j.b.v)) {
                    j2 = null;
                }
                kotlin.l.b.a.b.j.b.v vVar = (kotlin.l.b.a.b.j.b.v) j2;
                if (vVar == null || (str = (String) vVar.getValue()) == null) {
                    bVar = null;
                } else {
                    if (str != null) {
                        kotlin.l.b.a.b.f.i iVar = kotlin.l.b.a.b.f.i.BEGINNING;
                        int length = str.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                char charAt = str.charAt(i2);
                                switch (kotlin.l.b.a.b.f.e.$EnumSwitchMapping$0[iVar.ordinal()]) {
                                    case 1:
                                    case 2:
                                        if (Character.isJavaIdentifierPart(charAt)) {
                                            iVar = kotlin.l.b.a.b.f.i.MIDDLE;
                                            break;
                                        } else {
                                            break;
                                        }
                                    case 3:
                                        if (charAt != '.') {
                                            if (!Character.isJavaIdentifierPart(charAt)) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            iVar = kotlin.l.b.a.b.f.i.AFTER_DOT;
                                            break;
                                        }
                                }
                                i2++;
                            } else if (iVar != kotlin.l.b.a.b.f.i.AFTER_DOT) {
                                z = true;
                            }
                        }
                    }
                    z = false;
                    bVar = !z ? null : new kotlin.l.b.a.b.f.b(str);
                }
            }
            if (bVar == null) {
                bVar = null;
            } else if (!(!bVar.TCR.TCW.isEmpty() && bVar.q(kotlin.l.b.a.b.a.g.TcC))) {
                bVar = null;
            }
            if (bVar == null) {
                kotlin.l.b.a.b.d.a.i iVar2 = kotlin.l.b.a.b.d.a.i.ToZ;
                bVar2 = kotlin.l.b.a.b.d.a.i.m(kotlin.l.b.a.b.j.d.a.o(f.this));
            } else {
                bVar2 = bVar;
            }
            if (bVar2 == null) {
                AppMethodBeat.o(57809);
                return null;
            }
            e b2 = kotlin.l.b.a.b.j.d.a.b(f.this.Trn.Trv.Tfp, bVar2, kotlin.l.b.a.b.c.a.c.FROM_JAVA_LOADER);
            if (b2 == null) {
                AppMethodBeat.o(57809);
                return null;
            }
            at hzz = b2.hzz();
            p.g(hzz, "classDescriptor.typeConstructor");
            int size = hzz.getParameters().size();
            List<as> parameters = f.this.TrU.getParameters();
            p.g(parameters, "getTypeConstructor().parameters");
            int size2 = parameters.size();
            if (size2 == size) {
                List<as> list = parameters;
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(list, 10));
                for (T t : list) {
                    bh bhVar = bh.INVARIANT;
                    p.g(t, "parameter");
                    arrayList2.add(new ax(bhVar, t.hAG()));
                }
                arrayList = arrayList2;
            } else if (size2 == 1 && size > 1 && bVar == null) {
                bh bhVar2 = bh.INVARIANT;
                Object kw = kotlin.a.j.kw(parameters);
                p.g(kw, "typeParameters.single()");
                ax axVar = new ax(bhVar2, ((as) kw).hAG());
                kotlin.k.f fVar = new kotlin.k.f(1, size);
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(fVar, 10));
                Iterator it = fVar.iterator();
                while (it.hasNext()) {
                    ((kotlin.a.ab) it).nextInt();
                    arrayList3.add(axVar);
                }
                arrayList = arrayList3;
            } else {
                AppMethodBeat.o(57809);
                return null;
            }
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            aj a2 = ac.a(g.a.hBP(), b2, arrayList);
            AppMethodBeat.o(57809);
            return a2;
        }

        @Override // kotlin.l.b.a.b.m.at, kotlin.l.b.a.b.m.b
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.h hzS() {
            return f.this;
        }
    }

    static final class c extends q implements kotlin.g.a.a<List<? extends as>> {
        final /* synthetic */ f Tsf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.Tsf = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends as> invoke() {
            AppMethodBeat.i(57813);
            List<kotlin.l.b.a.b.d.a.e.w> hAt = this.Tsf.TrI.hAt();
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(hAt, 10));
            for (T t : hAt) {
                as a2 = this.Tsf.Trn.Trw.a(t);
                if (a2 == null) {
                    AssertionError assertionError = new AssertionError("Parameter " + ((Object) t) + " surely belongs to class " + this.Tsf.TrI + ", so it must be resolved");
                    AppMethodBeat.o(57813);
                    throw assertionError;
                }
                arrayList.add(a2);
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(57813);
            return arrayList2;
        }
    }

    @Override // kotlin.l.b.a.b.b.e
    public final Collection<e> hzN() {
        return kotlin.a.v.SXr;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(h hVar, l lVar, kotlin.l.b.a.b.d.a.e.g gVar, e eVar) {
        super(hVar.Trv.TcN, lVar, gVar.hAH(), hVar.Trv.TqY.a(gVar));
        kotlin.l.b.a.b.b.f fVar;
        w wVar;
        boolean z;
        boolean z2 = true;
        p.h(hVar, "outerContext");
        p.h(lVar, "containingDeclaration");
        p.h(gVar, "jClass");
        AppMethodBeat.i(57823);
        this.Tsa = hVar;
        this.TrI = gVar;
        this.Tsb = eVar;
        this.Trn = kotlin.l.b.a.b.d.a.c.a.a(this.Tsa, (kotlin.l.b.a.b.b.g) this, (x) this.TrI, 4);
        this.Trn.Trv.TqV.b(this.TrI);
        boolean z3 = kotlin.aa.SXc;
        if (this.TrI.hCO()) {
            fVar = kotlin.l.b.a.b.b.f.ANNOTATION_CLASS;
        } else if (this.TrI.isInterface()) {
            fVar = kotlin.l.b.a.b.b.f.INTERFACE;
        } else if (this.TrI.isEnum()) {
            fVar = kotlin.l.b.a.b.b.f.ENUM_CLASS;
        } else {
            fVar = kotlin.l.b.a.b.b.f.CLASS;
        }
        this.Tkr = fVar;
        if (this.TrI.hCO() || this.TrI.isEnum()) {
            wVar = w.FINAL;
        } else {
            w.a aVar = w.Tht;
            wVar = w.a.bn(this.TrI.hCQ() || this.TrI.isInterface(), !this.TrI.hCR());
        }
        this.Tkq = wVar;
        this.TkL = this.TrI.hzE();
        if (this.TrI.hCL() == null || this.TrI.hgu()) {
            z = false;
        } else {
            z = true;
        }
        this.Thz = z;
        this.TrU = new b();
        this.TrV = new g(this.Trn, this, this.TrI, this.Tsb == null ? false : z2);
        al.a aVar2 = al.ThI;
        this.TrW = al.a.a(this, this.Trn.Trv.TcN, this.Trn.Trv.Trh.hLM(), new d(this));
        this.TrX = new kotlin.l.b.a.b.j.f.f(this.TrV);
        this.TrY = new l(this.Trn, this.TrI, this);
        this.Tih = kotlin.l.b.a.b.d.a.c.f.a(this.Trn, this.TrI);
        this.TrZ = this.Trn.Trv.TcN.al(new c(this));
        AppMethodBeat.o(57823);
    }
}
