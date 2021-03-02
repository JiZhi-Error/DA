package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ah;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.am;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;

public abstract class d extends k implements ar {
    protected List<? extends as> Tka;
    private final c Tkb = new c(this);
    protected final ba Tkc;

    /* access modifiers changed from: protected */
    public abstract j hAI();

    /* access modifiers changed from: protected */
    public abstract List<as> hBU();

    public static final class a extends q implements kotlin.g.a.b<i, aj> {
        final /* synthetic */ d Tkd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar) {
            super(1);
            this.Tkd = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ aj invoke(i iVar) {
            AppMethodBeat.i(56996);
            iVar.M(this.Tkd);
            AppMethodBeat.o(56996);
            return null;
        }
    }

    static final class b extends q implements kotlin.g.a.b<bg, Boolean> {
        final /* synthetic */ d Tkd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(1);
            this.Tkd = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bg bgVar) {
            boolean z;
            AppMethodBeat.i(56997);
            bg bgVar2 = bgVar;
            p.g(bgVar2, "type");
            if (!ad.ap(bgVar2)) {
                h hzS = bgVar2.hKE().hzS();
                if ((hzS instanceof as) && (p.j(((as) hzS).hzx(), this.Tkd) ^ true)) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(56997);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(56997);
            return valueOf2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(l lVar, g gVar, f fVar, an anVar, ba baVar) {
        super(lVar, gVar, fVar, anVar);
        p.h(lVar, "containingDeclaration");
        p.h(gVar, "annotations");
        p.h(fVar, "name");
        p.h(anVar, "sourceElement");
        p.h(baVar, "visibilityImpl");
        this.Tkc = baVar;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        p.h(nVar, "visitor");
        return nVar.a(this, d2);
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
        return bc.b(hBv(), new b(this));
    }

    public final Collection<ag> hBR() {
        ak akVar;
        ah ahVar;
        e hBx = hBx();
        if (hBx == null) {
            return v.SXr;
        }
        Collection<kotlin.l.b.a.b.b.d> hxW = hBx.hxW();
        p.g(hxW, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (T t : hxW) {
            ah.a aVar = ah.Tmo;
            j hAI = hAI();
            d dVar = this;
            p.g(t, LocaleUtil.ITALIAN);
            p.h(hAI, "storageManager");
            p.h(dVar, "typeAliasDescriptor");
            p.h(t, "constructor");
            kotlin.l.b.a.b.m.ba a2 = ah.a.a(dVar);
            if (a2 == null) {
                ahVar = null;
            } else {
                kotlin.l.b.a.b.b.d a3 = t.a(a2);
                if (a3 == null) {
                    ahVar = null;
                } else {
                    g hzL = t.hzL();
                    b.a hAA = t.hAA();
                    p.g(hAA, "constructor.kind");
                    an hzM = dVar.hzM();
                    p.g(hzM, "typeAliasDescriptor.source");
                    ah ahVar2 = new ah(hAI, dVar, a3, null, hzL, hAA, hzM, (byte) 0);
                    ah ahVar3 = ahVar2;
                    List<av> hAw = t.hAw();
                    if (hAw == null) {
                        p.atM(26);
                    }
                    if (a2 == null) {
                        p.atM(27);
                    }
                    List<av> a4 = p.a((t) ahVar3, hAw, a2, false, false, (boolean[]) null);
                    if (a4 == null) {
                        ahVar = null;
                    } else {
                        p.g(a4, "FunctionDescriptorImpl.g…         ) ?: return null");
                        aj an = y.an(a3.hAu().hLF());
                        aj hAG = dVar.hAG();
                        p.g(hAG, "typeAliasDescriptor.defaultType");
                        aj b2 = am.b(an, hAG);
                        ak hAs = t.hAs();
                        if (hAs != null) {
                            p.g(hAs, LocaleUtil.ITALIAN);
                            ab b3 = a2.b(hAs.hBy(), bh.INVARIANT);
                            g.a aVar2 = g.TiC;
                            akVar = kotlin.l.b.a.b.j.b.a(ahVar2, b3, g.a.hBP());
                        } else {
                            akVar = null;
                        }
                        ahVar2.a(akVar, null, dVar.hzO(), a4, b2, w.FINAL, dVar.hzE());
                        ahVar = ahVar2;
                    }
                }
            }
            if (ahVar != null) {
                arrayList.add(ahVar);
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends kotlin.l.b.a.b.b.as>, java.util.List<kotlin.l.b.a.b.b.as> */
    @Override // kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        List list = this.Tka;
        if (list == null) {
            p.btv("declaredTypeParametersImpl");
        }
        return list;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final w hzC() {
        return w.FINAL;
    }

    @Override // kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        return this.Tkc;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzJ() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean hzK() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.v
    public final boolean isExternal() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        return this.Tkb;
    }

    @Override // kotlin.l.b.a.b.b.c.j
    public String toString() {
        return "typealias " + hAH().sG();
    }

    /* access modifiers changed from: private */
    /* renamed from: hBS */
    public ar hBT() {
        o hBT = super.hAE();
        if (hBT != null) {
            return (ar) hBT;
        }
        throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
    }

    public static final class c implements at {
        final /* synthetic */ d Tkd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(d dVar) {
            this.Tkd = dVar;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(56998);
            List<as> hBU = this.Tkd.hBU();
            AppMethodBeat.o(56998);
            return hBU;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(57001);
            String str = "[typealias " + this.Tkd.hAH().sG() + ']';
            AppMethodBeat.o(57001);
            return str;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final /* bridge */ /* synthetic */ h hzS() {
            return this.Tkd;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final Collection<ab> hBV() {
            AppMethodBeat.i(56999);
            Collection<ab> hBV = this.Tkd.hBv().hKE().hBV();
            p.g(hBV, "declarationDescriptor.un…pe.constructor.supertypes");
            AppMethodBeat.o(56999);
            return hBV;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final kotlin.l.b.a.b.a.g hBh() {
            AppMethodBeat.i(57000);
            kotlin.l.b.a.b.a.g G = kotlin.l.b.a.b.j.d.a.G(this.Tkd);
            AppMethodBeat.o(57000);
            return G;
        }
    }
}
