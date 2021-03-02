package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.o;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.g;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.k;

public final class ah extends p implements ag {
    public static final a Tmo = new a((byte) 0);
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(ah.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    final j TcN;
    private final g Tml;
    private d Tmm;
    final ar Tmn;

    static {
        AppMethodBeat.i(57298);
        AppMethodBeat.o(57298);
    }

    private ah(j jVar, ar arVar, d dVar, ag agVar, kotlin.l.b.a.b.b.a.g gVar, b.a aVar, an anVar) {
        super(arVar, agVar, gVar, f.bua("<init>"), aVar, anVar);
        AppMethodBeat.i(57316);
        this.TcN = jVar;
        this.Tmn = arVar;
        this.TkR = this.Tmn.hzK();
        this.Tml = this.TcN.am(new b(this, dVar));
        this.Tmm = dVar;
        AppMethodBeat.o(57316);
    }

    public /* synthetic */ ah(j jVar, ar arVar, d dVar, ag agVar, kotlin.l.b.a.b.b.a.g gVar, b.a aVar, an anVar, byte b2) {
        this(jVar, arVar, dVar, agVar, gVar, aVar, anVar);
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ kotlin.l.b.a.b.b.b a(l lVar, w wVar, ba baVar, b.a aVar) {
        AppMethodBeat.i(57313);
        ag d2 = d(lVar, wVar, baVar, aVar, false);
        AppMethodBeat.o(57313);
        return d2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ p a(l lVar, t tVar, b.a aVar, f fVar, kotlin.l.b.a.b.b.a.g gVar, an anVar) {
        boolean z = true;
        AppMethodBeat.i(57315);
        p.h(lVar, "newOwner");
        p.h(aVar, "kind");
        p.h(gVar, "annotations");
        p.h(anVar, "source");
        boolean z2 = aVar == b.a.DECLARATION || aVar == b.a.SYNTHESIZED;
        if (!kotlin.aa.SXc || z2) {
            if (fVar != null) {
                z = false;
            }
            if (!kotlin.aa.SXc || z) {
                ah ahVar = new ah(this.TcN, this.Tmn, this.Tmm, this, gVar, b.a.DECLARATION, anVar);
                AppMethodBeat.o(57315);
                return ahVar;
            }
            AssertionError assertionError = new AssertionError("Renaming type alias constructor: ".concat(String.valueOf(this)));
            AppMethodBeat.o(57315);
            throw assertionError;
        }
        AssertionError assertionError2 = new AssertionError("Creating a type alias constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + lVar + "\nkind: " + aVar);
        AppMethodBeat.o(57315);
        throw assertionError2;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final /* synthetic */ kotlin.l.b.a.b.b.k b(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57311);
        ag i2 = i(baVar);
        AppMethodBeat.o(57311);
        return i2;
    }

    @Override // kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t b(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57314);
        ag d2 = d(lVar, wVar, baVar, aVar, z);
        AppMethodBeat.o(57314);
        return d2;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t c(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57310);
        ag i2 = i(baVar);
        AppMethodBeat.o(57310);
        return i2;
    }

    /* Return type fixed from 'kotlin.l.b.a.b.b.m' to match base method */
    @Override // kotlin.l.b.a.b.b.ap, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ kotlin.l.b.a.b.b.a f(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57309);
        ag i2 = i(baVar);
        AppMethodBeat.o(57309);
        return i2;
    }

    @Override // kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.j, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ l hAE() {
        AppMethodBeat.i(57303);
        ag hCw = hCw();
        AppMethodBeat.o(57303);
        return hCw;
    }

    @Override // kotlin.l.b.a.b.b.t, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ t hAT() {
        AppMethodBeat.i(57307);
        ag hCw = hCw();
        AppMethodBeat.o(57307);
        return hCw;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ kotlin.l.b.a.b.b.a hAv() {
        AppMethodBeat.i(57305);
        ag hCw = hCw();
        AppMethodBeat.o(57305);
        return hCw;
    }

    @Override // kotlin.l.b.a.b.b.b, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ kotlin.l.b.a.b.b.b hAz() {
        AppMethodBeat.i(57306);
        ag hCw = hCw();
        AppMethodBeat.o(57306);
        return hCw;
    }

    @Override // kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.c.p
    public final /* synthetic */ o hBT() {
        AppMethodBeat.i(57304);
        ag hCw = hCw();
        AppMethodBeat.o(57304);
        return hCw;
    }

    @Override // kotlin.l.b.a.b.b.c.ag
    public final d hCv() {
        return this.Tmm;
    }

    @Override // kotlin.l.b.a.b.b.a, kotlin.l.b.a.b.b.k, kotlin.l.b.a.b.b.c.p
    public final ab hAu() {
        AppMethodBeat.i(57301);
        ab hAu = super.hAu();
        if (hAu == null) {
            p.hyc();
        }
        AppMethodBeat.o(57301);
        return hAu;
    }

    private ag hCw() {
        AppMethodBeat.i(57302);
        t hAT = super.hBT();
        if (hAT == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.o(57302);
            throw tVar;
        }
        ag agVar = (ag) hAT;
        AppMethodBeat.o(57302);
        return agVar;
    }

    private ag i(kotlin.l.b.a.b.m.ba baVar) {
        AppMethodBeat.i(57308);
        p.h(baVar, "substitutor");
        t c2 = super.f(baVar);
        if (c2 == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
            AppMethodBeat.o(57308);
            throw tVar;
        }
        ah ahVar = (ah) c2;
        kotlin.l.b.a.b.m.ba az = kotlin.l.b.a.b.m.ba.az(ahVar.hAu());
        p.g(az, "TypeSubstitutor.create(s…asConstructor.returnType)");
        d a2 = this.Tmm.hAL().a(az);
        if (a2 == null) {
            AppMethodBeat.o(57308);
            return null;
        }
        ahVar.Tmm = a2;
        ah ahVar2 = ahVar;
        AppMethodBeat.o(57308);
        return ahVar2;
    }

    private ag d(l lVar, w wVar, ba baVar, b.a aVar, boolean z) {
        AppMethodBeat.i(57312);
        p.h(lVar, "newOwner");
        p.h(wVar, "modality");
        p.h(baVar, "visibility");
        p.h(aVar, "kind");
        t hBg = hBa().h(lVar).a(wVar).a(baVar).a(aVar).EB(z).hBg();
        if (hBg == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
            AppMethodBeat.o(57312);
            throw tVar;
        }
        ag agVar = (ag) hBg;
        AppMethodBeat.o(57312);
        return agVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static kotlin.l.b.a.b.m.ba a(ar arVar) {
            AppMethodBeat.i(57296);
            if (arVar.hBx() == null) {
                AppMethodBeat.o(57296);
                return null;
            }
            kotlin.l.b.a.b.m.ba az = kotlin.l.b.a.b.m.ba.az(arVar.hBw());
            AppMethodBeat.o(57296);
            return az;
        }
    }

    static final class b extends q implements kotlin.g.a.a<ah> {
        final /* synthetic */ ah Tmp;
        final /* synthetic */ d Tmq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ah ahVar, d dVar) {
            super(0);
            this.Tmp = ahVar;
            this.Tmq = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ah invoke() {
            AppMethodBeat.i(57297);
            kotlin.l.b.a.b.b.a.g hzL = this.Tmq.hzL();
            b.a hAA = this.Tmq.hAA();
            p.g(hAA, "underlyingConstructorDescriptor.kind");
            an hzM = this.Tmp.Tmn.hzM();
            p.g(hzM, "typeAliasDescriptor.source");
            ah ahVar = new ah(this.Tmp.TcN, this.Tmp.Tmn, this.Tmq, this.Tmp, hzL, hAA, hzM, (byte) 0);
            a aVar = ah.Tmo;
            kotlin.l.b.a.b.m.ba a2 = a.a(this.Tmp.Tmn);
            if (a2 == null) {
                AppMethodBeat.o(57297);
                return null;
            }
            ak hAs = this.Tmq.hAs();
            ahVar.a(null, hAs != null ? hAs.e(a2) : null, this.Tmp.Tmn.hzO(), this.Tmp.hAw(), this.Tmp.hAu(), w.FINAL, this.Tmp.Tmn.hzE());
            AppMethodBeat.o(57297);
            return ahVar;
        }
    }

    @Override // kotlin.l.b.a.b.b.k
    public final boolean isPrimary() {
        AppMethodBeat.i(57299);
        boolean isPrimary = this.Tmm.isPrimary();
        AppMethodBeat.o(57299);
        return isPrimary;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.c.k, kotlin.l.b.a.b.b.t
    public final /* bridge */ /* synthetic */ l hzx() {
        return this.Tmn;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final /* bridge */ /* synthetic */ i hAR() {
        return this.Tmn;
    }

    @Override // kotlin.l.b.a.b.b.k
    public final e hAS() {
        AppMethodBeat.i(57300);
        e hAS = this.Tmm.hAS();
        p.g(hAS, "underlyingConstructorDescriptor.constructedClass");
        AppMethodBeat.o(57300);
        return hAS;
    }
}
